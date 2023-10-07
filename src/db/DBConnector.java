package db;

import settings.SettingsProperties;
import java.sql.Connection;
import java.sql.*;
import java.util.Map;


public class DBConnector implements IDBConnector {

    private static Connection connection = null;
    private static Statement statement = null;

    private void open() {
        Map<String, String> settings = new SettingsProperties().getDbSettings();
        try {
            if(connection==null) {
                connection = DriverManager.getConnection(settings.get("db_url") + "/"
                        + settings.get("db_name"), settings.get("db_username"), settings.get("db_password"));
            }
            if(statement==null){
                statement = connection.createStatement();
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public static void close() {
        if(statement!=null){
            try {
                statement.close();
                statement = null;
            } catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        if(connection!=null){
            try {
                connection.close();
                connection = null;
            } catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    public ResultSet executeQuery(String sqlRequest){
        this.open();
    try {
         return statement.executeQuery(sqlRequest);
    } catch (SQLException ex) {
        ex.printStackTrace();
        return null;
    }
    }

    public void execute(String sqlRequest){
        this.open();
        try {
            statement.execute(sqlRequest);
        } catch (SQLException ex){
            ex.printStackTrace();

        }
    }
}
