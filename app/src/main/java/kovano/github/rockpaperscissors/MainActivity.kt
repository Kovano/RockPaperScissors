package kovano.github.rockpaperscissors

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
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
//        icEmpty.setImageResource(R.drawable.a00_02_05_random)
        rockSnackBar()
        scissorsSnackBar()
        paperSnackBar()

    }

    private fun rockSnackBar() {
        icRock.setOnClickListener(){
            var thisDragonTurn = randomizerDragonTurn()
                icRock.setImageResource(R.drawable.a00_02_01_rockgreen)
            Snackbar.make(it,"Раунд! Камень VS $thisDragonTurn", Snackbar.LENGTH_SHORT).show()
            when (thisDragonTurn){
                "Камень" -> {icEmpty.setImageResource(R.drawable.a00_02_01_rockred)}
                "Ножницы" -> {icEmpty.setImageResource(R.drawable.a00_02_03_scissorsred);dragon.hitPointsDown(); textHPDragon.text = dragon.hitPoints.toString()}
                "Бумага" -> {icEmpty.setImageResource(R.drawable.a00_02_02_paperred);knight.hitPointsDown(); textHPKnight.text = knight.hitPoints.toString()}
                }
            when (dragon.hitPoints){
                0 ->  Snackbar.make(it,"You win", Snackbar.LENGTH_LONG).show()
            }
            when (knight.hitPoints){
                0 ->  Snackbar.make(it,"You lose", Snackbar.LENGTH_LONG).show()
            }
            icEmpty.postDelayed({icEmpty.setImageResource(R.drawable.a00_02_05_random)
                icRock.setImageResource(R.drawable.a00_02_01_rock)},500)
            }

        }

    private fun scissorsSnackBar(){
        icScissors.setOnClickListener(){
            var thisDragonTurn = randomizerDragonTurn()
            icScissors.setImageResource(R.drawable.a00_02_03_scissorsgreen)
            Snackbar.make(it,"Раунд! Ножницы VS $thisDragonTurn", Snackbar.LENGTH_SHORT).show()
            when (thisDragonTurn){
                "Камень" -> {icEmpty.setImageResource(R.drawable.a00_02_01_rockred);knight.hitPointsDown(); textHPKnight.text = knight.hitPoints.toString()}
                "Ножницы" -> {icEmpty.setImageResource(R.drawable.a00_02_03_scissorsred)}
                "Бумага" -> {icEmpty.setImageResource(R.drawable.a00_02_02_paperred); dragon.hitPointsDown(); textHPDragon.text = dragon.hitPoints.toString()}
            }
            when (dragon.hitPoints){
                0 ->  Snackbar.make(it,"You win", Snackbar.LENGTH_LONG).show()
            }
            when (knight.hitPoints){
                0 ->  Snackbar.make(it,"You lose", Snackbar.LENGTH_LONG).show()
            }
            icEmpty.postDelayed({icEmpty.setImageResource(R.drawable.a00_02_05_random)
                icScissors.setImageResource(R.drawable.a00_02_03_scissors)},500)
        }
    }
    private fun paperSnackBar(){
        icPaper.setOnClickListener(){
            var thisDragonTurn = randomizerDragonTurn()
            icPaper.setImageResource(R.drawable.a00_02_02_papergreen)
            Snackbar.make(it,"Раунд! Бумага VS $thisDragonTurn", Snackbar.LENGTH_SHORT).show()
            when (thisDragonTurn){
                "Камень" -> {icEmpty.setImageResource(R.drawable.a00_02_01_rockred);dragon.hitPointsDown(); textHPDragon.text = dragon.hitPoints.toString()}
                "Ножницы" -> {icEmpty.setImageResource(R.drawable.a00_02_03_scissorsred);knight.hitPointsDown(); textHPKnight.text = knight.hitPoints.toString()}
                "Бумага" -> icEmpty.setImageResource(R.drawable.a00_02_02_paperred)
            }
            when (dragon.hitPoints){
                0 ->  Snackbar.make(it,"You win", Snackbar.LENGTH_LONG).show()
            }
            when (knight.hitPoints){
                0 ->  Snackbar.make(it,"You lose", Snackbar.LENGTH_LONG).show()
            }
            icEmpty.postDelayed({icEmpty.setImageResource(R.drawable.a00_02_05_random)
                icPaper.setImageResource(R.drawable.a00_02_02_paper)},500)
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