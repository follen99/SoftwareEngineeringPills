package it.ranauro;

import org.junit.Assert;
import org.junit.Test;

public class ABSTest {
    @Test
    /**
     * testing del valore assoluto*/
    public void testAbs_Positive(){
        /**
         * devo confrontare '5' con l'abs di 5ù
         *
         * "se ti do un numero positivo e ti chiedo di fare il valore assoluto, deve essere uguale a quel numero.*/
        Assert.assertEquals(5, Math.abs(5));
    }

    @Test
    public void testAbs_Negative(){
        /**
         * il valore assoluto di -5 DEVE essere uguale a 5*/
        Assert.assertEquals(5, Math.abs(-5));
    }

    //######################## CASI PARTICOLARI ########################

    @Test
    public void testAbs_Max(){
        /**
         * il valore assoluto del piu piccolo intero che posso rappresentare in java
         * è uguale al valore assoluto del valore piu grande che posso rappresentare
         *
         * ovviamente il test fallisce perchè ciò non è vero.*/

        Assert.assertEquals(Integer.MAX_VALUE, Math.abs(Integer.MIN_VALUE));

        //questo test invece sarebbe positivo:
        //Assert.assertNotEquals(Integer.MAX_VALUE, Math.abs(Integer.MIN_VALUE));
    }

    /**
     * in qualsiasi momento posso rieseguire i test, anche già fatti.
     * tecnicamente potrei elaborare un ipotetico test (lungo) durante la notte
     * e poter rivedere i report il giorno dopo.*/
}
