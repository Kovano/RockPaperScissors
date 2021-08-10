package kovano.github.rockpaperscissors

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var knight = Person()
    var dragon = Person()
    private lateinit var dragonTurn : String

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
            var thisDragonTurn = randomizerDragonTurn();
            Snackbar.make(it,"Раунд! Камень VS $thisDragonTurn", Snackbar.LENGTH_SHORT).show()
            dragon.hitPointsDown()
            textHPDragon.text = dragon.hitPoints.toString()
        }
    }
    private fun scissorsSnackBar(){

    }
    private fun paperSnackBar(){

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