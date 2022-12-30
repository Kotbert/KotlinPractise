object Converters {

    val currency = listOf("1", "2", "3")

    fun get(currencyCode: String, amountOfCurrency: Int): Any {
        return when (currencyCode) {
            "1" -> Dollar(amountOfCurrency).convertToRub()
            "2" -> Euro(amountOfCurrency).convertToRub()
            "3" -> Tenge(amountOfCurrency).convertToRub()
            else -> object : CurrencyConverter {
                override var currencyCode: String = "0"
                override fun convertToRub() {
                    val money = amountOfCurrency / currencyCode.toInt()
                    println("Неизвестной валюты под номером $currencyCode в рублях: $money")
                }
            }
        }
    }
}