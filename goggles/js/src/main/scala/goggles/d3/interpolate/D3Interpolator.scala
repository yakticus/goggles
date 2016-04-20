package goggles.d3.interpolate

import goggles.api.interpolate.Interpolator
import scalajs.js
import goggles.d3._

class D3Interpolator[T](interpolator: js.Dynamic) extends Interpolator[T] {
  def this(a: T, b: T) = this(d3.interpolate(a.asInstanceOf[js.Any], b.asInstanceOf[js.Any]))

  override def apply(t: Double): T = interpolator(t).asInstanceOf[T]
}
