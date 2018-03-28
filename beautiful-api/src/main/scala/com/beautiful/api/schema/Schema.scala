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
case class Schema(columnMetaDatas: List[ColumnMetaData]) {
  val columnNamesIndex = columnMetaDatas.map(_.name).zipWithIndex.toMap[String, Int]
}


object Schema {

  class SchemaBuilder {
    private val columnMetaData = ListBuffer.empty[ColumnMetaData]

    def addColumn(metaData: ColumnMetaData): this.type = {
      columnMetaData += metaData
      this
    }

    /**
      * Create the Schema
      */
    def build: Schema = Schema(columnMetaData.toList)
  }

  object SchemaBuilder {
    def apply: SchemaBuilder = new SchemaBuilder()
  }


}
