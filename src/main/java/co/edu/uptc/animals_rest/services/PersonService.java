package co.edu.uptc.animals_rest.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.uptc.animals_rest.exception.InvalidRangeException;
import co.edu.uptc.animals_rest.models.Person;

import java.util.ArrayList;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
@Service
public class PersonService {
     private static final Logger logger = LoggerFactory.getLogger(PersonService.class);
    @Value("${persons.file.path}")
    private String filePath;
    


    
    

    public List<Person> getPersons() throws IOException {
        List<String> listPerson = Files.readAllLines(Paths.get(filePath));
        List<Person> personas = new ArrayList<>();
        

        for (String line : listPerson) {
            String[] parts = line.split(",");
            if (parts.length == 3) {
                String name = parts[0].trim();
                String id = parts[1].trim(); 
                String originTown = parts[2].trim();      

                personas.add(new Person(name,id,originTown));
            }
        }
    
        return personas;
    }
    public List<Person> getPersonBogota() {
        String filePathBogota = "data/personBogota.txt";
        List<Person> personas = new ArrayList<>();
    
        try {
            
            List<String> listPerson = Files.readAllLines(Paths.get(filePathBogota));
    
            for (String line : listPerson) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String name = parts[0].trim();
                    String id = parts[1].trim(); 
                    String originTown = parts[2].trim();      
                    personas.add(new Person(name, id, originTown));
                }
            }
    
        } catch (IOException e) {
            logger.warn("no se encontro el archivo  de personas de bogota");
            String errorMessage = "El archivo de personas de Bogotá no se encuentra en la ruta especificada: " + filePathBogota;
            logger.error(errorMessage);
            throw new IllegalStateException(errorMessage, e);  // Lanzamos la excepción aquí
        }
        
        return personas;
    }
}

