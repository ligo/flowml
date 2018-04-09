package com.beautiful.data.vec

import com.beautiful.api.ops._
import com.tinkerpop.blueprints.impls.tg.TinkerGraph

import scala.collection.mutable._


trait PreProcessBuilder {

  protected var opsGraph: AnyRef

  def addLoader(loader: Loader): this.type

  def addFilter(filter: Filter): this.type

  def addTransform(transform: Transform): this.type

  def addGrouper(group: Grouper): this.type

  def addRanker(ops: Ranker): this.type

  def addReducer(ops: AggregateReducer): this.type

  def addOps(ops: Ops): this.type


}

object SequentialPreProcessBuilder extends PreProcessBuilder {
  override protected var opsGraph: ArrayBuffer[Ops] = ArrayBuffer.empty[Ops]

  override def addLoader(loader: Loader): SequentialPreProcessBuilder.this.type = {
    opsGraph += loader
    this
  }

  override def addFilter(filter: Filter): SequentialPreProcessBuilder.this.type = {
    opsGraph += filter
    this
  }

  override def addTransform(transform: Transform): this.type = {
    opsGraph += transform
    this
  }

  override def addGrouper(group: Grouper): SequentialPreProcessBuilder.this.type = {
    opsGraph += group
    this
  }

  override def addRanker(ranker: Ranker): SequentialPreProcessBuilder.this.type = {
    opsGraph += ranker
    this
  }

  override def addReducer(reducer: AggregateReducer): SequentialPreProcessBuilder.this.type = {
    opsGraph += reducer
    this
  }

  override def addOps(ops: Ops): SequentialPreProcessBuilder.this.type = {
    opsGraph += ops
    this
  }
}

//先添加定点
object ComputerGraphPreProcessBuilder extends PreProcessBuilder {
  override protected var opsGraph: TinkerGraph = TinkerGraph

  override def addLoader(loader: Loader): ComputerGraphPreProcessBuilder.this.type = {
    opsGraph.addVertex(loader)
    this
  }

  override def addFilter(filter: Filter): ComputerGraphPreProcessBuilder.this.type = {
    opsGraph.addVertex(filter)
    this
  }

  override def addTransform(transform: Transform): ComputerGraphPreProcessBuilder.this.type = {
    opsGraph.addVertex(transform)
    this
  }

  override def addGrouper(group: Grouper): ComputerGraphPreProcessBuilder.this.type = {
    opsGraph.addVertex(group)
    this
  }

  override def addRanker(ranker: Ranker): ComputerGraphPreProcessBuilder.this.type = {
    opsGraph.addVertex(ranker)
    this
  }

  override def addReducer(reducer: AggregateReducer): ComputerGraphPreProcessBuilder.this.type = {
    opsGraph.addVertex(reducer)
    this

  }

  override def addOps(ops: Ops): ComputerGraphPreProcessBuilder.this.type = {
    opsGraph.addVertex(ops)
    this
  }



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
      case 1 => SequentialPreProcessBuilder
      case 2 => ComputerGraphPreProcessBuilder
      case _ => throw new IllegalArgumentException(s"非法参数${processType}")
    }

  }

}
