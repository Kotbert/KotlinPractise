class Tenge(var moneyArg: Int) : CurrencyConverter {

    override var currencyCode = Converters.currency[2]

    override fun convertToRub() {
        val money = moneyArg / currencyCode.toInt()
        println("Валюты под номером $currencyCode в рублях: $money")
    }

}