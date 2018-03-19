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


  def read(session:SparkSession, conf:Map[String,String]):Dataset[Row]= {
      require(conf.contains("url")&&conf.contains("table")&&conf.contains("user")&&conf.contains("password"))
      val driver=conf.get("driver") match {
        case None =>"com.mysql.jdbc.Driver"
        case _ =>conf.get("driver").get
      }
      session.read.format("jdbc").option("url", conf.get("url").get).option("driver",driver).option("dbtable", conf.get("table").get).option("user", conf.get("user").get).option("password", conf.get("password").get).load
   }




}
