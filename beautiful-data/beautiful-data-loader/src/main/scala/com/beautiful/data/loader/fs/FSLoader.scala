package com.beautiful.data.loader.fs

import org.apache.spark.sql.{Dataset, Encoders, Row, SparkSession}


/**
  *
  * @Description:文件系统loader
  * @Author: zhuyuping
  * @CreateDate: 2018/3/24 下午4:55
  *
  **/
object FSLoader {

  def read(conf: Map[String, String])(implicit session: SparkSession): Dataset[Row] = {
    require(conf.contains("path") && conf.contains("type"))
    conf.get("type").get match {
      case "csv" => session.read.format("csv").option("header", conf.getOrElse("header", true).asInstanceOf[Boolean]).option("inferSchema", true).csv(conf.get("path").get)
      case "json" => session.read.json(conf.get("path").get)
      case "parquet" => session.read.parquet(conf.get("path").get)
      case "binary" => session.createDataset(session.sparkContext.binaryRecords(conf.get("path").get, 1, session.sparkContext.hadoopConfiguration))(Encoders.BINARY).toDF()
      case _ => session.read.text(conf.get("path").get)
    }
  }
}
