package core;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by RichardG on 16.12.2015.
 */
public class MetaDataPrinter {

    // The Catalog is the Database
    public static void printCatalogs(Connection connection) throws SQLException {
        ResultSet rs = connection.getMetaData().getCatalogs();

        while (rs.next()) {
            System.out.println("Catalog: " + rs.getString("TABLE_CAT") );
        }
    }

    public static void printDefaultSchema(Connection connection) throws SQLException{
        String defaultSchema = connection.getSchema();
        System.out.println("DefaultSchema: "+defaultSchema);
    }

    public static void printSchemas(Connection connection) throws SQLException {
        DatabaseMetaData meta = connection.getMetaData();
        ResultSet schemas = meta.getSchemas();
        while (schemas.next()) {
            String tableSchema = schemas.getString(1);    // "TABLE_SCHEM"
            String tableCatalog = schemas.getString(2); //"TABLE_CATALOG"
            System.out.println("Schema: "+tableSchema+" TableCatalog: "+tableCatalog);
        }
    }

    public static void printTables(Connection connection, String schema) throws SQLException {
        DatabaseMetaData md = connection.getMetaData();

        ResultSet rs = md.getTables(connection.getCatalog(), schema, "%", null);
        while (rs.next()) {
            System.out.println("Table: " + rs.getString(3));
        }
    }

    public static void printForeignKeys(Connection connection, String schema, String tableName) throws SQLException {
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet foreignKeys = metaData.getImportedKeys(connection.getCatalog(), schema, tableName);
        while (foreignKeys.next()) {
            String fkTableName = foreignKeys.getString("FKTABLE_NAME");
            String fkColumnName = foreignKeys.getString("FKCOLUMN_NAME");
            String pkTableName = foreignKeys.getString("PKTABLE_NAME");
            String pkColumnName = foreignKeys.getString("PKCOLUMN_NAME");
            System.out.println(tableName+" Foreign Key: "+fkTableName + "." + fkColumnName + " -> " + pkTableName + "." + pkColumnName);
        }
    }

    public static void printPrimaryKeys(Connection connection, String schema, String tableName) throws SQLException {
        ResultSet rs = null;
        DatabaseMetaData meta = connection.getMetaData();
        // The Oracle database stores its table names as Upper-Case,
        // if you pass a table name in lowercase characters, it will not work.
        // MySQL database does not care if table name is uppercase/lowercase.
        //
        rs = meta.getPrimaryKeys(connection.getCatalog(), schema, tableName);

        while (rs.next()) {
            String columnName = rs.getString("COLUMN_NAME");
            System.out.println(tableName+" Primary Key: " + columnName);
        }
    }
}
