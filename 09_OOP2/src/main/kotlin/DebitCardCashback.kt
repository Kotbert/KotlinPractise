class DebitCardCashback() : DebitCardBase() {

    var cashback = 0.0
    override var balance = 10000
    override fun pay(amountOfMoney: Int) {
        super.pay(amountOfMoney)
        if (amountOfMoney >= 5000) {
            cashback += amountOfMoney * 0.01
            println("Количество бонусов: $cashback")
        }
    }

    override fun getBalanceInformation(){
        println("Средств на счету: $balance, бонусный кэшбэк: $cashback")
    }
}