import kotlin.random.Random
import kotlin.random.nextInt

fun main() {

    var countOfIteration: Int?
    while (true) {
        print("Введите число от 1 до бесконечности: ")
        countOfIteration = readLine()?.toIntOrNull()
        if (countOfIteration != null && countOfIteration != 0) break else println("Вы ничего не ввели или ввели 0. Попробуйте еще раз.")
    }

    for (i in 1 .. countOfIteration!!) {
        Reserve.arrayOfAnimal.forEach { animal ->
            animal.randomDo(Random.nextInt(1..4))
            if (animal.currentAge == animal.maxAge) {
                Reserve.dieAnimal.add(animal)
                println("${animal.name} умер в возрасте ${animal.currentAge}")
            }
        }
    }

    Reserve.arrayOfAnimal.addAll(Reserve.childAnimal)
    Reserve.childAnimal.clear()
    Reserve.arrayOfAnimal.removeAll(Reserve.dieAnimal)
    Reserve.dieAnimal.clear()

    Reserve.arrayOfAnimal.forEach{it -> println(it.name) }
    println("Количество животных: ${Reserve.arrayOfAnimal.size}")
}




