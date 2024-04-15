package br.com.alura.orgs.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.orgs.R
import br.com.alura.orgs.model.Produto

class ListaProdutosAdapter(
    private val context: Context,
    produtos: List<Produto>,
) :
    RecyclerView.Adapter<ListaProdutosAdapter.MeuViewHolder>() {

    private val produtos = produtos.toMutableList()

    class MeuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun vincula(produto: Produto) {
            val nome = itemView.findViewById<TextView>(R.id.nome)
            nome.text = produto.nome

            val descricao = itemView.findViewById<TextView>(R.id.descricao)
            descricao.text = produto.descricao

            val valor = itemView.findViewById<TextView>(R.id.valor)
            valor.text = produto.valor.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeuViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.produto_item, parent,false)
        return MeuViewHolder(view)
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
