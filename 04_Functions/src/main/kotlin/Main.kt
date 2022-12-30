fun main() {

    var decryptedMessage: String?
    var encryptedMessage: String?

    //Шифровка\\
    fun encryptLeft(word: String): String {
        println(word)
        var left = word.removeRange(word.length / 2, word.length)
        left.replace("0", "o")
        left = left.map { char -> char - 3 }.joinToString("")
        left.replace("4", "u")
        left.replace("5", "s")
        left = left.map { char -> char + 1 }.joinToString("")
        return left

    }

    fun encryptRight(word: String): String {
        println(word)
        var right = word.removeRange(0, word.length / 2)
        right.replace(" ", "_")
        right = right.map { char -> char - 4 }.joinToString("")
        right.reversed()
        return right
    }

    fun encrypt(word: String?) {
        if (word != null) {
            decryptedMessage = word.reversed()
            println("Зашифрованное сообщение: ${encryptLeft(decryptedMessage!!)}${encryptRight(decryptedMessage!!)}")
        }
    }
    //Шифровка\\

    //Дешивфровка\\
    fun decryptLeft(word: String): String {
        println(word)
        var left = word.removeRange((word.length) / 2, word.length)
        left = left.map { char -> char - 1 }.joinToString("")
        left.replace("s", "5")
        left.replace("u", "4")
        left = left.map { char -> char + 3 }.joinToString("")
        left.replace("o", "0")
        return left
    }
    fun decryptRight(word:String):String{
        println(word)
        var right = word.removeRange(0, (word.length) / 2)
        right.replace("_", " ")
        right = right.map { char -> char + 4 }.joinToString("")
        right.reversed()
        return right
    }

    fun decrypt(word: String?) {
        if (word != null) {
            encryptedMessage = word.reversed()
            encryptedMessage = decryptLeft(word) + decryptRight(word)
            encryptedMessage = encryptedMessage!!.reversed()
            println("Расшифрованное сообщеие: $encryptedMessage")
        }
    }
    //Дешифровка\\

    print("Введите обычное сообщение или нажмите Enter для продолжения: ")
    decryptedMessage = readLine()
    if (decryptedMessage != "") {
        encrypt(decryptedMessage)
    } else {
        print("Введите зашифрованное сообщение: ")
        encryptedMessage = readLine()
        decrypt(encryptedMessage)
    }
}