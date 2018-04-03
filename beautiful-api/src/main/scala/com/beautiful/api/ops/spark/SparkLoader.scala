package com.beautiful.api.ops.spark

import org.apache.spark.sql.{Dataset, Row, SparkSession}

/**
  *
  * @Description:结构类型load 加载 Either[Loader, Reader]
  * @Author: zhuyuping
  * @CreateDate: 2018/3/16 下午3:28
  *
  **/
trait SparkLoader {

  type Load = {def read(conf: Map[String, String])(implicit session: SparkSession): Dataset[Row]}

  def load(load: Load): Dataset[Row]


}
