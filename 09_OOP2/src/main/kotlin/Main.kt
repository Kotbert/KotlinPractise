fun main() {

    var card1 = DebitCardBase()
    var card2 = CreditCardBase()
    var card3 = DebitCardBonus()
    var card4 = DebitCardCashback()
    var card5 = DebitCardAccumulation()


    card1.balance
    card1.pay(100)
    card1.topUp(1000)
    card1.balance
    card1.pay(100)
    card1.getBalanceInformation()

    println()

    card2.currentCredit
    card2.currentCreditLimit()
    card2.currentCredit
    card2.topUp(5000)
    card2.pay(6000)
    card2.getInformationAboutAvailableFunds()

    println()

    card3.topUp(9000)
    card3.getBalanceInformation()

    println()


    card4.pay(5000)
    card4.getBalanceInformation()

    println()

    card5.topUp(50000)
    card5.getBalanceInformation()


}