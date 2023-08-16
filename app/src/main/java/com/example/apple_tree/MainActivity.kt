package com.example.apple_tree

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.apple_tree.databinding.ActivityFirstPageBinding
import com.example.apple_tree.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_page)
        Handler(Looper.getMainLooper()).postDelayed({
            setContentView(binding.root)
        }, 3000)
        val intent = Intent(this, FirstAppleActivity::class.java)

        binding.nextButton.setOnClickListener{startActivity(intent)}
    }
}