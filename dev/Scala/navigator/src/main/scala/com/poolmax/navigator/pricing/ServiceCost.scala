package com.poolmax.navigator.pricing

import com.google.maps.DirectionsApi.RouteRestriction
import com.google.maps._
import com.google.maps.model._
//import com.google.maps.model.DistanceMatrix._
import com.poolmax.navigator.common.CommonSettings
import com.poolmax.navigator.common.TripReqParams

class ServiceCost (){

  def getDistAndTime(tripReqParams: TripReqParams): Double = {

    val distanceMatrixContext: GeoApiContext = new GeoApiContext.Builder()
                                                    .apiKey(CommonSettings.getMapApiKeys("gmpApiKey"))
                                                    .build()

    val req: DistanceMatrixApiRequest = new DistanceMatrixApiRequest(distanceMatrixContext)

    val result = req
                .origins("2213+maidenhair+way+San+Ramon+CA")
                .destinations("1001+Marshall+St+Redwood+City+CA+94063")
                .mode(TravelMode.DRIVING)
                .avoid(RouteRestriction.TOLLS)
                .units(Unit.IMPERIAL)
                .language("en-US")
                .await()

    val distApart = result.rows(0).elements(0).distance.inMeters
    //2.8
    distApart
  }

}

object ServiceCost {
  def main(args: Array[String]): Unit = {

  }
}
