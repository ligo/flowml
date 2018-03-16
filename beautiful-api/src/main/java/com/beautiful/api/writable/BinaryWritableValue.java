package com.beautiful.api.writable;

import com.beautiful.api.schema.ColumnType;

import java.util.Arrays;

/**
 * Created by alex.zhu on 2017/11/17.
 */
public class BinaryWritableValue extends WritableValue{

    private byte[] value;


    @Override
    public Object get() {
        return value;
    }

    @Override
    public ColumnType getColumnType() {
        return ColumnType.BINARY;
    }

    @Override
    public int compareTo(WritableValue o) {
        boolean flag=Arrays.equals(this.value,((BinaryWritableValue)o).value);
        if(flag) return 0;
        try {
            return Integer.compare(WritableComparatorUtils.readVInt(this.value, 0), WritableComparatorUtils.readVInt(((BinaryWritableValue) o).value, 0));
        }catch (Exception e){
            return -1;
        }

    }
}
