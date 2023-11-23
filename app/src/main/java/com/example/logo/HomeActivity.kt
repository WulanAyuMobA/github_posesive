package com.example.logo

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.View
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class HomeActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var profile: CircleImageView
    private lateinit var logistik: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        profile = findViewById<CircleImageView>(R.id.Fprofil)
        logistik = findViewById<TextView>(R.id.tv_logistik2)
        profile.setOnClickListener(this)
        logistik.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.Fprofil -> {
                val intentb = Intent(this@HomeActivity, ProfileActivity::class.java)
                startActivity(intentb)
            }

            R.id.tv_logistik2 -> {
                val intentb = Intent(this@HomeActivity, LogistikBarangActivity::class.java)
                startActivity(intentb)
            }
        }
    }
}