package Wariors

import Weapon.AbstractWeapon
import calculateChance

abstract class AbstractWarrior(
    var maxHealth: Int,
    var dodge: Int,
    var accuracy: Int,
    var weapon: AbstractWeapon,
    var currentHealth: Int
) : Warrior {

    override fun toAttack(warrior: Warrior) {
        if (this.weapon.magazine.isEmpty()) {
            this.weapon.fillMagazine(weapon.weaponAmmoName.name)
        } else {
            warrior.takeDamge(
                this.weapon.weaponAmmoName.getDamage(weapon.weaponAmmoName), this.accuracy
            )
        }
    }

    override fun takeDamge(damage: Int, accuracy: Int) {
        if (this.dodge.calculateChance() && accuracy.calculateChance()) {
            this.currentHealth -= damage
        }
        if (this.currentHealth < 0) {
            this.isKilled = true
            this.currentHealth = 0
        }
    }
}

