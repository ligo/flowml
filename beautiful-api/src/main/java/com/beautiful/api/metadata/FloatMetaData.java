package com.beautiful.api.metadata;


import com.beautiful.api.schema.ColumnType;

public class FloatMetaData extends BaseColumnMetaData {

    private final Float minAllowedValue;
    private final Float maxAllowedValue;
    private final boolean allowNaN;
    private final boolean allowInfinite;

    public FloatMetaData(String name) {
        this(name, null, null, false, false);
    }

    /**
     * @param minAllowedValue Min allowed value. If null: no restriction on minAllowedValue value value in this column
     * @param maxAllowedValue Max allowed value. If null: no restiction on maxAllowedValue value in this column
     */
    public FloatMetaData(String name,Float minAllowedValue,
                    Float maxAllowedValue) {
        this(name, minAllowedValue, maxAllowedValue, false, false);
    }

    /**
     * @param min           Min allowed value. If null: no restriction on minAllowedValue value value in this column
     * @param maxAllowedValue           Max allowed value. If null: no restiction on maxAllowedValue value in this column
     * @param allowNaN      Are NaN values ok?
     * @param allowInfinite Are +/- infinite values ok?
     */
    public FloatMetaData(String name, Float min, Float maxAllowedValue, boolean allowNaN, boolean allowInfinite) {
        super(name);
        this.minAllowedValue = min;
        this.maxAllowedValue = maxAllowedValue;
        this.allowNaN = allowNaN;
        this.allowInfinite = allowInfinite;
    }

    @Override
    public ColumnType getColumnType() {
        return ColumnType.FLOAT;
    }

    @Override
    public ColumnMetaData clone() {
        return new FloatMetaData(name,minAllowedValue,maxAllowedValue,allowNaN,allowInfinite);
    }

    @Override
    public String toString() {
        return "FloatMetaData{" + "minAllowedValue=" + minAllowedValue + ", maxAllowedValue=" + maxAllowedValue + ", allowNaN=" + allowNaN + ", allowInfinite=" + allowInfinite + ", name='" + name + '\'' + '}';
    }
}
