package kovano.github.rockpaperscissors

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var knight = Person()
    var dragon = Person()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//todo: второй вариант портретной ориентации активити
// (первый в манифесте)
// requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        rockSnackBar()
        scissorsSnackBar()
        paperSnackBar()

    }

    private fun rockSnackBar() {
        icRock.setOnClickListener(){
            var thisDragonTurn = randomizerDragonTurn()
            Snackbar.make(it,"Раунд! Камень VS $thisDragonTurn", Snackbar.LENGTH_SHORT).show()
            when (thisDragonTurn){
//                "Камень" -> do nothing
                "Ножницы" -> {dragon.hitPointsDown(); textHPDragon.text = dragon.hitPoints.toString()}
                "Бумага" -> {knight.hitPointsDown(); textHPKnight.text = knight.hitPoints.toString()}
                }
            when (dragon.hitPoints){
                0 ->  Snackbar.make(it,"You win", Snackbar.LENGTH_LONG).show()
            }
            when (knight.hitPoints){
                0 ->  Snackbar.make(it,"You lose", Snackbar.LENGTH_LONG).show()
            }
            }
        }

    private fun scissorsSnackBar(){
        icScissors.setOnClickListener(){
            var thisDragonTurn = randomizerDragonTurn()
            Snackbar.make(it,"Раунд! Ножницы VS $thisDragonTurn", Snackbar.LENGTH_SHORT).show()
            when (thisDragonTurn){
                "Камень" -> {knight.hitPointsDown(); textHPKnight.text = knight.hitPoints.toString()}
//                "Ножницы" ->
                "Бумага" -> {dragon.hitPointsDown(); textHPDragon.text = dragon.hitPoints.toString()}
            }
            when (dragon.hitPoints){
                0 ->  Snackbar.make(it,"You win", Snackbar.LENGTH_LONG).show()
            }
            when (knight.hitPoints){
                0 ->  Snackbar.make(it,"You lose", Snackbar.LENGTH_LONG).show()
            }
        }
    }
    private fun paperSnackBar(){
        icPaper.setOnClickListener(){
            var thisDragonTurn = randomizerDragonTurn()
            Snackbar.make(it,"Раунд! Бумага VS $thisDragonTurn", Snackbar.LENGTH_SHORT).show()
            when (thisDragonTurn){
                "Камень" -> {dragon.hitPointsDown(); textHPDragon.text = dragon.hitPoints.toString()}
                "Ножницы" -> {knight.hitPointsDown(); textHPKnight.text = knight.hitPoints.toString()}
//                "Бумага" ->
            }
            when (dragon.hitPoints){
                0 ->  Snackbar.make(it,"You win", Snackbar.LENGTH_LONG).show()
            }
            when (knight.hitPoints){
                0 ->  Snackbar.make(it,"You lose", Snackbar.LENGTH_LONG).show()
            }
        }
    }

    private fun randomizerDragonTurn():String {

        var dragonTurnInt : Int = (0..4).random()
        var dragonTurn : String =  "Камень"
        when (dragonTurnInt){
            1 -> dragonTurn = "Камень"
            2 -> dragonTurn = "Ножницы"
            3 -> dragonTurn = "Бумага"
        }
        return dragonTurn
    }
}