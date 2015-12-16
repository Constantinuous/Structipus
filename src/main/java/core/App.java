package core;

import java.sql.Connection;

/**
 * Created by RichardG on 16.12.2015.
 */
public class App {

    public static void main(String[] argv) {
        ConnectionManager connectionManager = new ConnectionManager();
        System.out.println("-------- Oracle JDBC Connection Testing ------");
        connectionManager.testOracleDriver();

        if(argv.length != 4){
            System.out.println("You need exactly three parameters");
        }
        String url = argv[0];
        String user = argv[1];
        String pw = argv[2];
        String table = argv[3];

        String schema = "public";
        try(Connection connection = connectionManager.getConnection(url, user, pw)){
            MetaDataPrinter.printForeignKeys(connection, schema, table);
        }catch (Exception e){

        }
    }

}
