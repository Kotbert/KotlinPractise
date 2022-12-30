abstract class BankCard() {

    open var balance = 0

    abstract fun topUp(amountOfMoney: Int)
    abstract fun pay(amountOfMoney: Int)

    open fun getInformationAboutAvailableFunds(){}

    open fun getBalanceInformation() {
        println("Средств на счету: $balance")
    }
}