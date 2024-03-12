package main.java.com.kreitek.pets.controllers;

import main.java.com.kreitek.pets.Controller;
import main.java.com.kreitek.pets.Logger;
import main.java.com.kreitek.pets.domain.Cat;
import main.java.com.kreitek.pets.infraestructure.bd.DbService;

import java.util.List;

public class CatController implements Controller {

    private Logger logger = Logger.getInstancia();

    @Override
    public String executePut(String petName, String ownerName, String telephone) {
        logger.debug("CatController.executePut " + petName + "," + ownerName + "," + telephone);
        Cat cat = new Cat(petName, ownerName, telephone);
        DbService dbService = DbService.getInstance();
        dbService.addNewCat(cat);
        return "New cat has been added";
    }

    @Override
    public String executeGet() {
        logger.debug("CatController.executeGet CATS");
        DbService dbService = DbService.getInstance();
        List<Cat> cats = dbService.getCats();
        StringBuilder response = new StringBuilder();
        for (Cat cat : cats) {
            response.append(cat.toString()).append("\r\n");
        }
        return response.toString();
    }
}
