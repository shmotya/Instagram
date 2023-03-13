package com.example.instagram

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.instagram.databinding.ActivityMyProfileBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMyProfileBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btEditProfile.setOnClickListener {
            val intent = Intent(this, ChangeNameActivity::class.java)
            intent.putExtra("username", binding.tvUsername.text.toString())
            intent.putExtra("fullname", binding.tvFullName.text.toString())
            startActivityForResult(intent, 1)
        }

        binding.btLogIn.setOnClickListener {

            if(binding.etLogIn.text.toString() == "sshmotya" && binding.etPassword.text.toString() == "12345") {
                binding.llLogInWindow.isVisible = false
            }

            else
                binding.tvWrongPassword.text = "Wrong login or password!"

        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

            binding.tvUsername.text = data?.getStringExtra("username")
            binding.tvFullName.text = data?.getStringExtra("fullname")

    }

}

