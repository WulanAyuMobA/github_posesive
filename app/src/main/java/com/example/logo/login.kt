package com.example.logo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class login : AppCompatActivity(), View.OnClickListener {

    lateinit var btn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

         btn = findViewById<Button>(R.id.btn_logindisini)

        btn.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.btn_logindisini ->{
                val intentb =  Intent(this@login,HomeActivity::class.java)
                startActivity(intentb)
            }
        }
    }
}