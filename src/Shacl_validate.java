/*
 * Code from
 * https://github.com/apache/jena/blob/main/jena-examples/src/main/java/shacl/examples/Shacl01_validateGraph.java
 */

import org.apache.jena.atlas.logging.LogCtl;
import org.apache.jena.graph.Graph;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.shacl.ShaclValidator;
import org.apache.jena.shacl.Shapes;
import org.apache.jena.shacl.ValidationReport;
import org.apache.jena.shacl.lib.ShLib;

/** Load shapes and data, validate and print report */

public class Shacl_validate {
    static { LogCtl.setLogging(); }

    public static void main(String ...args) {
        String SHAPES = "data/schema_shacl.ttl";
        String DATA = "data/data.ttl";

        Graph shapesGraph = RDFDataMgr.loadGraph(SHAPES);
        Graph dataGraph = RDFDataMgr.loadGraph(DATA);

        Shapes shapes = Shapes.parse(shapesGraph);

        ValidationReport report = ShaclValidator.get().validate(shapes, dataGraph);
        ShLib.printReport(report);
        System.out.println();
        RDFDataMgr.write(System.out, report.getModel(), Lang.TTL);
    }
}
