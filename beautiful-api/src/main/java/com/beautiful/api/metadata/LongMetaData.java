package com.beautiful.api.metadata;


import com.beautiful.api.schema.ColumnType;

public class LongMetaData extends BaseColumnMetaData {


    public LongMetaData(String name) {
        super(name);

    }

    @Override
    public ColumnType getColumnType() {
        return ColumnType.LONG;
    }

    @Override
    public ColumnMetaData clone() {
        return new LongMetaData(name);
    }


}
