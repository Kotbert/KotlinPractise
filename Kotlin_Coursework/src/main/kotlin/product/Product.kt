package product

import kotlin.random.Random
import kotlin.random.nextInt

abstract class Product() {

    abstract var weight: Int
    abstract override fun toString(): String

    companion object{
        fun randomProduct(maxWeight: Int): Product {
            return when (Random.nextInt(1..6)) {
                1 -> SmallSizeProduct(Random.nextInt(1..maxWeight))
                2 -> MediumSizeProduct(Random.nextInt(1..maxWeight))
                3 -> OversizeProduct(Random.nextInt(1..maxWeight))
                4 -> FoodProduct.Bread(Random.nextInt(1..maxWeight))
                5 -> FoodProduct.Milk(Random.nextInt(1..maxWeight))
                else -> FoodProduct.Potatoes(Random.nextInt(1..maxWeight))
            }
        }
    }
}