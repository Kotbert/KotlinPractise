package product

class MediumSizeProduct(override var weight: Int) : Product() {

    override fun toString(): String = "Продукт среднего размера, вес: $weight"
}