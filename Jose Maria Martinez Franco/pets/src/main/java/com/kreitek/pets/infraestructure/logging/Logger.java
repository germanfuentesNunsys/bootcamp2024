package com.kreitek.pets.infraestructure.logging;

public class Logger {
    private static class SingletonHolder {
        private static final Logger INSTANCE = new Logger();
    }

    private int counter = 0;

    private Logger() {
    }

    public static Logger getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void debug(String message) {
        synchronized (this) {
            counter++;
        }
        System.out.println("[debug][" + counter + "] - " + message);
    }

    public void error(String message) {
        System.err.println("[ERROR] " + message);
    }
}
