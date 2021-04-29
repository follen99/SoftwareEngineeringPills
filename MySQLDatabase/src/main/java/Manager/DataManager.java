package Manager;

import Sangue.Sacca;

import java.util.List;

/**
 * Questa è l'interfaccia che ci permette di usare la nostra classe Manager.MySQLDataManager
 * deve dichiarare i metodi che Manager.MySQLDataManager dovrà impolementare. */

public interface DataManager {
    void createDB();        //metodo che crea il database
    void createTable();     //metodo che crea una tabella
    void addItemsToSacche(int amount);      //metodo che aggiunge sacche al database
    List<Sacca> getSacche(String sacca);
}
