package com.beautiful.api.writable


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

  trait WritableValueLike[T <: WritableValue] {
    def +(x: T, y: T): T

    def ++(x: T, y: T): Seq[T]

  }

  object WritableValueLike {

    implicit object DoubleWritableValueLike extends WritableValueLike[DoubleWritableValue] {
      override def +(x: DoubleWritableValue, y: DoubleWritableValue): DoubleWritableValue = new DoubleWritableValue(x.getValue + y.getValue)

      override def ++(x: DoubleWritableValue, y: DoubleWritableValue): Seq[DoubleWritableValue] = {
        List(x, y)
      }
    }

  }


}
