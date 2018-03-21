package beautiful;

import com.beautiful.api.utils.text.table.TextTable;
import org.junit.Test;

/**
 * @Description:
 * @Author: zhuyuping
 * @CreateDate: 2018/3/21 下午7:54
 **/

public class TestPrintTable {


    @Test
    public void testPrint() throws Exception {

        String[] columnNames = {
                "First Name",
                "Last Name",
                "Sport",
                "# of Years",
                "Vegetarian"};

        Object[][] data = {
                {"Kathy", "Smith",
                        "Snowboarding", new Integer(5), new Boolean(false)},
                {"John", "Doe",
                        "Rowing", new Integer(3), new Boolean(true)},
                {"Sue", "Black",
                        "Knitting", new Integer(2), new Boolean(false)},
                {"Jane", "White",
                        "Speed reading", new Integer(20), new Boolean(true)}, {"Joe", "Brown",
                "Pool", new Integer(10), new Boolean(false)}
        };

        TextTable tt = new TextTable(columnNames, data);
        // this adds the numbering on the left
        tt.setAddRowNumbering(true);
        // sort by the first column
        tt.setSort(0);
        //tt.printTable();
        System.out.println(tt.printString());

    }

}
