class CreditCardBase() : BankCard() {

    private var creditLimit = 10000
    var currentCredit = 0
    override var balance: Int = 0

    fun currentBank() {
        println("Текущий кредит: $currentCredit\nТекущий счет $balance")
    }

    override fun topUp(amountOfMoney: Int) {
        currentCredit -= amountOfMoney
        if (currentCredit < 0) {
            balance += currentCredit * (-1)
            currentCredit = 0
            currentBank()
        } else {
            currentCredit += amountOfMoney
            currentBank()
        }

    }

    override fun pay(amountOfMoney: Int) {
        if (currentCredit == creditLimit) {
            println("Вы достигли максимального кредитного лимита \nПроизведите выплаты в размере $currentCredit")
        } else if (currentCredit + amountOfMoney > creditLimit) {
            println("Недостаточно средств на счете")
            println("Введите меньшее значение")
        } else {
            if (balance > 0) {
                balance -= amountOfMoney
                if (balance < 0) {
                    currentCredit += balance * (-1)
                    balance = 0
                }
            }
            currentBank()
        }

    }

    fun currentCreditLimit() {
        println("Текущий кредитный лимит состовляет: $creditLimit")
    }

    override fun getInformationAboutAvailableFunds() {
        println("Доступные операции: \"Баланс и текущий кредит\", \"Снять средства\", \"Пополнить средства\"")
    }
}