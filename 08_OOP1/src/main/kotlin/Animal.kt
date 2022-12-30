import kotlin.random.Random

open class Animal(
    var name: String,
    var energy: Int,
    var wight: Int,
    var maxAge: Int
) {

    var currentAge = 0

    private fun tryIncrementAge() {
        if (Random.nextBoolean()) currentAge++
    }


    private fun sleeping() {
        if (currentAge <= maxAge) {
            energy += 5
            currentAge += 1
            println("$name спит")
        } else println("Животное уже старое")
    }

    private fun eating() {
        if (currentAge <= maxAge) {
            energy += 3
            wight += 1
            tryIncrementAge()
            println("$name ест")
        } else println("Животное уже старое")

    }

    open fun walking() {
        if (currentAge <= maxAge && energy > 0) {
            energy -= 5
            wight -= 1
            tryIncrementAge()
            println("$name передвигается")
        } else println("Животное уже старое")
    }

    open fun createChild() {
        Reserve.childAnimal.add(Fish(name, energy, maxAge, maxAge))
        val newChilde = Reserve.childAnimal[Reserve.childAnimal.lastIndex]
        println(
            "${newChilde.name} родился." +
                    " Енергия ${newChilde.energy}," +
                    " вес ${newChilde.wight}," +
                    " максимальный возраст ${newChilde.maxAge}"
        )
    }

    fun randomDo(number: Int) {
        if (this.currentAge <= maxAge) {
            when (number) {
                1 -> sleeping()
                2 -> eating()
                3 -> walking()
                4 -> createChild()
            }
        }
    }
}