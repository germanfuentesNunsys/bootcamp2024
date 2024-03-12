package com.kreitek.pets.utils;

public class LoggerUtil
{
    private static LoggerUtil instance;
    private int logCount = 0;

    public static LoggerUtil getInstance(){
        if(instance == null){
            instance = new LoggerUtil();
        }
        return instance;
    }


    public void debug(String log){
        logCount++;
        System.out.println("[debug][" + logCount + "] " + log);
    }
}
