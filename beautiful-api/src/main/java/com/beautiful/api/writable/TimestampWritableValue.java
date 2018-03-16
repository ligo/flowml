package com.beautiful.api.writable;

import com.beautiful.api.schema.ColumnType;

/**
 * Created by alex.zhu on 2017/11/18.
 */
public class TimestampWritableValue extends WritableValue{

    private long value;

    public TimestampWritableValue(long value) {
        this.value = value;
    }

    @Override
    public Object get() {
        return new java.sql.Timestamp(value);
    }

    @Override
    public ColumnType getColumnType() {
        return ColumnType.TIMESTAMP;
    }

    @Override
    public int compareTo(WritableValue o) {
        return Long.compare(value,((TimestampWritableValue)o).value);
    }
}
