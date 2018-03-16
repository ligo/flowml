package com.beautiful.api.writable;

import com.beautiful.api.schema.ColumnType;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

/**
 * Created by alex.zhu on 2017/11/18.
 */
public class MapWritableValue extends WritableValue{

    private Map<WritableValue,WritableValue> value;


    @Override
    public Object get() {
        Map map= Maps.newHashMap();
        for (Map.Entry<WritableValue,WritableValue> entry:
             value.entrySet()) {
            map.put(entry.getKey().get(),entry.getValue().get());
        }
        return map;
    }

    @Override
    public ColumnType getColumnType() {
        return ColumnType.MAP;
    }

    @Override
    public int compareTo(WritableValue o) {
        Map<WritableValue,WritableValue> thismap=this.value;
        Map<WritableValue,WritableValue> thatmap=((MapWritableValue)o).value;
        int flag=Integer.compare(thismap.size(),thatmap.size());
        if(flag==0){
            List<WritableValue> thiskeys=Lists.newArrayList(thismap.keySet());
            List<WritableValue> thatkeys=Lists.newArrayList(thatmap.keySet());
            for (int i = 0; i <thiskeys.size() ; i++) {
                 WritableValue writableValue=thiskeys.get(i);
                 if(writableValue.compareTo(thatkeys.get(i))!=0) return writableValue.compareTo(thatkeys.get(i));
            }

            return 0;
        }else{
            return flag;
        }

    }
}
