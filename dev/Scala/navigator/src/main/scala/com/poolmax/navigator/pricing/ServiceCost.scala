package com.poolmax.navigator.pricing

import com.google.maps.DirectionsApi.RouteRestriction
import com.google.maps._
import com.google.maps.model._
import com.poolmax.navigator.common.CommonSettings
//import com.google.maps.model.DistanceMatrix._
//import com.poolmax.navigator.common._
import com.poolmax.navigator.common.TripReqParams
import com.poolmax.navigator.common.TripCostParams
import com.poolmax.navigator.common.RulesLookUp

class ServiceCost (tripReqParams: TripReqParams){

  def getDistAndTime: (Double, Long) = {

    val distanceMatrixContext: GeoApiContext = new GeoApiContext.Builder()
                                                    .apiKey(CommonSettings.getMapApiKeys("gmpApiKey"))
                                                    .build()

    val req: DistanceMatrixApiRequest = new DistanceMatrixApiRequest(distanceMatrixContext)

    val result = req
                //.origins("2213+maidenhair+way+San+Ramon+CA")
                .origins(tripReqParams.tripReqStartPlace.replaceAll("\\s", "+"))
                //.destinations("1001+Marshall+St+Redwood+City+CA+94063")
                .destinations(tripReqParams.tripReqEndPlace.replaceAll("\\s", "+"))
                .mode(TravelMode.DRIVING)
                .avoid(RouteRestriction.TOLLS)
                .units(Unit.IMPERIAL)
                .language("en-US")
                .await()

    val distanceMiles :Double = result.rows(0).elements(0).distance.inMeters/1609.344
    val durationMinutes = result.rows(0).elements(0).duration.inSeconds/60
    (distanceMiles, durationMinutes)
  }

  def getTripCosts: TripCostParams = {

    val tripCosts = RulesLookUp.getCosts(tripReqParams.sourceGeo.cityId, tripReqParams.payloadType)
    val (distancMiles, durationMinutes) = getDistAndTime
    val tripTandDCost:Double = distancMiles * tripCosts.CostPerMile
    val tripCostParams = TripCostParams(tripReqParams.payloadType,tripReqParams.sourceGeo.cityId, tripReqParams.destGeo.cityId,
      tripReqParams.sourceGeo.cityId, distancMiles, durationMinutes, tripTandDCost, tripCosts)

    tripCostParams
  }
}
