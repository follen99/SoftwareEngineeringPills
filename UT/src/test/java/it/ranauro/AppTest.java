package it.ranauro;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */

    /**
     * Nel progetto non ho alcun main, ma posso eseguire i metodi come test.
     * utilizzo una notazione specifica, come lo statement "assertTrue" */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue( 0 == 0 );
    }
    @Test
    public void shouldAnswerWithFalse(){
        assertTrue( !(0==1));
        /**
         * Mi aspetto falso, se non mi arriva falso il test sarà fallito.*/
    }

    @Test
    public void testWillFail(){
        assertTrue( !(0==0));
        /**
         * Mi aspetto falso, se non mi arriva falso il test sarà fallito.*/
    }


}
