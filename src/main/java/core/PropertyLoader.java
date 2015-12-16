package core;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by RichardG on 16.12.2015.
 */
public class PropertyLoader {

    public final static String mainPropertyFileName = "config.properties";

    public Properties getMainProperties(){
        return load(mainPropertyFileName);
    }

    private Properties load(String propertyFileName){
        Properties prop = new Properties();
        try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propertyFileName)) {
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propertyFileName + "' not found in the classpath");
            }
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
        return prop;
    }
}
