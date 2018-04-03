package com.beautiful.data.vec.examples


import com.beautiful.api.ops.Filter
import com.beautiful.api.writable.WritableValue
import com.beautiful.api.writable.WritableValue.{DoubleWritable, FloatWritable, IntegerWritable, LongWritable}
import com.beautiful.data.vec.filter.BaseColumnFilter
import com.google.common.collect.Range

/**
  *
  * @Description:添加一个测试类
  * @Author: zhuyuping
  * @CreateDate: 2018/3/22 上午12:10
  *
  **/
class RangeMinMaxFilter(params: Map[String, AnyVal]) extends BaseColumnFilter {


  require(params != null, "params is not allow null")
  require(params.contains(Filter.COLUMN_NAME), "columnName is not allow null")
  require(params.contains("min"), "min param value is not allow null")
  require(params.contains("max"), "max param value is not allow null")

  val includeLower: Boolean = params.getOrElse("includeLower", true).asInstanceOf
  val includeUpper: Boolean = params.getOrElse("includeUpper", true).asInstanceOf
  var range: Range[Numeric] = _

  if (includeLower && includeUpper) {
    range = Range.closed[Numeric](params.get("min").get.asInstanceOf, params.get("max").get.asInstanceOf)
  } else if (!includeLower && includeUpper) {
    range = Range.openClosed[Numeric](params.get("min").get.asInstanceOf, params.get("max").get.asInstanceOf)
  } else if (!includeUpper && includeLower) {
    range = Range.closedOpen[Numeric](params.get("min").get.asInstanceOf, params.get("max").get.asInstanceOf)
  } else {
    range = Range.open[Numeric](params.get("min").get.asInstanceOf, params.get("max").get.asInstanceOf)
  }


  override def removeByColumn(writableValue: WritableValue): Boolean = {
    writableValue match {
      case v: IntegerWritable => range.contains(v.value.asInstanceOf[Numeric])
      case v: LongWritable => range.contains(v.value.asInstanceOf[Numeric])
      case v: FloatWritable => range.contains(v.value.asInstanceOf[Numeric])
      case v: DoubleWritable => range.contains(v.value.asInstanceOf[Numeric])
      case v: _ => throw new IllegalArgumentException(s"非法参数${v}")
    }

  }

  override protected val columnName: String = params.get(Filter.COLUMN_NAME).get.asInstanceOf
}

object RangeMinMaxFilter {

  def apply(columnName: String, map: Map[String, AnyVal]): RangeMinMaxFilter = new RangeMinMaxFilter(map + (Filter.COLUMN_NAME -> columnName))


}
