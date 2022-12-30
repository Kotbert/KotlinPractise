package Wariors

import Weapon.AbstractWeapon

class Captain(weapon: AbstractWeapon) :
    AbstractWarrior(150, 40, 70, weapon, 150) {

    override var isKilled: Boolean = false
    override var dodgeChance: Double = 0.4
}
