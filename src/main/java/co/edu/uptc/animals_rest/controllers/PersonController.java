package co.edu.uptc.animals_rest.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uptc.animals_rest.models.Person;
import co.edu.uptc.animals_rest.services.PersonService;




@RestController
@RequestMapping("/person")
public class PersonController {

 private static final Logger logger = LoggerFactory.getLogger(PersonController.class);

   @Autowired
    private PersonService personService;


    @GetMapping("/colombia")
    public List<Person> getAnimalAll() throws IOException {
        logger.info("se quiere mostrar todas las personas ");
        return personService.getPersons();
    }

    @GetMapping("/bogota")
    public List<Person> getPersonBogota() {
        logger.info("se quiere mostrar todas  las personas de bogota de otra ruta de archivo");
        try {
            return personService.getPersonBogota();
        } catch (IllegalStateException e) {
            
            logger.error("Error al obtener personas de Bogotá:", e.getMessage());
            System.exit(1);  
            return null;  
        }
    }
   



}
