package com.beautiful.data.vec

import com.beautiful.api.metadata.ColumnMetaData
import com.beautiful.api.ops._


/**
  *
  * @Description:
  * @Author: zhuyuping
  * @CreateDate: 2018/4/9 13:21
  *
  **/
trait DataFrame extends Iterable[DataRow] {

  def getColumns: Array[ColumnMetaData]

  def getColumn(name: String): ColumnMetaData

  def getColumn(index: Int): ColumnMetaData

  def groupby(grouper: Grouper*): DataFrame

  def reducer(reducer: AggregateReducer*): DataFrame

  def sort(sort: Ranker): DataFrame

  def map(transform: Transform): DataFrame

  def filter(filter: Filter): DataFrame

  def from(loader: Loader): DataFrame

  def to(export: Exporter): DataFrame

  def toList: Seq[Seq[AnyVal]]

  def toList[T](clazz: Class[T]): Seq[T]

  def toMap[K, V](keyClazz: Class[K], valueClazz: Class[K]): Seq[Map[K, V]]

  def print(): Unit


}

abstract class BasicDataFrame extends DataFrame {


}

object SQLDataFrame extends BasicDataFrame {


}
