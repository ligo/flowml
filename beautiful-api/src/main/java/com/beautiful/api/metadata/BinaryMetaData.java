package com.beautiful.api.metadata;


import com.beautiful.api.schema.ColumnType;

public class BinaryMetaData extends BaseColumnMetaData {


    public BinaryMetaData(String name) {
        super(name);
    }


    @Override
    public ColumnType getColumnType() {
        return ColumnType.BINARY;
    }

    @Override
    public ColumnMetaData clone() {
        return new BinaryMetaData(name);
    }

    @Override
    public String toString() {
        return "BinaryMetaData{" + "name='" + name + '\'' + '}';
    }
}
