package FireAndAmmo

import calculateChance

enum class Ammo(val damage: Int, val critChance: Int, val critDamage: Int) {
    PISTOL(1, 50, 2),
    RIFLE(5, 10, 2),
    MACHINE_GUN(20, 0, 1);

    fun getDamage(enum: Enum<Ammo>): Int {
        return when (enum) {
            PISTOL -> {
                return if (PISTOL.critChance.calculateChance()) {
                    PISTOL.damage * PISTOL.critDamage
                } else PISTOL.damage
            }

            RIFLE -> {
                return if (RIFLE.critChance.calculateChance()) {
                    RIFLE.damage * RIFLE.critDamage
                } else RIFLE.damage
            }

            MACHINE_GUN -> {
                return if (MACHINE_GUN.critChance.calculateChance()) {
                    MACHINE_GUN.damage * MACHINE_GUN.critDamage
                } else MACHINE_GUN.damage
            }
            else -> {0}
        }
    }
}