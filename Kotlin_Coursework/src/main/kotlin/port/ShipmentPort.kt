package port

import truck.Truck

class ShipmentPort : Port() {
    var isBusy = false

    fun shipmentProgress(truck: Truck) {
        isBusy = true
        truck.load(truck.loadCapacity)
        isBusy = false
    }
}