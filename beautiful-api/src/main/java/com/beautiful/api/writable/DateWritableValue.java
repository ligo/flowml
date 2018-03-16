package com.beautiful.api.writable;

import com.beautiful.api.schema.ColumnType;

import java.util.Date;

/**
 * Created by alex.zhu on 2017/11/18.
 */
public class DateWritableValue extends WritableValue{

    private long value;

    public DateWritableValue(long value) {
        this.value = value;
    }

    @Override
    public Object get() {
        return new Date(value);
    }

    @Override
    public ColumnType getColumnType() {
        return ColumnType.TIMESTAMP;
    }

    @Override
    public int compareTo(WritableValue o) {
        return Long.compare(value,((DateWritableValue)o).value);
    }
}
