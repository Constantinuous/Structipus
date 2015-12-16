package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by RichardG on 16.12.2015.
 */
public class ConnectionManager {

    public void testOracleDriver(){
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

        } catch (ClassNotFoundException e) {

            System.out.println("Where is your Oracle JDBC Driver?");
            e.printStackTrace();
            return;

        }

        System.out.println("Oracle JDBC Driver Registered!");
    }

    public Connection getConnection(String connectionUrl, String user, String password){
        Connection connection = null;

        try {

            connection = DriverManager.getConnection(connectionUrl, user, password);

        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return null;
        }

        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }

        return connection;
    }
}
