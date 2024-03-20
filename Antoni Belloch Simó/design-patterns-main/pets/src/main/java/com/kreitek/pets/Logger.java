package com.kreitek.pets;

public class Logger {
    private static volatile Logger instance = null;
    private int counter = 0;

    private Logger() {

    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void debug(String message) {
        counter++;
        System.out.println("[debug][" +counter+ "] - " + message);
    }
}
