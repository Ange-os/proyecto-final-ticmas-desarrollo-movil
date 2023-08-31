package com.curso.android.app.practica.comparete.view

import androidx.appcompat.app.AppCompatActivity
import com.curso.android.app.practica.comparete.models.TxT1
import com.curso.android.app.practica.comparete.models.TxT2
import androidx.activity.viewModels
import android.os.Bundle
import com.curso.android.app.practica.comparete.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bilding: ActivityMainBinding
    private val mainModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bilding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bilding.root)

        mainModel.devolucion.observe(this){
            bilding.textView.text = "${it.inf}"
        }
        bilding.imageButton.setOnClickListener {
            val firstWord = bilding.editTextText.text.toString()
            val secondWord = bilding.editTextText2.text.toString()

            mainModel.firsWord.value = TxT1(firstWord)
            mainModel.secundWord.value = TxT2(secondWord)

            mainModel.compareWord()
        }
        bilding.imageButton2.setOnClickListener{
            bilding.editTextText.text.clear()
            bilding.editTextText2.text.clear()
            mainModel.clean()
        }
    }
}