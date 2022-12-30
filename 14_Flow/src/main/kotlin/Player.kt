import kotlin.random.Random
import kotlin.random.nextInt

class Player(countOfCards: Int) {

    var playerCards: MutableMap<Int, MutableList<MutableMap<Int, Boolean>>> = mutableMapOf()
    var isWin = false

    init {
        for (i in 0 until countOfCards) {
            playerCards[i] = mutableListOf()
            for (y in 0..4) {
                playerCards[i]!!.add(mutableMapOf<Int, Boolean>(Random.nextInt(1..90) to false))
            }
        }
    }

    fun checkNumberForLineWin(number: Int) {
        playerCards.forEach { (_, playerCard) ->
            playerCard.forEach { someLine ->
                if (someLine.values.all { it }){this.isWin=true}
                someLine.forEach { (key, _) ->
                    if (key == number) {
                        someLine[key]=true
                    }
                }
            }
        }
    }

    fun checkNumberForCardWin(number: Int) {
        playerCards.forEach { (_, playerCard) ->
            playerCard.forEach { someLine  ->
                if (someLine.values.all{it}){this.isWin=true}
                someLine.forEach { (key, _) ->
                    if (key == number) {
                        someLine[key]=true
                    }
                }

            }
        }
    }

    fun printSelfCards() {
        playerCards.forEach { (index, value) ->
            print("Карта: ${index + 1} ")
            value.forEach { someLine ->
                someLine.forEach { (indexSecondMap, valueSecondMap) ->
                    when (valueSecondMap) {
                        true -> print("Ячейка: $indexSecondMap - было; ")
                        false -> print("Ячейка: $indexSecondMap - не было; ")
                    }
                }
            }
            println()
        }
    }
}