package FireAndAmmo

sealed class FireType {

    data class AutoFire(var ammo: Ammo) : FireType()
    object SinglFire : FireType()
}


