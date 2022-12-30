package product

sealed class FoodProduct() : Product() {

    class Bread(override var weight:Int) : FoodProduct() {

        override fun toString(): String = "Хлеб, вес: $weight"
    }

    class Milk(override var weight:Int) : FoodProduct() {
        override fun toString(): String = "Молоко, вес: $weight"
    }

    class Potatoes(override var weight:Int) : FoodProduct() {
        override fun toString(): String = "Картошка, вес: $weight"
    }
}
