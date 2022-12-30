package Weapon

import FireAndAmmo.Ammo
import FireAndAmmo.FireType
import FireAndAmmo.Stack

abstract class AbstractWeapon(
    val maxWeaponMagazine: Int,
    var magazine: Stack<Ammo>,
    val weaponAmmoName: Ammo,
    var fireType: FireType
) {

    var haveAmmo = magazine.isEmpty()

    abstract fun getAmmoForShoot(ammo: Ammo)
    abstract fun fillMagazine(weapon: String)
    abstract fun createAmmo(): Ammo
}