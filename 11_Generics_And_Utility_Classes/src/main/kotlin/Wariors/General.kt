package Wariors

import Weapon.AbstractWeapon

class General(weapon: AbstractWeapon) :
    AbstractWarrior(200, 80, 100, weapon, 200) {

    override var isKilled: Boolean = false
    override var dodgeChance: Double = 0.8
}