package com.example.edsonpn.alcoolougasolina

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btCalcular(view:View){

        val precoAlcool = edit_preco_alcool.text.toString()
        val precoGasolina = edit_preco_gasolina.text.toString()

        val validaCampos = validarCampos(precoAlcool,precoGasolina)
        if(validaCampos==true){
            calcularMelhorPreco(precoAlcool,precoGasolina)
        }else{
            text_resultado.setText("Preencha os preços primeiro!")
        }
    }

    fun validarCampos(precoAlcool: String, precoGasolina: String): Boolean{

        var camposValidados : Boolean = true

        if (precoAlcool==null || precoAlcool.equals("")){
            camposValidados = false
        }else if (precoGasolina==null || precoGasolina.equals("")){
            camposValidados= false
        }

        return camposValidados
    }

    fun calcularMelhorPreco(precoAlcool: String, precoGasolina: String){

        //converter valores string para numeros
        val valorAlcool = precoAlcool.toDouble()
        val valorGasolina = precoGasolina.toDouble()

        /*Faz Calculo(preco alcool/preco gasolina)
        Se o resultado >= 0.7 melhor utilizar gasolina
        senão melhor utilizar álcool
         */
        val resultadoPreco = valorAlcool/valorGasolina

        if (resultadoPreco>=0.7){
            text_resultado.setText("Melhor utilizar Gasolina!")
        }else{
            text_resultado.setText("Melhor utilizar Álcool!")
        }
    }
}
