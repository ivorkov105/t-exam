package task_solutions

class Task3 {
    private var n: Int = 0
    private var array: List<Int> = listOf()
    private val seen = mutableSetOf<Int>()

    fun readArray() {
        n = readln().toInt()
        array = readln().split(" ").map { it.toInt() }
    }

    fun solve(): Int {
        val sorted = array.sortedDescending()

        for (num in sorted) {
            var value = num
            while (value > 0) {
                if (seen.add(value)) break
                value /= 2
            }
            if (value == 0) {
                seen.add(0)
            }
        }

        return seen.size
    }
}

fun main() {
    val task3 = Task3()
    task3.readArray()
    println()
    println(task3.solve())
}