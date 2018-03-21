package com.beautiful.api.metadata;

import com.alibaba.fastjson.JSON;
import com.beautiful.api.utils.BeanToMapUtil;

import java.util.Map;

/**
 * Created by alex.zhu on 2017/11/17.
 */
public abstract class BaseColumnMetaData implements ColumnMetaData{
    protected String name;

    protected BaseColumnMetaData(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public abstract ColumnMetaData clone();

    @Override
    public String toString() {
        try {
            Map<String, Object> map = BeanToMapUtil.convertBean(this);
            map.put("type", getColumnType().name());
            return JSON.toJSONString(map);
        } catch (Exception e) {
            return JSON.toJSONString(this);
        }

    }
}
