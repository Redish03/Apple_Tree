package com.example.apple_tree

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.apple_tree.databinding.ActivityFirstAppleBinding

class FirstAppleActivity : AppCompatActivity() {
    val binding by lazy {ActivityFirstAppleBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_apple)


    }
}