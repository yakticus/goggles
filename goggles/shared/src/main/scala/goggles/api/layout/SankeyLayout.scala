package goggles.api.layout

import rx._

/**
  * [[http://bl.ocks.org/d3noob/5028304]]
  */
trait SankeyLayout {
  def nodeWidth(width: Int): SankeyLayout

  def nodePadding(padding: Int): SankeyLayout

  def size(width: Int, height: Int): SankeyLayout

  def link(): IndexedSeq[Rx[String]]

  def init(numNodes: Int, linkIndexes: IndexedSeq[(Int, Int)]): SankeyLayout
}
