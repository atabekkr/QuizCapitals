package com.example.startactivity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.startactivity.databinding.ActivityGameBinding
import com.example.startactivity.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        val sharedPreferences: SharedPreferences = getSharedPreferences("CapitalsSettings", Context.MODE_PRIVATE)

        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

      //  val s: TextView = findViewById(R.id.tv_check)
        val data = intent.getStringExtra("Data").toString()
        binding.tvCheck.text = getString(R.string.text_result, data)

        val cong = sharedPreferences.getString("username", "") ?: "Unknown"
    //    val cong = intent.getStringExtra("congrats").toString()

        binding.congrats.text = getString(R.string.text_congrats, cong)

        binding.btnExit.setOnClickListener {
            finish()
        }

        binding.btnNewGame.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
            finish()
        }


    }
}