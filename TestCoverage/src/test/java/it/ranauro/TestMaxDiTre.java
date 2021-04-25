package it.ranauro;

import org.junit.Assert;
import org.junit.Test;

public class TestMaxDiTre {
    //non c'è bisogno di creare un oggetto con @Before

    /**
     * PER TORNARE N1
     * n1 deve essere piu grande sia di n2 che di n3
     *
     * PER TORNARE N2
     * n2 deve essere piu grande di n1 e di n3
     *
     * PER TORNARE N3
     *  n1 deve essere piu grande di n2, ma piu piccolo di n3*/

    @Test
    /**
     * effettuo l'assert per controllare se il metodo restituisce 1,
     * fallisce perchè il metodo ritorna 3*/
    public void testFailure(){
        Assert.assertEquals(1,MaxDiTre.max(1,2,3));
    }

    @Test
    /**
     * mi aspetto che il metodo restituisca 1, dato che sia n2 che n3 sono piu
     * piccoli di n1*/
    public void testExpectingOne(){
        Assert.assertEquals(1,MaxDiTre.max(1,-1,-2));
    }

    @Test
    /**
     * mi aspetto che mi venga ritornato il terzo numero,
     * dato che per avere il terzo argomento esso deve essere piu grande di n1 e di n2,
     * con la clausola che n1 sia piu grande di n2*/
    public void testExpectingThree(){
        Assert.assertEquals(3,MaxDiTre.max(2,1,3));
    }
}
