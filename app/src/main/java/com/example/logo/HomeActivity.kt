package com.example.logo

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class HomeActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var logistik: ImageView
    private lateinit var komunitas: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        logistik = findViewById<ImageView>(R.id.logistik)
        logistik.setOnClickListener(this)

//        komunitas = findViewById<ImageView>(R.id.komunitas)
//        komunitas.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id){
            R.id.logistik -> {
                val intentb = Intent (this@HomeActivity, LogistikBarangActivity::class.java)
                startActivity(intentb)
            }
        }

    }
//    override fun onClick(view: View?) {
//        when (view?.id){
//            R.id.komunitas -> {
//                val intentb = Intent (this@HomeActivity, komunitas::class.java)
//                startActivity(intentb)
//            }
//        }
//
//    }

}