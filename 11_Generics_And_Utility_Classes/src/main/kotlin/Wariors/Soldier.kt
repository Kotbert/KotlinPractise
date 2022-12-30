package Wariors

import Weapon.AbstractWeapon

class Soldier(weapon: AbstractWeapon) :
    AbstractWarrior(100, 20, 40, weapon, 100) {

    override var isKilled: Boolean = false
    override var dodgeChance: Double = 0.2
}