package com.beautiful.data.loader.mysql

import org.apache.spark.sql.{Dataset, Row, SparkSession}


/**
  *
  * @Description:
  * @Author: zhuyuping
  * @CreateDate: 2018/3/19 下午9:06
  *
  **/
object MysqlLoader {


  def read(conf: Map[String, String])(implicit session: SparkSession): Dataset[Row] = {
      require(conf.contains("url")&&conf.contains("table")&&conf.contains("user")&&conf.contains("password"))
      val driver=conf.get("driver") match {
        case None =>"com.mysql.jdbc.Driver"
        case Some(x) => x
      }
      session.read.format("jdbc").option("url", conf.get("url").get).option("driver",driver).option("dbtable", conf.get("table").get).option("user", conf.get("user").get).option("password", conf.get("password").get).load
   }




}
