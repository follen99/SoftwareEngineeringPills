package com.ranauro.persistence;

import com.ranauro.sacca.Sacca;

import java.util.List;

public interface DataManager {
    void createDB();        //per creare il database
    void dropDB();          //per eliminare il databse
    void addSacca(Sacca s);        //per aggiungere una sacca al DB

    List<Sacca> getSacche(String gruppo_sanguigno);     //leggere le sacche
}
