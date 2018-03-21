package com.beautiful.api.metadata;


import com.beautiful.api.schema.ColumnType;

public class IntegerMetaData extends BaseColumnMetaData {

    public IntegerMetaData(String name) {
        super(name);
    }

    @Override
    public ColumnType getColumnType() {
        return ColumnType.INTEGER;
    }

    @Override
    public ColumnMetaData clone() {
        return new IntegerMetaData(name);
    }


}
