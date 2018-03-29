package com.beautiful.api.ops

import com.beautiful.api.writable.WritableValue
import org.apache.hadoop.io.Writable
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession

/**
  *
  * @Description:这是一个读取器 Either[Loader, Reader]
  * @Author: zhuyuping
  * @CreateDate: 2018/3/29 14:23
  *
  **/
trait Reader {

  type Read = {def read(conf: Map[String, String])(implicit session: SparkSession): RDD[Seq[WritableValue]]}

  def read(read: Read): RDD[Seq[Writable]]


}
