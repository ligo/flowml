package com.beautiful.api.metadata;


import com.beautiful.api.schema.ColumnType;

import java.io.Serializable;

/**
 * Created by alex.zhu on 2017/11/10.
 */
public interface ColumnMetaData extends Serializable, Cloneable {

    String getName();

    void setName(String name);

    ColumnType getColumnType();

    public ColumnMetaData clone();




}

