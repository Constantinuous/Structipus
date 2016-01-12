package de.constantinuous.structipus.core;

import core.MetaDataPrinter;
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
public class MetaDataPrinterTest {

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
    public void testDriver(){
        try {
            Class.forName(dbDriver);
        } catch (ClassNotFoundException e) {
            System.err.println("ERROR: failed to load HSQLDB JDBC driver.");
            e.printStackTrace();
            return;

        }

        System.out.println("HSQLDB JDBC Driver Registered!");
    }

    @Test
    public void testCatalogs() throws SQLException{
        String connStr = dbUrl;
        try (Connection connection = DriverManager.getConnection(connStr, "sa", "")) {
            MetaDataPrinter.printCatalogs(connection);
        }
    }

    @Test
    public void testDefaultSchema() throws SQLException{
        String connStr = dbUrl;
        try (Connection connection = DriverManager.getConnection(connStr, "sa", "")) {
            MetaDataPrinter.printDefaultSchema(connection);
        }
    }

    @Test
    public void testSchemas() throws SQLException{
        String connStr = dbUrl;
        try (Connection connection = DriverManager.getConnection(connStr, "sa", "")) {
            MetaDataPrinter.printSchemas(connection);
        }
    }

    @Test
    public void testTables() throws SQLException{
        String connStr = dbUrl;
        try (Connection connection = DriverManager.getConnection(connStr, "sa", "")) {
            MetaDataPrinter.printTables(connection, "PUBLIC");
        }
    }

    @Test
    public void testForeignKeys() throws SQLException{
        String connStr = dbUrl;
        try (Connection connection = DriverManager.getConnection(connStr, "sa", "")) {
            MetaDataPrinter.printForeignKeys(connection, "PUBLIC", "MY_TABLE");
            MetaDataPrinter.printForeignKeys(connection, "PUBLIC", "TEST_TABLE");
            MetaDataPrinter.printForeignKeys(connection, "PUBLIC", "USERS_ROLES");
        }
    }

    @Test
    public void testPrimaryKeys() throws SQLException{
        String connStr = dbUrl;
        try (Connection connection = DriverManager.getConnection(connStr, "sa", "")) {
            MetaDataPrinter.printPrimaryKeys(connection, "PUBLIC", "MY_TABLE");
            MetaDataPrinter.printPrimaryKeys(connection, "PUBLIC", "TEST_TABLE");
            MetaDataPrinter.printPrimaryKeys(connection, "PUBLIC", "USERS_ROLES");
        }
    }
}
