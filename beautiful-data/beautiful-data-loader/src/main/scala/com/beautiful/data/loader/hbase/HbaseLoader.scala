package com.beautiful.data.loader.hbase

import org.apache.spark.sql.execution.datasources.hbase.HBaseTableCatalog
import org.apache.spark.sql.{Dataset, Row, SparkSession}


/**
  *
  * @Description:
  * @Author: zhuyuping
  * @CreateDate: 2018/3/19 下午9:28
  *
  **/
object HbaseLoader {

  def read(conf: Map[String, String])(implicit session: SparkSession): Dataset[Row] = {

    if (conf.contains("hbase.zookeeper.quorum")) session.sparkContext.hadoopConfiguration.set("hbase.zookeeper.quorum", conf.get("hbase.zookeeper.quorum").get)
    session.sparkContext.hadoopConfiguration.set("hbase.zookeeper.property.clientPort", conf.get("hbase.zookeeper.property.clientPort") match { case None => "2181" case Some(x) => x })
    session.sparkContext.hadoopConfiguration.addResource("hbase-client.xml")
    session.sparkContext.hadoopConfiguration.addResource("hbase-client-default.xml")
    val schema = conf.get("schema") //"{\"table\":{\"namespace\":\"default\",\"name\":\"stock_history\"},\"rowkey\":\"key\",\"columns\":{\"symbol\":{\"cf\":\"rowkey\",\"col\":\"key\",\"type\":\"string\"},\"open\":{\"cf\":\"oneday_cf\",\"col\":\"open\",\"type\":\"string\"},\"high\":{\"cf\":\"oneday_cf\",\"col\":\"high\",\"type\":\"string\"},\"low\":{\"cf\":\"oneday_cf\",\"col\":\"low\",\"type\":\"string\"},\"close\":{\"cf\":\"oneday_cf\",\"col\":\"close\",\"type\":\"string\"},\"volume\":{\"cf\":\"oneday_cf\",\"col\":\"volume\",\"type\":\"string\"},\"name\":{\"cf\":\"oneday_cf\",\"col\":\"name\",\"type\":\"string\"},\"code\":{\"cf\":\"oneday_cf\",\"col\":\"fullCode\",\"type\":\"string\"}}}";
    session.read.options(Map(HBaseTableCatalog.tableCatalog->schema.get)).format("org.apache.spark.sql.execution.datasources.hbase").load
  }


}
