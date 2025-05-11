package task_solutions

class Task4 {
    private lateinit var array: Array<Int>
    private var n = 0

    fun initArray() {
        n = readLine()!!.toInt()
        array = readLine()!!.split(" ")
            .map { it.toInt() }
            .toTypedArray()
    }

    fun count(): Int {
        var q = 0
        for (l in 0 until n - 2) {
            for (r in l + 2 until n) {
                var found = false
                loop@ for (i in l until r - 1) {
                    for (j in i + 1 until r) {
                        for (k in j + 1..r) {
                            if (array[j] - array[i] == array[k] - array[j]) {
                                found = true
                                break@loop
                            }
                        }
                    }
                }
                if (found) q++
            }
        }

        return q
    }
}

fun main() {
    val task = Task4()
    task.initArray()
    println(task.count())
}