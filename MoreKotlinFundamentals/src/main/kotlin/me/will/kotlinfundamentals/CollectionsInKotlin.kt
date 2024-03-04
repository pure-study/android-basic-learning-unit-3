package me.will.kotlinfundamentals

fun main() {
    testArrays()
    println("==========")

    testLists()
    println("==========")

    testMaps()
}

private fun testArrays() {
    val rockPlanetsArray = arrayOf("Mercury", "Venus", "Earth", "Mars")
    val gasPlanetsArray = arrayOf("Jupiter", "Saturn", "Uranus", "Neptune", "Pluto")
    val solarSystemArray = rockPlanetsArray + gasPlanetsArray
    for (p in solarSystemArray) {
        println(p)
    }
}

private fun testLists() {
//    val solarSystem = listOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
    val solarSystem = mutableListOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
    println(solarSystem.size)
    println(solarSystem[2])
    println(solarSystem.indexOf("Earth"))
    println(solarSystem.indexOf("Pluto"))
    for (planet in solarSystem) {
        println(planet)
    }
    solarSystem.add("Pluto")
    solarSystem.add(3, "Theia")
    solarSystem[3] = "Future Moon"
    println("Theia" in solarSystem)
}

private fun testMaps() {
    val solarSystem = mutableMapOf(
        "Mercury" to 0,
        "Venus" to 0,
        "Earth" to 1,
        "Mars" to 2,
        "Jupiter" to 79,
        "Saturn" to 82,
        "Uranus" to 27,
        "Neptune" to 14,
    )
    println(solarSystem.size)

    solarSystem["Pluto"] = 5
    println(solarSystem.size)
    println(solarSystem["Pluto"])
    println(solarSystem["Theia"])

    solarSystem["Jupiter"] = 78
    for ((key, value) in solarSystem) {
        println("$key : $value")
    }
}