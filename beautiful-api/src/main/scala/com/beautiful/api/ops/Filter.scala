package com.beautiful.api.ops

import java.util

import com.beautiful.api.metadata.ColumnMetaData
import com.beautiful.api.writable.WritableValue

/**
  *
  * @Description:过滤器
  * @Author: zhuyuping
  * @CreateDate: 2018/3/16 下午3:18
  *
  **/
trait Filter {

  val schema:util.List[ColumnMetaData]

  def remove(input: util.List[WritableValue]):Boolean



}
