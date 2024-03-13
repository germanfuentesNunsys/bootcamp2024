package com.kreitek.pets.infraestructure.logging;

public class Logger {
    private static Logger instance;
    private static int counter = 0;

    private Logger() {
    }

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void debug(String message) {
        counter++;
        System.out.println("[debug][" + counter + "] - " + message);
    }

    public void error(String message) {
        System.err.println("[ERROR] " + message);
    }
}
