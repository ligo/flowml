package com.beautiful.api.writable;

import com.beautiful.api.schema.ColumnType;

import java.io.Serializable;

/**
 * Created by alex.zhu on 2017/11/17.
 */
public abstract class WritableValue implements Serializable,Comparable<WritableValue> {
    public abstract Object get();
    public abstract ColumnType getColumnType();

}
