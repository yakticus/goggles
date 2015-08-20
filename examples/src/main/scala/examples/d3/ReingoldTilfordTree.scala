package examples.d3

import examples.d3.Data._
import goggles.d3.all._
import goggles.svg._
import org.scalajs.dom.html
import upickle.{default => upickle}

import scala.scalajs.js.annotation.JSExport
import scalatags.JsDom.all._
import scalatags.JsDom.{svgAttrs => sa, svgTags => st}

/**
 * Reingold–Tilford Tree
 *
 * [[http://bl.ocks.org/mbostock/4339184]]
 */
@JSExport
object ReingoldTilfordTree {

  @JSExport
  def main(container: html.Div): Unit = {
    val aspectRatio = 0.48
    val (width, height) = goggles.api.dimensions(aspectRatio)

    val treeData = upickle.read[TreeNode](treeJson)
    val layout = d3.layout.tree.size(height, width - 160).layout(treeData)
    val diagonal = d3.shape.diagonal.projection({(x: Double, y: Double) => (y, x)})

    val linkTags = layout.links.map {link => st.path(cls:="treeLink", sa.d:=diagonal(link))}
    val nodeTags = layout.nodes.map { node =>
      val (anchor, dx) = if(node.isLeaf) ("start", 8) else ("end", -8)
      st.g(cls:="treeNode", sa.transform:=transform.translate(node.layout.y, node.layout.x),
        st.circle(cls:="treeNode", sa.r:= 3.5),
        st.text(sa.dx:=dx, sa.dy:=3, sa.textAnchor:=anchor, node.id))
    }

    container.appendChild(svgTag(aspectRatio)(
      st.g(sa.transform:= transform.translate(40, 0), linkTags, nodeTags)).render)
  }
}
