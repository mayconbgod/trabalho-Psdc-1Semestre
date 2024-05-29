package provaA3.ConexaoBD;

import java.sql.*;

public class Conexao {
    private static Connection conexao = null;
    private String fonte = "Sistema";

    private Conexao() {

        try {
            conexao = DriverManager.getConnection("jdbc:MySQL://localhost:3306/" + fonte, "root", "S589820x");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ocorreu um erro na conexao com o banco de dados!!!");
        }
    }

    public static Connection getInstance() {
        if (conexao == null) {
            new Conexao();
        }
        return conexao;
    }

    public static void main(String[] args) {
        Connection instance = getInstance();
        System.out.println(instance);
    }
}
