package com.example.tictactoedatabyte

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val start: Button =findViewById(R.id.button)
        val name: TextView=findViewById(R.id.name2)
        var avatar:String=""
        val p1: ImageView =findViewById(R.id.p1)
        val p2: ImageView =findViewById(R.id.p2)
        val p3: ImageView =findViewById(R.id.p3)
        val p4: ImageView =findViewById(R.id.p4)
        val p5: ImageView =findViewById(R.id.p5)
        val p6: ImageView =findViewById(R.id.p6)

        p1.setOnClickListener{
            avatar="p1"
            p1.isVisible=false
            p2.isVisible=true
            p3.isVisible=true
            p4.isVisible=true
            p5.isVisible=true
            p6.isVisible=true
        }
        p2.setOnClickListener{
            avatar="p2"
            p2.isVisible=false
            p1.isVisible=true
            p3.isVisible=true
            p4.isVisible=true
            p5.isVisible=true
            p6.isVisible=true
        }
        p3.setOnClickListener{
            avatar="p3"
            p3.isVisible=false
            p1.isVisible=true
            p2.isVisible=true
            p4.isVisible=true
            p5.isVisible=true
            p6.isVisible=true

        }
        p4.setOnClickListener{
            avatar="p4"
            p4.isVisible=false
            p1.isVisible=true
            p2.isVisible=true
            p3.isVisible=true
            p5.isVisible=true
            p6.isVisible=true
        }
        p5.setOnClickListener{
            avatar="p5"
            p5.isVisible=false
            p1.isVisible=true
            p2.isVisible=true
            p3.isVisible=true
            p4.isVisible=true
            p6.isVisible=true
        }
        p6.setOnClickListener{
            avatar="p6"
            p6.isVisible=false
            p1.isVisible=true
            p2.isVisible=true
            p3.isVisible=true
            p4.isVisible=true
            p5.isVisible=true
        }






        start.setOnClickListener{
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
    }
}