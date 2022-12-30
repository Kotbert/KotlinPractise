fun main(args: Array<String>) {

    val tv1 = TV("15B20", "Sony", 20)
    val tv2 = TV("15B25", "Sony", 25)
    val tv3 = TV("15B30", "Sony", 30)

    println("Телевизор №1")
    tv1.model
    tv1.changeChannel("+")
    tv1.getCurrentChannel()
    tv1.changeChannel("-")
    tv1.getCurrentChannel()
    tv1.changeChannel(4)
    tv1.getCurrentChannel()

    println("\nТелевизор №2")
    tv2.brand
    tv2.powerOnOff()
    tv2.currentVolume
    tv2.increaseVolume()
    tv2.currentVolume
    tv2.increaseVolume()
    tv2.increaseVolume()
    tv2.increaseVolume()
    tv2.increaseVolume()
    tv2.currentVolume

    println("\nТелевизор №3")
    tv1.powerOnOff()
    tv1.powerOnOff()
    tv3.diagonalSize
    tv3.printListOfChannels()
    tv3.decreaseVolume()
    tv3.currentVolume
    tv3.decreaseVolume()
    tv3.decreaseVolume()
    tv3.decreaseVolume()
    tv3.decreaseVolume()
    tv3.currentVolume
}