package com.example.instagram

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.instagram.databinding.ActivityMyProfileBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMyProfileBinding
    val SELECT_PICTURE = 100
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

        binding.imageProfile.setOnClickListener {
            imageChooser();
        }
    }

    fun imageChooser() {
        val i = Intent()
        i.type = "image/*"
        i.action = Intent.ACTION_GET_CONTENT

        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 3) {
            binding.tvUsername.text = data?.getStringExtra("username")
            binding.tvFullName.text = data?.getStringExtra("fullname")
        }

        if (requestCode == SELECT_PICTURE) {
            // Get the url of the image from data
            val selectedImageUri: Uri? = data?.data
            if (null != selectedImageUri) {
                // update the preview image in the layout
                binding.imageProfile.setImageURI(selectedImageUri)
            }
        }
    }


}


