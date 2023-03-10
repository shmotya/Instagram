package com.example.instagram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import de.hdodenhof.circleimageview.CircleImageView

class MyProfile : AppCompatActivity() {

    private var circleImageView: CircleImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_profile)

        circleImageView = findViewById(R.id.imageProfile)


    }
}