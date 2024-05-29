package provaA3.Beans;

import provaA3.ConexaoBD.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MesaDao {


    public static void criarMesa() {

    Scanner lerDadosMesa = new Scanner(System.in);
    System.out.println("Digite o codigo do garçom responsável pela mesa : ");
    int codGarcom = lerDadosMesa.nextInt();

    Garcom garcomEncontrado = GarcomDao.buscaGarcomPeloCodigo(codGarcom);
    if (garcomEncontrado == null) {
        System.out.println("\n\nNão foi encontrado este codigo do Garçom ! ");
        return;
    }

    System.out.println("Digite o número da Mesa : ");
    int numeroMesa = lerDadosMesa.nextInt();

    System.out.println("Digite quantos assentos terá : ");
    int capacidadeClientes = lerDadosMesa.nextInt();

    System.out.println("Digite o status da Mesa : ");
    String statusMesa = lerDadosMesa.next();

    Mesa mesa = new Mesa(numeroMesa, capacidadeClientes, statusMesa, garcomEncontrado);

    gravaMesaCriada(mesa);

    System.out.println("\nMesa criada!");

    }

    public static void gravaMesaCriada(Mesa mesa) {

        try {
            Connection conexaoRecebida = Conexao.getInstance();

            String sql = "INSERT INTO Mesa (numeroMesa, capacidade, statusMesa, GarcomResponsavelMesa) VALUES (?, ?, ?, ?)";

            PreparedStatement stmt = conexaoRecebida.prepareStatement(sql);

            stmt.setInt(1, mesa.getNumeroMesa());
            stmt.setInt(2, mesa.getCapacidadeClientes());
            stmt.setString(3, mesa.getStatusMesa());
            stmt.setInt(4, mesa.getGarcomResponsavelMesa().getCodigoGarcom());

            stmt.execute();
            stmt.close();

        }
        catch(Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao gravar mesa ! ");
        }
    }

    public static void removeMesa(int numeroMesa) {
        try {
            Connection conexaoRecebida = Conexao.getInstance();


            String sql = "DELETE FROM Mesa WHERE numeroMesa = ?";

            PreparedStatement stmt = conexaoRecebida.prepareStatement(sql);

            stmt.setInt(1, numeroMesa);

            stmt.execute();
            stmt.close();

        }
        catch(Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao remover Mesa!");
        }
    }

    public static ArrayList<Mesa> buscaMesas() {
        ArrayList <Mesa> vetorMesas = new ArrayList<Mesa>();
        try {
            Connection conexaoRecebida = Conexao.getInstance();
            String sql = "SELECT * FROM Mesa";

            PreparedStatement stmt = conexaoRecebida.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next() == true) {

                int numeroMesa = rs.getInt("numeroMesa");
                int capacidadeClientes = rs.getInt("capacidade");
                String statusMesa = rs.getString("statusMesa");
                int garcom = rs.getInt("garcomResponsavelMesa");
                Garcom garc = GarcomDao.buscaGarcomPeloCodigo(garcom);

                Mesa mesa = new Mesa (numeroMesa, capacidadeClientes, statusMesa, garc );
                vetorMesas.add(mesa);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao buscar buscar Mesa!");
        }
        return vetorMesas;
    }

    public static Mesa buscarMesaPeloNumero(int numeroBuscado){
        Mesa mesaEncontrada = null;
        try {
            Connection conexaoRecebida = Conexao.getInstance();
            String sql = "SELECT * FROM Mesa WHERE numeroMesa = ?";
            PreparedStatement stmt = conexaoRecebida.prepareStatement(sql);

            stmt.setInt(1, numeroBuscado);

            ResultSet rs = stmt.executeQuery();

            boolean retorno = rs.next();

            if (retorno == true) {

                int numeroMesa = rs.getInt("numeroMesa");
                int capacidadeClientes = rs.getInt("capacidade");
                String status = rs.getString("statusMesa");
                int garcom = rs.getInt("garcomResponsavelMesa");
                Garcom garc = GarcomDao.buscaGarcomPeloCodigo(garcom);

                mesaEncontrada = new Mesa(numeroMesa, capacidadeClientes, status, garc);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
            System.out.println("\nErro ao buscar mesa pelo número!");
        }
        return mesaEncontrada;
    }

    public static Mesa buscarMesaPelosAssentos(int assentosMesa){

        Mesa mesaPorAssentos = null;
        try {
            Connection conexaoRecebida = Conexao.getInstance();
            String sql = "SELECT * FROM Mesa WHERE capacidade = ?";
            PreparedStatement stmt = conexaoRecebida.prepareStatement(sql);

            stmt.setInt(1, assentosMesa);

            ResultSet rs = stmt.executeQuery();

            boolean retorno = rs.next();

            if (retorno == true) {

                int numeroMesa = rs.getInt("numeroMesa");
                int capacidadeClientes = rs.getInt("capacidade");
                String status = rs.getString("statusMesa");
                int garcom = rs.getInt("garcomResponsavelMesa");
                Garcom garc = GarcomDao.buscaGarcomPeloCodigo(garcom);

                mesaPorAssentos = new Mesa(numeroMesa, capacidadeClientes, status, garc);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
            System.out.println("\nErro ao buscar mesa por assentos!");
        }
        return mesaPorAssentos;
    }

    public static Mesa buscaMesasOcupadas(String ocupada){
        try {
            Connection conexaoRecebida = Conexao.getInstance();
            String sql = "SELECT * FROM Mesa WHERE statusMesa = ?";

            PreparedStatement stmt = conexaoRecebida.prepareStatement(sql);
            stmt.setString(1, ocupada);
            ResultSet rs = stmt.executeQuery();

            while (rs.next() == true) {

                List<Mesa> mesaOcup = MesaDao.buscaMesas();
                for (int i = 0; i < mesaOcup.size(); i++) {
                    Mesa mesaEncontrada = mesaOcup.get(i);

                    if (mesaEncontrada.getStatusMesa().equalsIgnoreCase("Ocupada")) {

                        System.out.println("\n\nNumero de mesa: " + mesaEncontrada.getNumeroMesa());
                        System.out.println("Assentos : " + mesaEncontrada.getCapacidadeClientes());
                        System.out.println("Situção de mesa : " + mesaEncontrada.getStatusMesa());
                        System.out.println("Garçom responsável por mesa : " + mesaEncontrada.getGarcomResponsavelMesa().getNomeGarcom());

                    }
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao buscar buscar Mesa Ocupada!");
        }
        return null;
    }


    public static Mesa buscaMesasLivres(String livre){
        try {
            Connection conexaoRecebida = Conexao.getInstance();
            String sql = "SELECT * FROM Mesa WHERE statusMesa = ?";

            PreparedStatement stmt = conexaoRecebida.prepareStatement(sql);
            stmt.setString(1, livre);
            ResultSet rs = stmt.executeQuery();

            while (rs.next() == true) {

                List<Mesa> mesaLiv = MesaDao.buscaMesas();
                for (int i = 0; i < mesaLiv.size(); i++) {
                    Mesa mesaEncontrada = mesaLiv.get(i);

                    if (mesaEncontrada.getStatusMesa().equalsIgnoreCase("Livre")) {

                        System.out.println("\n\nNumero de mesa: " + mesaEncontrada.getNumeroMesa());
                        System.out.println("Assentos : " + mesaEncontrada.getCapacidadeClientes());
                        System.out.println("Situção de mesa : " + mesaEncontrada.getStatusMesa());
                        System.out.println("Garçom responsável por mesa : " + mesaEncontrada.getGarcomResponsavelMesa().getNomeGarcom());

                    }
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao buscar buscar Mesa Livre!");
        }
        return null;
    }

    public static Mesa buscaMesasReservadas(String reservada){
        try {
            Connection conexaoRecebida = Conexao.getInstance();
            String sql = "SELECT * FROM Mesa WHERE statusMesa = ?";

            PreparedStatement stmt = conexaoRecebida.prepareStatement(sql);
            stmt.setString(1, reservada);
            ResultSet rs = stmt.executeQuery();

            while (rs.next() == true) {

                List<Mesa> mesaRes = MesaDao.buscaMesas();
                for (int i = 0; i < mesaRes.size(); i++) {
                    Mesa mesaEncontrada = mesaRes.get(i);

                    if (mesaEncontrada.getStatusMesa().equalsIgnoreCase("Reservada")) {

                        System.out.println("\n\nNumero de mesa: " + mesaEncontrada.getNumeroMesa());
                        System.out.println("Assentos : " + mesaEncontrada.getCapacidadeClientes());
                        System.out.println("Situção de mesa : " + mesaEncontrada.getStatusMesa());
                        System.out.println("Garçom responsável por mesa : " + mesaEncontrada.getGarcomResponsavelMesa().getNomeGarcom());

                    }
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao buscar buscar Mesa Reservada!");
        }
        return null;
    }

}
