package com.beautiful.api.row;

import com.beautiful.api.column.DataColumn;

import java.io.Serializable;

/**
 * @Description:
 * @Author: zhuyuping
 * @CreateDate: 2018/4/10 13:28
 **/
public interface DataRow extends Serializable {

    DataColumn[] getColumns();

    Object get(int index);

    Object get(String name);


}
