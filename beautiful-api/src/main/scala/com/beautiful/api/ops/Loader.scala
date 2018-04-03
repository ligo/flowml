package com.beautiful.api.ops


import com.bautiful.api.listener.RecordListener
import com.beautiful.api.row.Record
import com.beautiful.api.split.LoadSplit

import scala.collection.mutable



/**
  *
  * @Description:结构类型load 加载 Either[Loader, Reader]
  * @Author: zhuyuping
  * @CreateDate: 2018/3/16 下午3:28
  *
  **/
trait Loader extends Ops {

  protected var listeners = mutable.ArrayBuffer.empty[RecordListener]

  def init(conf: Map[String, String], split: LoadSplit): Unit

  def next: Record

  def hasNext: Boolean

  def addListener(listener: RecordListener): this.type = {
    listeners += listener
    this
  }










}
