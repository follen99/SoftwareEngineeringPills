package it.ranauro;

import org.junit.*;

public class TestUnaClasse {
    UnaClasse uc;

    @Before
    public void prima(){
        uc = new UnaClasse();       //per prima cosa creo la classe
    }

    @Test
    public void testOk() throws UnaClasse.EccezioneNonVoglioZero{
        Assert.assertEquals(100, uc.unMetodo(100));
        //mi aspetto che il metodo della classe mi restituisca il mio numero,
        //datoo che è diverso da 0
    }

    /**
     * per testare il throw di una eccezione, si aggiunge vicino a @Test
     * il fatto che ci aspettiamo un'istanza di eccezione.*/
    @Test(expected = UnaClasse.EccezioneNonVoglioZero.class)
    public void testNotOK() throws UnaClasse.EccezioneNonVoglioZero{
        Assert.assertEquals(100, uc.unMetodo(0));
    }




    // ############ come testo un metodo privato ?? ############
    /**
     * ci sono varie opzioni:
     * 1) i metodi privati non vengono testati, per via del fatto che verranno testati inevitabilmente
     *      quando testerò i metodi pubblici
     *
     * 2) posso scrivere degli appositi metodi di test per testare
     * i metodi privati.*/
}
