package com.beautiful.api.metadata;
import com.beautiful.api.schema.ColumnType;
import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



public class EnumMetaData extends BaseColumnMetaData {

    private final List<String> stateNames;
    private final Set<String> stateNamesSet; //For fast lookup

    public EnumMetaData(String name){
        super(name);
        this.stateNames = Lists.newArrayList();
        stateNamesSet = new HashSet<>(stateNames);
    }

    public EnumMetaData(String name, String... stateNames) {
        this(name, Arrays.asList(stateNames));
    }

    public EnumMetaData(String name, List<String> stateNames) {
        super(name);
        this.stateNames = stateNames;
        stateNamesSet = new HashSet<>(stateNames);
    }

    @Override
    public ColumnType getColumnType() {
        return ColumnType.ENUM;
    }

    @Override
    public ColumnMetaData clone() {
        return new EnumMetaData(name,stateNames);
    }


}
