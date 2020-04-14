package com.laboratorios.lab3.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.laboratorios.lab3.R
import com.laboratorios.lab3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var cambio = false

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding= DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.imgVirus.setImageResource(R.drawable.coronavirus_hero)
        binding.txtTextoInfo.text = getString(R.string.infoEdad)
        binding.scrollView2.visibility = View.GONE
        botones()
    }

    fun botones(){
        binding.apply {
            btnCambio.setOnClickListener {
                if (cambio == false){
                    txtNombre.visibility = View.GONE
                    txtNombree.visibility = View.GONE
                    txtEdad.visibility = View.GONE
                    txtEdadd.visibility = View.GONE
                    binding.scrollView2.visibility = View.VISIBLE
                    cambio = true
                }else{
                    txtNombre.visibility = View.VISIBLE
                    txtNombree.visibility = View.VISIBLE
                    txtEdad.visibility = View.VISIBLE
                    txtEdadd.visibility = View.VISIBLE
                    binding.scrollView2.visibility = View.GONE
                    cambio = false
                }
            }

            btnVirus.setOnClickListener {InfoActivity(0)}
            btnSintomas.setOnClickListener {InfoActivity(1)}
            btnIndicaciones.setOnClickListener {InfoActivity(2)}
        }
    }

    fun InfoActivity(tipo: Int){
        var intent = Intent(this, InformacionActivity::class.java)
        intent.putExtra("tipo",tipo)
        startActivity(intent)
    }




}
