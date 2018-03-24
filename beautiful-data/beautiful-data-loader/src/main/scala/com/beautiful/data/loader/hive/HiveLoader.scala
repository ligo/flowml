package com.beautiful.data.loader.hive

import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.sql.{Dataset, Row, SparkSession}

/**
  *
  * @Description:
  * @Author: zhuyuping
  * @CreateDate: 2018/3/24 下午5:15
  *
  **/
object HiveLoader {

  def read(conf: Map[String, String])(implicit session: SparkSession): Dataset[Row] = {
    //防止用户创建sparkSession未使用enableHiveSuport选项 enableHiveSupport
    require(conf.contains("loadsql") && conf.contains("querysql"))
    val sqlContext = new HiveContext(session.sparkContext)
    sqlContext.sql(conf.get("loadsql").get) //"LOAD DATA LOCAL INPATH 'examples/src/main/resources/kv1.txt' INTO TABLE src"
    sqlContext.sql(conf.get("querysql").get)
  }


}
