package com.example.logo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.logo.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class login : AppCompatActivity() {

//    lateinit var btn: Button
//    lateinit var regi: TextView
//    lateinit var email: EditText
//    lateinit var pass: EditText
    private lateinit var auth: FirebaseAuth
    lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        binding.register.setOnClickListener{
            val intent = Intent (this, registerdaftar::class.java)
            startActivity(intent)
        }

        binding.btnLogindisini.setOnClickListener{
            val email = binding.etEmail.text.toString()
            val katasandi = binding.etPass.text.toString()

            if (email.isEmpty()){
                binding.etEmail.error = "Isi email Anda terlebih dahulu"
                binding.etEmail.requestFocus()
                return@setOnClickListener
            }

            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.etEmail.error = "Email tidak valid"
                binding.etEmail.requestFocus()
                return@setOnClickListener
            }

            if (katasandi.isEmpty()){
                binding.etPass.error = "Buat kata sandi Anda terlebih dahulu"
                binding.etPass.requestFocus()
                return@setOnClickListener
            }
            LoginFirebase(email,katasandi)
        }
    }

    private fun LoginFirebase(email: String, katasandi: String) {
        auth.signInWithEmailAndPassword(email, katasandi).addOnCompleteListener(this){
                if (it.isSuccessful){
                    Toast.makeText(this, "Selamat datang $email", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this,HomeActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }


    }
}