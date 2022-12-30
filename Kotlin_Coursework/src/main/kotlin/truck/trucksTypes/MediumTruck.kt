package truck.trucksTypes

import product.Product
import truck.Truck

class MediumTruck(cargo: Product) : Truck(cargo) {
    override val loadCapacity = 100
    override fun toString(): String = "Средний тягач, с максимальной загрузкой $loadCapacity и содержит: $cargo"
}