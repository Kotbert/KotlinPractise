import Exception.IncorrectPressure
import Exception.TooHighPressure
import Exception.TooLowPressure

class Wheel {
    private var currentPressure = -1

    fun pumpUpTheWheel(numberOfPressure: Int) {
        currentPressure = numberOfPressure
    }

    fun checkTirePressure() {
        if (currentPressure < 0) throw IncorrectPressure()
        else if (currentPressure > 10) throw TooHighPressure()
        else if (currentPressure < 2) throw TooLowPressure()
        else println("Текущее давление в пределах нормы: $currentPressure")
    }
}