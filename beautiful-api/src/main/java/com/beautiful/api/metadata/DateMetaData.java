package com.beautiful.api.metadata;


import com.beautiful.api.schema.ColumnType;

public class DateMetaData extends BaseColumnMetaData {


    public DateMetaData(String name) {
        super(name);
    }


    @Override
    public ColumnType getColumnType() {
        return ColumnType.DATE;
    }

    @Override
    public ColumnMetaData clone() {
        return new DateMetaData(name);
    }

}
