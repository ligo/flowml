package com.beautiful.api.metadata

import com.beautiful.api.schema.ColumnType

/**
  *
  * @Description:
  * @Author: zhuyuping
  * @CreateDate: 2018/3/26 下午11:26
  *
  **/
sealed abstract case class ColumnMetaData(val name: String, val columnType: ColumnType) extends Serializable with Cloneable

case class StringMetaData(override val name: String, override val columnType: ColumnType = ColumnType.STRING) extends ColumnMetaData(name, columnType)

case class LongMetaData(override val name: String, override val columnType: ColumnType = ColumnType.LONG) extends ColumnMetaData(name, columnType)

case class FloatMetaData(override val name: String, override val columnType: ColumnType = ColumnType.FLOAT) extends ColumnMetaData(name, columnType)

case class DoubleMetaData(override val name: String, override val columnType: ColumnType = ColumnType.DOUBLE) extends ColumnMetaData(name, columnType)

case class IntegerMetaData(override val name: String, override val columnType: ColumnType = ColumnType.INTEGER) extends ColumnMetaData(name, columnType)

case class DecimalMetaData(override val name: String, override val columnType: ColumnType = ColumnType.DECIMAL, scale: Option[Int] = None, precision: Option[Int] = None) extends ColumnMetaData(name, columnType)

case class TimestampMetaData(override val name: String, override val columnType: ColumnType = ColumnType.TIMESTAMP) extends ColumnMetaData(name, columnType)

case class DateMetaData(override val name: String, override val columnType: ColumnType = ColumnType.DATE) extends ColumnMetaData(name, columnType)

case class VectorMetaData(override val name: String, override val columnType: ColumnType = ColumnType.VECTOR) extends ColumnMetaData(name, columnType)

case class MatrixMetaData(override val name: String, override val columnType: ColumnType = ColumnType.MATRIX, val row: Int, val col: Int) extends ColumnMetaData(name, columnType)

case class StructMetaData(override val name: String, override val columnType: ColumnType = ColumnType.STRUCT, eles: Array[ColumnMetaData]) extends ColumnMetaData(name, columnType)

case class ArrayMetaData(override val name: String, override val columnType: ColumnType = ColumnType.ARRAY, val eleColumnType: ColumnType) extends ColumnMetaData(name, columnType)

case class MapMetaData(override val name: String, override val columnType: ColumnType = ColumnType.MAP, val keyColumnType: ColumnType, val valColumnType: ColumnType) extends ColumnMetaData(name, columnType)


object ColumnMetaData {


  def unapply(that: Any): Option[(String, ColumnType)] = {
    that match {
      case m: ColumnMetaData => Some(m.name, m.columnType)
      case _ => None
    }
  }

}

