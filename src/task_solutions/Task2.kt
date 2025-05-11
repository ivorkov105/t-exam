package task_solutions

class Task2 {
    private var n = 0
    private var q = 0
    private val timetable = mutableListOf<Pair<Int, Int>>()
    private val trainMeeting = mutableListOf<Pair<Int, Int>>()

    fun getBranches() {
        val a = readLine()?.toIntOrNull()
        if (a != null && a in 1..100) {
            n = a
        } else {
            println("Введите число в диапазоне 1 - 100:")
            return
        }
    }

    fun timetable() {
        repeat(n) {
            val parts = readLine()?.split(" ")?.mapNotNull { it.toIntOrNull() }
            if (parts != null && parts.size == 2)
                timetable.add(parts[0] to parts[1])
            else {
                println("Неверный ввод, повторите")
                return
            }
        }
    }

    fun requests() {
        val a = readLine()?.toIntOrNull()
        if (a != null && a in 1..100) {
            q = a
        } else {
            println("Введите число в диапазоне 1 - 100:")
            return
        }
    }

    fun meetingTrain() {
        repeat(q) {
            val parts = readLine()?.split(" ")?.mapNotNull { it.toIntOrNull() }
            if (parts != null && parts.size == 2)
                trainMeeting.add(parts[0] to parts[1])
            else {
                println("Неверный ввод, повторите")
                return
            }
        }
    }

    fun checkData() {
        for (i in 0 until q) {
            val (lineHuman, arrivalTime) = trainMeeting[i]
            val line = lineHuman - 1

            if (line < 0 || line >= n) {
                println("Неверный номер ветки: $lineHuman")
                continue
            }

            val (firstTrain, interval) = timetable[line]

            if (arrivalTime <= firstTrain) {
                println(firstTrain)
            } else {
                val timeDiff = arrivalTime - firstTrain
                val nextTrainTime = firstTrain + ((timeDiff + interval - 1) / interval) * interval
                println(nextTrainTime)
            }
        }
    }
}

fun main() {
    val task2 = Task2()
    task2.getBranches()
    task2.timetable()
    task2.requests()
    task2.meetingTrain();
    task2.checkData();
}