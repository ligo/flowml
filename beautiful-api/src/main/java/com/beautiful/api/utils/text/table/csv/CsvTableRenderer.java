package com.beautiful.api.utils.text.table.csv;

import au.com.bytecode.opencsv.CSVWriter;
import com.beautiful.api.utils.text.table.TableRenderer;
import com.beautiful.api.utils.text.table.TextTable;

import javax.swing.table.TableModel;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class CsvTableRenderer implements TableRenderer {

    protected String[] formats;
    protected int[] lengths;

    protected TextTable textTable;

    protected TableModel tableModel;

    public CsvTableRenderer(TextTable textTable) {
        this.textTable = textTable;
        this.tableModel = textTable.getTableModel();
    }

    @Override
    public void render(OutputStream ps, int indent) {
        this.render(new OutputStreamWriter(ps), indent);
    }

    @Override
    public void render(Writer w, int indent) {
        TableModel tableModel = textTable.getTableModel();
        try (CSVWriter csvWriter = new CSVWriter(w)) {
            String[] headers = new String[tableModel.getColumnCount()];
            for (int i = 0; i < headers.length; i++) {
                headers[i] = tableModel.getColumnName(i);
            }
            csvWriter.writeNext(headers);
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                String[] line = new String[tableModel.getColumnCount()];
                for (int j = 0; j < tableModel.getColumnCount(); j++) {
                    Object valueAt = tableModel.getValueAt(i, j);
                    line[j] = String.valueOf(valueAt);
                }
                csvWriter.writeNext(line);
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

}
