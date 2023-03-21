//package main.scala.common
package com.poolmax.navigator.common

object CommonSettings {

  def getMapApiKeys : Map[String, String] = {
    val mapApiKeys = Map("gmpApiKey" -> "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA")
    mapApiKeys
  }

  def getGeoPricing (geo: String): Map[String,String] = {
    val geoPricing = Map( "geo" -> "Default",
                          "dollerPerMile" -> "1.25",
                          "centsPerMinute" -> "19"

    )
    geoPricing
  }


}
