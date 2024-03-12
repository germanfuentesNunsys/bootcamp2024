package com.kreitek.pets.infraestructure.logging;

public class Logger {
    private static int counter = 0;

    public static void debug(String message) {
        counter++;
        System.out.println("[debug][" + counter + "] - " + message);
    }

    public void error(String message) {
        System.err.println("[ERROR] " + message);
    }
}
