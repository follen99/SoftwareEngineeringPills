package com.ranauro.persistence;

import com.ranauro.sacca.Sacca;
import com.ranauro.sacca.Seriale;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.Properties;

public class MySqlDataManager  implements DataManager{

    public MySqlDataManager(){
        readLogin();

        Properties loadProps = new Properties();

        try {
            loadProps.loadFromXML(new FileInputStream("db_settings.xml"));
        } catch (InvalidPropertiesFormatException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        host = loadProps.getProperty(TAG_HOST);
        port = loadProps.getProperty(TAG_PORT);
        db = loadProps.getProperty(TAG_DB);
    }

    private void readLogin(){

    }

    //stesso metodo dell'altra volta
    public void createDB(){
        String url = "jdbc:mysql://"+host+":"+port;

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_CREATE_DB+db);
            ) {
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } ;

        try (Connection conn = DriverManager.getConnection(url+"/"+db, username, password);
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_CREATE_TABLE)) {
            preparedStatement.execute();
            preparedStatement.close();;
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    //elimino il db
    public void dropDB () {
        String url = "jdbc:mysql://"+host+":"+port+"/"+db;

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_DROP_DB+db)) {
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    public void addSacca (Sacca s) {
        String url = "jdbc:mysql://"+host+":"+port+"/"+db;

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT)) {

            preparedStatement.setString(1, s.getSeriale().toString());
            preparedStatement.setString(2, s.getGruppo().toString());
            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<Sacca> getSacche(String gruppo_sanguigno) {
        String url = "jdbc:mysql://"+host+":"+port+"/"+db;

        List<Sacca> sacche = new ArrayList<Sacca>();

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_QUERY)){

            preparedStatement.setString(1, gruppo_sanguigno);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                Sacca s = new Sacca(new Seriale(rs.getString(COL_SERIALE)), gruppo_sanguigno);
                sacche.add(s);
            }
            rs.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sacche;
    }

    private String host;
    private String port;
    private String db;

    private static final String TAG_DB = "db_mysql_name";
    private static final String TAG_HOST = "db_mysql_host";
    private static final String TAG_PORT = "db_mysql_port";

    private static final String TABLE_SACCHE = "SACCHE";
    private static final String COL_SERIALE = "SERIALE";
    private static final String COL_GRUPPO = "GRUPPO";

    private static final String username = null;
    private static final String password = null;

    private static final String SQL_CREATE_DB = "CREATE DATABASE IF NOT EXISTS ";

    private static final String SQL_DROP_DB = "DROP DATABASE IF EXISTS ";

    private static final String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_SACCHE
            + "("
            + COL_SERIALE + " varchar(20) NOT NULL,"
            + COL_GRUPPO + " varchar(5) NOT NULL,"
            + " PRIMARY KEY (SERIALE)"
            + ")";

    private static final String SQL_INSERT = "INSERT INTO "+ TABLE_SACCHE +" ("+ COL_SERIALE+", "+COL_GRUPPO+") VALUES (?,?)";

    private static final String SQL_QUERY = "SELECT * FROM " + TABLE_SACCHE +  " WHERE "+ COL_GRUPPO + " = ?";
}
