package com.beautiful.api.schema


import com.beautiful.api.metadata._

import scala.collection.mutable.ListBuffer

/**
  *
  * @Description:
  * @Author: zhuyuping
  * @CreateDate: 2018/3/28 上午2:16
  *
  **/
case class Schema(columnMetaDatas: Set[ColumnMetaData]) {
  def getIndexOfColumn(columnName: String) = {
    columnMetaDatas.toList.indexOf(columnName)
  }

  val columnNamesIndex = columnMetaDatas.map(_.name).zipWithIndex.toMap[String, Int]
}


object Schema {
  def newSchema(columnMetaDatas: Seq[ColumnMetaData]): Schema = {
    SchemaBuilder.build(columnMetaDatas)
  }

  object SchemaBuilder {
    private val columnMetaData = ListBuffer.empty[ColumnMetaData]

    def addColumn(metaData: ColumnMetaData): this.type = {
      columnMetaData += metaData
      this
    }
    /**
      * Create the Schema
      */
    def build: Schema = Schema(columnMetaData.toSet)

    def build(columnMetaDatas: Seq[ColumnMetaData]): Schema = Schema(columnMetaDatas.toSet)
  }


}
