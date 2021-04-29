package Manager;

import Sangue.Sacca;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.Properties;

public class MySQLDataManager implements DataManager {
    //l'obbiettivo del manager è quello di fornire dei metodi che permettano l'utilizzo del database con un programma java

    /**
     * costruttore
     * */
    public MySQLDataManager(){

        Properties loadProps = new Properties();

        try {
            loadProps.loadFromXML(new FileInputStream("src/main/java/res/db_settings.xml")); //C:\Users\giuli\Documents\MyStuff\Universita\ing software\GitHub\SoftwareEngineeringPills\MySQLDatabase\src\main\java\res
        } catch (InvalidPropertiesFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //una volta creato l'oggetto posso accedere al suo contenuto
        host = loadProps.getProperty("db_host");
        db = loadProps.getProperty("db_name");

        try {
            loadProps.loadFromXML(new FileInputStream("src/main/java/res/credentials.xml")); //C:\Users\giuli\Documents\MyStuff\Universita\ing software\GitHub\SoftwareEngineeringPills\MySQLDatabase\src\main\java\res
        } catch (InvalidPropertiesFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //leggo anche username e password
        username = loadProps.getProperty("login");
        password = loadProps.getProperty("password");

    }





    @Override
    public void createDB() {
        String url = "jdbc:mysql://"+host;      //stringa di default per la connessione

        try {
            Connection connection = DriverManager.getConnection(url, this.username, this.password);       //mi connetto al database
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_CREATE_DB+" "+db);
            try {
                preparedStatement.execute();    //eseguo la query
                preparedStatement.close();      //chiudo la connessione
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        } catch (SQLException throwables) {
            //something se non riesco a connettermi al database
            throwables.printStackTrace();
        }
    }

    public void createTable(){
        String url = "jdbc:mysql://"+host;

        try {
            Connection connection = DriverManager.getConnection(url+"/"+db, this.username, this.password);
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_CREATE_TABLE);

            try {
                preparedStatement.execute();
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void addItemsToSacche(int amount){
        String url = "jdbc:mysql://"+host;

        for (int i = 0; i<amount; i++){ //inefficiente da cambiare

            try (Connection conn = DriverManager.getConnection(url+"/"+db, username, password);
                 PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO sacche (SERIALE, GRUPPO)"+
                         "values('seriale"+i+"', 'gr"+i+"');")){

                preparedStatement.execute();
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }


    @Override
    public List<Sacca> getSacche(String sacca) {
        return null;
    }

    private static final String SQL_CREATE_DB = "CREATE DATABASE IF NOT EXISTS";    //creo un database se non è gia presente
    private static final String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS SACCHE"
            + "("
            + " SERIALE varchar(20) NOT NULL,"
            + " GRUPPO varchar(5) NOT NULL,"
            + " PRIMARY KEY (SERIALE)"
            + ")";

    private static final String SQL_INSERT = "INSERT INTO SACCHE (SERIALE, GRUPPO) VALUES (?,?)";

    private static final String SQL_QUERY = "SELECT * FROM sacche WHERE GRUPPO = ";

    private String host = null;
    private String db = null;

    private String username = null;
    private String password = null;
}
