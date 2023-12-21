package com.example.logo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.logo.databinding.ActivityLoginBinding
import com.example.logo.databinding.ActivityRegisterBinding
import com.example.logo.databinding.ActivityRegisterdaftarBinding
import com.google.firebase.auth.FirebaseAuth

class registerdaftar : AppCompatActivity() {

    lateinit var binding: ActivityRegisterdaftarBinding
    lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRegisterdaftarBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.logindulu.setOnClickListener{
            val intent = Intent(this, login::class.java)
            startActivity(intent)
        }

        binding.btnDaftar.setOnClickListener{
            val email = binding.emailregister.text.toString()
            val katasandi = binding.katsan.text.toString()
            val verifikasikatasandi = binding.verikatsan.text.toString()

            if (email.isEmpty()){
                binding.emailregister.error = "Isi email Anda terlebih dahulu"
                binding.emailregister.requestFocus()
                return@setOnClickListener
            }

            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.emailregister.error = "Email tidak valid"
                binding.emailregister.requestFocus()
                return@setOnClickListener
            }

            if (katasandi.isEmpty()){
                binding.katsan.error = "Buat kata sandi Anda terlebih dahulu"
                binding.katsan.requestFocus()
                return@setOnClickListener
            }

            if (katasandi.length < 6){
                binding.katsan.error = "Password minimal 10 karakter"
                binding.katsan.requestFocus()
                return@setOnClickListener
            }

            RegisterFirebase(email,katasandi,verifikasikatasandi)

        }

    }

    private fun RegisterFirebase(email: String, katasandi: String, verifikasikatasandi: String) {
        auth.createUserWithEmailAndPassword(email,katasandi)
            .addOnCompleteListener(this){
                if (it.isSuccessful){
                    Toast.makeText(this, "Berhasil buat akun", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this,register::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }

    }
}