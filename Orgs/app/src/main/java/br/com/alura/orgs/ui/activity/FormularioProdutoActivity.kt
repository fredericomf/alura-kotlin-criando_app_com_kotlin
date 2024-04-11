package br.com.alura.orgs.ui.activity

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.com.alura.orgs.R
import br.com.alura.orgs.model.Produto
import java.math.BigDecimal

class FormularioProdutoActivity : AppCompatActivity(R.layout.activity_formulario_produto) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val botaoSalvar = findViewById<Button>(R.id.botao_salvar)

        botaoSalvar.setOnClickListener{

            val nome = findViewById<EditText>(R.id.nome).text.toString()
            val descricao = findViewById<EditText>(R.id.descricao).text.toString()
            val valorText = findViewById<EditText>(R.id.valor).text.toString()

            val valor = if(valorText.isBlank()){
                BigDecimal.ZERO
            }else{
                BigDecimal(valorText)
            }

            val produto = Produto(nome, descricao, valor)


            Log.i("FormularioProdutoActivity", produto.toString())
        }
    }

}