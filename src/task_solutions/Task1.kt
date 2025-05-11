package task_solutions

class Task1() {
    private val yes = "YES"
    private val no = "NO"
    private val string = readLine()

    fun checkString() {
        if (!string.isNullOrEmpty() && string.length == 4) {
            if (string[0] == string[3])
                println(yes)
            else if (string[0] == string[2])
                println(yes)
            else if (string[1] == string[3])
                println(yes)
            else
                println(no)
        } else println(no)
    }
}

fun main() {
    val task1 = Task1()
    task1.checkString()
}