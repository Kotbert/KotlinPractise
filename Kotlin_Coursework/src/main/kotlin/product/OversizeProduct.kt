package product

class OversizeProduct(override var weight: Int) : Product(){
    override fun toString(): String = "Продукт большого размера, вес: $weight"

}