package com.example.instagram

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.instagram.databinding.ActivityChangeNameBinding

class ChangeNameActivity : AppCompatActivity() {

    lateinit var binding: ActivityChangeNameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChangeNameBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val username = intent.getStringExtra("username")
        binding.tv.setText(username)

        binding.btSave.setOnClickListener {
            var resultIntent = Intent(this, MyProfile::class.java)
            resultIntent.putExtra("username", binding.etNameChange.text.toString())
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }

    }

}