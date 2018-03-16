package com.beautiful.api.metadata;


import com.beautiful.api.schema.ColumnType;

/**
 * Created by alex.zhu on 2017/11/14.
 */
public class ComplexArrayMetaData extends BaseColumnMetaData{

    private ColumnMetaData elementMetaData;


    public ComplexArrayMetaData(String name,ColumnMetaData metaData){
        super(name);
        this.elementMetaData=metaData;
    }


    @Override
    public ColumnType getColumnType() {
        return ColumnType.ARRAY;
    }

    @Override
    public ColumnMetaData clone() {
        return new ComplexArrayMetaData(name,elementMetaData);
    }

    public ColumnMetaData getElementMetaData() {
        return elementMetaData;
    }

    public void setElementMetaData(ColumnMetaData elementMetaData) {
        this.elementMetaData = elementMetaData;
    }

    @Override
    public String toString() {
        return "ComplexArrayMetaData{" + "elementMetaData=" + elementMetaData + ", name='" + name + '\'' + '}';
    }
}
