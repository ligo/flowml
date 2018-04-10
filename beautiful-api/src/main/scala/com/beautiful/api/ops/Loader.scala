package com.beautiful.api.ops


import com.beautiful.api.row.DataRow
import com.beautiful.api.split.LoadSplit




/**
  *
  * @Description:结构类型load 加载 Either[Loader, Reader]
  * @Author: zhuyuping
  * @CreateDate: 2018/3/16 下午3:28
  *
  **/
trait Loader extends Ops {



  def init(conf: Map[String, String], split: LoadSplit): Unit

  def next: DataRow

  def hasNext: Boolean

  def destroy: Unit






}
