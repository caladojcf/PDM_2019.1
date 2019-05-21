package com.example.jogodamemoriasi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.GridView
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    internal var curView: ImageView? = null
    private var countPair = 0
    internal var drawable = intArrayOf(R.drawable.alana, R.drawable.alex, R.drawable.candido, R.drawable.crishane, R.drawable.denio, R.drawable.edemberg, R.drawable.fausto, R.drawable.francisco, R.drawable.fred, R.drawable.giovanni, R.drawable.gustavo, R.drawable.heremita, R.drawable.juliana, R.drawable.lafayette, R.drawable.leonidas, R.drawable.luiz, R.drawable.nilton, R.drawable.paulo, R.drawable.petronio, R.drawable.pryscilla, R.drawable.thiago, R.drawable.valeria, R.drawable.varandas, R.drawable.zefilho)

    internal var pos = intArrayOf(1, 0, 5, 6, 2, 11, 1, 21, 21, 4, 6, 5, 11, 2, 0, 4)
    internal var currentPos = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gridView = findViewById<View>(R.id.gridView) as GridView
        val imgAdapter = ImgAdapter(this)
        gridView.adapter = imgAdapter

        gridView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            if (currentPos < 0) {
                currentPos = position
                curView = view as ImageView
                view.setImageResource(drawable[pos[position]])
            } else {
                if (currentPos == position) {
                    (view as ImageView).setImageResource(R.drawable.interrogacao)
                } else if (pos[currentPos] != pos[position]) {
                    curView!!.setImageResource(R.drawable.interrogacao)
                    Toast.makeText(applicationContext, "Errou!", Toast.LENGTH_SHORT).show()
                } else {
                    (view as ImageView).setImageResource(drawable[pos[position]])
                    countPair++
                    if (countPair == 8) {
                        Toast.makeText(applicationContext, "Parabéns. Acertou!", Toast.LENGTH_SHORT).show()
                    }
                }
                currentPos = -1
            }
        }
    }
}