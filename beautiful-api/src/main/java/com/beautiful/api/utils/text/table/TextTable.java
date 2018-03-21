package com.beautiful.api.utils.text.table;


import com.beautiful.api.utils.text.table.csv.CsvTableRenderer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Daniel Orr
 */
public class TextTable {

    protected TableModel tableModel;
    protected List<SeparatorPolicy> separatorPolicies = new ArrayList<SeparatorPolicy>();

    protected boolean addRowNumbering;

    protected RowSorter<?> rowSorter;

    protected boolean headless;

    public TextTable(TableModel tableModel) {
        this.tableModel = tableModel;
    }

    public TextTable(TableModel tableModel, boolean addNumbering) {
        this.tableModel = tableModel;
        this.addRowNumbering = addNumbering;
    }

    public TextTable(String[] columnNames, Object[][] data) {
        this.tableModel = new DefaultTableModel(data, columnNames);
    }

    public TextTable(String[] columnNames, List<Object[]> datas) {
        Object[][] arr = new Object[datas.size()][];
        Object[][] arrobj = datas.toArray(arr);
        this.tableModel = new DefaultTableModel(arrobj, columnNames);
    }


    public TableModel getTableModel() {
        return tableModel;
    }

    public void setAddRowNumbering(boolean addNumbering) {
        this.addRowNumbering = addNumbering;
    }

    public void addSeparatorPolicy(SeparatorPolicy separatorPolicy) {
        separatorPolicies.add(separatorPolicy);
        separatorPolicy.setTableModel(tableModel);
    }

    public void setSort(int column) {
        setSort(column, SortOrder.ASCENDING);
    }

    public void setSort(int column, SortOrder sortOrder) {
        rowSorter = new TableRowSorter<TableModel>(this.tableModel);
        List<RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>();
        // sortKeys.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));
        sortKeys.add(new RowSorter.SortKey(column, sortOrder));
        rowSorter.setSortKeys(sortKeys);
    }

    public void printTable() {
        printTable(System.out, 0);
    }

    public String printString() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        TextTableRenderer renderer = new TextTableRenderer(this);
        renderer.render(byteArrayOutputStream, 0);
        return new String(byteArrayOutputStream.toByteArray(), "UTF-8");
    }

    public void printTable(PrintStream ps, int indent) {
        TextTableRenderer renderer = new TextTableRenderer(this);
        renderer.render(ps, indent);
    }

    public void toCsv(OutputStream os) {
        CsvTableRenderer csvTableRenderer = new CsvTableRenderer(this);
        csvTableRenderer.render(os, 0);
    }

    protected Object getValueAt(int row, int column) {
        int rowIndex = row;
        if (rowSorter != null) {
            rowIndex = rowSorter.convertRowIndexToModel(row);
        }
        return tableModel.getValueAt(rowIndex, column);
    }

    protected boolean hasSeparatorAt(int row) {
        for (SeparatorPolicy separatorPolicy : separatorPolicies) {
            if (separatorPolicy.hasSeparatorAt(row)) {
                return true;
            }
        }
        return false;
    }

}
