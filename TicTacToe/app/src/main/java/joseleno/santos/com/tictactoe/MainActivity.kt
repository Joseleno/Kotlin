package joseleno.santos.com.tictactoe

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    val p1 = arrayListOf<Int>()
    val p2 = arrayListOf<Int>()
    var currentP = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun jouer(position: Int, btnSelected: Button){
        if (currentP == 1){
            btnSelected.text = "x"
            btnSelected.setBackgroundResource(R.color.colorP1)
            p1.add(position)
            currentP = 2
        }else{
            btnSelected.text = "0"
            btnSelected.setBackgroundResource(R.color.colorP2)
            p2.add(position)
            currentP = 1

        }

        btnSelected.isClickable = false

        testRsult()
    }

    fun btnPosition(v: View) = when(v.id){
        R.id.btn1 -> jouer(1,v as Button)
        R.id.btn2 -> jouer(2,v as Button)
        R.id.btn3 -> jouer(3,v as Button)
        R.id.btn4 -> jouer(4,v as Button)
        R.id.btn5 -> jouer(5,v as Button)
        R.id.btn6 -> jouer(6,v as Button)
        R.id.btn7 -> jouer(7,v as Button)
        R.id.btn8 -> jouer(8,v as Button)
        R.id.btn9 -> jouer(9,v as Button)
        else -> jouer(0,v as Button)
    }

    fun testRsult(){
        val row1 = listOf(1,2,3)
        val row2 = listOf(4,5,6)
        val row3 = listOf(7,8,8)

        val col1 = listOf(1,4,7)
        val col2 = listOf(2,5,8)
        val col3 = listOf(3,6,9)

        val dia1 = listOf(1,5,9)
        val dia2 = listOf(3,5,7)

        var winner = -1

        if(p1.containsAll(row1)||p1.containsAll(row2)||p1.containsAll(row3)||p1.containsAll(col1)||p1.containsAll(col2)||p1.containsAll(col3)||p1.containsAll(dia1)||p1.containsAll(dia2)){
            winner = 1
        }

        if(p2.containsAll(row1)||p2.containsAll(row2)||p2.containsAll(row3)||p2.containsAll(col1)||p2.containsAll(col2)||p2.containsAll(col3)||p2.containsAll(dia1)||p2.containsAll(dia2)){
            winner = 2
        }

        when(winner){
            1-> Toast.makeText(this,"Player 1 win!!!", Toast.LENGTH_LONG).show()
            2-> Toast.makeText(this,"Player 2 win!!!", Toast.LENGTH_LONG).show()
        }

    }

}
