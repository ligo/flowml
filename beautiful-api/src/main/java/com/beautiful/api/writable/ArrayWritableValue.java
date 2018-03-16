package com.beautiful.api.writable;

import com.beautiful.api.schema.ColumnType;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by alex.zhu on 2017/11/18.
 */
public class ArrayWritableValue extends WritableValue{

    private List<WritableValue> value;

    public ArrayWritableValue(List<WritableValue> value) {
        this.value = value;
    }

    @Override
    public Object get() {
        List<Object> objects= Lists.newArrayList();
        for (WritableValue writableValue:
             value) {
            objects.add(writableValue.get());
        }
        return objects;
    }

    @Override
    public ColumnType getColumnType() {
        return ColumnType.ARRAY;
    }

    @Override
    public int compareTo(WritableValue o) {
        List<WritableValue> thisvals=this.value;
        List<WritableValue> thatvals=((ArrayWritableValue)o).value;
        if(Integer.compare(thisvals.size(),thatvals.size())==0){
            for (int i = 0; i <thisvals.size() ; i++) {
                 WritableValue thisval=thisvals.get(i);
                 WritableValue thatval=thatvals.get(i);
                 if(thisval.compareTo(thatval)!=0);
                 return thisval.compareTo(thatval);
            }
        }else{
            return Integer.compare(thisvals.size(),thatvals.size());
        }
        return 0;
    }
}
