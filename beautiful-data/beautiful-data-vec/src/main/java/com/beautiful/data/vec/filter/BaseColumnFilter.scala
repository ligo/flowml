package com.beautiful.data.vec.filter

import com.beautiful.api.ops.Filter
import com.beautiful.api.schema.Schema
import com.beautiful.api.writable.WritableValue
import com.typesafe.scalalogging.LazyLogging

/**
  *
  * @Description:scala 实现是为了后面做隐式转换
  * @Author: zhuyuping
  * @CreateDate: 2018/3/21 下午7:31
  *
  **/
abstract class BaseColumnFilter(val columnName: String) extends Filter with LazyLogging {


  protected var schema: Schema = _
  protected var columnIdx = 0

  override def setInputSchema(schema: Schema): Unit = {
    this.schema = schema;
    this.columnIdx = schema.getIndexOfColumn(columnName)
  }

  override def remove(input: List[WritableValue]): Boolean = {
    val columnIndex = schema.getIndexOfColumn(columnName)
    removeByColumn(input(columnIndex))
  }

  protected def removeByColumn(value: WritableValue): Boolean


}
