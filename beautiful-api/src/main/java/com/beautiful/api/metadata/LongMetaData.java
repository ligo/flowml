package com.beautiful.api.metadata;


import com.beautiful.api.schema.ColumnType;

public class LongMetaData extends BaseColumnMetaData {

    private final Long minAllowedValue;
    private final Long maxAllowedValue;

    public LongMetaData(String name) {
        this(name, null, null);
    }

    public LongMetaData(String name,Long minAllowedValue,
                    Long maxAllowedValue) {
        super(name);
        this.minAllowedValue = minAllowedValue;
        this.maxAllowedValue = maxAllowedValue;
    }

    @Override
    public ColumnType getColumnType() {
        return ColumnType.LONG;
    }

    @Override
    public ColumnMetaData clone() {
        return new LongMetaData(name,minAllowedValue,maxAllowedValue);
    }

    @Override
    public String toString() {
        return "LongMetaData{" + "minAllowedValue=" + minAllowedValue + ", maxAllowedValue=" + maxAllowedValue + ", name='" + name + '\'' + '}';
    }
}
