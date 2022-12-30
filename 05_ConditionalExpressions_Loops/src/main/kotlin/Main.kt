fun main() {

    var countOfIteration: Int?
    while (true) {
        print("Введите число от 1 до бесконечности: ")
        countOfIteration = readLine()?.toIntOrNull()
        if (countOfIteration != null && countOfIteration != 0) break else println("Вы ничего не ввели или ввели 0. Попробуйте еще раз.")
    }

    if (countOfIteration == 1) {
        val firsNumber = 0
        println(firsNumber)
    } else {
        var firsNumber = 0
        var secondNumber = 1
        println("$firsNumber\n$secondNumber")
        if (countOfIteration != null) {
            for (i in 0..countOfIteration - 3) {
                val result = firsNumber + secondNumber
                firsNumber = secondNumber
                secondNumber = result
                println(result)
            }
        }
    }
}