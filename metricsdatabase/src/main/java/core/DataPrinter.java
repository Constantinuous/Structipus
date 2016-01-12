package core;

import java.sql.*;

/**
 * Created by RichardG on 16.12.2015.
 */
public class DataPrinter {


    public static void printRows(Connection connection, String schema, String tableName) throws SQLException {
        String query = "select * from "+tableName;
        Statement stmt = connection.createStatement();

        ResultSet rs = stmt.executeQuery(query);
        ResultSetMetaData rsmd = rs.getMetaData();

        int numberOfColumns = rsmd.getColumnCount();

        for (int i = 1; i <= numberOfColumns; i++) {
            if (i > 1) System.out.print(",  ");
            String columnName = rsmd.getColumnName(i);
            System.out.print(columnName);
        }
        System.out.println("");

        while (rs.next()) {
            for (int i = 1; i <= numberOfColumns; i++) {
                if (i > 1) System.out.print(",  ");
                String columnValue = rs.getString(i);
                System.out.print(columnValue);
            }
            System.out.println("");
        }

        stmt.close();
    }

}
