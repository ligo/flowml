package com.beautiful.api.writable;

import com.beautiful.api.schema.ColumnType;

/**
 * Created by alex.zhu on 2017/11/17.
 */
public class BooleanWritableValue extends WritableValue{

    private boolean value;

    public BooleanWritableValue(boolean value) {
        this.value = value;
    }


    @Override
    public Object get() {
        return Boolean.valueOf(value);
    }

    @Override
    public ColumnType getColumnType() {
        return ColumnType.BOOLEAN;
    }

    @Override
    public int compareTo(WritableValue o) {
        return Boolean.compare(value,((BooleanWritableValue)o).value);
    }
}
