import com.google.maps.DirectionsApi.RouteRestriction
import com.google.maps._
import com.google.maps.model._
import com.google.maps.model.DistanceMatrix._
import org.joda.time.DateTime
import com.poolmax.navigator.common._


val sourceGeo = Geo(countryId = 5, regionId = 6, metroCodeId = 3, cityId = 1, zip3Id = "4", areaCodeId = 10)
val destGeo = Geo(countryId = 6, regionId = 7, metroCodeId = 8, cityId = 9, zip3Id = "4", areaCodeId = 10)
val dateNow = DateTime.now()

val tp: TripReqParams = new TripReqParams("aa",
  sourceGeo,
  destGeo,
                                          tripReqReceivedDateTime = dateNow,
                                          customerId = "aa11",
                                          payloadType = PayloadType.Student,
                                          scheduleType =  ScheduleType.Scheduled,
                                          tripReqStartPlace =  "2213+maidenhair+way+San+Ramon+CA",
                                          tripReqEndPlace = "30600+Dyer+St,+Union+City,+CA+94587",
                                          tripReqReqStartTime= dateNow,
                                          tripReqReqDelTime = dateNow,
                                          tripReqPromoRequested = "ZZZZ",
                                          favStores = List("aa", "bb"),
                                          payloadId = List(),
                                          payloadCount = 15,
                                          tripReqRequestedStoreId = 10,
                                          tripReqStatus =  TripReqStatus.Requested)

val distanceMatrixContext: GeoApiContext = new GeoApiContext.Builder()
  .apiKey(CommonSettings.getMapApiKeys("gmpApiKey"))
  .build()

val req: DistanceMatrixApiRequest = new DistanceMatrixApiRequest(distanceMatrixContext)

println(req)
