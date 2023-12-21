package com.example.logo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class halkomunitas : AppCompatActivity(), View.OnClickListener {

    private lateinit var profil : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_halkomunitas)

        profil = findViewById<ImageView>(R.id.profil)
        profil.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id){
            R.id.profil -> {
                val intentb = Intent (this@halkomunitas, ProfileActivity::class.java)
                startActivity(intentb)
            }
        }

    }
}