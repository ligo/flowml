package com.beautiful.api.ops

import com.beautiful.api.writable.WritableValue


/**
  *
  * @Description:结构类型load 加载
  * @Author: zhuyuping
  * @CreateDate: 2018/3/16 下午3:28
  *
  **/
trait Exporter extends Ops {

  type Export = {def write(conf: Map[String, String]): List[WritableValue]}

  def export(export: Export): List[WritableValue]

  




}
