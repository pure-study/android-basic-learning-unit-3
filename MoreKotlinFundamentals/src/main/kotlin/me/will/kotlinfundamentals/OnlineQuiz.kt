package me.will.kotlinfundamentals

fun main() {
    Quiz().apply {
        printQuiz()
        printProgressBar()
    }
}

// enum
enum class Difficulty {
    EASY, MEDIUM, HARD
}

interface ProgressPrintable {
    val progressText: String
    fun printProgressBar()
}

class Quiz : ProgressPrintable {
    private val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    private val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    private val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)

    // singleton
    companion object StudentProgress {
        var total: Int = 10
        var answered: Int = 3
    }

    override val progressText: String
        get() = "$answered of $total answered"

    override fun printProgressBar() {
        repeat(answered) { print("▓") }
        repeat(total - answered) { print("▒") }
        println()
        println(progressText)
    }

    fun printQuiz() {
        question1.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question2.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question3.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
    }
}

// property extension
//val Quiz.StudentProgress.progressText: String
//    get() = "$answered of $total answered"

// method extension
//fun Quiz.StudentProgress.printProgressBar() {
//    repeat(Quiz.answered) { print("▓") }
//    repeat(Quiz.total - Quiz.answered) { print("▒") }
//    println()
//    println(Quiz.progressText)
//}

// data class and generic type
data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty,
)

// singleton
//object StudentProgress {
//    var total: Int = 10
//    var answered: Int = 3
//}
