open class DebitCardBase() : BankCard() {

    override var balance: Int = 0
    override fun topUp(amountOfMoney: Int) {
        balance += amountOfMoney
        println("Баланс дебетовой карты состовляет: $balance")
    }

    override fun pay(amountOfMoney: Int) {
        while (true) {
            if ( balance == 0) {
                println("Ваши средства равняются 0")
                break
            } else if (amountOfMoney > balance) {
                println("Недостаточно средств на счете")
                println("Введите меньшее значение")
            } else {
                balance -= amountOfMoney
                println("Счет после операции: $balance")
                break
            }
        }
    }
}