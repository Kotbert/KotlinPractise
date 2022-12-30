package Weapon

object Weapons {

    fun createPistol(): Pistol {
        return Pistol()
    }

    fun createRifle(): Rifle {
        return Rifle()
    }

    fun createMachineGun(): MachineGun {
        return MachineGun()
    }
}