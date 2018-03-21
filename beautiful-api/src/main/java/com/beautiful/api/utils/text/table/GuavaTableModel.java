package com.beautiful.api.utils.text.table;

import com.google.common.collect.Lists;
import com.google.common.collect.Table;

import javax.swing.table.AbstractTableModel;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @author Daniel Orr
 */
public class GuavaTableModel<V> extends AbstractTableModel {

    private Table<Integer, String, V> guavaTable;
    private List<String> columnNames;
    private int rowCount;

    public GuavaTableModel(Table<Integer, String, V> guavaTable) {
        this.guavaTable = guavaTable;
        this.columnNames = Lists.newArrayList(guavaTable.columnKeySet());
        Collections.sort(this.columnNames);
        Set<Integer> rowIndexes = this.guavaTable.rowKeySet();
        this.rowCount = Collections.max(rowIndexes) + 1;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames.get(column);
    }

    @Override
    public int getRowCount() {
        return rowCount;
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return guavaTable.get(rowIndex, columnNames.get(columnIndex));
    }
}
