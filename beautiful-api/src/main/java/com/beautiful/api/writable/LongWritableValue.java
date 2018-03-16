package com.beautiful.api.writable;

import com.beautiful.api.schema.ColumnType;

/**
 * Created by alex.zhu on 2017/11/17.
 */
public class LongWritableValue extends WritableValue{

    private long value;

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public LongWritableValue(long value) {
        this.value = value;
    }



    @Override
    public int compareTo(WritableValue o) {
        return Long.compare(this.value,((LongWritableValue)o).value);
    }

    @Override
    public Object get() {
        return Long.valueOf(value);
    }

    @Override
    public ColumnType getColumnType() {
        return ColumnType.LONG;
    }
}
