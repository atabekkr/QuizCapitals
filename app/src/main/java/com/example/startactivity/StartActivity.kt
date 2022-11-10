package com.example.startactivity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import com.example.startactivity.databinding.ActivityResultBinding
import com.example.startactivity.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityStartBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val intent1 = Intent(this, ResultActivity::class.java)


        val sharedPreferences = getSharedPreferences("CapitalsSettings", Context.MODE_PRIVATE)



        binding.etName.addTextChangedListener {
            binding.tilName.isErrorEnabled = false
        }

        binding.btnStart.setOnClickListener {
            val name = binding.etName.text.toString()
            intent1.putExtra("congrats", name)
            if (name.isEmpty() || name.isBlank()){
                binding.tilName.error = getString(R.string.error_text)
            } else {
                sharedPreferences.edit().putString("username", name).apply()
                val intent = Intent(this, GameActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}