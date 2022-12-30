package port

import DistributionCenter
import truck.Truck
import truck.trucksTypes.MediumTruck
import truck.trucksTypes.SmallTruck

class DischargePort : Port() {
    var isBusy = false

    fun dischargeProgress(truck: Truck) {
        isBusy = true
        truck.unload(truck.cargo)
        if (truck is SmallTruck || truck is MediumTruck)
            DistributionCenter.addInQueueShipment(truck)
        isBusy = false
    }
}