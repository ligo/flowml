package com.beautiful.data.vec


import java.util.Date

import com.beautiful.api.metadata.ColumnMetaData
import com.beautiful.api.writable.{WritableValue, _}

/**
  *
  * @Description:
  * @Author: zhuyuping
  * @CreateDate: 2018/4/9 12:56
  *
  **/
trait DataRow {
  def getColumns: Array[ColumnMetaData]

  def get(index: Int): WritableValue

  def get(name: String): WritableValue

  def getBoolean(index: Int): Boolean = get(index).toBoolean

  def getBoolean(name: String): Boolean = get(name).toBoolean

  def getInteger(index: Int): Int = get(index).toInt

  def getInteger(name: String): Int = get(name).toInt

  def getLong(index: Int): Long = get(index).toLong

  def getLong(name: String): Long = get(name).toLong

  def getFloat(index: Int): Float = get(index).toFloat

  def getFloat(name: String): Float = get(name).toFloat

  def getDouble(index: Int): Double = get(index).toDouble

  def getDouble(name: String): Double = get(name).toDouble

  def getString(name: String): String = get(name).toStr

  def getString(index: Int): String = get(index).toStr

  def getDate(index: Int): Date = get(index).toDate

  def getDate(name: String): Date = get(name).toDate

  def getDecimal(index: Int): BigDecimal = get(index).toDecimal

  def getDecimal(name: String): BigDecimal = get(name).toDecimal

  def getTimestamp(index: Int): Long = get(index).toTimestamp

  def getTimestamp(name: String): Long = get(name).toTimestamp

  def getVector(index: Int): Vector = get(index).toVector

  def getVector(name: String): Vector = get(name).toVector

  def getMatrix(index: Int): Matrix = get(index).toMatrix

  def getMatrix(name: String): Matrix = get(name).toMatrix

  def getArray(index: Int): Seq[WritableValue] = get(index).toArray

  def getArray(name: String): Seq[WritableValue] = get(name).toArray

  def getStruct(index: Int): Seq[WritableValue] = get(index).toArray

  def getStruct(name: String): Seq[WritableValue] = get(name).toArray

}
