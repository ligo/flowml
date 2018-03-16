package com.beautiful.api.writable;

import java.io.Serializable;

/**
 * Created by alex.zhu on 2017/11/17.
 */
public class Vector implements Serializable{

    private double[] value;

    private int length;

    public Vector(double[] value) {
        this.value = value;
        this.length=value.length;
    }


    public double[] getValue() {
        return value;
    }

    public void setValue(double[] value) {
        this.value = value;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }



}
