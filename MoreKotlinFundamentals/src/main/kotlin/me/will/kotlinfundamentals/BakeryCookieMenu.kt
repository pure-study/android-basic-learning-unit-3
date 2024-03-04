package me.will.kotlinfundamentals

class Cookie(
    val name: String,
    val softBaked: Boolean,
    val hasFilling: Boolean,
    val price: Double
)

val cookies = listOf(
    Cookie(
        name = "Chocolate Chip",
        softBaked = false,
        hasFilling = false,
        price = 1.69
    ),
    Cookie(
        name = "Banana Walnut",
        softBaked = true,
        hasFilling = false,
        price = 1.49
    ),
    Cookie(
        name = "Vanilla Creme",
        softBaked = false,
        hasFilling = true,
        price = 1.59
    ),
    Cookie(
        name = "Chocolate Peanut Butter",
        softBaked = false,
        hasFilling = true,
        price = 1.49
    ),
    Cookie(
        name = "Snickerdoodle",
        softBaked = true,
        hasFilling = false,
        price = 1.39
    ),
    Cookie(
        name = "Blueberry Tart",
        softBaked = true,
        hasFilling = true,
        price = 1.79
    ),
    Cookie(
        name = "Sugar and Sprinkles",
        softBaked = false,
        hasFilling = false,
        price = 1.39
    ),
)

fun main() {
    println("=====testForEach()=====")
    testForEach()

    println("=====testMap()=====")
    testMap()

    println("=====testFilter()=====")
    testFilter()

    println("=====testGroupBy()=====")
    testGroupBy()

    println("=====testFold()=====")
    testFold()

    println("=====testReduce()=====")
    testReduce()

    println("=====testSortedBy()=====")
    testSortedBy()
}

fun testForEach() {
    cookies.forEach { println("Menu item: ${it.name}") }
}

fun testMap() {
    val fullMenu = cookies.map { "${it.name} - $${it.price}" }
    println("Full menu:")
    fullMenu.forEach { println(it) }
}

fun testFilter() {
    val softBakedMenu = cookies.filter { it.softBaked }
    println("Soft cookies:")
    softBakedMenu.forEach { println("${it.name} - $${it.price}") }
}

fun testGroupBy() {
    val groupedMenu = cookies.groupBy { it.softBaked }
    val softBakedMenu = groupedMenu[true] ?: emptyList()
    val crunchyMenu = groupedMenu[false] ?: emptyList()

    println("Soft cookies:")
    softBakedMenu.forEach { println("${it.name} - $${it.price}") }
    println("Crunchy cookies:")
    crunchyMenu.forEach { println("${it.name} - $${it.price}") }
}

fun testFold() {
    val totalPrice = cookies.fold(0.0) { total, cookie ->
        total + cookie.price
    }
    println("Total price - fold(): $${totalPrice}")
}

fun testReduce() {
    val totalPrice = cookies.map { it.price }.reduce { acc, price ->
        acc + price
    }
    println("Total price - reduce(): $${totalPrice}")
}

fun testSortedBy() {
    val alphabeticalMenu = cookies.sortedBy { it.name }
    println("Alphabetical menu:")
    alphabeticalMenu.forEach { println(it.name) }
}