import kotlin.random.Random

fun Int.calculateChance(): Boolean {
    val result = Random.nextInt(0, 101)
    return result <= this
}

fun main() {

    var team1 = Team(10)
    var team2 = Team(10)

    println("Здоровье первой команды: ${team1.getCurrentTeamHeath()}")
    println("Здоровье второй команды: ${team2.getCurrentTeamHeath()}")

    team1.stepOfWar()
    team2.stepOfWar()

    println("Здоровье первой команды: ${team1.getCurrentTeamHeath()}")
    println("Здоровье второй команды: ${team2.getCurrentTeamHeath()}")


    for (i in 0..100) {
        team1.stepOfWar()
        team2.stepOfWar()
        println("Здоровье первой команды: ${team1.getCurrentTeamHeath()}")
        println("Здоровье второй команды: ${team2.getCurrentTeamHeath()}")
    }

    println("Здоровье первой команды: ${team1.getCurrentTeamHeath()}")
    println("Здоровье второй команды: ${team2.getCurrentTeamHeath()}")
}