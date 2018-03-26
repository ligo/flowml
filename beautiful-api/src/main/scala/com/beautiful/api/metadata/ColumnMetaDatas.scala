package com.beautiful.api.metadata

import org.apache.spark.sql.types.{DataTypes, StructField}


/**
  *
  * 扩展一些Value 方便像原生类型直接操作 todo add api
  *
  * @Description:
  * @Author: zhuyuping
  * @CreateDate: 2018/3/26 下午10:13
  *
  **/
object ColumnMetaDatas {

  trait ColumnMetaDataLike[T <: ColumnMetaData] {
    def toStructField(x: T): StructField


  }

  object ColumnMetaDataLike {

    implicit object StringColumnMetaDataLike extends ColumnMetaDataLike[StringMetaData] {
      override def toStructField(x: StringMetaData): StructField = {
        DataTypes.createStructField(x.getName, DataTypes.StringType, true)
      }
    }

  }


}
