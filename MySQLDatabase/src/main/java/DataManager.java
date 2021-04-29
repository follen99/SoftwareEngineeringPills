import java.util.List;

/**
 * Questa è l'interfaccia che ci permette di usare la nostra classe MySQLDataManager
 * deve dichiarare i metodi che MySQLDataManager dovrà impolementare. */

public interface DataManager {
    void createDB();        //metodo che crea il database
    void addItemsToSacche(int amount);      //metodo che aggiunge sacche al database
    //List<> getSacche(String sacca);
}
