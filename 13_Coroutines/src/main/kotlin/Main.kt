import kotlinx.coroutines.*
import java.math.BigInteger

fun main(): Unit = runBlocking {

    var countOfIteration: Int? = 100000000
    /*while (true) {
        print("Введите число от 1 до бесконечности: ")
        countOfIteration = readLine()?.toIntOrNull()
        if (countOfIteration != null && countOfIteration != 0) break else println("Вы ничего не ввели или ввели 0. Попробуйте еще раз.")
    }*/

    val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)   //отдельный scope

    var job1Result = BigInteger.ONE
    var job2Result = BigInteger.ONE

    launch {
        while (scope.isActive) {
            delay(50)
            print(".")
        }
        println()
        println("Job1 result = $job1Result")
        println("Job2 result = $job2Result")
    }

    val job1 = scope.async {
        currentCoroutineContext().isActive
        Fibonacci.take(countOfIteration!!)
    }

    val job2 = scope.async {
        Fibonacci.take(countOfIteration!!).divide((-1).toBigInteger())
    }

    job1Result = job1.await()
    job2Result = job2.await()
    scope.cancel()
}