package com.beautiful.api.metadata;


import com.beautiful.api.schema.ColumnType;

/**
 * Created by alex.zhu on 2017/11/15.
 */
public class VectorMetaData extends BaseColumnMetaData {


    public VectorMetaData(String name) {
        super(name);
    }


    @Override
    public ColumnType getColumnType() {
        return ColumnType.VECTOR;
    }

    @Override
    public ColumnMetaData clone() {
        return new VectorMetaData(name);
    }


}
