package com.example.startactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val s: TextView = findViewById(R.id.tv_check)
        val data = intent.getStringExtra("Data").toString()
        s.text = data
    }
}