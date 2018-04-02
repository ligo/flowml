package com.beautiful.data.loader.reader

import com.beautiful.api.writable.WritableValue
import org.apache.spark.api.java.JavaRDD
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession

import scala.collection.JavaConverters.{mapAsJavaMapConverter, _}

/**
  *
  * @Description:提供一个对外接口 用于java 继承扩展 来实现reader 自定义读取
  * @Author: zhuyuping
  * @CreateDate: 2018/3/29 14:28
  *              todo: 提供 spark dataSource 自定义dataframe的 简易接口
  *
  **/
trait BasicReader {

  def read(conf: Map[String, String])(implicit session: SparkSession): RDD[Seq[WritableValue]]

}

trait JavaBasicReader extends BasicReader {
  override def read(conf: Map[String, String])(implicit session: SparkSession): RDD[Seq[WritableValue]] = {
    JavaRDD.toRDD(javaRead(conf.asJava)(session).map((v1: java.util.List[WritableValue]) => v1.asScala))
    //JavaRDD.fromRDD()
  }

  def javaRead(conf: java.util.Map[String, String])(implicit session: SparkSession): JavaRDD[java.util.List[WritableValue]]
}

object BasicReader {

  def create(basicReader: BasicReader) = {
    new {
      def read(conf: Map[String, String])(implicit session: SparkSession): RDD[Seq[WritableValue]] = {
        basicReader.read(conf)(session)
      }
    }
  }


}
