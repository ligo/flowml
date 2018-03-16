package com.beautiful.api.metadata;


import com.beautiful.api.schema.ColumnType;


public class ByteMetaData extends BaseColumnMetaData {


    public ByteMetaData(String name) {
        super(name);
    }

    @Override
    public ColumnType getColumnType() {
        return ColumnType.BYTE;
    }

    @Override
    public ColumnMetaData clone() {
        return new ByteMetaData(name);
    }

    @Override
    public String toString() {
        return "ByteMetaData{" + "name='" + name + '\'' + '}';
    }
}
