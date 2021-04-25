package it.ranauro;

import static org.junit.Assert.assertTrue;

import org.junit.*;

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



    //################################## ALTRE FAMIGLIE DI TEST ##################################
    // Before e After
    // BeforeClass e AfterClass

    @Before
    /**
     * il metodo annotato con 'Before' viene eseguito prima di ogni testCase.*/
    public void prima(){
        System.out.println("prima");
    }

    @After
    /**
     * il metodo annotato con 'After' viene eseguito dopo ogni testCase.*/
    public void dopo(){
        System.out.println("dopo");
    }

    @BeforeClass
    /**
     * il metodo annotato con 'BeforeClass' viene eseguito una volta per tutte prima di iniziare l'esecuzione di TUTTI
     * i test case.*/
    public static void primaClasse(){
        System.out.println("prima prima");
    }

    @AfterClass
    /**
     * il metodo annotato con 'Afterclass' viene eseguito una volta per tutte dopo di iniziare l'esecuzione di TUTTI
     * i test case.*/
    public static void dopoClasse(){
        System.out.println("dopo dopo");
    }
}

/**
 * l'output che mi aspetto è il seguente:
 * prima prima
 * prima
 * dopo
 * prima
 * dopo
 * prima
 * dopo
 *
 * ERRORE
 *
 * dopo dopo*/