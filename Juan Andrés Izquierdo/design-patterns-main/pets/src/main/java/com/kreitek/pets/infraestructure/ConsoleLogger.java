package com.kreitek.pets.infraestructure;

public class ConsoleLogger {
    private static int counter = 0;

    public void debug(String message) {
        counter++;
        System.out.println("[debug][" + counter + "] - " + message);
    }
}
