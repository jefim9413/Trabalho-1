import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Pessoa {
    private String nome;
    private String cpf;
    private int idade;

    public Pessoa(String nome, String cpf, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void escreverParaStream(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeUTF(nome);
        dataOutputStream.writeUTF(cpf);
        dataOutputStream.writeInt(idade);
    }

    public static Pessoa lerDaStream(DataInputStream dataInputStream) throws IOException {
        String nome = dataInputStream.readUTF();
        String cpf = dataInputStream.readUTF();
        int idade = dataInputStream.readInt();
        return new Pessoa(nome, cpf, idade);
    }
}
