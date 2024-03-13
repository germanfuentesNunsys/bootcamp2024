package com.kreitek.pets.infraestructure.bd;

import com.kreitek.pets.domain.Cat;
import com.kreitek.pets.domain.Dog;
import com.kreitek.pets.infraestructure.logging.Logger;

import java.util.ArrayList;
import java.util.List;

public class DbService {
    private static volatile DbService instance = null;
    private static final Logger logger = new Logger(); // Declaración del Logger

    private List<Cat> cats = new ArrayList<>();
    private List<Dog> dogs = new ArrayList<>();

    private DbService() {
        if (instance != null) {
            throw new RuntimeException("Usage getInstance() method to create");
        }
    }

    public static DbService getInstance() {
        if (instance == null) {
            synchronized(DbService.class) {
                if (instance == null) {
                    instance = new DbService();
                }
            }
        }
        return instance;
    }

    public void addNewDog(Dog dog) {
        dogs.add(dog);
        logger.debug("DbService.Dog added"); // Registro de debug
    }

    public void addNewCat(Cat cat) {
        cats.add(cat);
        logger.debug("DbService.Cat added"); // Registro de debug
    }

    public List<Cat> getCats() {
        logger.debug("DbService.Get " + cats.size() + " cats"); // Registro de debug
        return new ArrayList<>(cats);
    }

    public List<Dog> getDogs() {
        logger.debug("DbService.Get " + dogs.size() + " dogs"); // Registro de debug
        return new ArrayList<>(dogs);
    }
}
