package com.beautiful.api.metadata;


import com.beautiful.api.schema.ColumnType;

/**
 * Created by alex.zhu on 2017/11/15.
 */
public class MatrixMetaData extends BaseColumnMetaData {

    private Integer rows;

    private Integer cols;

    public MatrixMetaData(String name){
        super(name);
    }

    public MatrixMetaData(String name,Integer rows,Integer cols) {
        super(name);
        this.rows=rows;
        this.cols=cols;

    }


    @Override
    public ColumnType getColumnType() {
        return ColumnType.MATRIX;
    }

    @Override
    public ColumnMetaData clone() {
        return new MatrixMetaData(name,rows,cols);
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getCols() {
        return cols;
    }

    public void setCols(Integer cols) {
        this.cols = cols;
    }


}
