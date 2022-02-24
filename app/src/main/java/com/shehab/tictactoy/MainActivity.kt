package com.shehab.tictactoy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }
// can you call one or more button in the same function
    //player click
    fun buSelect (view : View){ //view represent click button || view is obj of class View
        var buChoice= view as Button // as"Casting" means convert the view class to Button
        var cellId : Int = 0
        when(buChoice.id){
            R.id.btn1 -> cellId= 1
            R.id.btn2 -> cellId =2
            R.id.btn3 -> cellId = 3
            R.id.btn4 -> cellId =4
            R.id.btn5 -> cellId =5
            R.id.btn6 -> cellId =6
            R.id.btn7 -> cellId =7
            R.id.btn8 -> cellId =8
            R.id.btn9 -> cellId =9
        }
        Log.d("cellId :",cellId.toString()) // show massage

    gamePlayer(cellId,buChoice)



}

    val player1 =ArrayList<Int>() //choice cells by Player
    val player2 =ArrayList<Int>() //choice cells by Player
    var activePlayer =1
    val xPlayer :String= "X"
    val oPlayer :String= "O"

    fun gamePlayer(cellId:Int,buChoice:Button){

        if (activePlayer==1) {
            buChoice.text = xPlayer
            buChoice.setBackgroundResource(R.drawable.change_bg_tn)//change background btn
            player1.add(cellId) //Store selected buttons
            activePlayer = 2//change active player
            autoPlay()
        }else{
            buChoice.text = oPlayer
            buChoice.setBackgroundResource(R.drawable.change_btn_tn2)//change background btn
            player2.add(cellId) //Store selected buttons
            activePlayer = 1//change active player
        }
        buChoice.isEnabled=false
        findWinner()



    }
    fun findWinner( ){
        //row 1
        var winner =-1
        if(player1.contains(1)&&player1.contains(2)&&player1.contains(3))
            winner =1
        if(player2.contains(1)&&player2.contains(2)&&player2.contains(3))
            winner =2
        //row 2
        if(player1.contains(4)&&player1.contains(5)&&player1.contains(6))
            winner =1
        if(player2.contains(4)&&player2.contains(5)&&player2.contains(6))
            winner =2
        //row 3
        if(player1.contains(7)&&player1.contains(8)&&player1.contains(9))
            winner =1
        if(player2.contains(7)&&player2.contains(8)&&player2.contains(9))
            winner =2
        //col 1
        if(player1.contains(1)&&player1.contains(4)&&player1.contains(7))
            winner =1
        if(player2.contains(1)&&player2.contains(4)&&player2.contains(7))
            winner =2
        //col 2
        if(player1.contains(2)&&player1.contains(5)&&player1.contains(8))
            winner =1
        if(player2.contains(2)&&player2.contains(5)&&player2.contains(8))
            winner =2
        if(player1.contains(3)&&player1.contains(6)&&player1.contains(9))
            winner =1
        if(player2.contains(3)&&player2.contains(6)&&player2.contains(9))
            winner =2

        if (winner!=-1){
            if (winner==1){
                Toast.makeText(this,"Player $xPlayer is winner",Toast.LENGTH_LONG).show()
            }else {
                Toast.makeText(this, "Player $oPlayer is winner", Toast.LENGTH_LONG).show()
            }


        }
    }
    fun autoPlay() {
        val emptyCell = ArrayList<Int>()
        for (index in 1..9){
            if (!(player1.contains(index)||player2.contains(index))){
                emptyCell.add(index)
            }
        }
        val rand =Random
        try {
            var randIndex =rand.nextInt(emptyCell.size-0)+1
            val CellID =emptyCell[randIndex]
            var buselect : Button?=null
            when(CellID){
                1-> buselect =btn1
                2-> buselect =btn2
                3-> buselect =btn3
                4-> buselect =btn4
                5-> buselect =btn5
                6-> buselect =btn6
                7-> buselect =btn7
                8-> buselect =btn8
                9-> buselect =btn9
                else ->{
                    buselect =btn1
                }
            }

            gamePlayer(CellID,buselect)

        }catch (ex :Exception){
            Toast.makeText(this, " ",Toast.LENGTH_LONG).show()
        }






    }

}