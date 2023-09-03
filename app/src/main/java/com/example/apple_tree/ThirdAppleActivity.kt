package com.example.apple_tree

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.apple_tree.databinding.ActivityThirdAppleBinding

class ThirdAppleActivity : AppCompatActivity() {
    val binding by lazy { ActivityThirdAppleBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}