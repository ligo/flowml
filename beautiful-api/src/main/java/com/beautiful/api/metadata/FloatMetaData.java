package com.beautiful.api.metadata;


import com.beautiful.api.schema.ColumnType;

public class FloatMetaData extends BaseColumnMetaData {


    public FloatMetaData(String name) {
        super(name);
    }
    @Override
    public ColumnType getColumnType() {
        return ColumnType.FLOAT;
    }

    @Override
    public ColumnMetaData clone() {
        return new FloatMetaData(name);
    }


}
