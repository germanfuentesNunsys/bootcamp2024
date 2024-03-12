package com.kreitek.pets.infraestructure.bd;

import com.kreitek.Logs;
import com.kreitek.pets.domain.Cat;
import com.kreitek.pets.domain.Dog;

import java.util.ArrayList;
import java.util.List;

public class DbService {
    private static volatile DbService instance = null;

    // TODO Logger declaration
    private static Logs logs = Logs.getInstance();
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
        // TODO  
        logs.debug("BdService.Dog added");
    }
    public void addNewCat(Cat cat) {
        cats.add(cat);
        // TODO  
        logs.debug("BdService.Cat added");
    }

    public List<Cat> getCats() {
        // TODO  
        logs.debug("BdService.Get" + cats.size() + "cats");
        return new ArrayList<>(cats);
    }

    public List<Dog> getDogs() {
        // TODO  
        logs.debug("BdService.Get " + cats.size() + "dogs");
        return new ArrayList<>(dogs);
    }
}
