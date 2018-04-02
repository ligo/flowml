package com.bautiful.api.listener

import com.beautiful.api.ops.Loader

/**
  *
  * @Description:
  * @Author: zhuyuping
  * @CreateDate: 2018/4/2 20:46
  *
  **/
trait RecordListener {

  def callback(reader: Loader, record: Any): Unit

}
