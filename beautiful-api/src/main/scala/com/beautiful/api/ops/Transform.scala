package com.beautiful.api.ops

import java.util

import com.beautiful.api.metadata.ColumnMetaData
import com.beautiful.api.writable.WritableValue

/**
  *
  * @Description:转换器
  * @Author: zhuyuping
  * @CreateDate: 2018/3/16 下午3:27
  *
  **/
trait Transform {

  val inputColumn:ColumnMetaData

  def map(input: util.List[WritableValue]): util.List[WritableValue]

  def transform(columnMetaDatas: util.List[ColumnMetaData]): util.List[ColumnMetaData]

}
