import Wariors.Captain
import Wariors.General
import Wariors.Soldier
import Weapon.MachineGun
import Weapon.Pistol
import Weapon.Rifle
import kotlin.random.Random
import kotlin.random.nextInt

class Team(countInTeam: Int) {

    var listOfTeam = MutableList(countInTeam) { unit ->
        if (20.calculateChance()) {
            General(
                if (20.calculateChance()) {
                    Rifle()
                } else {
                    Pistol()
                }
            )
        } else if (60.calculateChance()) {
            Captain(
                if (20.calculateChance()) {
                    MachineGun()
                } else {
                    Rifle()
                }
            )
        } else {
            Soldier(
                if (10.calculateChance()) {
                    Pistol()
                } else if (60.calculateChance()) {
                    Rifle()
                } else {
                    MachineGun()
                }
            )
        }
    }

    fun getCurrentTeamHeath(): Int {
        var sumOfHealth = 0
        listOfTeam.forEach { abstractWarrior -> sumOfHealth += abstractWarrior.currentHealth }
        return sumOfHealth
    }

    fun stepOfWar() {

        listOfTeam.forEach { abstractWarrior ->
            abstractWarrior.toAttack(listOfTeam[Random.nextInt(0 until listOfTeam.size)])
        }

        listOfTeam.forEach { abstractWarrior ->
            if (abstractWarrior.isKilled == true)
                listOfTeam.remove(abstractWarrior)
        }
    }
}