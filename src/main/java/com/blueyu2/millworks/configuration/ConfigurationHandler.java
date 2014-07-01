package com.blueyu2.millworks.configuration;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

/**
 * Created by Blueyu2 on 6/30/2014.
 */
public class ConfigurationHandler {
    public static void init(File configFile){
        //Create the configuration object from the given configuration file
        Configuration configuration = new Configuration(configFile);
        boolean configValue = false;
        boolean configValue2 = true;
        try{
            //Load the configuration file
            configuration.load();
            //Read in properties from configuration file
            configValue = configuration.get(Configuration.CATEGORY_GENERAL, "configValue", true, "This is an example config value.").getBoolean(true);
            configValue2 = configuration.get("Testy", "configValue2", false, "This is also an example config value.").getBoolean();
        }
        catch (Exception e){
            //Log the exception
        }
        finally {
            //Save the configuration file
            configuration.save();
        }
        System.out.println("Configuration Test: " + configValue);
        System.out.println("Configuration Test #2: " + configValue2);
    }
}
