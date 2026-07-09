
package supermercadoraffa;


public class Produtos {
    private int id;
    private String nome;
    private String marca;
    private String validade;

    public Produtos() {
    }

    public Produtos(int id, String nome, String marca, String validade) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.validade = validade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }
}