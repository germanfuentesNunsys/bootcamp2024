package com.kreitek.pets.controllers;

public class Logger {

    private static Logger instance = null;
    private static int contador = 0;

    private Logger() {}
    public static Logger getInstance(){
        if(instance == null){
            instance = new Logger();
        }
        return  instance;
    }
    public void debug (String message){
        contador++;
        System.out.println("[debug][" + contador + "] - " + message);
    }
}
