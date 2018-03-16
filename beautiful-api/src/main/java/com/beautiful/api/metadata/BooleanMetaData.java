package com.beautiful.api.metadata;


import com.beautiful.api.schema.ColumnType;

public class BooleanMetaData extends BaseColumnMetaData {


    public BooleanMetaData(String name) {
        super(name);
    }

    @Override
    public ColumnType getColumnType() {
        return ColumnType.BOOLEAN;
    }

    @Override
    public ColumnMetaData clone() {
        return new BooleanMetaData(name);
    }

    @Override
    public String toString() {
        return "BooleanMetaData{" + "name='" + name + '\'' + '}';
    }
}
