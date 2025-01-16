package com.example.api;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

    public static final Properties properties = new Properties();

    static {
        try{
            properties.load(new FileInputStream("/Users/jay/Anagha/apiframework/src/main/resources/config.properties"));
        }catch(Exception e){
            throw new RuntimeException("Failed to load configuration file", e);

        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }

}

    



   
