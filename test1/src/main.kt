
fun getTemperature(lat: Double,long: Double, key: String):Double{

    val url = "http://api.openweathermap.org/data/2.5/weather?lat=$lat&lon=$long&APPID=$key"
    val resp:String=wGet(url)

    val cont: String =resp.substringAfter("temp",",")
    val tempC=cont.removePrefix("\":").removeRange(6,cont.length-2).toDouble()-273.15
    return (tempC)
}


fun main(){
    var temp:Double=getTemperature(72.3502234, -26.8250673, "bc035b5de2d6a91405d43cec0cb53b2d")
    var tempA=0.0
    var count=1
    var promedio: Double
    while (true) {
        tempA=(temp+tempA)
        promedio=tempA/count
        count++
        print("Temperatura actual:"+temp)
        println("\t Temperatura promedio:"+promedio)
        temp = getTemperature(72.3502234, -26.8250673, "bc035b5de2d6a91405d43cec0cb53b2d")
        Thread.sleep(10000)
    }
}