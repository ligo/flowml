package com.beautiful.api.split

import org.apache.spark.Partition


/**
  *
  * @Description:
  * @Author: zhuyuping
  * @CreateDate: 2018/4/2 20:31
  *
  **/
class LoadSplit(params: AnyVal, idx: Int) extends Partition {
  override def index: Int = idx
}



