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


  override def remove(input: Seq[WritableValue])(implicit schema: Schema): Boolean = {
    val columnIndex = schema.getIndexOfColumn(columnName)
    removeByColumn(input(columnIndex))
  }

  protected def removeByColumn(value: WritableValue): Boolean


}
