package core;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;

/**
 * Created by RichardG on 16.12.2015.
 */
public class TestHsqlb {

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
    public void testCatalogs(){
        String connStr = dbUrl;
        System.out.println("Connection String: "+dbUrl);
        try (Connection connection = DriverManager.getConnection(connStr, "sa", "")) {
            ResultSet rs = connection.getMetaData().getCatalogs();

            while (rs.next()) {
                System.out.println("TABLE_CAT = " + rs.getString("TABLE_CAT") );
            }
        }catch (SQLException e){

        }
    }
}
