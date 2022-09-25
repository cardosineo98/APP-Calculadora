package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.calculadora.databinding.ActivityMainBinding
import com.example.calculadora.utils.Constants.Companion.DIVISAO
import com.example.calculadora.utils.Constants.Companion.MULTIPLICACAO
import com.example.calculadora.utils.Constants.Companion.SOMA
import com.example.calculadora.utils.Constants.Companion.SUBTRACAO

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var num1: Float = 0.0f
    var num2: Float = 0.0f
    var resultado: Float = 0.0f
    private var operacao: Int = 0

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        //Eventos
        binding.botaoZero.setOnClickListener {
            binding.textVisor.text = addToInputText("0")
        }
        binding.botaoUm.setOnClickListener {
            binding.textVisor.text = addToInputText("1")
        }
        binding.botaoDois.setOnClickListener {
            binding.textVisor.text = addToInputText("2")
        }
        binding.botaoTres.setOnClickListener {
            binding.textVisor.text = addToInputText("3")
        }
        binding.botaoQuatro.setOnClickListener {
            binding.textVisor.text = addToInputText("4")
        }
        binding.botaoCinco.setOnClickListener {
            binding.textVisor.text = addToInputText("5")
        }
        binding.botaoSeis.setOnClickListener {
            binding.textVisor.text = addToInputText("6")
        }
        binding.botaoSete.setOnClickListener {
            binding.textVisor.text = addToInputText("7")
        }
        binding.botaoOito.setOnClickListener {
            binding.textVisor.text = addToInputText("8")
        }
        binding.botaoNove.setOnClickListener {
            binding.textVisor.text = addToInputText("9")
        }
        binding.botaoPonto.setOnClickListener {
            binding.textVisor.text = addToInputText(".")
        }

        binding.botaoSoma.setOnClickListener {
            operacaoPresionada(SOMA)
        }
        binding.botaoSubtracao.setOnClickListener {
            operacaoPresionada(SUBTRACAO)
        }
        binding.botaoMultiplicacao.setOnClickListener {
            operacaoPresionada(MULTIPLICACAO)
        }
        binding.botaoDivisao.setOnClickListener {
            operacaoPresionada(DIVISAO)
        }

        binding.botaoDel.setOnClickListener {
            limpar()
        }

        //Realizando as Operações
        binding.botaoIgual.setOnClickListener {
            realizarOperacao(num1, num2)
        }
    }

    override fun onClick(v: View?) {

    }

    //Acrescentando Numero ao Visor
    private fun addToInputText(botaoValue: String): String {
        return "${binding.textVisor.text}$botaoValue"
    }

    //Detectando Operacao Escolhida
    private fun operacaoPresionada(operacao: Int) {
        try {
            this.operacao = operacao
            num1 = binding.textVisor.text.toString().toFloat()
            binding.textVisor.text = ""
        } catch (e: NumberFormatException) {

        }
    }

    //Resetando a Calculadora
    private fun limpar() {
        binding.textVisor.text = ""
        num1 = 0.0f
        num2 = 0.0f
    }

    private fun realizarOperacao(num1: Float, num2: Float) {
        this.num2 = binding.textVisor.text.toString().toFloat()
        resultado = when (operacao) {
            SOMA -> (num1 + this.num2)
            SUBTRACAO -> (num1 - this.num2)
            MULTIPLICACAO -> (num1 * this.num2)
            DIVISAO -> (num1 / this.num2)
            else -> 0.0f
        }
        binding.textVisor.text = resultado.toString()
    }
}