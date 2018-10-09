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

class TripReqParams (tripReqId: String,
                     geo: Geo,
                     tripReqReceivedDateTime: DateTime,
                     customerId: String,
                     payloadType: PayloadType.Value,
                     scheduleType: ScheduleType.Value,
                     tripReqStartPlace: String,
                     tripReqEndPlace: String,
                     tripReqReqStartTime: DateTime,
                     tripReqReqDelTime: DateTime,
                     tripReqPromoRequested: String,
                     favStores: List[String],
                     payloadId: List[BigInt],
                     payloadCount: Int,
                     tripReqRequestedStoreId: BigInt,
                     tripReqStatus: TripReqStatus.Value) {

  def getCustomerId:String = customerId

}
