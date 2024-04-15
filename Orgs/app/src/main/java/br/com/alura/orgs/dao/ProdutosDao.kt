package br.com.alura.orgs.dao

import br.com.alura.orgs.model.Produto

class ProdutosDao {
    fun salvar(produto : Produto){
        listaProdutos.add(produto)
    }

    fun buscarTodos() : List<Produto>{
        return listaProdutos.toList()
    }

    companion object {
        private val listaProdutos = mutableListOf<Produto>()
    }
}