package com.beautiful.api.utils.text.table;

import javax.swing.table.AbstractTableModel;

public abstract class TextTableModel extends AbstractTableModel {

    /**
     *
     */
    private static final long serialVersionUID = -663028121137688537L;

    public abstract boolean allowNumberingAt(int row);

    public abstract boolean addSeparatorAt(int row);
}
