object Channels {
    var listOfChannels = arrayListOf("REN","НТВ","Россия 24","National Geographic", "Discovery")
    fun getRandomChannels(): MutableMap<Int, String> {
        listOfChannels = listOfChannels.shuffled() as ArrayList<String>
        var variableOfShuffledChannels= mutableMapOf<Int,String>()
        for (i in 0 until listOfChannels.size){
            variableOfShuffledChannels.put(i,listOfChannels[i])

        }
        return variableOfShuffledChannels
    }
}