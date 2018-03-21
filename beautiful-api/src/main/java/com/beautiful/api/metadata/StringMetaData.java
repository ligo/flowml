package com.beautiful.api.metadata;


import com.beautiful.api.schema.ColumnType;

public class StringMetaData extends BaseColumnMetaData {


    public StringMetaData(String name) {
        super(name);

    }

    @Override
    public ColumnType getColumnType() {
        return ColumnType.STRING;
    }

    @Override
    public ColumnMetaData clone() {
        return new StringMetaData(name);
    }


}
