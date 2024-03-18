package com.kreitek.pets.controllers;

import com.kreitek.pets.Controller;
import com.kreitek.pets.domain.Cat;
import com.kreitek.pets.domain.Dog;
import com.kreitek.pets.infraestructure.bd.DbService;

import java.util.List;

public class DogController implements Controller {

    // TODO Logger declaration
    public String executePut(String petName, String ownerName, String telephone) {
        // TODO logger.debug(Name + "DogController.executePut " + petName + "," + owner"," + telephone);
        Dog dog = new Dog(petName, ownerName, telephone);
        DbService dbService = DbService.getInstance();
        dbService.addNewDog(dog);
        Logger logger = Logger.getInstance();
        logger.debug("DogController.executePut "+ dog.getPetName() + "," + dog.getOwnerName() + "," + dog.getTelephone());
        return "New dog has been added";
    }

    @Override
    public String executeGet() {
        Logger logger = Logger.getInstance();
        logger.debug("DogController.executeGet DOGS");// TODO logger.debug("DogController.executeGet DOGS");
        DbService dbService = DbService.getInstance();
        List<Dog> dogs = dbService.getDogs();
        String response = "";
        for (Dog dog:dogs) {
            response += dog.toString() + "\r\n";
        }
        return response;
    }
}
