import kotlinx.coroutines.*

suspend fun main() {

    var countOfCards: Int?

    while (true) {
        print("Введите число игральных карт: ")
        countOfCards = readLine()?.toIntOrNull()
        if (countOfCards != null && countOfCards != 0) break else println("Вы ничего не ввели или ввели 0. Попробуйте еще раз.")
    }

    var someNumber = 0

    val player1 = Player(countOfCards!!)
    val player2 = Player(countOfCards)
    val player3 = Player(countOfCards)


    //Игра на всю линию
    CoroutineScope(Dispatchers.Default + SupervisorJob()).launch {

        for (i in 0 until 90) {
            LotteryDrum.rollLotteryDrumAsFlow().collect { someNumber = it }
            LotteryDrum.removeLotteryNumber(someNumber)
            delay(10)
            print("$someNumber ")

            val job1 = async { player1.checkNumberForLineWin(someNumber) }
            val job2 = async { player2.checkNumberForLineWin(someNumber) }
            val job3 = async { player3.checkNumberForLineWin(someNumber) }

            if (player1.isWin || player2.isWin || player3.isWin) {
                if (player1.isWin) {
                    println("Победил игрок 1")
                } else if (player2.isWin) {
                    println("Победил игрок 2")
                } else if (player3.isWin) {
                    println("Победил игрок 3")
                }
                break
            }

            job1.await()
            job2.await()
            job3.await()
        }




    }.join()

    //Игра на всю карту
    CoroutineScope(Dispatchers.Default + SupervisorJob()).launch {

        for (i in 0 until 90) {
            LotteryDrum.rollLotteryDrumAsFlow().collect { someNumber = it }
            LotteryDrum.removeLotteryNumber(someNumber)
            delay(10)
            print("$someNumber ")

            val job1 = async { player1.checkNumberForCardWin(someNumber) }
            val job2 = async { player2.checkNumberForCardWin(someNumber) }
            val job3 = async { player3.checkNumberForCardWin(someNumber) }

            if (player1.isWin || player2.isWin || player3.isWin) {
                if (player1.isWin) {
                    println("Победил игрок 1")
                } else if (player2.isWin) {
                    println("Победил игрок 2")
                } else if (player3.isWin) {
                    println("Победил игрок 3")
                }
                break
            }

            job1.await()
            job2.await()
            job3.await()
        }




    }.join()


    println("\nИгрок 1")
    player1.printSelfCards()

    println("\nИгрок 2")
    player2.printSelfCards()

    println("\nИгрок 3")
    player3.printSelfCards()

    println()
    println(LotteryDrum.listOfLotteryDrum)

}