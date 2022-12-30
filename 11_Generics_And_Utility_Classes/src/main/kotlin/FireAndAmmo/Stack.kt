package FireAndAmmo

class Stack<T> {

    var listOfAnyObject: ArrayList<T> = ArrayList()

    fun push(item: T) {
        listOfAnyObject.add(item)
    }

    fun pop(): T? {
        val returnObject = listOfAnyObject.lastOrNull()
        listOfAnyObject.removeAt(listOfAnyObject.lastIndex)
        return returnObject
    }


    fun isEmpty(): Boolean {
        return listOfAnyObject.isEmpty()
    }
}