package com.example.logo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class ProfileActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btneditp : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        btneditp = findViewById<Button>(R.id.EditProfileButton)

        btneditp.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.EditProfileButton ->{
                val intentb =  Intent(this@ProfileActivity,EditProfileActivity::class.java)
                startActivity(intentb)
            }
        }
    }
}