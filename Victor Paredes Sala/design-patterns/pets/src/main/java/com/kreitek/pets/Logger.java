package com.kreitek.pets;

public class Logger {
    private static volatile Logger instance = null;
    private int count = 0;
    private final String prefix = "[debug]";

    private Logger(){
        if(instance != null){
            throw new RuntimeException("Usage getInstance() method to create");
        }
    }

    public static Logger getInstance(){
        if(instance == null){
            synchronized(Logger.class){
                if(instance == null){
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public void debug(String message){
        System.out.println(prefix + "[" + getCount() + "] - " + message);
    }

    private int getCount(){
        count++;
        return count;
    }
}
