package goggles.d3.shape

import goggles.api.shape.{Arc, Diagonal, Shape}
import goggles.d3._

object D3Shape extends Shape {
  override def diagonal: Diagonal = new D3Diagonal()

  override def diagonalRadial: Diagonal = new D3Diagonal(d3.svg.diagonal.radial())

  override def arc: Arc = new D3Arc
}
