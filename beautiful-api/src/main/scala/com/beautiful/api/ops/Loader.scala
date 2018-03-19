package com.beautiful.api.ops

import org.apache.spark.sql.{Dataset, Row, SparkSession}

/**
  *
  * @Description:结构类型load 加载
  * @Author: zhuyuping
  * @CreateDate: 2018/3/16 下午3:28
  *
  **/
trait Loader {

  type Load={ def read(session:SparkSession, conf:Map[String,String]):Dataset[Row] }

  def load(load:Load):Dataset[Row]






}
