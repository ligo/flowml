package com.beautiful.api.metadata;

/**
 * Created by alex.zhu on 2017/11/17.
 */
public abstract class BaseColumnMetaData implements ColumnMetaData{
    protected String name;

    protected BaseColumnMetaData(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public abstract ColumnMetaData clone();

}
