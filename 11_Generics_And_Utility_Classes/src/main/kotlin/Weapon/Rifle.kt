package Weapon

import FireAndAmmo.Ammo
import FireAndAmmo.FireType
import FireAndAmmo.Stack

class Rifle() :
    AbstractWeapon(25, Stack(), Ammo.RIFLE, FireType.AutoFire(Ammo.RIFLE)) {

    override fun createAmmo() = Ammo.RIFLE

    override fun fillMagazine(weapon: String) {
        for (i in 0 until maxWeaponMagazine) {
            magazine.push(createAmmo())
        }
    }

    override fun getAmmoForShoot(ammo: Ammo) {
        if (!magazine.isEmpty()) {
            magazine.pop()
        } else haveAmmo = haveAmmo.not()
    }
}