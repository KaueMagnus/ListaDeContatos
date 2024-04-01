package contato;

// Classe que representa um contato na agenda
public class Contato {

    private String nome; // Nome do contato
    private String numero; // Numero de telefone do contato

    // Construtor da classe Contato
    public Contato(String nome, String numero) {
        this.nome = nome;
        this.numero = numero;
    }

    // Métodos getter e setter para o nome
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Métodos getter e setter para o número
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }

    // Método toString para exibir o contato de forma legível
    public String toString() {
        return nome + ": " + numero;
    }
}
