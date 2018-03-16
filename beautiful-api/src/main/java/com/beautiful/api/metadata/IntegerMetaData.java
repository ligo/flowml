package com.beautiful.api.metadata;


import com.beautiful.api.schema.ColumnType;

public class IntegerMetaData extends BaseColumnMetaData {

    private final Integer minAllowedValue;
    private final Integer maxAllowedValue;

    public IntegerMetaData(String name) {
        this(name, null, null);
    }

    /**
     * @param min Min allowed value. If null: no restriction on min value value in this column
     * @param max Max allowed value. If null: no restiction on max value in this column
     */
    public IntegerMetaData(String name,Integer min,
                    Integer max) {
        super(name);
        this.minAllowedValue = min;
        this.maxAllowedValue = max;
    }

    @Override
    public ColumnType getColumnType() {
        return ColumnType.INTEGER;
    }

    @Override
    public ColumnMetaData clone() {
        return new IntegerMetaData(name,minAllowedValue,maxAllowedValue);
    }

    @Override
    public String toString() {
        return "IntegerMetaData{" + "minAllowedValue=" + minAllowedValue + ", maxAllowedValue=" + maxAllowedValue + ", name='" + name + '\'' + '}';
    }
}
