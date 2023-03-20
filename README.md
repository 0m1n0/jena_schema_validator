# jena_schema_validator

Try to understand how RDF data structure verification works in [Apache Jena](https://jena.apache.org/).

Two possibilities are investigated in this project:
- via [Apache Jena Fuseki](https://jena.apache.org/documentation/fuseki2/index.html), a SPARQL server
- via Apache Jena API, a Java API

## 1. Data

- `data/data.ttl`: sample data with 3 users (`Tutankhamen`, `Leonardo da Vinci`, `Julius Ceasar`) and 1 project 
  (`Tutankhamen` has a project)
- `data/schema_shacl.ttl`: schema defining data structure

## 2. Method

### 2.1. Fuseki (Ongoing)

Via server configuration according to [Integration with Apache Jena Fuseki](https://jena.apache.org/documentation/shacl/index.html#integration-with-apache-jena-fuseki)

### 2.2. Jena API

Java code is in `src/Shacl_validate.java`, based on an official example from [GitHub](https://github.com/apache/jena/blob/main/jena-examples/src/main/java/shacl/examples/Shacl01_validateGraph.java)

## 3. Results

### 3.1. Fuseki

Ongoing

### 3.2. Jena API

Successfully validated, the report is below:
```bash
Conforms

@prefix rdf:  <http://www.w3.org/1999/02/22-rdf-syntax-ns#> .
@prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#> .
@prefix sh:   <http://www.w3.org/ns/shacl#> .
@prefix xsd:  <http://www.w3.org/2001/XMLSchema#> .

[ rdf:type     sh:ValidationReport ;
  sh:conforms  true
] .

Process finished with exit code 0
```