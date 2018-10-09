package com.poolmax.navigator.common

object  Utils {

  def createGUID: String = {
    val uuid = java.util.UUID.randomUUID.toString
    uuid
  }


}
