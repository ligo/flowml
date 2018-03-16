package com.beautiful.api.writable;

import com.beautiful.api.schema.ColumnType;

/**
 * Created by alex.zhu on 2017/11/17.
 */
public class EnumWritableValue extends WritableValue{

    private String value;

    public EnumWritableValue(String value) {
        this.value = value;
    }

    @Override
    public Object get() {
        return value;
    }

    @Override
    public ColumnType getColumnType() {
        return ColumnType.ENUM;
    }

    @Override
    public int compareTo(WritableValue o) {
        return value.compareTo(((EnumWritableValue)o).value);
    }
}
