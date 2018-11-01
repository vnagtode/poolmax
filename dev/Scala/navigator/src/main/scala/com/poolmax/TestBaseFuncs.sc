

val rulesData:String = "SanRamon&100&Student&1.10&19&0&2.00\n" +
  "Dublin&101&Student&1.05&18&5.00&2.00\n" +
  "SanJose&201&Student&1.30&22&0.00&3.00\n"

for (line <- rulesData.lines) {
  val Array(cityNameR, cityIdR, payLoadTypeR, costPerMileR, costPerMinuteR, fixedByConfCostR, minByConfigCostR) = line.split("&").map(_.trim)
  val costs = line.split("&").map(_.trim)
  //val ll = line.split("&")
  //println(ll(0))
  //println(ll.getClass)
  //ll.foreach(println)
  //costs.foreach(println)
  println (costs(0))
  println (costs(2))
  (costs(0), costs(2)) match {
    case ("SanRamon", "Student") => println("Hi")
    case _ => 0
  }
  println("New Line")
}