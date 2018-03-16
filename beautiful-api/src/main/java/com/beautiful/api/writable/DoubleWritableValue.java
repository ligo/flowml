package com.beautiful.api.writable;

import com.beautiful.api.schema.ColumnType;

/**
 * Created by alex.zhu on 2017/11/17.
 */
public class DoubleWritableValue extends WritableValue{

    private double value;

    public DoubleWritableValue(double value) {
        this.value = value;
    }

    @Override
    public Object get() {
        return value;
    }

    @Override
    public ColumnType getColumnType() {
        return ColumnType.DOUBLE;
    }

    @Override
    public int compareTo(WritableValue o) {
        return Double.compare(this.value,((DoubleWritableValue)o).value);
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
