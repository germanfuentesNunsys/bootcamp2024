package main.java.com.kreitek.pets.controllers;



public class ControllerFactory {
    public CatController getCatController() {
        return new CatController();
    }

    public DogController getDogController() {
        return new DogController();
    }
}
