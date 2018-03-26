package com.beautiful.api.metadata;


import com.beautiful.api.schema.ColumnType;

/**
 * Created by alex.zhu on 2017/11/14.
 *
 */
public class ComplexMapMetaData extends BaseColumnMetaData{

    private ColumnMetaData keyMetaData;
    private ColumnMetaData valueMetaData;


    public ComplexMapMetaData(String name, ColumnMetaData keyMetaData, ColumnMetaData valueMetaData) {
        super(name);
        this.keyMetaData=keyMetaData;
        this.valueMetaData=valueMetaData;

    }


    @Override
    public ColumnType getColumnType() {
        return ColumnType.MAP;
    }

    @Override
    public ColumnMetaData clone() {
        return new ComplexMapMetaData(name,keyMetaData,valueMetaData);
    }

    public ColumnMetaData getKeyMetaData() {
        return keyMetaData;
    }

    public void setKeyMetaData(ColumnMetaData keyMetaData) {
        this.keyMetaData = keyMetaData;
    }

    public ColumnMetaData getValueMetaData() {
        return valueMetaData;
    }

    public void setValueMetaData(ColumnMetaData valueMetaData) {
        this.valueMetaData = valueMetaData;
    }

}
