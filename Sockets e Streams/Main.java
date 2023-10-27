import java.io.*;

public class Main {
    public static void main(String[] args) {
        // Criar algumas pessoas de exemplo
        Pessoa pessoa1 = new Pessoa("João", "123456789", 30);
        Pessoa pessoa2 = new Pessoa("Maria", "987654321", 25);
        Pessoa pessoa3 = new Pessoa("Carlos", "456789123", 40);

        Pessoa[] pessoas = {pessoa1, pessoa2, pessoa3};

        try {
            // Testar PessoasOutputStream com System.out
            PessoasOutputStream outputStream1 = new PessoasOutputStream(pessoas, System.out);
            outputStream1.enviarDados();

            // Testar PessoasOutputStream com um arquivo
            OutputStream fileOutputStream = new FileOutputStream("pessoas.dat");
            PessoasOutputStream outputStream2 = new PessoasOutputStream(pessoas, fileOutputStream);
            outputStream2.enviarDados();
            fileOutputStream.close();

            // Testar PessoasInputStream com um arquivo
            InputStream fileInputStream = new FileInputStream("pessoas.dat");
            PessoasInputStream inputStream = new PessoasInputStream(fileInputStream);
            Pessoa[] pessoasLidas = inputStream.lerDados();

            // Imprimir as pessoas lidas
            for (Pessoa pessoa : pessoasLidas) {
                System.out.println("Nome: " + pessoa.getNome());
                System.out.println("CPF: " + pessoa.getCpf());
                System.out.println("Idade: " + pessoa.getIdade());
                System.out.println();
            }

            fileInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
