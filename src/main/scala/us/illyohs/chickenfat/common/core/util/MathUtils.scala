package us.illyohs.chickenfat.common.core.util

import java.math.{BigDecimal, MathContext}

object MathUtils {

  def milesToKilometers(miles:Float):Double = miles.toDouble/0.62137

  def significantMilesToKilometers(miles:Float):Double = {
    val m2k = milesToKilometers(miles)
    var small = new BigDecimal(m2k)
    small = small.round(new MathContext(3))

    small.doubleValue()
  }
}
