package kovano.github.rockpaperscissors

open class Person () {
    var id : String? = null
    var name : String? = null
    var hitPoints : Int = 100

    fun hitPointsDown (hitPoints: Int) : Int {
        this.hitPoints -= 10
       return hitPoints
    }
}