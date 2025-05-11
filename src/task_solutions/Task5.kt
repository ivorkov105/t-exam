package task_solutions

class Task5 {
    private var n: Int = 0
    private var x: Long = 0
    private var y: Long = 0
    private lateinit var s: String

    fun init() {
        // Читаем n, x, y
        val parts = readLine()!!.split(" ")
        n = parts[0].toInt()
        x = parts[1].toLong()
        y = parts[2].toLong()

        s = readLine()!!.trim()
        require(s.length == n) { "Ожидалась строка длины $n, получила ${s.length}" }
    }

    fun solve(): Long {
        var balance = 0
        var mismatchCount = 0
        for (ch in s) {
            if (ch == '(') {
                balance++
            } else {
                if (balance == 0) {
                    mismatchCount++
                    balance = 1
                } else {
                    balance--
                }
            }
        }

        val totalOpen = s.count { it == '(' }
        val totalClose = n - totalOpen
        val diff = totalOpen - totalClose
        val replPairs = kotlin.math.abs(diff) / 2
        val swapCost = minOf(x, 2 * y)

        return mismatchCount * swapCost + replPairs * y
    }
}

fun main() {
    val task = Task5()
    task.init()
    println(task.solve())
}