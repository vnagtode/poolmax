package com.poolmax.navigator.common

//Pending work:
//1. Add defaults values to the lookup when config is missing.
//2. Add code to handle mistyped values.
//
object RulesLookUp {

  // rulesData Format: CityName&CityId&PayloadType&CostPerMile&CostPerMinute&FixedByConfCost&MinByConfigCost
  val rulesData:String = "SanRamon&100&Student&1.10&19&0&2.00\n" +
    "Dublin&101&Student&1.05&18&5.00&2.00\n" +
    "SanJose&201&Student&1.30&22&0.00&3.00\n"

  def getCosts(cityId: Int, payloadType: PayloadType.Value): TripCosts ={
    // This line creates array of array of strings. Inner array member represents a line split into elements.
    val lines = rulesData.split("\n").map(_.trim).map(_.split("&").map(_.trim))
    val configsArr: Array[Array[String]] = lines.filter(x => x(1) == cityId.toString && x(2) == payloadType.toString)
    val configs = configsArr(0)
    val tripCosts = TripCosts(cityId, payloadType, configs(3).toDouble, configs(4).toDouble, configs(5).toDouble, configs(6).toDouble )
    tripCosts
  }

/*
  def getCostPerMile(cityId: Int, payloadType: PayloadType.Value) :Double = {
    var derivedCostPerMile: Double = 0.0
    for (line <- rulesData.lines) {
      val Array(cityNameR, cityIdR, payLoadTypeR, costPerMileR, costPerMinuteR, fixedByConfCostR, minByConfigCostR) = line.split("&").map(_.trim)
      //println(s"$month $revenue $expenses $profit")
      if (cityIdR == cityId.toString) {
        if (payLoadTypeR == payloadType.toString) {}
        var derivedCostPerMile: Double = costPerMileR.toDouble
      }
    }
    derivedCostPerMile
  }
*/
/*
  def getCostPerMinute(cityId: Int, payloadType: PayloadType.Value) :Double = {
    var derivedCostPerMinute: Double = 0.0
    for (line <- rulesData.lines) {
      val Array(cityNameR, cityIdR, payLoadTypeR, costPerMileR, costPerMinuteR, fixedByConfCostR, minByConfigCostR) = line.split("&").map(_.trim)
      //println(s"$month $revenue $expenses $profit")
      if (cityIdR == cityId.toString) {
        if (payLoadTypeR == payloadType.toString) {}
        var derivedCostPerMinute: Double = costPerMinuteR.toDouble
      }
    }
    derivedCostPerMinute
  }
*/
/*
  def getFixedConfigCost(cityId: Int, payloadType: PayloadType.Value) :Double = {
    var derivedFixedConfigCost: Double = 0.0
    for (line <- rulesData.lines) {
      val Array(cityNameR, cityIdR, payLoadTypeR, costPerMileR, costPerMinuteR, fixedByConfCostR, minByConfigCostR) = line.split("&").map(_.trim)
      //println(s"$month $revenue $expenses $profit")
      if (cityIdR == cityId.toString) {
        if (payLoadTypeR == payloadType.toString) {}
        var derivedFixedConfigCost: Double = fixedByConfCostR.toDouble
      }
    }
    derivedFixedConfigCost
  }
*/
/*
  def getMinimumConfigCost(cityId: Int, payloadType: PayloadType.Value) :Double = {
    //var derivedMinimumConfigCost: Double = 0.0
    for (line <- rulesData.lines) {
      val Array(cityNameR, cityIdR, payLoadTypeR, costPerMileR, costPerMinuteR, fixedByConfCostR, minByConfigCostR) = line.split("&").map(_.trim)
      //println(s"$month $revenue $expenses $profit")
      if (cityIdR == cityId.toString) {
        if (payLoadTypeR == payloadType.toString) {}
        val derivedMinimumConfigCost: Double = fixedByConfCostR.toDouble
      }
    }
    derivedMinimumConfigCost
  }
*/

}



/*
    for (line <- rulesData.lines) {
      val Array(month, revenue, expenses, profit) = line.split(",").map(_.trim)
      println(s"$month $revenue $expenses $profit")
 */