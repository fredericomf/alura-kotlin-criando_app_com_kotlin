package br.com.alura.orgs.ui.activity

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.orgs.R
import br.com.alura.orgs.dao.ProdutosDao
import br.com.alura.orgs.databinding.ActivityFormularioProdutoBinding
import br.com.alura.orgs.model.Produto
import java.math.BigDecimal

class FormularioProdutoActivity : AppCompatActivity() {

    private val binding by lazy{
        ActivityFormularioProdutoBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val botaoSalvar = binding.botaoSalvar

        botaoSalvar.setOnClickListener{

            val nome = binding.nome.text.toString()
            val descricao = binding.descricao.text.toString()
            val valorText = binding.valor.text.toString()

            val valor = if(valorText.isBlank()){
                BigDecimal.ZERO
            }else{
                BigDecimal(valorText)
            }

            val produto = Produto(nome, descricao, valor)

            val dao = ProdutosDao()

            dao.salvar(produto)

            Log.i("Lista atualizada", "${dao.buscarTodos()}")

            finish()
        }

        setContentView(binding.root)
    }

}