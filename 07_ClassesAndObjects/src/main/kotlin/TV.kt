class TV(var model: String, var brand: String, var diagonalSize: Int) {

    private var activeOnOff = false
    private var channels = Channels.getRandomChannels()
    private var currentChannel = 0
    var currentVolume = 50

    fun powerOnOff() {
        activeOnOff = activeOnOff.not()
        if (activeOnOff) println("Включен") else println("Выключен")
    }

    fun increaseVolume() {
        if (currentVolume < maxVolume) {
            currentVolume++
            println("Громкость: $currentVolume")
        } else println("Максимальная громкость")
    }

    fun decreaseVolume() {
        if (currentVolume > minVolume) {
            currentVolume--
            println("Громкость: $currentVolume")
        } else println("Минимальная громкость")
    }

    fun changeChannel(command: Int) {
        when (command) {
            1 -> currentChannel = 0
            2 -> currentChannel = 1
            3 -> currentChannel = 2
            4 -> currentChannel = 3
            5 -> currentChannel = 4

            else -> println("Не верное значение")
        }
        print("№${currentChannel + 1} - ")
    }

    fun changeChannel(command: String) {
        if (!activeOnOff) powerOnOff()
        when (currentChannel) {
            0 -> currentChannel = 4
            4 -> currentChannel = 0
            else -> when (command) {
                "+" -> currentChannel++
                "-" -> currentChannel--

            }
        }
        print("№${currentChannel + 1} - ")
    }


    fun getCurrentChannel() {
        println(channels[currentChannel])
    }

    fun printListOfChannels() {
        channels.forEach { (index, value) -> println("№${index + 1} - $value") }
    }

    companion object {
        const val minVolume = 0
        const val maxVolume = 100
    }
}