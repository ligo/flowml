package com.beautiful.api.writable;

import com.beautiful.api.schema.ColumnType;

import java.math.BigDecimal;

/**
 * Created by alex.zhu on 2017/11/17.
 */
public class DecimalWritableValue extends WritableValue{


    private BigDecimal value;

    @Override
    public Object get() {
        return value;
    }

    @Override
    public ColumnType getColumnType() {
        return ColumnType.DECIMAL;
    }

    @Override
    public int compareTo(WritableValue o) {
        return this.value.compareTo(((DecimalWritableValue)o).value);
    }

    public DecimalWritableValue(String value) {

        this.value = new BigDecimal(value);
    }
    public DecimalWritableValue(double value) {

        this.value = new BigDecimal(value);
    }

    public DecimalWritableValue(BigDecimal value) {

        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
