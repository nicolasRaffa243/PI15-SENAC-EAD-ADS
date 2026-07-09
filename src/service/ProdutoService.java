package service;

import DAO.ProdutoDAO;
import java.util.List;
import supermercadoraffa.Produtos;

public class ProdutoService {

    private ProdutoDAO dao = new ProdutoDAO();

    public void cadastrarProduto(Produtos produto) {

        dao.cadastrarProduto(produto);

    }

    public List<Produtos> listarProdutos() {

        return dao.listarProdutos();

    }

    public List<Produtos> pesquisarProdutos(String pesquisa) {

        return dao.pesquisarProdutos(pesquisa);

    }

    public void excluirProduto(int id) {

        dao.excluirProduto(id);

    }

}
