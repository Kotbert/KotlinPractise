import kotlin.random.Random
import kotlin.random.nextInt

object Reserve {
    var arrayOfAnimal:MutableList<Animal> = mutableListOf(
        Bird("Фулиф", Random.nextInt(5..10),Random.nextInt(5..15),Random.nextInt(10..20)),
        Bird("Фьютьлиф", Random.nextInt(5..10),Random.nextInt(5..15),Random.nextInt(10..20)),
        Bird("Фовлиф", Random.nextInt(5..10),Random.nextInt(5..15),Random.nextInt(10..20)),
        Bird("Фоолиф", Random.nextInt(5..10),Random.nextInt(5..15),Random.nextInt(10..20)),
        Bird("Фыхлиф", Random.nextInt(5..10),Random.nextInt(5..15),Random.nextInt(10..20)),

        Fish("Гуггили", Random.nextInt(1..5),Random.nextInt(1..5),Random.nextInt(3..7)),
        Fish("Дуддыли", Random.nextInt(1..5),Random.nextInt(1..5),Random.nextInt(3..7)),
        Fish("Муммыли", Random.nextInt(1..5),Random.nextInt(1..5),Random.nextInt(3..7)),

        Dog("Мао", Random.nextInt(5..20),Random.nextInt(1..10),Random.nextInt(10..15)),
        Dog("Чао", Random.nextInt(5..20),Random.nextInt(1..10),Random.nextInt(10..15)),


        Animal("Зверушка 1", Random.nextInt(30..70),Random.nextInt(20..40),Random.nextInt(100..200)),
        Animal("Зверушка 2", Random.nextInt(30..70),Random.nextInt(20..40),Random.nextInt(100..200)),
    )
    var dieAnimal:MutableList<Animal> = mutableListOf()
    var childAnimal:MutableList<Animal> = mutableListOf()
}