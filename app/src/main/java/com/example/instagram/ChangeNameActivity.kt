package com.example.instagram

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
        val fullname = intent.getStringExtra("fullname")
        binding.tvCurrentUsername.setText(username)
        binding.tvCurrentName.setText(fullname)

        binding.btSave.setOnClickListener {
            var resultIntent = Intent(this, MyProfile::class.java)
            resultIntent.putExtra("username", binding.etUsernameChange.text.toString())
            resultIntent.putExtra("fullname", binding.etNameChange.text.toString())
            setResult(3, resultIntent)
            finish()
        }

    }

}