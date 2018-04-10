package com.beautiful.data.vec


import com.beautiful.api.block.DataBlock
import com.beautiful.api.column.DataColumn
import com.beautiful.api.index.Index
import com.beautiful.api.ops._
import com.beautiful.api.row.DataRow
import shapeless.T


/**
  *
  * @Description:
  * @Author: zhuyuping
  * @CreateDate: 2018/4/9 13:21
  *
  **/
trait DataFrame extends Iterable[DataRow] {

  def getIndex: Index

  def getColumns: Array[DataColumn]

  def getColumn(name: String): DataColumn

  def getColumn(index: Int): DataColumn

  def groupBy(grouper: Grouper*): DataFrame

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

abstract class BasicDataFrame(var index: Index, var columns: Seq[DataColumn], var datas: DataBlock[T]) extends DataFrame {


  this () = {
    this (new Index, Seq.empty, new DataBlock);
  }

  this (index: Index, columns: Seq[DataColumn]) = {
    this (index, columns, new DataBlock);
  }

  override def from(loader: Loader): DataFrame = {
    loader.addListener()

  }
}


