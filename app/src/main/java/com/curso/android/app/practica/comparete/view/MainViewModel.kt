package com.curso.android.app.practica.comparete.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import com.curso.android.app.practica.comparete.models.TxT1
import com.curso.android.app.practica.comparete.models.TxT2
import com.curso.android.app.practica.comparete.models.Return

class MainViewModel:ViewModel() {
    val firsWord = MutableLiveData<TxT1> (TxT1(""))
    val secundWord = MutableLiveData<TxT2> (TxT2(""))
    val devolucion = MutableLiveData<Return> (Return(""))


    fun compareWord(){
        val fristWord = firsWord.value?.palabra
        val scudWord = secundWord.value?.palabraT2
        if (fristWord != null && scudWord != null) {
            if (fristWord == scudWord){
                devolucion.value = Return("Palabras iguales")
            }else{
                devolucion.value = Return("Palabras no iguales")
            }
        }
    }

    fun clean(){
        devolucion.value = Return("")
    }

}