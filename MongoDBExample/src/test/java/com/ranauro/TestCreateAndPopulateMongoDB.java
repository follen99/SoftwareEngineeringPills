package com.ranauro;

import com.ranauro.persistence.DataManager;
import com.ranauro.persistence.MyMongoDataManager;
import com.ranauro.sacca.Sacca;
import com.ranauro.sacca.Seriale;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestCreateAndPopulateMongoDB {
    public static void main(String[] args) {

        Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
        mongoLogger.setLevel(Level.SEVERE);

        DataManager dm = (DataManager) new MyMongoDataManager();
        dm.createDB();

        final int NUMSACCHE=5;
        ArrayList<String> gruppi = new ArrayList<>();
        gruppi.add("Ap");
        gruppi.add("Am");
        gruppi.add("Bp");
        gruppi.add("ZEROp");
        gruppi.add("ZEROm");
        gruppi.add("ABp");
        gruppi.add("ABm");
        Random generatore = new Random();
        Sacca s;
        for (int i=0; i<NUMSACCHE; i++) {
            s = new Sacca(gruppi.get(generatore.nextInt(gruppi.size())));
            dm.addSacca(s);
            System.out.println("Added sacca: "+s);
        }

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                Seriale.updateSettings();
            }
        }));

    }
}
