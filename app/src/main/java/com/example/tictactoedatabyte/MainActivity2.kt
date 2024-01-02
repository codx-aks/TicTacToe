package com.example.tictactoedatabyte

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val name1 = intent.getStringExtra("name1")
        val avatar1 = intent.getStringExtra("avatar1")
        val start: Button =findViewById(R.id.button)
        val name2: TextView =findViewById(R.id.name2)
        var avatar2:String = ""
        val picsid = intArrayOf(R.id.p1, R.id.p2,R.id.p3,R.id.p4,R.id.p5,R.id.p6)
        val pics= mutableListOf<ImageView>()
        for(a in picsid.indices){
            pics.add(findViewById(picsid[a]))
        }
        for (b in pics.indices){
            pics[b].setOnClickListener {
                avatar2="p"
                avatar2+="${b+1}"
                for (c in pics.indices){
                    if(c==b)pics[b].isVisible=false
                    else pics[c].isVisible=true
                }
            }
        }
        start.setOnClickListener{
            if(name2.text.toString()==""){
                Toast.makeText(this@MainActivity2,"Enter Username and No of Games", Toast.LENGTH_SHORT).show()
            }
            else{
                val intent= Intent(this, MainActivity3::class.java)
                intent.putExtra("name2",name2.text.toString())
                intent.putExtra("avatar2",avatar2)
                intent.putExtra("name1",name1)
                intent.putExtra("avatar1",avatar1)
                startActivity(intent)
            }
    }}}
