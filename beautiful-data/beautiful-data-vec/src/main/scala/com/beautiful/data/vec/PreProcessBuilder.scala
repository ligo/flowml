package com.beautiful.data.vec

import com.beautiful.api.ops._
import com.tinkerpop.blueprints.impls.tg.TinkerGraph

import scala.collection.mutable._


trait PreProcessBuilder {

  protected var opsGraph: AnyRef

  def addLoader(loader: Loader): this.type

  def addFilter(filter: Filter): this.type

  def addTransform(transform: Transform)

  def addGrouper(group: Grouper): this.type

  def addRanker(ops: Ranker): this.type

  def addReducer(ops: AggregateReducer): this.type

  def addOps(ops: Ops): this.type


}

object SequentialPreProcessBuilder extends PreProcessBuilder {
  override protected var opsGraph: AnyRef = ArrayBuffer.empty[Ops]
}

object ComputerGraphPreProcessBuilder extends PreProcessBuilder {
  override protected var opsGraph: AnyRef = TinkerGraph
}

object PreProcessBuilder {

  def builder = {

  }

  def fromJson(json: String) = {
    //转化为图
  }

  def toJson(builder: PreProcessBuilder) = {

  }

  def toImage(builder: PreProcessBuilder) = {

  }

  def apply(processType: Int): PreProcessBuilder = {
    processType match {
      case 1 =>
      case 2 =>
      case _ => throw new IllegalArgumentException(s"非法参数${processType}")
    }

  }

}
