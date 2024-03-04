package me.will.kotlinfundamentals.practices

sealed class Daypart {
    data object MORNING: Daypart()
    data object AFTERNOON: Daypart()
    data object EVENING: Daypart()
}

//enum class Daypart {
//    MORNING,
//    AFTERNOON,
//    EVENING
//}