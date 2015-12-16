package core;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by RichardG on 16.12.2015.
 */
public class TestHsqlb {

    @Test
    public void test(){
        testDriver();
        testConnection();
    }

    public void testDriver(){
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
        } catch (ClassNotFoundException e) {
            System.err.println("ERROR: failed to load HSQLDB JDBC driver.");
            e.printStackTrace();
            return;

        }

        System.out.println("Oracle JDBC Driver Registered!");
    }

    public void testConnection(){
        String connStr = "jdbc:hsqldb:file:src/test/tmp/hsqldb/db";
        try (Connection connection = DriverManager.getConnection(connStr, "sa", "")) {

        }catch (SQLException e){

        }
    }
}
