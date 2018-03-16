package com.beautiful.api.writable;

import com.beautiful.api.schema.ColumnType;
import org.apache.spark.ml.linalg.Matrices;

import java.util.Arrays;

/**
 * Created by alex.zhu on 2017/11/17.
 */
public class MatrixWritableValue extends WritableValue{

    private Matrix value;

    public MatrixWritableValue(Matrix value) {
        this.value = value;
    }

    public MatrixWritableValue(double[] value,int rows,int cols) {
        this.value = new Matrix(value,rows,cols);
    }

    @Override
    public Object get() {
        // Matrix matMl = MLLibUtil.toMatrix(matIND);
        return Matrices.dense(value.getRows(),value.getCols(),value.getValue());
    }

    @Override
    public ColumnType getColumnType() {
        return ColumnType.MATRIX;
    }

    @Override
    public int compareTo(WritableValue o) {
        int thiscols=this.value.getCols();
        int thisrows=this.value.getRows();
        int thatcols=((MatrixWritableValue)o).value.getCols();
        int thatrows=((MatrixWritableValue)o).value.getRows();
        double[] thisvals=this.value.getValue();
        double[] thatvals=((MatrixWritableValue)o).value.getValue();
        int flag=Integer.compare(thisrows,thatrows);
        if(flag==0){
            flag=Integer.compare(thiscols,thatcols);
            if(flag==0){
                if(Arrays.equals(thisvals,thatvals)) return 0;
                for (int i = 0; i < thisvals.length; i++) {
                     double thisval=thisvals[i];
                     double thatval=thatvals[i];
                    if (Double.compare(thisval, thatval) != 0) {
                        return Double.compare(thisval, thatval);
                    }

                }

            }
        }
        return flag;
    }
}
