package me.will.kotlinfundamentals.practices

data class Event(
    val title: String,
    val description: String? = null,
    val daypart: Daypart,
    val durationInMinutes: Int
)

val Event.durationOfEvent: String
    get() = if (durationInMinutes < 60) {
        "short"
    } else {
        "long"
    }

// one more test of extension method
fun Event.isDescriptionEmpty(): Boolean {
    return description.isNullOrEmpty()
}