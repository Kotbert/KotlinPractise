fun main(args: Array<String>) {

    var firstName="Александр"
    var lastName="Сидоренко"
    var height:Double=188.0
    var weight=100.1
    var isChild = height<150||weight<40
    var info="Мое имя $firstName, моя фамилия $lastName, рост $height, вес $weight. Ребенок ли я ${isChild}"
    println(info)
    height =88.0
    isChild = height<150||weight<40
    info="\nМое имя $firstName.\nМоя фамилия $lastName.\nРост $height.\nВес $weight.\nРебенок ли я ${isChild}"
    println(info)
}