package com.beautiful.api.ops

import java.util.Comparator

import com.beautiful.api.writable.WritableValue

/**
  *
  * @Description:
  * @Author: zhuyuping
  * @CreateDate: 2018/3/16 下午3:33
  *
  **/
trait Ranker {

  var sortColumnName:String
  var sortNewColumnName:String

  def isAscending: Boolean //是否顺序

  def setComparator: Comparator[_ <: WritableValue] //设置比较器

}
