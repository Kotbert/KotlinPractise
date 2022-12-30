import port.DischargePort
import port.ShipmentPort
import product.FoodProduct.*
import product.MediumSizeProduct
import product.OversizeProduct
import product.Product
import product.SmallSizeProduct
import truck.Truck

object DistributionCenter {

    enum class DistributionWarehouse(var amount: Int) {
        OversizeProduct(0),
        MediumSizeProduct(0),
        SmallSizeProduct(0),
        Milk(0),
        Bread(0),
        Potatoes(0)
    }

    private val dischargePorts = mutableMapOf(
        1 to DischargePort(),
        2 to DischargePort(),
        3 to DischargePort()
    )
    private val shipmentPorts = mutableMapOf(
        1 to ShipmentPort(),
        2 to ShipmentPort(),
        3 to ShipmentPort(),
        4 to ShipmentPort(),
        5 to ShipmentPort()
    )

    private val queueDischarge = mutableListOf<Truck>()
    private val queueShipment = mutableListOf<Truck>()

    fun addInQueueShipment(truck: Truck) {
        queueShipment.add(truck)
    }

    fun addInQueueDischarge(truck: Truck) {
        println("Добавлен трак на разгрузку: $truck")
        queueDischarge.add(truck)
    }

    fun getTruckDischarge() {
        if (queueDischarge.isEmpty()) {
            println("Очередь на разгрузку пуста")
        } else {
            println("Обнаружен трак в очереди ${queueDischarge[0]}")
            val firstTruck = queueDischarge[0]
            queueDischarge.removeAt(0)
            for (i in 1..3) {
                if (dischargePorts[i]!!.isBusy) continue
                else {
                    dischargePorts[i]!!.dischargeProgress(firstTruck)
                    break
                }
            }
        }
    }

    fun getTruckShipment() {
        if (queueShipment.isNotEmpty()) {
            for (i in 1..5) {
                if (!shipmentPorts[i]!!.isBusy) {
                    shipmentPorts[i]!!.shipmentProgress(queueShipment[0])
                    queueShipment.removeAt(0)
                    break
                }
            }
        } else println("Очередь погрузки пустая")
    }

    fun plusProduct(product: Product, amount: Int) {
        when (product) {
            is SmallSizeProduct -> DistributionWarehouse.SmallSizeProduct.amount += amount
            is MediumSizeProduct -> DistributionWarehouse.MediumSizeProduct.amount += amount
            is OversizeProduct -> DistributionWarehouse.OversizeProduct.amount += amount
            is Milk -> DistributionWarehouse.Milk.amount += amount
            is Bread -> DistributionWarehouse.Bread.amount += amount
            is Potatoes -> DistributionWarehouse.Potatoes.amount += amount
        }
    }

    fun findProduct(product: Product): Int {
        return when (product) {
            is SmallSizeProduct -> DistributionWarehouse.SmallSizeProduct.amount
            is MediumSizeProduct -> DistributionWarehouse.MediumSizeProduct.amount
            is OversizeProduct -> DistributionWarehouse.OversizeProduct.amount
            is Milk -> DistributionWarehouse.Milk.amount
            is Bread -> DistributionWarehouse.Bread.amount
            is Potatoes -> DistributionWarehouse.Potatoes.amount
            else -> throw Exception("Продукт не верен")
        }
    }

    fun minusProduct(product: Product, amount: Int) {
        when (product) {
            is SmallSizeProduct -> DistributionWarehouse.SmallSizeProduct.amount -= amount
            is MediumSizeProduct -> DistributionWarehouse.MediumSizeProduct.amount -= amount
            is OversizeProduct -> DistributionWarehouse.OversizeProduct.amount -= amount
            is Milk -> DistributionWarehouse.Milk.amount -= amount
            is Bread -> DistributionWarehouse.Bread.amount -= amount
            is Potatoes -> DistributionWarehouse.Potatoes.amount -= amount
        }
    }
}

