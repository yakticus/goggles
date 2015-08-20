package goggles.d3.shape
import goggles.api.layout.{Coordinate, TreeLink}
import goggles.api.shape.Diagonal
import goggles.d3._

import scala.scalajs.js
import scala.scalajs.js.Dynamic.literal


class D3Diagonal(shape: js.Dynamic = d3.svg.diagonal()) extends Diagonal {

  override def apply(datum: TreeLink[Coordinate]): String = {
    val dyn = literal(source = literal(x = datum.source.x, y = datum.source.y),
      target = literal(x = datum.target.x, y = datum.target.y))
    shape(dyn).asInstanceOf[String]
  }

  override def projection(fn: (Double, Double) => (Double, Double)): this.type = {
    shape.projection({d: js.Dynamic =>
      val (x, y) = fn(d.x.asInstanceOf[Double], d.y.asInstanceOf[Double])
      js.Array(x, y)
    })
    this
  }

  override def apply(datum: TreeLink[Coordinate], index: Int): String =
    shape(datum.asInstanceOf[js.Any], index).asInstanceOf[String]
}
