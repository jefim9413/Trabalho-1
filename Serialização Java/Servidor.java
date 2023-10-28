import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        int port = 12345;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Servidor aguardando conexões na porta " + port);

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
                     ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream())) {
                    
                    Request clientRequest = (Request) in.readObject();
                    Reply serverReply = processRequest(clientRequest);

                    out.writeObject(serverReply);
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Reply processRequest(Request request) {
        // Lógica para processar a requisição e gerar uma resposta (Reply)
        return new Reply(true, "Operação realizada com sucesso", null);
    }
}
