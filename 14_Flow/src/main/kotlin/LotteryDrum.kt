import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.Flow
import kotlin.random.Random
import kotlin.random.nextInt

object LotteryDrum {

    private val listTemplate = (1..90)
    val listOfLotteryDrum = listTemplate.toMutableList()

    fun removeLotteryNumber(number: Int) = listOfLotteryDrum.remove(number)

    fun rollLotteryDrumAsFlow(): Flow<Int> {
        return {listOfLotteryDrum[Random.nextInt(0 until listOfLotteryDrum.size)]}.asFlow()
    }
}