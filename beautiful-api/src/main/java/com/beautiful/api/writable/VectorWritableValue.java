package com.beautiful.api.writable;

import com.beautiful.api.schema.ColumnType;
import org.apache.spark.ml.linalg.Vectors;

import java.util.Arrays;

/**
 * Created by alex.zhu on 2017/11/17.
 */
public class VectorWritableValue extends WritableValue{

    private Vector value;

    public VectorWritableValue(Vector value) {

        this.value = value;
    }

    public VectorWritableValue(double[] value) {

        this.value = new Vector(value);
    }

    @Override
    public Object get() {

        return Vectors.dense(value.getValue());
    }

    @Override
    public ColumnType getColumnType() {
        return ColumnType.VECTOR;
    }

    @Override
    public int compareTo(WritableValue o) {
        double[] thisval=this.value.getValue();
        double[] thatval=((VectorWritableValue)o).value.getValue();
        if(Arrays.equals(thisval,thatval)) return 0;
        try {
            return Long.compare(WritableComparatorUtils.readVLong(WritableComparatorUtils.toByteArray(thisval), 0), WritableComparatorUtils.readVLong(WritableComparatorUtils.toByteArray(thatval), 0));
        }catch (Exception e){
            return Integer.compare(thisval.length,thatval.length);
        }
    }
}
