package com.kreitek;

import javax.management.RuntimeErrorException;

public class Logs {
    
    private static volatile Logs instance = null;
    private int contadorr = 0;


    private Logs(){
        if (instance != null){
            throw new RuntimeErrorException(null, "Usage getInstance() method to create");
        }
    }

    public static Logs getInstance(){
        if ( instance == null){
            synchronized(Logs.class){
                if (instance == null) {
                    instance = new Logs();
                }
            }
        }
        return instance;
    }
    public void debug(String message) {
        System.out.println("[debug][" + (++contadorr) + "]- " + message);
    }
    
}
