import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class PessoasInputStream {
    private InputStream inputStream;

    public PessoasInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public Pessoa[] lerDados() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        int numPessoas = objectInputStream.readInt();
        Pessoa[] pessoas = new Pessoa[numPessoas];

        for (int i = 0; i < numPessoas; i++) {
            int nomeLength = objectInputStream.readInt();
            byte[] nomeBytes = new byte[nomeLength];
            objectInputStream.readFully(nomeBytes);
            String nome = new String(nomeBytes);
            String cpf = objectInputStream.readUTF();
            int idade = objectInputStream.readInt();

            pessoas[i] = new Pessoa(nome, cpf, idade);
        }

        return pessoas;
    }
}
