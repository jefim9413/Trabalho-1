import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.List;
import java.util.ArrayList;


public class PessoasInputStream extends InputStream {
    private DataInputStream dataInputStream;

    public PessoasInputStream(InputStream inputStream) {
        dataInputStream = new DataInputStream(inputStream);
    }

    @Override
    public int read() throws IOException {
        return dataInputStream.read();
    }

    public List<Pessoa> lerPessoas() throws IOException {
        int numPessoas = dataInputStream.readInt();
        List<Pessoa> pessoas = new ArrayList<>();

        for (int i = 0; i < numPessoas; i++) {
            pessoas.add(Pessoa.lerDaStream(dataInputStream));
        }

        return pessoas;
    }

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12345); // Conectando ao servidor local
            PessoasInputStream inputStream = new PessoasInputStream(socket.getInputStream());
            List<Pessoa> pessoasLidas = inputStream.lerPessoas();

            for (Pessoa pessoa : pessoasLidas) {
                System.out.println("Nome: " + pessoa.getNome());
                System.out.println("CPF: " + pessoa.getCpf());
                System.out.println("Idade: " + pessoa.getIdade());
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
