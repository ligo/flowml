package com.beautiful.api.ops

import org.apache.spark.sql.{Dataset, Row}

/**
  *
  * @Description:结构类型load 加载
  * @Author: zhuyuping
  * @CreateDate: 2018/3/16 下午3:28
  *
  **/
trait Loader {

  type Load={ def open(conf:Map[String,String]):Dataset[Row] }

  def load(conf:Load):Dataset[Row]






}
