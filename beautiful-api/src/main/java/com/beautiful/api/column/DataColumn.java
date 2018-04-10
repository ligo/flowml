package com.beautiful.api.column;

import com.beautiful.api.metadata.ColumnMetaData;

import java.io.Serializable;
import java.util.Map;

/**
 * @Description:
 * @Author: zhuyuping
 * @CreateDate: 2018/4/10 13:30
 **/
public class DataColumn implements Serializable {

    private ColumnMetaData columnMetaData;

    private Map<String, Object> props;


    public ColumnMetaData getColumnMetaData() {
        return columnMetaData;
    }

    public void setColumnMetaData(ColumnMetaData columnMetaData) {
        this.columnMetaData = columnMetaData;
    }

    public Map<String, Object> getProps() {
        return props;
    }

    public void setProps(Map<String, Object> props) {
        this.props = props;
    }
}
