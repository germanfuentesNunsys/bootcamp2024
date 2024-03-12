package main.java.com.kreitek.pets.controllers;

import main.java.com.kreitek.pets.Controller;
import main.java.com.kreitek.pets.Logger;
import main.java.com.kreitek.pets.domain.Dog;
import main.java.com.kreitek.pets.infraestructure.bd.DbService;

import java.util.List;

public class DogController implements Controller {

    private Logger logger = Logger.getInstancia();

    public String executePut(String petName, String ownerName, String telephone) {
        logger.debug("DogController.executePut " + petName + "," + ownerName + "," + telephone);
        Dog dog = new Dog(petName, ownerName, telephone);
        DbService dbService = DbService.getInstance();
        dbService.addNewDog(dog);
        return "New dog has been added";
    }

    @Override
    public String executeGet() {
        logger.debug("DogController.executeGet DOGS");
        DbService dbService = DbService.getInstance();
        List<Dog> dogs = dbService.getDogs();
        StringBuilder response = new StringBuilder();
        for (Dog dog : dogs) {
            response.append(dog.toString()).append("\r\n");
        }
        return response.toString();
    }
}

