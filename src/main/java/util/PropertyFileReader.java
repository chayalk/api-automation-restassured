package util;

import groovy.beans.PropertyReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFileReader {

    private static Properties prop;

    public static String getProperty(String propertyName) {
        prop = new Properties();
        try {
            InputStream propertyFileStream = PropertyReader.class.getClassLoader().getResourceAsStream("environment.properties");
            if (propertyFileStream != null) {
                prop.load(propertyFileStream);
                System.out.println("Property file was read successfully");
            } else {
                System.err.println("Failed to read the property file successfully");
            }
            return prop.getProperty(propertyName);

        } catch (IOException ioException) {
            System.err.println(ioException);
        }
        return null;
    }
}
