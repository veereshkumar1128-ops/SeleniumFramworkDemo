package com.litigation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.ScatteringByteChannel;
import java.util.Properties;

public class ReadProperties {
    private Log log;
    Properties prop;
    public ReadProperties(){
        try
        {
            prop = new Properties();
            File f = new File(System.getProperty("user.dir") + "./src/main/resources/properties/config.properties");
            FileInputStream fis = new FileInputStream(f);
            prop.load(fis);
            Log.info("Config properties file loaded");

        }
        catch(IOException e){
            System.out.println("File not found");

        }
    }
    public String getValue(String key){
        Log.info("Key :"+key+"Value :"+prop.getProperty(key));
        return prop.getProperty(key);
    }
}
