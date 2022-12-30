class Fish(name: String, energy: Int, wight: Int, maxAge: Int) : Animal(name, energy, wight, maxAge) {

    override fun walking() {
        println("${this.name} плывет")
    }

    override fun createChild() {
        Reserve.childAnimal.add(Fish(name, energy, maxAge, maxAge))
        val newChilde = Reserve.childAnimal[Reserve.childAnimal.lastIndex]
        println(
            "${newChilde.name} родился." +
                    " Енергия ${newChilde.energy}," +
                    " вес ${newChilde.wight}," +
                    " максимальный возраст ${newChilde.maxAge}"
        )
    }
}