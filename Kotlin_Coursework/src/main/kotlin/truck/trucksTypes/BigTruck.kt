package truck.trucksTypes

import product.Product
import truck.Truck

class BigTruck(cargo: Product) : Truck(cargo) {
    override val loadCapacity = 150

    override fun toString(): String = "Больной тягач, с максимальной загрузкой $loadCapacity и содержит: $cargo "
}