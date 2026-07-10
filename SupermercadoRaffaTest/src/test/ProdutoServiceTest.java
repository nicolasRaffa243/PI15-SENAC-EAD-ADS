package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import service.ProdutoService;
import supermercadoraffa.Produtos;

public class ProdutoServiceTest {

    @Test
    public void deveValidarProdutoValido() {

        ProdutoService service = new ProdutoService();

        Produtos produto = new Produtos();
        produto.setNome("Arroz");
        produto.setMarca("Tio João");
        produto.setValidade("2026-12-31");

        assertTrue(service.validarProduto(produto));

    }

    @Test
    public void naoDeveValidarProdutoSemNome() {

        ProdutoService service = new ProdutoService();

        Produtos produto = new Produtos();
        produto.setNome("");
        produto.setMarca("Tio João");
        produto.setValidade("2026-12-31");

        assertFalse(service.validarProduto(produto));

    }

}
