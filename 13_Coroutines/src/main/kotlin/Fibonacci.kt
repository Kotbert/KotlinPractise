import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.withTimeout
import java.math.BigInteger

object Fibonacci {

    private fun Int.toBigInteger(): BigInteger = BigInteger.valueOf(toLong())

    suspend fun take(amountOfIteration: Int): BigInteger {

        var result = 0.toBigInteger()

        try {
            withTimeout(2000L) {

                when (amountOfIteration) {
                    1 -> {
                        result = 0.toBigInteger()
                        return@withTimeout result
                    }

                    2 -> {
                        result = 1.toBigInteger()
                        return@withTimeout result
                    }

                    3 -> {
                        result = 2.toBigInteger()
                        return@withTimeout result
                    }

                    else -> {
                        var firsNumber = 0
                        var secondNumber = 1
                        result = result.plus(secondNumber.toBigInteger())
                        for (i in 0..amountOfIteration - 3) {
                            val thirdNumber = firsNumber + secondNumber
                            firsNumber = secondNumber
                            secondNumber = thirdNumber
                            result = result.plus(thirdNumber.toBigInteger())

                        }
                        return@withTimeout result
                    }
                }
            }
        } catch (Exeption: TimeoutCancellationException){
            println("Время вышло")
        }

        return result
    }
}