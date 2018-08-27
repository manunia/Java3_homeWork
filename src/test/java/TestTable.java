import lesson6.Table;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

public class TestTable {

    Table table;

    @Before
    public void init() {
        table = new Table();
    }

    //проверка чтения
    @Test
    public void test1() {
        try {
            Assert.assertEquals("Bob1",table.read());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //проверка записи
    @Test
    public void test2() {
        try {
            Assert.assertEquals("Bob9", table.insert("Bob9", 12));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
