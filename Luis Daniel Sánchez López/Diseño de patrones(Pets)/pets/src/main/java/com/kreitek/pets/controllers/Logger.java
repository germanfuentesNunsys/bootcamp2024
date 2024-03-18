package com.kreitek.pets.controllers;

public class Logger {

    private static volatile Logger instance = null;
    private int contador = 0;

    private Logger() {}
    
    public static Logger getInstance() {
    if (instance == null) {
        synchronized (Logger.class) {
            if (instance == null) {
                instance = new Logger();
            }
        }
    }
    return instance;
}
    public void debug (String message){
        contador++;
        System.out.println("[debug][" + contador + "] - " + message);
    }
}
