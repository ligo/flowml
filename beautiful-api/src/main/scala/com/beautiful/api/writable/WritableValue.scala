package com.beautiful.api.writable

import com.beautiful.api.writable.Writables.WritableValueLike


/**
  *
  * @Description:
  * @Author: zhuyuping
  * @CreateDate: 2018/3/28 上午1:41
  *              STRING, INTEGER, LONG, DOUBLE, FLOAT, DECIMAL, TIMESTAMP, DATE, VECTOR, MATRIX, ARRAY, MAP, STRUCT;
  *
  **/
sealed trait WritableValue {

  def compare[T: WritableValueLike](x: T, y: T): Int = {
    implicitly[WritableValueLike[T]].compare(x, y)
  }

  def to


}

case class Vector(arr: Array[Double])

case class Matrix(arr: Array[Double], shape: (Int, Int))

object WritableValue {

  case class IntegerWritable(value: Int) extends WritableValue

  case class LongWritable(value: Long) extends WritableValue

  case class FloatWritable(value: Float) extends WritableValue

  case class DoubleWritable(value: Double) extends WritableValue

  case class StringWritable(value: String) extends WritableValue

  case class DecimalWritable(value: BigDecimal) extends WritableValue

  case class TimestampWritable(value: Long) extends WritableValue

  case class DateWritable(value: Long) extends WritableValue

  case class VectorWritable(value: Vector) extends WritableValue

  case class MatrixWritable(value: Matrix) extends WritableValue

  case class ArrayWritable(value: Array[WritableValue]) extends WritableValue

  case class MapWritable(value: Array[(WritableValue, WritableValue)]) extends WritableValue

  case class StructWritable(value: Array[(String, WritableValue)]) extends WritableValue


}




