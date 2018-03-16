package com.beautiful.api.writable;

import com.beautiful.api.schema.ColumnType;

/**
 * Created by alex.zhu on 2017/11/17.
 */
public class ByteWritableValue extends WritableValue{

    private byte value;

    public ByteWritableValue(byte value) {
        this.value = value;
    }

    @Override
    public Object get() {
        return Byte.valueOf(value);
    }

    @Override
    public ColumnType getColumnType() {
        return ColumnType.BYTE;
    }

    @Override
    public int compareTo(WritableValue o) {
        return Byte.compare(this.value,((ByteWritableValue)o).value);
    }

}
