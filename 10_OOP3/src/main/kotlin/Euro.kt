class Euro(var moneyArg: Int) : CurrencyConverter {

    override var currencyCode = Converters.currency[1]

    override fun convertToRub() {
        val money = moneyArg / currencyCode.toInt()
        println("Валюты под номером $currencyCode в рублях: $money")
    }
}