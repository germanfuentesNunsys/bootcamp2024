package com.kreitek.pets.controllers;

import com.kreitek.pets.Controller;
import com.kreitek.pets.domain.Dog;
import com.kreitek.pets.infraestructure.bd.DbService;
import com.kreitek.pets.infraestructure.logging.Logger;

import java.util.List;

public class DogController implements Controller {
    private static final Logger logger = Logger.getInstance();

    public String executePut(String petName, String ownerName, String telephone) {
        try {
            logger.debug("DogController.executePut " + petName + "," + ownerName + "," + telephone);
            Dog dog = new Dog(petName, ownerName, telephone);
            DbService dbService = DbService.getInstance();
            dbService.addNewDog(dog);
            return "New dog has been added";
        } catch (Exception e) {
            logger.error("Error al agregar un nuevo perro: " + e.getMessage());
            return "Error al agregar un nuevo perro: " + e.getMessage();
        }
    }

    @Override
    public String executeGet() {
        try {
            logger.debug("DogController.executeGet DOGS");
            DbService dbService = DbService.getInstance();
            List<Dog> dogs = dbService.getDogs();
            StringBuilder response = new StringBuilder();
            for (Dog dog : dogs) {
                response.append(dog.toString()).append("\r\n");
            }
            return response.toString();
        } catch (Exception e) {
            logger.error("Error al obtener la lista de perros: " + e.getMessage());
            return "Error al obtener la lista de perros: " + e.getMessage();
        }
    }
}
