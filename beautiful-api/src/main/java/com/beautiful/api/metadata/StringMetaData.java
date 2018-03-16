package com.beautiful.api.metadata;


import com.beautiful.api.schema.ColumnType;

public class StringMetaData extends BaseColumnMetaData {

    private final String regex;
    private final Integer minLength;
    private final Integer maxLength;



    public StringMetaData(String name) {
        this(name, null, null, null);
    }


    public StringMetaData(String name,String mustMatchRegex,
                    Integer minLength,Integer maxLength) {
        super(name);
        this.regex = mustMatchRegex;
        this.minLength = minLength;
        this.maxLength = maxLength;
    }


    @Override
    public ColumnType getColumnType() {
        return ColumnType.STRING;
    }

    @Override
    public ColumnMetaData clone() {
        return new StringMetaData(name,regex,minLength,maxLength);
    }

    @Override
    public String toString() {
        return "StringMetaData{" + "regex='" + regex + '\'' + ", minLength=" + minLength + ", maxLength=" + maxLength + ", name='" + name + '\'' + '}';
    }
}
