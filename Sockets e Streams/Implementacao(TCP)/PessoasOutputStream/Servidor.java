import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345); // Porta do servidor

            System.out.println("Aguardando conexão...");
            Socket clientSocket = serverSocket.accept(); // Aguarda a conexão do cliente

            // Criar PessoasInputStream usando o socket
            ObjectInputStream objectInputStream = new ObjectInputStream(clientSocket.getInputStream());

            // Ler o array de pessoas
            Pessoa[] pessoas = (Pessoa[]) objectInputStream.readObject();

            // Imprimir as pessoas recebidas
            for (Pessoa pessoa : pessoas) {
                System.out.println("Nome: " + pessoa.getNome());
                System.out.println("CPF: " + pessoa.getCpf());
                System.out.println("Idade: " + pessoa.getIdade());
                System.out.println();
            }

            clientSocket.close();
            serverSocket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
