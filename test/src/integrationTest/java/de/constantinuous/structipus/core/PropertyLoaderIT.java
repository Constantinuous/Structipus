package de.constantinuous.structipus.core;

import core.PropertyLoader;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import static org.hamcrest.Matchers.*;

/**
 * Created by RichardG on 16.12.2015.
 */
public class PropertyLoaderIT {

    @Test
    public void testLoad(){
        PropertyLoader propertyLoader = new PropertyLoader();
        Properties properties = propertyLoader.getMainProperties();

        Assert.assertThat(properties.getProperty("dburl"), not(nullValue()));
    }
}
