package product

class SmallSizeProduct(override var weight: Int) : Product(){
    override fun toString(): String = "Продукт малого размера, вес: $weight"
}