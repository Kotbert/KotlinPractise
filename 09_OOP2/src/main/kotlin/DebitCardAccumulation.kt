class DebitCardAccumulation() : DebitCardBase() {

    var bonusAccumulation = 0.0
    override fun topUp(amountOfMoney: Int) {
        super.topUp(amountOfMoney)
        bonusAccumulation += amountOfMoney * 0.005
    }
    override fun getBalanceInformation(){
        println("Средств на счету: $balance, бонусные накопления: $bonusAccumulation")
    }
}