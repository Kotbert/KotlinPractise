package Weapon

import FireAndAmmo.Ammo
import FireAndAmmo.FireType
import FireAndAmmo.Stack

class MachineGun() :
    AbstractWeapon(50, Stack(), Ammo.MACHINE_GUN, FireType.AutoFire(Ammo.MACHINE_GUN)) {

    override fun createAmmo() = Ammo.MACHINE_GUN

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