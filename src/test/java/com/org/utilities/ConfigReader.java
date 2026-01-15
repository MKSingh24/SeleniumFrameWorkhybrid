package com.org.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop = new Properties();
    private static boolean isLoaded = false;

    public static String get(String key) {
        if (!isLoaded) {
            loadProperties();
        }
        return prop.getProperty(key);
    }

    private static void loadProperties() {
        try (FileInputStream fis = new FileInputStream("src/test/resources/config.properties")) {
            prop.load(fis);
            isLoaded = true;
        } catch (IOException e) {
            throw new RuntimeException("❌ Could not load config.properties file!", e);
        }
    }
}
