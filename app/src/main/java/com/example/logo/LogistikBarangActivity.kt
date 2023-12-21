package com.example.logo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class LogistikBarangActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var komunitas2: ImageView
    private lateinit var nama: EditText
    private lateinit var notelp: EditText
    private lateinit var tanggal: EditText
    private lateinit var alamat: EditText
    private lateinit var kelurahan: EditText
    private lateinit var jumlah: EditText
    private lateinit var spin: Spinner
    private lateinit var alasan: EditText
    private lateinit var kirim: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logistik_barang)

        komunitas2 = findViewById<ImageView>(R.id.komunitas2)
        komunitas2.setOnClickListener(this)

        nama = findViewById(R.id.namalengkap)
        notelp = findViewById(R.id.notelepon)
        tanggal = findViewById(R.id.tanggal)
        alamat = findViewById(R.id.alamat)
        kelurahan = findViewById(R.id.kelurahan)
        jumlah = findViewById(R.id.jumlah)
        spin = findViewById(R.id.spinner)
        alasan = findViewById(R.id.alasan)
        kirim = findViewById(R.id.Send)

    }

    override fun onClick(view: View?) {
            when (view?.id){
                R.id.komunitas2 -> {
                    val intentb = Intent (this@LogistikBarangActivity, halkomunitas::class.java)
                    startActivity(intentb)
                }
            }
        saveData()
        }
    private fun saveData (){
        val Nama = nama.text.toString().trim()
        val noTelepon = notelp.text.toString().trim()
        val Tanggal = tanggal.text.toString().trim()
        val Alamat = alamat.text.toString().trim()
        val Kelurahan = kelurahan.text.toString().trim()
        val Jumlah = jumlah.text.toString().trim()
        val spinner = arrayOf(spin).toString().trim()
        val Alasan = alasan.text.toString().trim()

        if(Nama.isEmpty()){
            nama.error = "Isi datadiri anda terlebih dahulu"
            return
        }
        if(noTelepon.isEmpty()){
            notelp.error = "Isi datadiri anda terlebih dahulu"
            return
        }
        if(Tanggal.isEmpty()){
            tanggal.error = "Isi datadiri anda terlebih dahulu"
            return
        }
        if(Alamat.isEmpty()){
            alamat.error = "Isi datadiri anda terlebih dahulu"
            return
        }
        if(Kelurahan.isEmpty()){
            kelurahan.error = "Isi datadiri anda terlebih dahulu"
            return
        }
        if(Jumlah.isEmpty()){
            jumlah.error = "Isi datadiri anda terlebih dahulu"
            return
        }
        if(Alasan.isEmpty()){
            alasan.error = "Isi alasan Anda"
            return
        }

        val ref = FirebaseDatabase.getInstance().getReference("Permintaan")
        val konsumenId = ref.push().key

        val konsumen = permintaan(konsumenId,Nama, noTelepon, Tanggal, Alamat, Kelurahan, Jumlah, spinner, Alasan)

        if (konsumenId != null) {
            ref.child(konsumenId).setValue(konsumen).addOnCompleteListener{
                    Toast.makeText(applicationContext, "Permintaan Anda berhasil dikirim!", Toast.LENGTH_SHORT).show()
            }
        }
    }
    }
