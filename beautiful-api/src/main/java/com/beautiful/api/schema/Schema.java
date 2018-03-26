package com.beautiful.api.schema;

import com.beautiful.api.metadata.*;
import com.beautiful.api.utils.text.table.TextTable;
import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * @Description:
 * @Author: zhuyuping
 * @CreateDate: 2018/3/21 下午7:38
 **/
public class Schema implements Serializable {

    private List<String> columnNames;

    private List<MetaDatas> columnMetaData;

    private Map<String, Integer> columnNamesIndex;


    private Schema() {

    }

    protected Schema(Builder builder) {
        this.columnMetaData = builder.columnMetaData;
        this.columnNames = new ArrayList<>();
        for (MetaDatas meta : this.columnMetaData)
            this.columnNames.add(meta.getName());
        columnNamesIndex = new HashMap<>();
        for (int i = 0; i < columnNames.size(); i++) {
            columnNamesIndex.put(columnNames.get(i), i);
        }
    }


    public Schema(List<MetaDatas> columnMetaData) {
        if (columnMetaData == null || columnMetaData.size() == 0)
            throw new IllegalArgumentException("Column meta data must be non-empty");
        this.columnMetaData = columnMetaData;
        this.columnNames = new ArrayList<>();
        for (MetaDatas meta : this.columnMetaData)
            this.columnNames.add(meta.getName());
        this.columnNamesIndex = new HashMap<>();
        for (int i = 0; i < columnNames.size(); i++) {
            columnNamesIndex.put(columnNames.get(i), i);
        }
    }


    public boolean sameTypes(Schema schema) {
        if (schema.numColumns() != numColumns())
            return false;
        for (int i = 0; i < schema.numColumns(); i++) {
            if (getType(i) != schema.getType(i))
                return false;
        }

        return true;
    }


    public List<MetaDatas> differences(Schema schema) {
        List<MetaDatas> ret = new ArrayList<>();
        for (int i = 0; i < schema.numColumns(); i++) {
            if (!columnMetaData.contains(schema.getMetaData(i)))
                ret.add(schema.getMetaData(i));
        }

        return ret;
    }


    public Schema newSchema(List<MetaDatas> columnMetaData) {
        return new Schema(columnMetaData);
    }


    public int numColumns() {
        return columnNames.size();
    }


    public String getName(int column) {
        return columnNames.get(column);
    }


    public ColumnType getType(int column) {
        if (column < 0 || column >= columnMetaData.size())
            throw new IllegalArgumentException(
                    "参数index 不合法. " + column + "only " + columnMetaData.size() + "present.");
        return columnMetaData.get(column).getColumnType();
    }


    public ColumnType getType(String columnName) {
        if (!hasColumn(columnName)) {
            throw new IllegalArgumentException("列名不存在");
        }
        return getMetaData(columnName).getColumnType();
    }


    public MetaDatas getMetaData(int column) {
        return columnMetaData.get(column);
    }


    public MetaDatas getMetaData(String column) {
        return getMetaData(getIndexOfColumn(column));
    }


    public List<String> getColumnNames() {
        return new ArrayList<>(columnNames);
    }

    public List<ColumnType> getColumnTypes() {
        List<ColumnType> list = new ArrayList<>(columnMetaData.size());
        for (MetaDatas md : columnMetaData)
            list.add(md.getColumnType());
        return list;
    }


    public List<MetaDatas> getColumnMetaData() {
        return new ArrayList<>(columnMetaData);
    }


    public int getIndexOfColumn(String columnName) {
        Integer idx = columnNamesIndex.get(columnName);
        if (idx == null)
            throw new NoSuchElementException("列名不存在: \"" + columnName + "\"");
        return idx;
    }


    public int[] getIndexOfColumns(Collection<String> columnNames) {
        return getIndexOfColumns(columnNames.toArray(new String[columnNames.size()]));
    }


    public int[] getIndexOfColumns(String... columnNames) {
        int[] out = new int[columnNames.length];
        for (int i = 0; i < out.length; i++) {
            out[i] = getIndexOfColumn(columnNames[i]);
        }
        return out;
    }


    public boolean hasColumn(String columnName) {
        Integer idx = columnNamesIndex.get(columnName);
        return idx != null;
    }

    @Override
    public String toString() {

        String[] columnNames = {
                "index",
                "name",
                "type",
                "meta data"
        };
        List<Object[]> datas = Lists.newArrayList();
        for (int i = 0; i < numColumns(); i++) {
            Object[] objects = new Object[4];
            String colName = getName(i);
            ColumnType type = getType(i);
            MetaDatas meta = getMetaData(i);
            objects[0] = i;
            objects[1] = colName;
            objects[2] = type;
            objects[3] = meta;
            datas.add(objects);
        }
        TextTable tt = new TextTable(columnNames, datas);
        // this adds the numbering on the left
        tt.setAddRowNumbering(true);
        // sort by the first column
        tt.setSort(0);
        try {
            return tt.printString();
        } catch (Exception e) {
            tt.printTable();
            return "";
        }
    }


    public static class Builder {
        List<MetaDatas> columnMetaData = new ArrayList<>();


        public Builder addColumn(MetaDatas metaData) {
            columnMetaData.add(metaData);
            return this;
        }

        public Builder addColumnLong(String name) {
            return addColumn(new LongMetaData(name));
        }

        public Builder addColumnInteger(String name) {
            return addColumn(new IntegerMetaData(name));
        }

        public Builder addColumnFloat(String name) {
            return addColumn(new FloatMetaData(name));
        }

        public Builder addColumnDouble(String name) {
            return addColumn(new DoubleMetaData(name));
        }

        public Builder addColumnsDouble(String... columnNames) {
            for (String s : columnNames)
                addColumnDouble(s);
            return this;
        }

        public Builder addColumnString(String name) {
            return addColumn(new StringMetaData(name));
        }

        public Builder addColumnsString(String... columnNames) {
            for (String s : columnNames)
                addColumnString(s);
            return this;
        }

        public Builder addColumnsString(String name) {
            return addColumnsString(name);
        }

        public Builder addColumnDecimal(String columnName) {
            return addColumn(new DecimalMetaData(columnName));
        }

        public Builder addColumnDecimal(String columnName, Integer scale, Integer presion) {
            return addColumn(new DecimalMetaData(columnName, scale, presion));
        }

        public Builder addColumnComplexArray(String columnName, MetaDatas base) {
            return addColumn(new ComplexArrayMetaData(columnName, base));
        }

        public Builder addColumnComplexMap(String columnName, MetaDatas keymeta, MetaDatas valuemeta) {
            return addColumn(new ComplexMapMetaData(columnName, keymeta, valuemeta));
        }

        public Builder addColumnBinary(String columnName) {
            return addColumn(new BinaryMetaData(columnName));
        }

        public Builder addColumnStruct(String columnName, List<MetaDatas> metaDatas) {
            return addColumn(new StructMetaData(columnName, metaDatas));
        }


        /**
         * Create the Schema
         */
        public Schema build() {
            return new Schema(this);
        }
    }


}
