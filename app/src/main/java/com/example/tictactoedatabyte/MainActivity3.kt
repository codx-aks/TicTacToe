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
        var name1 = intent.getStringExtra("name1")
        var avatar1 = intent.getStringExtra("avatar1")
        var name2 = intent.getStringExtra("name2")
        var avatar2 = intent.getStringExtra("avatar2")
        var u1:TextView=findViewById(R.id.u1)
        var u2:TextView=findViewById(R.id.u2)
        var sc1:TextView=findViewById(R.id.sc1)
        var sc2:TextView=findViewById(R.id.sc2)
        var a1:ImageView=findViewById(R.id.a1)
        var a2:ImageView=findViewById(R.id.a2)



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
            var winner=dialogBinding1.findViewById<TextView>(R.id.winner)
            if(s1>s2){
                winner.text="$name1 is the WINNER"
            }
            else if(s2>s1){
                winner.text="$name2 is the WINNER"
            }
            else{
                winner.text="Its a DRAW"
            }

            home.setOnClickListener {
                val intent= Intent(this, MainActivity::class.java)
                startActivity(intent)
                mydialog1.dismiss()
            }
            mydialog1.show()
        }
        if (avatar1=="p1"){
            a1.setImageResource(R.drawable.p1)
        }
        if (avatar1=="p2"){
            a1.setImageResource(R.drawable.p2)
        }
        if (avatar1=="p3"){
            a1.setImageResource(R.drawable.p3)
        }
        if (avatar1=="p4"){
            a1.setImageResource(R.drawable.p4)
        }
        if (avatar1=="p5"){
            a1.setImageResource(R.drawable.p5)
        }
        if (avatar1=="p6"){
            a1.setImageResource(R.drawable.p6)
        }
        if (avatar2=="p1"){
            a2.setImageResource(R.drawable.p1)
        }
        if (avatar2=="p2"){
            a2.setImageResource(R.drawable.p2)
        }
        if (avatar2=="p3"){
            a2.setImageResource(R.drawable.p3)
        }
        if (avatar2=="p4"){
            a2.setImageResource(R.drawable.p4)
        }
        if (avatar2=="p5"){
            a2.setImageResource(R.drawable.p5)
        }
        if (avatar2=="p6"){
            a2.setImageResource(R.drawable.p6)
        }



        var end:Button=findViewById(R.id.end)
        var restart:Button=findViewById(R.id.restart)
        var b1:Button=findViewById(R.id.b1)
        var b2:Button=findViewById(R.id.b2)
        var b3:Button=findViewById(R.id.b3)
        var b4:Button=findViewById(R.id.b4)
        var b5:Button=findViewById(R.id.b5)
        var b6:Button=findViewById(R.id.b6)
        var b7:Button=findViewById(R.id.b7)
        var b8:Button=findViewById(R.id.b8)
        var b9:Button=findViewById(R.id.b9)
        var t1:TextView=findViewById(R.id.t1)
        var t2:TextView=findViewById(R.id.t2)
        var t3:TextView=findViewById(R.id.t3)
        var t4:TextView=findViewById(R.id.t4)
        var t5:TextView=findViewById(R.id.t5)
        var t6:TextView=findViewById(R.id.t6)
        var t7:TextView=findViewById(R.id.t7)
        var t8:TextView=findViewById(R.id.t8)
        var t9:TextView=findViewById(R.id.t9)
        fun reset(){
            t1.text=""
            t2.text=""
            t3.text=""
            t4.text=""
            t5.text=""
            t6.text=""
            t7.text=""
            t8.text=""
            t9.text=""
            b1.isEnabled=true
            b2.isEnabled=true
            b3.isEnabled=true
            b4.isEnabled=true
            b5.isEnabled=true
            b6.isEnabled=true
            b7.isEnabled=true
            b8.isEnabled=true
            b9.isEnabled=true
            n=0
            d=0
            i=i+1
            sc1.text=s1.toString()
            sc2.text=s2.toString()
        }
    fun check(){
        if((t1.text.toString()=="X"&&t2.text.toString()=="X"&&t3.text.toString()=="X")||(t4.text=="X"&&t5.text=="X"&&t6.text=="X")||(t7.text=="X"&&t8.text=="X"&&t9.text=="X")||(t1.text=="X"&&t5.text=="X"&&t9.text=="X")||(t1.text=="X"&&t4.text=="X"&&t7.text=="X")||(t2.text=="X"&&t5.text=="X"&&t8.text=="X")||(t3.text=="X"&&t6.text=="X"&&t9.text=="X")||(t3.text=="X"&&t5.text=="X"&&t7.text=="X")){
            if(i%2==0){
                s1=s1+1
                d=1
                n=9
                Toast.makeText(this@MainActivity3,"$name1 WON ", Toast.LENGTH_SHORT).show()

            }
            else {
                d=1
                n=9
                s2=s2+1
                Toast.makeText(this@MainActivity3,"$name2 WON", Toast.LENGTH_SHORT).show()

            }
            reset()
        }
        else if((t1.text=="O"&&t2.text=="O"&&t3.text=="O")||(t4.text=="O"&&t5.text=="O"&&t6.text=="O")||(t7.text=="O"&&t8.text=="O"&&t9.text=="O")||(t1.text=="O"&&t5.text=="O"&&t9.text=="O")||(t1.text=="O"&&t4.text=="O"&&t7.text=="O")||(t2.text=="O"&&t5.text=="O"&&t8.text=="O")||(t3.text=="O"&&t6.text=="O"&&t9.text=="O")||(t3.text=="O"&&t5.text=="O"&&t7.text=="O")){
            if(i%2==0){
                s2=s2+1
                d=1
                n=9
                Toast.makeText(this@MainActivity3,"$name2 WON", Toast.LENGTH_SHORT).show()
            }
            else {
                d=1
                s1=s1+1
                n=9
                Toast.makeText(this@MainActivity3,"$name1 WON", Toast.LENGTH_SHORT).show()
            }
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

                b1.setOnClickListener{
                    if(n%2==0){
                        t1.text="X"
                    }
                    else{
                        t1.text="O"
                    }
                    n=n+1
                    b1.isEnabled=false
                    check()
                }
                b2.setOnClickListener{
                    if(n%2==0){
                        t2.text="X"
                    }
                    else{
                        t2.text="O"
                    }
                    n=n+1
                    b2.isEnabled=false
                    check()
                }
                b3.setOnClickListener{
                    if(n%2==0){
                        t3.text="X"
                    }
                    else{
                        t3.text="O"
                    }
                    n=n+1
                    b3.isEnabled=false
                    check()
                }
                b4.setOnClickListener{
                    if(n%2==0){
                        t4.text="X"
                    }
                    else{
                        t4.text="O"
                    }
                    n=n+1
                    b4.isEnabled=false
                    check()
                }
                b5.setOnClickListener{
                    if(n%2==0){
                        t5.text="X"
                    }
                    else{
                        t5.text="O"
                    }
                    n=n+1
                    b5.isEnabled=false
                    check()
                }
                b6.setOnClickListener{
                    if(n%2==0){
                        t6.text="X"
                    }
                    else{
                        t6.text="O"
                    }
                    n=n+1
                    b6.isEnabled=false
                    check()
                }
                b7.setOnClickListener{
                    if(n%2==0){
                        t7.text="X"
                    }
                    else{
                        t7.text="O"
                    }
                    n=n+1
                    b7.isEnabled=false
                    check()
                }
                b8.setOnClickListener{
                    if(n%2==0){
                        t8.text="X"
                    }
                    else{
                        t8.text="O"
                    }
                    n=n+1
                    b8.isEnabled=false
                    check()
                }
                b9.setOnClickListener{
                    if(n%2==0){
                        t9.text="X"
                    }
                    else{
                        t9.text="O"
                    }
                    n=n+1
                    b9.isEnabled=false
                    check()
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
