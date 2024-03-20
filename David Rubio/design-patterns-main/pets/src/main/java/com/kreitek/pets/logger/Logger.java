package com.kreitek.pets.logger;

import java.util.ArrayList;
import java.util.List;

public class Logger {
    private static volatile Logger instance = null;
    List<String> logs = new ArrayList<>();
    int counter = 0;

    private Logger() {
        if (instance != null) {
            throw new RuntimeException("Usage getInstance() method to create");
        }
    }

    public static Logger getInstance() {
        if (instance == null) {
            synchronized(Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public void debug(String message) {
        String log = "[debug]["+counter+"] - "+message;
        System.out.println(log);
        logs.add(log);
        counter++;
    }






}
