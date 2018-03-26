package com.beautiful.data.vec.transform

import com.alibaba.fastjson.JSON
import com.beautiful.api.ops.Transform
import com.beautiful.api.schema.Schema
import com.beautiful.api.writable.WritableValue

import scala.collection.JavaConverters._
/**
  *
  * @Description:
  * @Author: zhuyuping
  * @CreateDate: 2018/3/23 下午9:37
  *
  **/
abstract class BaseColumnTransform(columnName: String) extends Transform{

  protected var columnNumber: Int = -1


  def transformColumnMeta(oldmeta: MetaDatas): MetaDatas

  def mapColumn(value: WritableValue):WritableValue

  override def map(inputs: List[WritableValue])(implicit schema: Schema): List[WritableValue] = {
    columnNumber=schema.getIndexOfColumn(columnName)
    require(columnNumber != -1)
    logger.info(s"当前设置schema为 ${JSON.toJSONString(schema)} columnName 为 "${JSON.toJSONString(columnName)})
    inputs.map(input => if(input eq (inputs(columnNumber))) mapColumn(input) else input)
  }

  override def transform(implicit schema: Schema): Schema = {
    val oldmetas=schema.getColumnMetaData.asScala
      //oldmetas.zipWithIndex.map{case (oldmeta,index) => if (index==columnNumber) transformColumnMeta(oldmeta) else oldmeta)}
     return schema.newSchema(oldmetas.map(oldmeta=>if(oldmeta eq oldmetas(columnNumber)) transformColumnMeta(oldmeta) else oldmeta).toList);

  }
}
