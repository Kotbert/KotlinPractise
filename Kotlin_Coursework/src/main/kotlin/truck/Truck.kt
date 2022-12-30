package truck

import DistributionCenter
import product.*
import truck.trucksTypes.BigTruck
import truck.trucksTypes.MediumTruck
import truck.trucksTypes.SmallTruck
import kotlin.random.Random
import kotlin.random.nextInt

abstract class Truck(var cargo: Product) {

    abstract val loadCapacity: Int

    fun unload(someProduct: Product) {
        when (someProduct) { //Как бы время погрузки
            is SmallSizeProduct -> Thread.sleep((cargo.weight * 10).toLong())
            is MediumSizeProduct -> Thread.sleep((cargo.weight * 25).toLong())
            is OversizeProduct -> Thread.sleep((cargo.weight * 50).toLong())

        }

        DistributionCenter.plusProduct(someProduct, cargo.weight)
        cargo.weight = 0
        getRandomLoad()
    }

    private fun getRandomLoad(): Product {
        return when (Random.nextInt(1..6)) {
            1 -> SmallSizeProduct(0)
            2 -> MediumSizeProduct(0)
            3 -> OversizeProduct(0)
            4 -> FoodProduct.Bread(0)
            5 -> FoodProduct.Milk(0)
            else -> FoodProduct.Potatoes(0)
        }
    }

    fun load(needAmount: Int) {
        println("Начата погрузка $this в количестве $needAmount")
        if (DistributionCenter.findProduct(cargo) >= needAmount) {
            when (cargo) { //Как бы время погрузки
                is SmallSizeProduct -> Thread.sleep((cargo.weight * 10).toLong())
                is MediumSizeProduct -> Thread.sleep((cargo.weight * 25).toLong())
                is OversizeProduct -> Thread.sleep((cargo.weight * 50).toLong())
            }
            cargo.weight = needAmount
            DistributionCenter.minusProduct(cargo, needAmount)
            println("Трак загружен - $cargo. Трак отправлен.")

        } else {
            var remainingAmount = needAmount
            for (i in 0..4) {
                var haveAmount = DistributionCenter.findProduct(cargo)
                if (haveAmount > remainingAmount)
                    haveAmount = remainingAmount
                cargo.weight += haveAmount
                remainingAmount -= haveAmount
                DistributionCenter.minusProduct(cargo, haveAmount)
                if (this.cargo.weight == loadCapacity) {
                    break
                } else {
                    Thread.sleep(5000)
                }
            }
            println("Трак загружен - $cargo. Трак отправлен.")
        }
    }


    abstract override fun toString(): String

    companion object {
        fun randomTruck(): Truck {
            return when (Random.nextInt(1..3)) {
                1 -> SmallTruck(Product.randomProduct(50)) //Тут должно быть значение SmallTruck > loadCapacity,
                // но тут оно абстрактное, а из класса SmallTruck не берет

                2 -> MediumTruck(Product.randomProduct(100)) //Тут должно быть значение MediumTruck > loadCapacity,
                // но тут оно абстрактное, а из класса MediumTruck не берет

                else -> BigTruck(Product.randomProduct(150)) //Тут должно быть значение BigTruck > loadCapacity,
                // но тут оно абстрактное, а из класса BigTruck не берет
            }
        }
    }
}