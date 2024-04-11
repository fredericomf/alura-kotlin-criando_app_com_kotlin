package br.com.alura.orgs.ui.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.orgs.R
import br.com.alura.orgs.model.Produto
import br.com.alura.orgs.ui.recyclerview.adapter.ListaProdutosAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.math.BigDecimal

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val listaRecyclerView = findViewById<RecyclerView>(R.id.listaRecyclerView)
        listaRecyclerView.adapter = ListaProdutosAdapter(context = this, produtos = listOf<Produto>(
            Produto(
                nome = "Cesta de fruitas",
                descricao = "Uva, manga e goiaba",
                valor = BigDecimal("19.99"),
            ),Produto(
                nome = "Cesta de legumens",
                descricao = "Cenoura, cebola e batata",
                valor = BigDecimal("99.59"),
            ),Produto(
                nome = "Cesta de verduras",
                descricao = "Alface, rúcula e espinafre",
                valor = BigDecimal("1.51"),
            ),
        ))

        findViewById<FloatingActionButton>(R.id.adicionarProduto).setOnClickListener{
            val intent = Intent(this, FormularioProdutoActivity::class.java)
            startActivity(intent)
        }

    }


}