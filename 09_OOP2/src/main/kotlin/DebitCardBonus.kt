class DebitCardBonus() : DebitCardBase() {

    private var bonusPoints = 0.0

    override fun topUp(amountOfMoney: Int) {
        if (balance > amountOfMoney) {
            super.pay(amountOfMoney)
            bonusPoints += amountOfMoney * 0.01
            println("Количество бонусов: $bonusPoints")
        }
    }

    override fun getBalanceInformation() {
        println("Средств на счету: $balance, бонусные баллы: $bonusPoints")
    }
}