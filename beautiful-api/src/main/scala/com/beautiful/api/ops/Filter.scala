package com.beautiful.api.ops

import com.beautiful.api.schema.Schema
import com.beautiful.api.writable.WritableValue

/**
  *
  * @Description:过滤器
  * @Author: zhuyuping
  * @CreateDate: 2018/3/16 下午3:18
  *
  **/
trait Filter {

  def remove(input: Seq[WritableValue])(implicit schema: Schema)


}

