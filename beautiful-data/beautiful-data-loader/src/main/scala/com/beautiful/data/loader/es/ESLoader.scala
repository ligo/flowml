package com.beautiful.data.loader.es


import org.apache.spark.sql.{Dataset, Row, SparkSession}
import org.elasticsearch.spark.sql.EsSparkSQL


/**
  *
  * @Description:
  * @Author: zhuyuping
  * @CreateDate: 2018/3/19 下午8:22
  *
  **/
object ESLoader {


  def read(conf: Map[String, String])(implicit session: SparkSession): Dataset[Row] = {
    require(conf.contains("index")&&conf.contains("type")&&conf.contains("query"))
    val resourcestr:String=conf.get("index").get + "/" + conf.get("type").get
    val querystr:String=conf.get("query").get
    EsSparkSQL.esDF(session,resourcestr,querystr)
  }




}
