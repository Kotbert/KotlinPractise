fun main(args: Array<String>) {

    var countOfIteration: Int?
    var arrayOfNumbers: MutableList<String> = mutableListOf()
    var arraysOfSet: MutableSet<String>
    var sumOfSet = 0
    var arrayOfMutableMap = mutableMapOf<String, String>()

    fun addNumber(countOfNubres: Int) {
        var tempPhone: String
        for (i in 0 until countOfNubres) {
            print("Введите ${i + 1} номер: ")
            tempPhone = readLine().toString()
            if (tempPhone != "") arrayOfNumbers.add(tempPhone) else println("Вы ввели пустую строку.")
        }
        println()
    }

    println("Задание №1.")
    while (true) {
        println("Введите необходимое колличество номеров.")
        print("Введите число больше 1: ")
        countOfIteration = readLine()?.toIntOrNull()
        if (countOfIteration != null && countOfIteration > 0) break else println("Вы ничего не ввели или число меньше 1. Попробуйте еще раз.")
    }
    println()


    println("Задание номер №2,3,4.")
    if (countOfIteration != null) addNumber(countOfIteration)

    println("Задание №5")
    arrayOfNumbers.forEachIndexed { index, number -> println("${index + 1} номер: $number") }
    println(arrayOfNumbers.filter { it.startsWith("+7") })
    println()

    println("Задание №6")
    arraysOfSet = arrayOfNumbers.toSet() as MutableSet<String>
    println(arraysOfSet.size)
    println()

    println("Задание №7")
    sumOfSet += arraysOfSet.sumOf { index -> index.length }
    println(sumOfSet)
    println()

    println("Задание №8")
    if (countOfIteration != null) {
        for (i in 0 until countOfIteration) {
            print("Введите имя для телефона ${arrayOfNumbers[i]}: ")
            arrayOfMutableMap.put(arrayOfNumbers[i], readLine().toString())
        }
    }

    println("Задание №9")
    arrayOfMutableMap.forEach { (key, value) -> println("Номер $key принадлежит $value") }

    println("Задание №10")
    println(arrayOfMutableMap.toSortedMap().keys)

    println("Задание №11")
    println(arrayOfMutableMap.toSortedMap().values)
}