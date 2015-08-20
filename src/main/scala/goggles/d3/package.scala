import goggles.d3.interpolate.D3Interpolate
import goggles.d3.layout.D3Layout
import goggles.d3.scale.D3Scale
import goggles.d3.shape.D3Shape

import scala.scalajs.js

package goggles {
  package object d3 {
    val d3 = js.Dynamic.global.d3

    object all {
      object d3 {
        val layout = D3Layout
        val scale = D3Scale
        val shape = D3Shape
        def interpolate[T] = D3Interpolate.interpolate[T] _
      }
    }
  }
}
