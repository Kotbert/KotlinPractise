import DistributionCenter.DistributionWarehouse.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import truck.Truck
import truck.Truck.Companion.randomTruck


suspend fun main(): Unit = coroutineScope {

    fun truckEmit(): Flow<Truck> = flow {
        emit(randomTruck())
        Thread.sleep(2000)
    }.flowOn(Dispatchers.IO)

    launch {
        while (true) {
            truckEmit()
        }
    }

    launch {
        while (true) {
            DistributionCenter.getTruckShipment()
            withContext(Dispatchers.IO) {
                Thread.sleep(1000)
            }
        }
    }

    launch {
        while (true) {
            withContext(Dispatchers.IO) {
                Thread.sleep(100)
            }
            truckEmit().collect { truck -> DistributionCenter.addInQueueDischarge(truck) }
            DistributionCenter.getTruckDischarge()
            println("$OversizeProduct ${OversizeProduct.amount}")
            println("$MediumSizeProduct ${MediumSizeProduct.amount}")
            println("$SmallSizeProduct ${SmallSizeProduct.amount}")
            println("$Milk ${Milk.amount}")
            println("$Bread ${Bread.amount}")
            println("$Potatoes ${Potatoes.amount}")
        }
    }
}