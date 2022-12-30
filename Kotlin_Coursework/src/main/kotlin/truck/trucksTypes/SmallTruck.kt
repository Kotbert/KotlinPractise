package truck.trucksTypes

import product.Product
import truck.Truck

class SmallTruck(cargo: Product) : Truck(cargo) {
    override val loadCapacity = 50
    override fun toString(): String = "Малый тягач, с максимальной загрузкой $loadCapacity и содержит: $cargo"

}