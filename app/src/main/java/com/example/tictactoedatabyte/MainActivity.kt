package com.example.tictactoedatabyte

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val twoPlayer: Button =findViewById(R.id.button)
        val name: TextView=findViewById(R.id.name2)
        var avatar:String=""
        val picsid = intArrayOf(R.id.p1, R.id.p2,R.id.p3,R.id.p4,R.id.p5,R.id.p6)
        val pics= mutableListOf<ImageView>()
        for(a in picsid.indices){
            pics.add(findViewById(picsid[a]))
        }
        for (b in pics.indices){
            pics[b].setOnClickListener {
                avatar="p"
                avatar+="${b+1}"
                for (c in pics.indices){
                    if(c==b)pics[b].isVisible=false
                    else pics[c].isVisible=true
                }
            }
        }

        twoPlayer.setOnClickListener{
            if(name.text.toString()=="" ){
                Toast.makeText(this@MainActivity,"Enter Username", Toast.LENGTH_SHORT).show()

            }
            else{
                val intent= Intent(this, MainActivity2::class.java)
                intent.putExtra("name1",name.text.toString())
                intent.putExtra("avatar1",avatar)
                startActivity(intent)
            }
        }
        val onePlayer: Button =findViewById(R.id.compplay)
        onePlayer.setOnClickListener{
            if(name.text.toString()=="" ){
                Toast.makeText(this@MainActivity,"Enter Username", Toast.LENGTH_SHORT).show()
            }
            else{
                val intent= Intent(this, MainActivity4::class.java)
                intent.putExtra("name1",name.text.toString())
                intent.putExtra("avatar1",avatar)
                startActivity(intent)
            }
        }
    }
}