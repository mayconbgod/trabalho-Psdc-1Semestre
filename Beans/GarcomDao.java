package provaA3.Beans;

import provaA3.ConexaoBD.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GarcomDao {


    public static void  criarGarcom() {

        Scanner lerDadosGarcom = new Scanner(System.in);

        System.out.println("Digite codigo garçom : ");
        int codGarcom = lerDadosGarcom.nextInt();

        System.out.println("Digite o nome do garçom : ");
        String nome = lerDadosGarcom.next();

        System.out.println("Digite o CPF do garçom : ");
        String cpf = lerDadosGarcom.next();

        System.out.println("Digite o email do garçom : ");
        String email = lerDadosGarcom.next();

        System.out.println("Digite o sexo do garcom : ");
        String sexo = lerDadosGarcom.next();

        System.out.println("Digite a data de nascimento dd/mm/aa : ");
        String dtNascimento = lerDadosGarcom.next();

        System.out.println("Digite o telefone 0000-0000 : ");
        String numeroTelefone = lerDadosGarcom.next();

        System.out.println("Digite o salário do garçom : ");
        float salGarcom = lerDadosGarcom.nextFloat();

        Garcom garcom = new Garcom(codGarcom, nome, cpf, email, sexo, dtNascimento, numeroTelefone, salGarcom);
        gravaGarcomCriado(garcom);

        System.out.println("\nGarçom criado!");
    }

    public static ArrayList <Garcom> buscaGarcons() {
        ArrayList <Garcom> vetorGarcons = new ArrayList<Garcom>();
        try {
            Connection conexaoRecebida = Conexao.getInstance();
            String sql = "SELECT * FROM Garcom";

            PreparedStatement stmt = conexaoRecebida.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next() == true) {

                int codigoGarcom = rs.getInt("codGarcom");
                String nomeGarcom = rs.getString("nome");
                String cpfGarcom = rs.getString("cpf");
                String emailGarcom = rs.getString("email");
                String sexoGarcom = rs.getString("sexo");
                String dtNascimentoGarcom = rs.getString("dtNascimento");
                String telefone = rs.getString("telefone");
                Float salarioGarcom = rs.getFloat("salario");

                Garcom garcom = new Garcom (codigoGarcom, nomeGarcom, cpfGarcom, emailGarcom, sexoGarcom, dtNascimentoGarcom, telefone, salarioGarcom);
                vetorGarcons.add(garcom);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao buscar buscar Garçom!");
        }
        return vetorGarcons;
    }

    public static Garcom buscaGarcomPeloCodigo(int codGarcomBuscado) {
        Garcom garcomEncontrado = null;
        try {
            Connection conexaoRecebida = Conexao.getInstance();
            String sql = "SELECT * FROM Garcom WHERE codGarcom = ?";
            PreparedStatement stmt = conexaoRecebida.prepareStatement(sql);

            stmt.setInt(1, codGarcomBuscado);

            ResultSet busca = stmt.executeQuery();

            boolean retorno = busca.next();

            if (retorno == true) {

                int codigoGarcom = busca.getInt("codGarcom");
                String nomeGarcom = busca.getString("nome");
                String cpfGarcom = busca.getString("cpf");
                String emailGarcom = busca.getString("email");
                String sexoGarcom = busca.getString("sexo");
                String dtNascimentoGarcom = busca.getString("dtNascimento");
                String telefone = busca.getString("telefone");
                Float salarioGarcom = busca.getFloat("salario");

                garcomEncontrado = new Garcom (codigoGarcom, nomeGarcom, cpfGarcom, emailGarcom, sexoGarcom, dtNascimentoGarcom, telefone, salarioGarcom);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
            System.out.println("\nErro ao buscar garçom pelo codigo!");
        }
        return garcomEncontrado;
    }

    public static Garcom buscaGarcomPeloEmail(String emailGarcomBuscado) {
        Garcom garcomEncontrado = null;
        try {
            Connection conexaoRecebida = Conexao.getInstance();
            String sql = "SELECT * FROM Garcom WHERE email = ?";
            PreparedStatement stmt = conexaoRecebida.prepareStatement(sql);

            stmt.setString(1, emailGarcomBuscado);

            ResultSet busca = stmt.executeQuery();

            boolean retorno = busca.next();

            if (retorno == true) {

                int codigoGarcom = busca.getInt("codGarcom");
                String nomeGarcom = busca.getString("nome");
                String cpfGarcom = busca.getString("cpf");
                String emailGarcom = busca.getString("email");
                String sexoGarcom = busca.getString("sexo");
                String dtNascimentoGarcom = busca.getString("dtNascimento");
                String telefone = busca.getString("telefone");
                Float salarioGarcom = busca.getFloat("salario");

                garcomEncontrado = new Garcom (codigoGarcom, nomeGarcom, cpfGarcom, emailGarcom, sexoGarcom, dtNascimentoGarcom, telefone, salarioGarcom);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
            System.out.println("\nErro ao buscar garçom pelo email!");
        }
        return garcomEncontrado;
    }

    public static void gravaGarcomCriado(Garcom garcom) {
        try {
            Connection conexaoRecebida = Conexao.getInstance();

            String sql = "INSERT INTO Garcom (codGarcom, nome, cpf, email, sexo, dtNascimento, telefone, salario) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement stmt = conexaoRecebida.prepareStatement(sql);

            stmt.setInt(1, garcom.getCodigoGarcom());
            stmt.setString(2, garcom.getNomeGarcom());
            stmt.setString(3, garcom.getCpfGarcom());
            stmt.setString(4, garcom.getEmailGarcom());
            stmt.setString(5, garcom.getSexoGarcom());
            stmt.setString(6, garcom.getDtNascimentoGarcom());
            stmt.setString(7, garcom.getTelefoneGarcom());
            stmt.setFloat(8, garcom.getSalario());

            stmt.execute();
            stmt.close();

        }
        catch(Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao gravar garçom ! ");
        }
    }

    public static void removeGarcom (int codigoGarcom) {
        try {
            Connection conexaoRecebida = Conexao.getInstance();


            String sql = "DELETE FROM Garcom WHERE codGarcom = ?";

            PreparedStatement stmt = conexaoRecebida.prepareStatement(sql);

            stmt.setInt(1, codigoGarcom);

            stmt.execute();
            stmt.close();

        }
        catch(Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao buscar Garçom pelo codigo!");
        }
    }

    public static Garcom RelatorioMesaGarcomAtende (){
        try {
            Connection conexaoRecebida = Conexao.getInstance();
            String sql = "SELECT * FROM Garcom";

            PreparedStatement stmt = conexaoRecebida.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next() == true) {

                List<Mesa> mesa = MesaDao.buscaMesas();

                Scanner sc = new Scanner(System.in);
                System.out.println("\n\nDigite o código do garçom : ");
                int cod = sc.nextInt();

                for (int i = 0; i < mesa.size(); i++) {
                    Mesa mesaEncontrada = mesa.get(i);
                    if (mesaEncontrada.getGarcomResponsavelMesa().getCodigoGarcom() == cod) {
                        System.out.println("\n\nNúmero da mesa : " + mesaEncontrada.getNumeroMesa());
                        System.out.println("Status da mesa : " + mesaEncontrada.getStatusMesa());
                        System.out.println("Código Garçom : " + mesaEncontrada.getGarcomResponsavelMesa().getCodigoGarcom());
                        System.out.println("Nome do Garçom : " + mesaEncontrada.getGarcomResponsavelMesa().getNomeGarcom());
                    }
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao buscar buscar Garçom!");
        }
        return null;
    }

}
