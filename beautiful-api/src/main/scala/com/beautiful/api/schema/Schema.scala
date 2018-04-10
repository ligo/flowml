package com.beautiful.api.schema


import com.beautiful.api.column.DataColumn

import scala.collection.mutable.ListBuffer

/**
  *
  * @Description:
  * @Author: zhuyuping
  * @CreateDate: 2018/3/28 上午2:16
  *
  **/
case class Schema(dataColumns: Seq[DataColumn]) {
  val columnNamesIndex = dataColumns.map(_.getColumnMetaData.name).zipWithIndex.toMap[String, Int]

  def getIndexOfColumn(columnName: String): Int = {
    for ((p: DataColumn, i: Int) <- dataColumns.zipWithIndex) {
      if (p.getColumnMetaData.name.eq(columnName)) i
    }
    -1
  }
}


object Schema {
  def newSchema(columnMetaDatas: Seq[DataColumn]): Schema = {
    SchemaBuilder.build(columnMetaDatas)
  }

  object SchemaBuilder {
    private val columnMetaData = ListBuffer.empty[DataColumn]

    def addColumn(metaData: DataColumn): this.type = {
      columnMetaData += metaData
      this
    }
    /**
      * Create the Schema
      */
    def build: Schema = Schema(columnMetaData.toIndexedSeq)

    def build(columnMetaDatas: Seq[DataColumn]): Schema = Schema(columnMetaDatas)
  }


}
