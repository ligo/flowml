package com.beautiful.api.writable

import com.beautiful.api.writable.WritableValue.DoubleWritable
import com.google.common.primitives.Doubles


/**
  *
  * 扩展一些Value 方便像原生类型直接操作 todo add api
  *
  * @Description:
  * @Author: zhuyuping
  * @CreateDate: 2018/3/26 下午10:13
  *
  **/
object Writables {

  trait WritableValueLike[T] {
    def compare(x: T, y: T): Int

    def +(x: T, y: T): T

    def ++(x: T, y: T): Seq[T]

  }

  object WritableValueLike {

    implicit object DoubleWritableValueLike extends WritableValueLike[DoubleWritable] {
      override def +(x: DoubleWritable, y: DoubleWritable): DoubleWritable = DoubleWritable(x.value + y.value)

      override def ++(x: DoubleWritable, y: DoubleWritable): Seq[DoubleWritable] = {
        List(x, y)
      }

      override def compare(x: DoubleWritable, y: DoubleWritable): Int = Doubles.compare(x.value, y.value)
    }

  }


}
