package com.example.logo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class LogistikBarangActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var komunitas2: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logistik_barang)

        komunitas2 = findViewById<ImageView>(R.id.komunitas2)
        komunitas2.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
            when (view?.id){
                R.id.komunitas2 -> {
                    val intentb = Intent (this@LogistikBarangActivity, halkomunitas::class.java)
                    startActivity(intentb)
                }
            }

        }
    }
