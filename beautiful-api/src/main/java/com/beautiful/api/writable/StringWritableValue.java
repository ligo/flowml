package com.beautiful.api.writable;

import com.beautiful.api.schema.ColumnType;

/**
 * Created by alex.zhu on 2017/11/17.
 */
public class StringWritableValue extends WritableValue{

    private String value;

    public StringWritableValue(String value) {
        this.value = value;
    }

    @Override
    public Object get() {
        return value;
    }

    @Override
    public ColumnType getColumnType() {
        return ColumnType.STRING;
    }

    @Override
    public int compareTo(WritableValue o) {
        return this.value.compareTo(((StringWritableValue)o).value);
    }
}
