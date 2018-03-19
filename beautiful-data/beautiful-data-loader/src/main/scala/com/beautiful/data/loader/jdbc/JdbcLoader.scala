package com.beautiful.data.loader.jdbc




import org.apache.spark.sql.{Dataset, Row, SparkSession}

/**
  *
  * @Description:
  * @Author: zhuyuping
  * @CreateDate: 2018/3/19 下午9:20
  *
  **/
object JdbcLoader {

  def read(session:SparkSession, conf:Map[String,String]):Dataset[Row]= {
    require(conf.contains("url"))
    require(conf.contains("table"))
    require(conf.contains("driver"))
    require(conf.contains("user"))
    require(conf.contains("password"))
    val options: java.util.Map[String, String] = new java.util.HashMap[String, String]
    options.put("url", conf.get("url").get)
    options.put("dbtable", conf.get("table").get)
    options.put("driver", conf.get("driver").get)
    if (conf.contains("user")) options.put("user", conf.get("user").get)
    if (conf.contains("password")) options.put("password", conf.get("password").get)
    session.read.format("jdbc").options(options).load
  }

}
