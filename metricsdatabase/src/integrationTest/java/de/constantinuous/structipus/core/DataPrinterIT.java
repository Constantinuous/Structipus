package de.constantinuous.structipus.core;

import core.DataPrinter;
import core.PropertyLoader;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;

/**
 * Created by RichardG on 16.12.2015.
 */
public class DataPrinterIT {

    private Properties properties;

    private String dbDriver;
    private String dbUrl;

    @Before
    public void BeforeEachTest(){
        PropertyLoader propertyLoader = new PropertyLoader();
        properties = propertyLoader.getMainProperties();

        dbDriver = properties.getProperty("dbdriver");
        dbUrl = properties.getProperty("dburl");
        Assert.assertThat(dbDriver, not(nullValue()));
        Assert.assertThat(dbUrl, not(nullValue()));
    }

    @Test
    public void testTables() throws SQLException {
        String connStr = dbUrl;
        try (Connection connection = DriverManager.getConnection(connStr, "sa", "")) {
            DataPrinter.printRows(connection, "PUBLIC", "ROLES");
        }
    }
}
