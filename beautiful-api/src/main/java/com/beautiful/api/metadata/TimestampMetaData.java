package com.beautiful.api.metadata;


import com.beautiful.api.schema.ColumnType;

public class TimestampMetaData extends BaseColumnMetaData {


    public TimestampMetaData(String name) {
        super(name);
    }


    @Override
    public ColumnType getColumnType() {
        return ColumnType.TIMESTAMP;
    }

    @Override
    public ColumnMetaData clone() {
        return new TimestampMetaData(name);
    }

}
