package com.example.tictactoedatabyte

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity3 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        var n=0
        var i=0
        var s1=0.0
        var s2=0.0
        var d=0
        val name1 = intent.getStringExtra("name1")
        val avatar1 = intent.getStringExtra("avatar1")
        val name2 = intent.getStringExtra("name2")
        val avatar2 = intent.getStringExtra("avatar2")
        val u1:TextView=findViewById(R.id.u1)
        val u2:TextView=findViewById(R.id.u2)
        val sc1:TextView=findViewById(R.id.sc1)
        val sc2:TextView=findViewById(R.id.sc2)
        val a1:ImageView=findViewById(R.id.a1)
        val a2:ImageView=findViewById(R.id.a2)


        sc1.text=s1.toString()
        sc2.text=s2.toString()
        u1.text=name1
        u2.text=name2
        fun dialog() {
            val dialogBinding1 = layoutInflater.inflate(R.layout.gameover, null)
            val mydialog1 = Dialog(this)
            mydialog1.setContentView(dialogBinding1)
            mydialog1.setCancelable(true)


            val home = dialogBinding1.findViewById<Button>(R.id.home)
            val winner = dialogBinding1.findViewById<TextView>(R.id.winner)
            if (s1 > s2) {
                winner.text = "$name1 is the WINNER"
            } else if (s2 > s1) {
                winner.text = "$name2 is the WINNER"
            } else {
                winner.text = "Its a DRAW"
            }

            home.setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                mydialog1.dismiss()
            }
            mydialog1.show()
        }
        val avr = intArrayOf(R.drawable.p1,R.drawable.p2,R.drawable.p3,R.drawable.p4,R.drawable.p5,R.drawable.p6)
        if (avatar1=="p1") a1.setImageResource(avr[0])
        else if (avatar1=="p2")a1.setImageResource(avr[1])
        else if (avatar1=="p3") a1.setImageResource(avr[2])
        else if (avatar1=="p4") a1.setImageResource(avr[3])
        else if (avatar1=="p5") a1.setImageResource(avr[4])
        else a1.setImageResource(avr[5])

        if (avatar2=="p1") a2.setImageResource(avr[0])
        else if (avatar2=="p2") a2.setImageResource(avr[1])
        else if (avatar2=="p3") a2.setImageResource(avr[2])
        else if (avatar2=="p4") a2.setImageResource(avr[3])
        else if (avatar2=="p5") a2.setImageResource(avr[4])
        else a2.setImageResource(avr[5])

        val btn = mutableListOf<Button>()
        val txt = mutableListOf<TextView>()
        val arrbtn = intArrayOf(R.id.b1,R.id.b2,R.id.b3,R.id.b4,R.id.b5,R.id.b6,R.id.b7,R.id.b8,R.id.b9)
        val arrtxt = intArrayOf(R.id.t1,R.id.t2,R.id.t3,R.id.t4,R.id.t5,R.id.t6,R.id.t7,R.id.t8,R.id.t9)

        val end:Button=findViewById(R.id.end)
        val restart:Button=findViewById(R.id.restart)

        for (j in arrbtn.indices){
            btn.add(j,findViewById(arrbtn[j]))
            txt.add(j,findViewById(arrtxt[j]))
        }
        fun reset(){
            for (k in btn.indices){
                btn[k].isEnabled=true
                txt[k].text=""
            }
            n=0
            d=0
            i=i+1
            sc1.text=s1.toString()
            sc2.text=s2.toString()
        }
        fun check(){
            if((txt[0].text.toString()=="X"&&txt[1].text.toString()=="X"&&txt[2].text.toString()=="X")||(txt[3].text=="X"&&txt[4].text=="X"&&txt[5].text=="X")||(txt[6].text=="X"&&txt[7].text=="X"&&txt[8].text=="X")||(txt[0].text=="X"&&txt[4].text=="X"&&txt[8].text=="X")||(txt[0].text=="X"&&txt[3].text=="X"&&txt[6].text=="X")||(txt[1].text=="X"&&txt[4].text=="X"&&txt[7].text=="X")||(txt[2].text=="X"&&txt[5].text=="X"&&txt[8].text=="X")||(txt[2].text=="X"&&txt[4].text=="X"&&txt[6].text=="X")){
                if(i%2==0){
                    s1=s1+1
                    Toast.makeText(this@MainActivity3,"$name1 WON ", Toast.LENGTH_SHORT).show()
                }
                else {
                    s2=s2+1
                    Toast.makeText(this@MainActivity3,"$name2 WON", Toast.LENGTH_SHORT).show()
                }
                d=1
                n=9
                reset()
            }
            else if((txt[0].text.toString()=="O"&&txt[1].text.toString()=="O"&&txt[2].text.toString()=="O")||(txt[3].text=="O"&&txt[4].text=="O"&&txt[5].text=="O")||(txt[6].text=="O"&&txt[7].text=="O"&&txt[8].text=="O")||(txt[0].text=="O"&&txt[4].text=="O"&&txt[8].text=="O")||(txt[0].text=="O"&&txt[3].text=="O"&&txt[6].text=="O")||(txt[1].text=="O"&&txt[4].text=="O"&&txt[7].text=="O")||(txt[2].text=="O"&&txt[5].text=="O"&&txt[8].text=="O")||(txt[2].text=="O"&&txt[4].text=="O"&&txt[6].text=="O")){
                if(i%2==0){
                    s2=s2+1
                    Toast.makeText(this@MainActivity3,"$name2 WON", Toast.LENGTH_SHORT).show()
                }
                else {
                    s1=s1+1
                    Toast.makeText(this@MainActivity3,"$name1 WON", Toast.LENGTH_SHORT).show()
                }
                d=1
                n=9
                reset()
            }
            else{
                if(n==9&&d==0){
                    s1=s1+0.5
                    s2=s2+0.5
                    Toast.makeText(this@MainActivity3,"ITS A STALEMATE !! ", Toast.LENGTH_SHORT).show()
                    reset()
                }
            }}
        if(n<9){
            for(l in txt.indices){
                btn[l].setOnClickListener{
                    if(n%2==0){
                        txt[l].text="X"
                    }
                    else{
                        txt[l].text="O"
                    }
                    n=n+1
                    btn[l].isEnabled=false
                    check()
                }
            }
        }
        restart.setOnClickListener{
            s1=0.0
            s2=0.0
            reset()
        }
        end.setOnClickListener{
            dialog()
        }
    }
}
