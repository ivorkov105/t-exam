package task_solutions

class Task6 {
    private var n: Int = 0
    private lateinit var a: IntArray
    private lateinit var dp: Array<LongArray>

    fun init() {
        n = readLine()!!.toInt()
        a = readLine()!!
            .split(" ")
            .map { it.toInt() }
            .toIntArray()
        require(a.size == n) { "Ожидалась длина $n, но получено ${a.size}" }

        dp = Array(n + 2) { LongArray(n + 2) }
    }

    fun solve(): Long {
        for (len in 2..n) {
            for (l in 1..n - len + 1) {
                val r = l + len - 1
                dp[l][r] = dp[l][r - 1]
                for (k in l until r) {
                    val left  = if (k > l) dp[l][k - 1] else 0L
                    val inner = if (k + 1 <= r - 1) dp[k + 1][r - 1] else 0L
                    val cost  = kotlin.math.abs(a[k - 1] - a[r - 1]).toLong()
                    dp[l][r] = maxOf(dp[l][r], left + inner + cost)
                }
            }
        }
        return dp[1][n]
    }
}

fun main() {
    val task = Task6()
    task.init()
    println(task.solve())
}