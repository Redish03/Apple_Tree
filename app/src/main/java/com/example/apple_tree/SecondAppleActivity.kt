package com.example.apple_tree

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.PersistableBundle
import android.text.InputType
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.apple_tree.databinding.ActivitySecondAppleBinding

class SecondAppleActivity : AppCompatActivity() {
    val binding by lazy { ActivitySecondAppleBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.editTextTextMultiLine.setImeOptions(EditorInfo.IME_ACTION_DONE);
        binding.editTextTextMultiLine.setRawInputType(InputType.TYPE_CLASS_TEXT);

        val sharedPreference = getSharedPreferences("sp1", MODE_PRIVATE)
        val editor : SharedPreferences.Editor = sharedPreference.edit()

        binding.editTextTextMultiLine.addTextChangedListener {
            var str = binding.editTextTextMultiLine.text.toString()
            editor.putString("2nd", str)
        }
        val intent = Intent(this, ThirdAppleActivity::class.java)
        binding.button.setOnClickListener {startActivity(intent)}
    }
}