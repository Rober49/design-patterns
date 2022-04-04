package com.kreitek.pets.logs;

import com.kreitek.pets.ILogger;

public class Logger implements ILogger {
    private static volatile Logger instance = null;
    int contador = 1;

    private Logger(){
        if (instance != null) {
            throw new RuntimeException("Usage getInstance() method to create");
        }
    }

    public static Logger getInstance(){
        if (instance == null) {
            synchronized(Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    @Override
    public void debug(String message) {
        System.out.println("[debug][" + contador + "] - " + message);
        contador++;
    }
}
