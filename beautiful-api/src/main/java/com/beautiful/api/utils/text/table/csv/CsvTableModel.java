package com.beautiful.api.utils.text.table.csv;

import au.com.bytecode.opencsv.CSVReader;

import javax.swing.table.AbstractTableModel;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Daniel Orr
 */
public class CsvTableModel extends AbstractTableModel {

    private String[] columnNames;
    private List<String[]> lines = new ArrayList<>();

    public CsvTableModel(File csvFile) throws IOException {
        this(new FileReader(csvFile));
    }

    public CsvTableModel(String csvString) throws IOException {
        this(new StringReader(csvString));
    }

    public CsvTableModel(Reader reader) throws IOException {
        try (CSVReader csvReader = new CSVReader(reader)) {
            String[] line = null;
            boolean first = true;
            while ((line = csvReader.readNext()) != null) {
                if (first) {
                    columnNames = line;
                    first = false;
                } else {
                    lines.add(line);
                }
            }
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public int getRowCount() {
        return lines.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String[] line = lines.get(rowIndex);
        return line[columnIndex];
    }

}
