package com.example.apple_tree

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.apple_tree.databinding.ActivityFirstAppleBinding

class FirstAppleActivity : AppCompatActivity() {
    private val TAG = "FirstAppleActivity"
    val binding by lazy {ActivityFirstAppleBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.editTextTextMultiLine.setImeOptions(EditorInfo.IME_ACTION_DONE);
        binding.editTextTextMultiLine.setRawInputType(InputType.TYPE_CLASS_TEXT);

        val sharedPreference = getSharedPreferences("sp1", MODE_PRIVATE)
        val editor : SharedPreferences.Editor = sharedPreference.edit()
        var str = ""

        binding.editTextTextMultiLine.addTextChangedListener {
            str = binding.editTextTextMultiLine.text.toString()
       }

        val intent = Intent(this, SecondAppleActivity::class.java)
        binding.next.setOnClickListener {
            if(str == "") {
                Toast.makeText(this, "First Apple can't be empty", Toast.LENGTH_LONG).show()
            }
            else {
                editor.putString("1st", str)
                Log.d(TAG, "${str}")
                startActivity(intent)
            }
        }
    }
}
