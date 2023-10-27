import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Servidor {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345); // Porta 12345, você pode escolher outra porta
            System.out.println("Servidor aguardando conexões...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Conexão estabelecida com " + clientSocket.getInetAddress());

                List<Pessoa> pessoas = new ArrayList<>();
                pessoas.add(new Pessoa("Alice", "12345678901", 30));
                pessoas.add(new Pessoa("Bob", "98765432101", 25));

                DataOutputStream dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
                dataOutputStream.writeInt(pessoas.size());
                for (Pessoa pessoa : pessoas) {
                    pessoa.escreverParaStream(dataOutputStream);
                }

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
