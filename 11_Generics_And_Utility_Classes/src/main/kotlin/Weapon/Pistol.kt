package Weapon

import FireAndAmmo.Ammo
import FireAndAmmo.FireType
import FireAndAmmo.Stack

class Pistol() :
    AbstractWeapon(10, Stack(), Ammo.PISTOL, FireType.SinglFire) {

    override fun createAmmo() = Ammo.PISTOL

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