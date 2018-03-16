package com.beautiful.api.writable;

import java.io.Serializable;

/**
 * Created by alex.zhu on 2017/11/17.
 */
public class Matrix implements Serializable{

    private double[] value;

    private int rows;

    private int cols;

    public Matrix(double[] value, int rows, int cols) {
        this.value = value;
        this.rows = rows;
        this.cols = cols;
    }

    public double[] getValue() {
        return value;
    }

    public void setValue(double[] value) {
        this.value = value;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }
}
