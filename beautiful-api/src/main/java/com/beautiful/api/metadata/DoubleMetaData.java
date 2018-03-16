package com.beautiful.api.metadata;


import com.beautiful.api.schema.ColumnType;

public class DoubleMetaData extends BaseColumnMetaData {

    private final Double minAllowedValue;
    private final Double maxAllowedValue;
    private final boolean allowNaN;
    private final boolean allowInfinite;

    public DoubleMetaData(String name) {
        this(name, null, null, false, false);
    }

    /**
     * @param minAllowedValue Min allowed value. If null: no restriction on minAllowedValue value value in this column
     * @param maxAllowedValue Max allowed value. If null: no restiction on maxAllowedValue value in this column
     */
    public DoubleMetaData(String name, Double minAllowedValue,
                    Double maxAllowedValue) {
        this(name, minAllowedValue, maxAllowedValue, false, false);
    }

    /**
     * @param min           Min allowed value. If null: no restriction on minAllowedValue value value in this column
     * @param maxAllowedValue           Max allowed value. If null: no restiction on maxAllowedValue value in this column
     * @param allowNaN      Are NaN values ok?
     * @param allowInfinite Are +/- infinite values ok?
     */
    public DoubleMetaData(String name, Double min, Double maxAllowedValue, boolean allowNaN, boolean allowInfinite) {
        super(name);
        this.minAllowedValue = min;
        this.maxAllowedValue = maxAllowedValue;
        this.allowNaN = allowNaN;
        this.allowInfinite = allowInfinite;
    }

    @Override
    public ColumnType getColumnType() {
        return ColumnType.DOUBLE;
    }

    @Override
    public ColumnMetaData clone() {
        return new DoubleMetaData(name,minAllowedValue,maxAllowedValue,allowNaN,allowInfinite);
    }

    @Override
    public String toString() {
        return "DoubleMetaData{" + "minAllowedValue=" + minAllowedValue + ", maxAllowedValue=" + maxAllowedValue + ", allowNaN=" + allowNaN + ", allowInfinite=" + allowInfinite + ", name='" + name + '\'' + '}';
    }
}
