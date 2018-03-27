package com.beautiful.api.metadata

import com.beautiful.api.schema.ColumnType

/**
  *
  * @Description:
  * @Author: zhuyuping
  * @CreateDate: 2018/3/26 下午11:26
  *
  **/
case class ColumnMetaData(val name: String, val columnType: ColumnType) extends Serializable with Cloneable

object ColumnMetaData {

  def apply(name: String, columnType: ColumnType): ColumnMetaData = {
    require(ColumnType.values().contains(columnType))
    new ColumnMetaData(name, columnType)
  }

  def unapply(that: Any): Option[(String, ColumnType)] = {
    that match {
      case m: ColumnMetaData => Some(m.name, m.columnType)
      case _ => None
    }
  }

}

