package com.poolmax.navigator.tripReq

import org.joda.time.DateTime
import com.poolmax.navigator.common._

class TripReq (tripReqParams: TripReqParams) {

  //var tripReqParamValidationStatus: String
  //var tripReqStatus: String

  def validateTripReqParams : Boolean = {
    true
  }

  def deriveTripReqScheduleType (tripReqReqStartTime: DateTime, tripReqReqDelTime: DateTime): ScheduleType.Value = {
    ScheduleType.Immediate
  }

  //def deriveTripReqStatus ():{}

  //def tripReqRecord():{}      //Store trip req to database

  def getTripReqParams: TripReqParams ={
    tripReqParams
  }

}
