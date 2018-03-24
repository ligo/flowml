package com.beautiful.api.ops

import com.beautiful.api.schema.Schema
import com.beautiful.api.writable.WritableValue
import com.typesafe.scalalogging.LazyLogging

/**
  *
  * @Description:转换器
  * @Author: zhuyuping
  * @CreateDate: 2018/3/16 下午3:27
  *
  **/
trait Transform extends LazyLogging {

  def map(input: List[WritableValue])(implicit schema: Schema): List[WritableValue]

  def transform(implicit schema: Schema): Schema

}
