package com.beautiful.api.writable;

import com.beautiful.api.schema.ColumnType;

/**
 * Created by alex.zhu on 2017/11/17.
 */
public class IntWritableValue extends WritableValue{

    private Integer value;

    public IntWritableValue(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public int compareTo(WritableValue o) {
        return Integer.compare(this.value,((IntWritableValue)o).value);
    }

    @Override
    public Object get() {
        return value;
    }

    @Override
    public ColumnType getColumnType() {
        return ColumnType.INTEGER;
    }
}
