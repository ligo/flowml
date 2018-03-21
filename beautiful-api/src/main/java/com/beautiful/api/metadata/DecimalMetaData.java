package com.beautiful.api.metadata;


import com.beautiful.api.schema.ColumnType;



public class DecimalMetaData extends BaseColumnMetaData {


    private final Integer scale;
    private final Integer precision;
    public DecimalMetaData(String name) {
        this(name, null, null);
    }

    /**
     *
     * @param name
     * @param scale
     * @param precision
     */
    public DecimalMetaData(String name, Integer scale,
                           Integer precision) {
        super(name);
        this.scale=scale;
        this.precision=precision;
    }



    @Override
    public ColumnType getColumnType() {
        return ColumnType.DECIMAL;
    }

    @Override
    public ColumnMetaData clone() {
        return new DecimalMetaData(name,scale,precision);
    }

    public Integer getScale() {
        return scale;
    }

    public Integer getPrecision() {
        return precision;
    }


}
