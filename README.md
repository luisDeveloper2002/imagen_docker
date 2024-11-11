# PERSON REST

### Author
Luis Eduardo Hernandez Rincon
2024 Noviembre

## Description

This project returns a list of persons with the following endpoint and generate logs for practice in kubernetes:

1. `person/colombia`   
   Returns list with all person of colombia.
2.  `person/bogota`
   Returns person bogota but file not exist generate intentional error for logs.


## use endpoint



Example 1: 
`http://localhost:8081/person/colombia`
Example 2 for colapse app: 
`http://localhost:8081/person/bogota`



## Compilation

```
mvn clean install
```

## package jar
```
mvn clean package
```

---


