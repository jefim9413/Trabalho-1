import java.io.*;
import java.net.*;

public class PessoasOutputStream {
    public static void main(String[] args) {
        try {
            // Conectar ao servidor remoto
            Socket socket = new Socket("127.0.0.1", 12345); // Endereço e porta do servidor

            // Criar algumas pessoas de exemplo
            Pessoa pessoa1 = new Pessoa("João", "123456789", 30);
            Pessoa pessoa2 = new Pessoa("Maria", "987654321", 25);
            Pessoa pessoa3 = new Pessoa("Carlos", "456789123", 40);
            Pessoa[] pessoas = {pessoa1, pessoa2, pessoa3};

            // Criar PessoasOutputStream usando o socket
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            
            // Enviar o array de pessoas serializado
            objectOutputStream.writeObject(pessoas);

            objectOutputStream.flush();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
