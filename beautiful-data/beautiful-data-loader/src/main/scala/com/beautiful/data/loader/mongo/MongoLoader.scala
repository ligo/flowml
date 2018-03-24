package com.beautiful.data.loader.mongo


import com.mongodb.spark.MongoSpark
import com.mongodb.spark.config.ReadConfig
import org.apache.spark.sql.{Dataset, Row, SparkSession}

/**
  *
  * @Description:
  * @Author: zhuyuping
  * @CreateDate: 2018/3/24 下午5:10
  *
  **/
object MongoLoader {

  def read(conf: Map[String, String])(implicit session: SparkSession): Dataset[Row] = {
    require(conf.contains("database") && conf.contains("uri") && conf.contains("collection"))
    val readOverrides: Map[String, String] = Map("database" -> conf.get("database").get
      , "uri" -> conf.get("uri").get, "collection" -> conf.get("collection").get)
    val readConfig: ReadConfig = ReadConfig.create(session).withOptions(readOverrides)
    MongoSpark.loadAndInferSchema(session, readConfig)
  }


}
