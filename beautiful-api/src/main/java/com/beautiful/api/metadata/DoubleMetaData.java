package com.beautiful.api.metadata;


import com.beautiful.api.schema.ColumnType;

public class DoubleMetaData extends BaseColumnMetaData {

    public DoubleMetaData(String name) {
        super(name);
    }

    @Override
    public ColumnType getColumnType() {
        return ColumnType.DOUBLE;
    }

    @Override
    public ColumnMetaData clone() {
        return new DoubleMetaData(name);
    }


}
