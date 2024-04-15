package br.com.alura.orgs.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.orgs.R
import br.com.alura.orgs.databinding.ProdutoItemBinding
import br.com.alura.orgs.model.Produto

class ListaProdutosAdapter(
    private val context: Context,
    produtos: List<Produto>,
) :
    RecyclerView.Adapter<ListaProdutosAdapter.MeuViewHolder>() {

    private val produtos = produtos.toMutableList()

    class MeuViewHolder(binding: ProdutoItemBinding) : RecyclerView.ViewHolder(binding.root) {

        private val nome = binding.nome
        private val descricao = binding.descricao
        private val valor = binding.valor

        fun vincula(produto: Produto) {
            nome.text = produto.nome
            descricao.text = produto.descricao
            valor.text = produto.valor.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeuViewHolder {
        val binding = ProdutoItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return MeuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MeuViewHolder, position: Int) {
        holder.vincula(produtos[position])
    }

    override fun getItemCount(): Int = produtos.size

    fun atualiza(novosProdutos: List<Produto>){
        produtos.clear()
        produtos.addAll(novosProdutos)
        notifyDataSetChanged()
    }
}
