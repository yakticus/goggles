package goggles.d3.layout

import goggles.api.layout._
import goggles.d3._
import rx.Rx

import scala.scalajs.js
import scala.scalajs.js.Dynamic.literal
import scala.scalajs.js.JSConverters._

class D3SankeyLayout extends SankeyLayout {
  private[this] val layout: js.Dynamic = d3.layout.sankey()

  private[this] var _points = IndexedSeq.empty[VarPoint]
  private[this] var _paths = IndexedSeq.empty[Rx[String]]
  private[this] var jsNodes = js.Array[js.Object with js.Dynamic]()
  private[this] var jsLinks = js.Array[js.Object with js.Dynamic]()

  // 1. bind position of nodes and links to Var(Option[Double]), using array index as the "ID"
  override def init(numNodes: Int, linkIndexes: IndexedSeq[(Int, Int)]): SankeyLayout = {
    require(numNodes > 0, s"number of nodes ($numNodes) must be a positive number")
    require(linkIndexes.forall { case (i, j) => i >= 0 && i < numNodes && j >= 0 && j < numNodes},
      s"link indexes must be between 0 and $numNodes ($linkIndexes)")

    _points = (0 until numNodes).toIndexedSeq.map(_ => new VarPoint)
    jsNodes = (0 until numNodes).map(i => literal(index = i)).toJSArray
    _paths = linkIndexes.map{case (source, target) => ???}
    jsLinks = linkIndexes.map{case (source, target) => literal(source = source, target = target)}.toJSArray
    layout.nodes(jsNodes).links(jsLinks)

    layout.on("tick", { (event: js.Dynamic) =>
      _points.zipWithIndex.foreach {
        case (point, index) =>
          val node = jsNodes(index).asInstanceOf[ForceNode]
          point.update(node.x, node.y)
      }
    })
    this
  }

  override def link(): IndexedSeq[Rx[String]] = {

  }

  override def nodeWidth(width: Int): SankeyLayout = {
    layout.nodeWidth(width)
    this
  }

  override def size(width: Int, height: Int): SankeyLayout = {
    layout.size(js.Array(width, height))
    this
  }

  override def nodePadding(padding: Int): SankeyLayout = {
    layout.nodePadding(padding)
    this
  }
}
