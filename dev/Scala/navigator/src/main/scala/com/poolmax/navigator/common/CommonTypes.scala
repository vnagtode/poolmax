package com.poolmax.navigator.common

import org.joda.time.DateTime


object PayloadType extends Enumeration{
  val Student, Adult, Food, Groceries, Shipments = Value
}

object ScheduleType extends Enumeration {
  val Immediate, Scheduled = Value
}

object TripReqStatus extends Enumeration {
  val Requested, Scheduled, Processing, Cancelled, Completed, Failed = Value
}

object TripReqPoolStatus extends Enumeration {
  val PoolRequested, PoolAvoided, PoolBanned, Pooled = Value
}

case class Geo( countryId: Int,
                regionId: Int,
                metroCodeId: Int,
                cityId: Int,
                zip3Id: String,
                areaCodeId: Int){}

// This object is to hold all the parameters that will go into deriving the cost of the trip.
// That would include the parameters and values coming from the trip request as well as the values configured in the database/application.
case class TripCostParams (payloadType: PayloadType.Value,
                           tripOriginCityId: Int,
                           tripDestCityId: Int,
                           tripCostBasisCityId: Int,
                           tripDistanceMiles: Double,
                           tripDurationMins: Long,
                           tripTandDCost: Double,
                           tripCosts: TripCosts
                          ){}

case class TripCosts (cityId: Int, payloadType: PayloadType.Value, CostPerMile: Double, CostPerMinute: Double, fixedCharge: Double, minimumCharge: Double){}


class TripReqParams (var tripReqId: String,
                     var sourceGeo: Geo,
                     var destGeo: Geo,
                     val tripReqReceivedDateTime: DateTime,
                     val customerId: String,
                     val payloadType: PayloadType.Value,
                     var scheduleType: ScheduleType.Value,
                     val tripReqStartPlace: String,
                     val tripReqEndPlace: String,
                     val tripReqReqStartTime: DateTime,
                     val tripReqReqDelTime: DateTime,
                     val tripReqPromoRequested: String,
                     val favStores: List[String],
                     val favDriver: Int,
                     val payloadId: List[BigInt],
                     val payloadCount: Int,
                     val tripReqRequestedStoreId: BigInt,
                     var tripReqStatus: TripReqStatus.Value) {

  def getCustomerId:String = customerId

}
