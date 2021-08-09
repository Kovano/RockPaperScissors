package kovano.github.rockpaperscissors

import android.content.pm.ActivityInfo
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
            dragonTurn = randomiserDragonTurn();
            Snackbar.make(it,"Раунд! Камень VS $dragonTurn", Snackbar.LENGTH_SHORT).show()
            dragon.hitPointsDown()
            println(dragon.hitPoints)
            textHPDragon.text = dragon.hitPoints.toString()
        }
    }
    private fun scissorsSnackBar(){

    }
    private fun paperSnackBar(){

    }

    private fun randomiserDragonTurn():String {
        var dragonTurn2 : String =  "Камень"
        return dragonTurn2
    }
}