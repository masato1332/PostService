package com.example.postservice

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
    val b1: Button by Delegates.notNull<Button>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var b1 = findViewById(R.id.button1) as Button
        b1.setOnClickListener {
            val post = AsyncHttp("Android", 10.11)
            post.execute()
        }
    }
}
