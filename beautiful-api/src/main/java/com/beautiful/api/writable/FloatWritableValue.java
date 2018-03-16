package com.beautiful.api.writable;

import com.beautiful.api.schema.ColumnType;

/**
 * Created by alex.zhu on 2017/11/17.
 */
public class FloatWritableValue extends WritableValue{

    private float value;

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public FloatWritableValue(float value) {
        this.value = value;
    }



    @Override
    public int compareTo(WritableValue o) {
        return Float.compare(this.value,((FloatWritableValue)o).value);
    }

    @Override
    public Object get() {
        return Float.valueOf(value);
    }

    @Override
    public ColumnType getColumnType() {
        return ColumnType.FLOAT;
    }
}
