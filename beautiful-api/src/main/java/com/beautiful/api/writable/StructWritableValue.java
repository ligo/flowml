package com.beautiful.api.writable;

import com.beautiful.api.schema.ColumnType;
import org.apache.spark.sql.RowFactory;

import java.util.List;

/**
 * Created by alex.zhu on 2017/11/18.
 */
public class StructWritableValue extends WritableValue{

    private List<WritableValue> value;

    public StructWritableValue(List<WritableValue> value) {
        this.value = value;
    }

    @Override
    public Object get() {
        Object[] rows=new Object[value.size()];
        for (int i = 0; i <value.size() ; i++) {
            WritableValue wvalue=value.get(i);
            rows[i]=wvalue.get();
        }
        return RowFactory.create(rows);
    }

    @Override
    public ColumnType getColumnType() {
        return ColumnType.STRUCT;
    }

    @Override
    public int compareTo(WritableValue o) {
        List<WritableValue> thisvals=this.value;
        List<WritableValue> thatvals=((StructWritableValue)o).value;
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
