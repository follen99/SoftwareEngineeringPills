import Manager.DataManager;
import Manager.MySQLDataManager;
import org.junit.Before;
import org.junit.Test;

public class TestXmlRead {
    @Before
    public void createClass(){
        dm = new MySQLDataManager();
    }

    @Test
    public void createDatabase(){
        dm.createDB();
    }

    @Test
    public void createTable(){
        dm.createTable();
    }

    public void populate(){
        dm.addItemsToSacche(20);
    }

    DataManager dm;
}
