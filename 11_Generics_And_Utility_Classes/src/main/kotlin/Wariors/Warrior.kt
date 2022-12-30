package Wariors

interface Warrior {
    var isKilled: Boolean
    var dodgeChance: Double

    fun toAttack(warrior: Warrior)
    fun takeDamge(damage: Int, accuracy: Int)
}