package ru.russ

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import ru.m.lib.myController
import ru.m.lib.myModel
import ru.m.lib.myView
import kotlin.coroutines.coroutineContext

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            Thread() {
                linlay.addView(myB(this))
            }.run()
        }

    }

}

class myB(context: Context?) : Button(context) {
    private var running = true

    init {
        setOnClickListener {
            running = !running
            System.out.println("===" + running)
            if (running) {
                Thread() {
                    //while (running) {
                    var x = 0.0
                    val t1 = System.currentTimeMillis()
                    for (i in 0..1_000_000_000) {
                        x = i * 1.00
                        var sx = Math.tan(x)
                    }
                    val t2 = System.currentTimeMillis()
                    //val time = (t2 - t1) / 1000
                    text = (t2 - t1).toString()
                }.run()
            }

        }
    }

}

