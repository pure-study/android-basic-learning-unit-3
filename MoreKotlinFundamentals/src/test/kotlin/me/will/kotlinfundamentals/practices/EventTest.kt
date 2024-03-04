package me.will.kotlinfundamentals.practices

import kotlin.test.*

class EventTest {
    private var eventList: List<Event> = emptyList()

    @BeforeTest
    fun beforeTest() {
        eventList = mutableListOf(
            Event("Wake up", "Time to get up", Daypart.MORNING, 0),
            Event("Eat breakfast", null, Daypart.MORNING, 15),
            Event("Learn about Kotlin", null, Daypart.AFTERNOON, 30),
            Event("Practice Compose", null, Daypart.AFTERNOON, 60),
            Event("Watch latest DevBytes video", null, Daypart.AFTERNOON, 10),
            Event("Check out latest Android Jetpack library", null, Daypart.EVENING, 45)
        )
    }

    @Test
    fun `basic test of Event`() {
        val event = Event(
            title = "Study Kotlin",
            description = "Commit to studying Kotlin at least 15 minutes per day.",
            daypart = Daypart.EVENING,
            durationInMinutes = 15
        )

        with(event.toString()) {
            assertTrue(contains("title=Study Kotlin"))
            assertTrue(contains("description=Commit to studying Kotlin at least 15 minutes per day."))
            assertTrue(contains("daypart=EVENING"))
            assertTrue(contains("durationInMinutes=15"))
        }
    }

    @Test
    fun `test of more than one Event`() {
        assertEquals(6, eventList.size)
    }

    @Test
    fun `test events of those are less than 60 minutes`() {
        val shortEvents = eventList.filter { it.durationInMinutes < 60 }
        assertEquals(5, shortEvents.size)
    }

    @Test
    fun `test of grouping events based on daypart`() {
        val eventsOfDaypart = eventList.groupBy { it.daypart }
        assertEquals(3, eventsOfDaypart.size)

        for ((dp, events) in eventsOfDaypart) {
            when (dp) {
                Daypart.MORNING -> assertEquals(2, events.size)
                Daypart.AFTERNOON -> assertEquals(3, events.size)
                Daypart.EVENING -> assertEquals(1, events.size)
            }
        }
    }

    @Test
    fun `test of getting the last element`() {
        with(eventList.last()) {
            assertEquals("Check out latest Android Jetpack library", title)
            assertNull(description)
            assertEquals(Daypart.EVENING, daypart)
            assertEquals(45, durationInMinutes)
        }
    }

    @Test
    fun `test of extension property`() {
        assertEquals("short", eventList[0].durationOfEvent)
        assertEquals("long", eventList[3].durationOfEvent)
    }

    @Test
    fun `test of extension method`() {
        assertFalse(eventList[0].isDescriptionEmpty())
        assertTrue(eventList[1].isDescriptionEmpty())
    }
}