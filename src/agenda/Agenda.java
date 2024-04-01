package agenda;

import contato.Contato;

import java.util.ArrayList;
import java.util.List;

// Classe que representa uma agenda de contatos
public class Agenda {
    private static List<Contato> contatos; // Lista de contatos na agenda

    // Construtor da classe Agenda
    public Agenda() {
        contatos = new ArrayList<>();
    } // Inicializa a lista de contatos

    // Método para adicionar um contato à agenda
    public void adicionarContato(Contato contato) {
        contatos.add(contato);
    }

    // Método para editar o número ou nome de um contato existente na agenda
    public void editarContato(String nome, String novoNumero) {
        for (Contato contato : contatos) {
            if (contato.getNome().equals(nome)) {
                contato.setNumero(novoNumero);
                break;
            }
        }
    }

    // Método para remover um contato da agenda
    public boolean removerContato(String nome) {
        contatos.removeIf(contato -> contato.getNome().equals(nome));
        return true;
    }

    // Método para buscar um contato na agenda pelo nome
    public static Contato buscarContato(String nome) {
        for (Contato contato : contatos) {
            if (contato.getNome().equals(nome)) {
                return contato;   // Retorna o contato se encontrado
            }
        }
        return null;   // Retorna null se o contato não for encontrado
    }


    // Método para listar todos os contatos da agenda
    public List<Contato> listarContatos() {
        return contatos;
    }
}
