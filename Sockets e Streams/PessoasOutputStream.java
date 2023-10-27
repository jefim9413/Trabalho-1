import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class PessoasOutputStream {
    private Pessoa[] pessoas;
    private OutputStream outputStream;

    public PessoasOutputStream(Pessoa[] pessoas, OutputStream outputStream) {
        this.pessoas = pessoas;
        this.outputStream = outputStream;
    }

    public void enviarDados() throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeInt(pessoas.length);

        for (Pessoa pessoa : pessoas) {
            byte[] nomeBytes = pessoa.getNome().getBytes();
            objectOutputStream.writeInt(nomeBytes.length);
            objectOutputStream.write(nomeBytes);
            objectOutputStream.writeUTF(pessoa.getCpf());
            objectOutputStream.writeInt(pessoa.getIdade());
        }

        objectOutputStream.flush();
    }
}
