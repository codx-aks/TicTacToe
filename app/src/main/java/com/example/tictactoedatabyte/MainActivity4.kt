package com.example.tictactoedatabyte

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast


class MainActivity4 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    private var i=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        var n=0

        var s1=0.0
        var s2=0.0
        var d=0
        val name1 = intent.getStringExtra("name1")
        val avatar1 = intent.getStringExtra("avatar1")
        val name2 = "AI"
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
            val winner=dialogBinding1.findViewById<TextView>(R.id.winner)
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


        val avr = intArrayOf(R.drawable.p1,R.drawable.p2,R.drawable.p3,R.drawable.p4,R.drawable.p5,R.drawable.p6)
        if (avatar1=="p1") a1.setImageResource(avr[0])
        else if (avatar1=="p2")a1.setImageResource(avr[1])
        else if (avatar1=="p3") a1.setImageResource(avr[2])
        else if (avatar1=="p4") a1.setImageResource(avr[3])
        else if (avatar1=="p5") a1.setImageResource(avr[4])
        else a1.setImageResource(avr[5])
        a2.setImageResource(R.drawable.aidp)

        val btn = mutableListOf<Button>()
        val txt = mutableListOf<TextView>()
        val arrbtn = intArrayOf(R.id.b1,R.id.b2,R.id.b3,R.id.b4,R.id.b5,R.id.b6,R.id.b7,R.id.b8,R.id.b9)
        val arrtxt = intArrayOf(R.id.t1,R.id.t2,R.id.t3,R.id.t4,R.id.t5,R.id.t6,R.id.t7,R.id.t8,R.id.t9)

        val end:Button=findViewById(R.id.end)
        val restart:Button=findViewById(R.id.restart)

        var board: Array<Array<Char>> = Array(3) { Array(3) { ' ' } }

        for (j in arrbtn.indices){
            btn.add(j,findViewById(arrbtn[j]))
            txt.add(j,findViewById(arrtxt[j]))
        }











        fun evaluate(board: Array<Array<Char>>): Int? {
            for (row in board) {
                if (row.all { it == 'X' }) return 1
                else if (row.all { it == 'O' }) return -1
            }

            for (col in 0 until 3) {
                if ((0 until 3).all { row -> board[row][col] == 'X' }) return 1
                else if ((0 until 3).all { row -> board[row][col] == 'O' }) return -1
            }

            if ((0 until 3).all { i -> board[i][i] == 'X' } || (0 until 3).all { i -> board[i][2 - i] == 'X' }) return 1
            else if ((0 until 3).all { i -> board[i][i] == 'O' } || (0 until 3).all { i -> board[i][2 - i] == 'O' }) return -1

            if (board.all { row -> row.all { cell -> cell != ' ' } }) return 0

            return null
        }

        fun minimax(board: Array<Array<Char>>, depth: Int, isMaximizing: Boolean, a: Int, b: Int): Int {
            val result = evaluate(board)
            if (result != null) {
                return result
            }

            var alpha = a
            var beta = b

            if (isMaximizing) {
                var maxEval = Int.MIN_VALUE
                for (x in 0 until 3) {
                    for (y in 0 until 3) {
                        if (board[x][y] == ' ') {
                            board[x][y] = 'X'
                            val evalScore = minimax(board, depth + 1, false, alpha, beta)
                            board[x][y] = ' '
                            maxEval = maxOf(maxEval, evalScore)
                            alpha = maxOf(alpha, evalScore)
                            if (beta <= alpha) {
                                break
                            }
                        }
                    }
                }
                return maxEval
            } else {
                var minEval = Int.MAX_VALUE
                for (x in 0 until 3) {
                    for (y in 0 until 3) {
                        if (board[x][y] == ' ') {
                            board[x][y] = 'O'
                            val evalScore = minimax(board, depth + 1, true, alpha, beta)
                            board[x][y] = ' '
                            minEval = minOf(minEval, evalScore)
                            beta = minOf(beta, evalScore)
                            if (beta <= alpha) {
                                break
                            }
                        }
                    }
                }
                return minEval
            }
        }


        fun findBestMove(board: Array<Array<Char>>, firstPlayer: Boolean): Pair<Int, Int>? {
            var bestMove: Pair<Int, Int>? = null
            var maxEval = -2
            var a = -2
            var b = 2
            var minEval = 2

            for (x in 0 until 3) {
                for (y in 0 until 3) {
                    if (firstPlayer) {
                        if (board[x][y] == ' ') {
                            board[x][y] = 'X'
                            val evalScore = minimax(board, 0, false, a, b)
                            board[x][y] = ' '
                            if (evalScore > maxEval) {
                                maxEval = evalScore
                                bestMove = Pair(x, y)
                            }
                        }
                    } else {
                        if (board[x][y] == ' ') {
                            board[x][y] = 'O'
                            val evalScore = minimax(board, 0, true, a, b)
                            board[x][y] = ' '
                            if (evalScore < minEval) {
                                minEval = evalScore
                                bestMove = Pair(x, y)
                            }
                        }
                    }
                }
            }

            return bestMove
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
            board= Array(3) { Array(3) { ' ' } }
            if(i%2!=0){
                Log.d("test","${i},${n} as X first move")
                val move=findBestMove(board,true)
                if(move!=null) {
                    board[move?.first!!][move?.second!!] = 'X'
                    val ind = (move?.first!!) * 3 + move?.second!!
                    txt[ind].text = "X"
                    btn[ind].isEnabled = false
                }
                n = n + 1
            }

        }

    fun check(){
        if((txt[0].text.toString()=="X"&&txt[1].text.toString()=="X"&&txt[2].text.toString()=="X")||(txt[3].text=="X"&&txt[4].text=="X"&&txt[5].text=="X")||(txt[6].text=="X"&&txt[7].text=="X"&&txt[8].text=="X")||(txt[0].text=="X"&&txt[4].text=="X"&&txt[8].text=="X")||(txt[0].text=="X"&&txt[3].text=="X"&&txt[6].text=="X")||(txt[1].text=="X"&&txt[4].text=="X"&&txt[7].text=="X")||(txt[2].text=="X"&&txt[5].text=="X"&&txt[8].text=="X")||(txt[2].text=="X"&&txt[4].text=="X"&&txt[6].text=="X")){
            if(i%2==0){
                s1=s1+1
                Toast.makeText(this@MainActivity4,"$name1 WON ", Toast.LENGTH_SHORT).show()
            }
            else {
                s2=s2+1
                Toast.makeText(this@MainActivity4,"$name2 WON", Toast.LENGTH_SHORT).show()
            }
            d=1
            n=9
            reset()
        }
        else if((txt[0].text.toString()=="O"&&txt[1].text.toString()=="O"&&txt[2].text.toString()=="O")||(txt[3].text=="O"&&txt[4].text=="O"&&txt[5].text=="O")||(txt[6].text=="O"&&txt[7].text=="O"&&txt[8].text=="O")||(txt[0].text=="O"&&txt[4].text=="O"&&txt[8].text=="O")||(txt[0].text=="O"&&txt[3].text=="O"&&txt[6].text=="O")||(txt[1].text=="O"&&txt[4].text=="O"&&txt[7].text=="O")||(txt[2].text=="O"&&txt[5].text=="O"&&txt[8].text=="O")||(txt[2].text=="O"&&txt[4].text=="O"&&txt[6].text=="O")){
            if(i%2==0){
                s2=s2+1
                Toast.makeText(this@MainActivity4,"$name2 WON", Toast.LENGTH_SHORT).show()
            }
            else {
                s1=s1+1
                Toast.makeText(this@MainActivity4,"$name1 WON", Toast.LENGTH_SHORT).show()
            }
            d=1
            n=9
            reset()
        }
        else{
            if(n==9&&d==0){
                s1=s1+0.5
                s2=s2+0.5
                Toast.makeText(this@MainActivity4,"ITS A STALEMATE !! ", Toast.LENGTH_SHORT).show()
                reset()
            }
        }}
        if (n < 9) {


                        for (l in txt.indices) {

                            btn[l].setOnClickListener {
                                if (i % 2 == 0) {
                                Log.d("test", "${i},${n} as O move - player")
                                txt[l].text = "X"
                                board[l / 3][l % 3] = 'X'
                                n = n + 1
                                btn[l].isEnabled = false


                                if (n < 9) {

                                    val move = findBestMove(board, false)
                                    Log.d("test", "${i},${n} as O move - ai")
                                    if (move != null) {
                                        board[move.first][move.second] = 'O'
                                        val ind = move.first * 3 + move.second
                                        txt[ind].text = "O"
                                        btn[ind].isEnabled = false
                                        n = n + 1

                                    }
                                }
                                check()


                            }
                                else{
                                    Log.d("test","${i},${n} as X move - player")
                                    txt[l].text = "O"
                                    board[l / 3][l % 3] = 'O'
                                    n = n + 1
                                    btn[l].isEnabled = false

                                    if (n < 9) {
                                        // Call the AI function, get output, disable the button
                                        val move = findBestMove(board, true)
                                        Log.d("test","${i},${n} as X move - ai")
                                        if (move != null) {
                                            board[move.first][move.second] = 'X'
                                            val ind = move.first * 3 + move.second
                                            txt[ind].text = "X"
                                            btn[ind].isEnabled = false
                                            n = n + 1

                                        }
                                    }
                                    check()
                                }

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
