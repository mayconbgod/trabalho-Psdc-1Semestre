package provaA3.Visao;

import provaA3.Beans.Garcom;
import provaA3.Beans.Mesa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class TelaSistemaPrincipal {

    //COMPONENTES DO GRUPO:
    //Maycon Douglas Silva Bezerra RA: 202220869
    //João Pedro Castro Lima RA: 202217893
    //Henrique Oliveira Gobi RA: 202220731
    //Marcos Gabriel Silva sousa RA: 202218879

    private static ArrayList<Garcom> BD_Garcom = new ArrayList<>();
    private static ArrayList<Mesa> BD_Mesa = new ArrayList<>();

    public static void main(String[] args) {

        mostraMenuPrincipal();
        Scanner sc = new Scanner(System.in);
        int opcao = sc.nextInt();

        while (opcao != 11) {
            switch (opcao) {
                case 1: {
                    Scanner criar = new Scanner(System.in);
                    criarGarcom();

                    System.out.println("\nDeseja cadastrar outro garçom? Sim ou Não");
                    String entrada = criar.next();
                    while (entrada.equalsIgnoreCase("Sim")) {
                        criarGarcom();
                        System.out.println("\nDeseja cadastrar outro garçom? Sim ou Não");
                        entrada = criar.next();
                    }
                    break;
                }

                case 2: {
                    Scanner remove = new Scanner(System.in);
                    System.out.println("\nInforme o codigo do garçom a ser removido :");
                    int codigoGarcom = remove.nextInt();
                    removeGarcom(codigoGarcom);
                    break;
                }

                case 3: {
                    Scanner procurar = new Scanner(System.in);
                    System.out.println("\nDigite o codigo do garçom que deseja encontrar :");
                    int garcomBuscado = procurar.nextInt();

                    Garcom garcomEncontrado = buscarGarcomPeloCod(garcomBuscado);
                    if (garcomEncontrado == null) {
                        System.out.println("\n\nNão foi encontrado um garçom com esse codigo!");
                    }
                    else {
                        System.out.println("\n\nCPF do garçom: " + garcomEncontrado.getCpfGarcom());
                        System.out.println("codigo do garçom : " + garcomEncontrado.getCodigoGarcom());
                        System.out.println("nome do garçom : " + garcomEncontrado.getNomeGarcom());
                        System.out.println("sexo do garçom : " + garcomEncontrado.getSexoGarcom());
                        System.out.println("o salário do garçom : " + garcomEncontrado.getSalario());
                    }
                    break;
                }
                case 4: {
                    Scanner procurar = new Scanner(System.in);
                    System.out.println("\nDigite o email do garçom que deseja encontrar :");
                    String garcomBuscado = procurar.next();

                    Garcom garcomEncontrado = buscarGarcomPeloEmail(garcomBuscado);
                    if (garcomEncontrado == null) {
                        System.out.println("\n\nNão foi encontrado um garçom com esse email!");
                    }
                    else {
                        System.out.println("\n\nCPF do garçom: " + garcomEncontrado.getCpfGarcom());
                        System.out.println("email do garçom : " + garcomEncontrado.getEmailGarcom());
                        System.out.println("nome do garçom : " + garcomEncontrado.getNomeGarcom());
                        System.out.println("sexo do garçom : " + garcomEncontrado.getSexoGarcom());
                        System.out.println("o salário do garçom : " + garcomEncontrado.getSalario());
                    }
                    break;
                }

                case 5: {
                    mostraMenuRelatorioGarcom();
                    Scanner doMenuGarcom = new Scanner(System.in);
                    int garcons = doMenuGarcom.nextInt();

                    switch (garcons) {
                        case 1: {
                            List<Garcom> vetorGarcons = buscaGarcons();
                            if (BD_Garcom.size() == 0) {
                                System.out.println("\nCadastre pelo menos um garçom !!");
                                break;
                            }
                            else {
                            for (int i = 0; i < vetorGarcons.size(); i++) {
                                Garcom garcom = vetorGarcons.get(i);
                                System.out.println("\n\n codigo : " + garcom.getCodigoGarcom());
                                System.out.println(" nome : " + garcom.getNomeGarcom());
                                System.out.println(" CPF : " + garcom.getCpfGarcom());
                                System.out.println(" email : " + garcom.getEmailGarcom());
                                System.out.println(" sexo : " + garcom.getSexoGarcom());
                                System.out.println(" data de nascimento : " + garcom.getDtNascimentoGarcom());
                                System.out.println(" telefone : " + garcom.getTelefoneGarcom());
                                System.out.println(" salário  : " + garcom.getSalario());
                            }
                            break; }
                        }

                        case 2: {
                            if (BD_Garcom.size() == 0) {
                                System.out.println("\nCadastre pelo menos um garçom " + "\nE também uma Mesa !!");
                                break;
                            }
                            else {
                            System.out.println("\nDigite o código do Garçom:");
                            int codigoGarcom = doMenuGarcom.nextInt();

                            for (int i = 0; i < BD_Mesa.size(); i++) {
                                Mesa vetMesas = BD_Mesa.get(i);
                                if (vetMesas.getGarcomResponsavelMesa().getCodigoGarcom() == codigoGarcom) {
                                    System.out.println("\n\nNúmero da mesa : " + vetMesas.getNumeroMesa());
                                    System.out.println("Status da mesa : " + vetMesas.getStatusMesa());
                                    System.out.println("Código Garçom : " + vetMesas.getGarcomResponsavelMesa().getCodigoGarcom());
                                    System.out.println("Nome do Garçom : " + vetMesas.getGarcomResponsavelMesa().getNomeGarcom());
                                }
                            }
                            break; }
                        }
                    }
                    break;
                }

                case 6: {
                    Scanner criar = new Scanner(System.in);
                    criarMesa();
                    if (BD_Garcom.size() == 0) {
                        System.out.println("\nCadastre pelo menos um garçom ");
                        break;
                    }

                    System.out.println("\nDeseja cadastrar outra mesa ? Sim ou Não");
                    String entrada = criar.next();
                    while (entrada.equalsIgnoreCase("Sim")) {
                        criarMesa();
                        System.out.println("\nDeseja cadastrar outra Mesa? Sim ou Não");
                        entrada = criar.next();
                    }
                    break;
                }

                case 7: {
                    Scanner remove = new Scanner(System.in);
                    System.out.println("Informe o numero da mesa a ser removido :");
                    int numeroMesa = remove.nextInt();
                    removeMesa(numeroMesa);
                    System.out.println("\nDeseja remover outra mesa ? Sim ou Não");
                    String entrada = remove.next();
                    break;
                }

                case 8: {
                    Scanner busca = new Scanner(System.in);

                    System.out.println("\nDigite o número da mesa que deseja encontrar :");
                    int numeroMesa = busca.nextInt();

                    Mesa mesaEncontrada = buscarMesaPeloNumero(numeroMesa);
                    if (mesaEncontrada == null) {
                        System.out.println("\n\nNão foi encontrada uma mesa com esse numero!");
                    } else {
                        System.out.println("\n\nNumero de mesa: " + mesaEncontrada.getNumeroMesa());
                        System.out.println("Assentos : " + mesaEncontrada.getCapacidadeClientes());
                        System.out.println("Situção de mesa : " + mesaEncontrada.getStatusMesa());
                        System.out.println("Garçom responsável por mesa : " + mesaEncontrada.getGarcomResponsavelMesa().getNomeGarcom());
                    }
                    break;
                }

                case 9: {
                    Scanner buscaPeloNumero = new Scanner(System.in);
                    System.out.println("\nInforme a quantidade de assentos desejados: ");
                    int assentos = buscaPeloNumero.nextInt();

                    Mesa mesaPorAssentos = buscarMesaPelosAssentos(assentos);
                    if (mesaPorAssentos == null) {
                        System.out.println("\n\n Não foi possivel encontrar uma mesa com essa quantidade de assentos!");
                    } else {
                        System.out.println("\n\nNumero de mesa: " + mesaPorAssentos.getNumeroMesa());
                        System.out.println("Assentos : " + mesaPorAssentos.getCapacidadeClientes());
                        System.out.println("Situção de mesa : " + mesaPorAssentos.getStatusMesa());
                        System.out.println("Garçom responsável por mesa : " + mesaPorAssentos.getGarcomResponsavelMesa().getNomeGarcom());
                    }
                    break;
                }

                case 10: {
                    mostraMenuRelatorioMesa();
                    Scanner doMenuMesa = new Scanner(System.in);
                    int mesas = doMenuMesa.nextInt();

                    switch (mesas) {
                        case 1: {
                            for (int i = 0; i < BD_Mesa.size(); i++) {
                                Mesa mesaOcup = BD_Mesa.get(i);
                                if (mesaOcup == null) {

                                    System.out.println("\n\n Não foi possivel encontrar mesas ocupadas!");

                                } if (mesaOcup.getStatusMesa().equalsIgnoreCase("Ocupada")) {

                                    System.out.println("\n\nNumero de mesa: " + mesaOcup.getNumeroMesa());
                                    System.out.println("Assentos : " + mesaOcup.getCapacidadeClientes());
                                    System.out.println("Situção de mesa : " + mesaOcup.getStatusMesa());
                                    System.out.println("Garçom responsável por mesa : " + mesaOcup.getGarcomResponsavelMesa().getNomeGarcom());
                                }
                            }
                            break;
                        }
                        case 2: {
                            for (int i = 0; i < BD_Mesa.size(); i++) {
                                Mesa mesaRes = BD_Mesa.get(i);
                                if (mesaRes == null) {

                                    System.out.println("\n\n Não foi possivel encontrar mesas ocupadas!");

                                } if (mesaRes.getStatusMesa().equalsIgnoreCase("Reservada")) {

                                    System.out.println("\n\nNumero de mesa: " + mesaRes.getNumeroMesa());
                                    System.out.println("Assentos : " + mesaRes.getCapacidadeClientes());
                                    System.out.println("Situção de mesa : " + mesaRes.getStatusMesa());
                                    System.out.println("Garçom responsável por mesa : " + mesaRes.getGarcomResponsavelMesa().getNomeGarcom());
                                }
                            }
                            break;
                        }

                        case 3: {
                            for (int i = 0; i < BD_Mesa.size(); i++) {
                                Mesa mesaLiv = BD_Mesa.get(i);
                                if (mesaLiv == null) {

                                    System.out.println("\n\n Não foi possivel encontrar mesas ocupadas!");

                                } if (mesaLiv.getStatusMesa().equalsIgnoreCase("Livre")) {

                                    System.out.println("\n\nNumero de mesa: " + mesaLiv.getNumeroMesa());
                                    System.out.println("Assentos : " + mesaLiv.getCapacidadeClientes());
                                    System.out.println("Situção de mesa : " + mesaLiv.getStatusMesa());
                                    System.out.println("Garçom responsável por mesa : " + mesaLiv.getGarcomResponsavelMesa().getNomeGarcom());
                                }
                            }
                            break;
                        }

                        case 4:{
                            List <Mesa> vetMesas = buscaMesas();

                            for (int i = 0; i < vetMesas.size(); i++) {
                                Mesa mesa = vetMesas.get(i);
                                System.out.println("\n\nNumero de mesa: " + mesa.getNumeroMesa());
                                System.out.println("Assentos : " + mesa.getCapacidadeClientes());
                                System.out.println("Situção de mesa : " + mesa.getStatusMesa());
                                System.out.println("Garçom responsável por mesa : " + mesa.getGarcomResponsavelMesa().getNomeGarcom());
                            }
                            break;
                        }
                    }
                    break;
                }
                case 11: {
                    System.out.println("\n\nVocê saiu do programa :D");
                    return;
                }
                default:{
                    System.out.println("Entrada inválida!");
                    break;
                }
            }

            mostraMenuPrincipal();
            sc = new Scanner(System.in);
            opcao = sc.nextInt();

        }
    }
    public static void  criarGarcom() {
        Scanner lerDadosGarcom = new Scanner(System.in);

        System.out.println("Digite codigo garçom : ");
        int codGarcom = lerDadosGarcom.nextInt();

        for (int i = 0; i < BD_Garcom.size(); i++) {
            Garcom garcomNoVetor = BD_Garcom.get(i);

            if (codGarcom == garcomNoVetor.getCodigoGarcom()) {
                System.out.println("\n\nGarçom já Cadastrado !!");
                System.out.println("Cadastre com outro código : ");
                return;
            }
        }

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
        BD_Garcom.add(garcom);
        gravaGarcomCriado(garcom);

        System.out.println("\nGarçom criado!");
    }

    private static void gravaGarcomCriado(Garcom garcom) {
        try {
            BD_Garcom.add(garcom);
        }
        catch(Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao gravar garçom ! ");
        }
    }

    private static void removeGarcom (int codigoGarcom) {
        try {
            for (int i = 0; i < BD_Garcom.size(); i++) {
                Garcom garcomAtualNoVetor = BD_Garcom.get(i);
                if (garcomAtualNoVetor.getCodigoGarcom() == codigoGarcom) {
                    BD_Garcom.remove(i);
                    System.out.println("Garçom removido do Banco de dados !!");
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao buscar Garçom pelo codigo!");
        }
    }

    private static Garcom buscarGarcomPeloCod (int codGarcomBuscado){
        Garcom garcomEncontrado = null;
        try {
            for(int i=0; i < BD_Garcom.size(); i++) {

                Garcom garcomAtualNoVetor = BD_Garcom.get(i);

                if(garcomAtualNoVetor.getCodigoGarcom() == codGarcomBuscado) {
                    garcomEncontrado = BD_Garcom.get(i);
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
            System.out.println("\nErro ao buscar garçom pelo codigo!");
        }
        return garcomEncontrado;
    }

    private static Garcom buscarGarcomPeloEmail (String emailGarcomBuscado){
        Garcom garcomEncontrado = null;
        try {
            for(int i=0; i < BD_Garcom.size(); i++) {

                Garcom garcomAtualNoVetor = BD_Garcom.get(i);

                if(garcomAtualNoVetor.getEmailGarcom().equals(emailGarcomBuscado)) {
                    garcomEncontrado = BD_Garcom.get(i);
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
            System.out.println("\nErro ao buscar garçom pelo email!");
        }
        return garcomEncontrado;
    }

    private static ArrayList <Garcom> buscaGarcons() {
        return BD_Garcom;
    }

    public static void criarMesa() {

        Scanner lerDadosMesa = new Scanner(System.in);
        System.out.println("Digite o codigo do garçom responsável pela mesa : ");
        int codGarcom = lerDadosMesa.nextInt();

        Garcom garcomEncontrado = buscarGarcomPeloCod(codGarcom);
        if (garcomEncontrado == null) {
            System.out.println("\n\nNão foi encontrado este codigo do Garçom ! ");
            return;
        }

        System.out.println("Digite o número da Mesa : ");
        int numeroMesa = lerDadosMesa.nextInt();

        for (int i = 0; i < BD_Mesa.size(); i++) {
            Mesa mesavetor = BD_Mesa.get(i);

            if (numeroMesa == mesavetor.getNumeroMesa()) {
                System.out.println("\n\nMesa já Cadastrada !!");
                System.out.println("Cadastre com outro número : ");
                return;
            }
        }
            System.out.println("Digite quantos assentos terá : ");
            int capacidadeClientes = lerDadosMesa.nextInt();

            System.out.println("Digite o status da Mesa : ");
            String statusMesa = lerDadosMesa.next();

            Mesa mesa = new Mesa(numeroMesa, capacidadeClientes, statusMesa, garcomEncontrado);

            gravaMesaCriada(mesa);

            System.out.println("\nMesa criada!");

    }

    private static void gravaMesaCriada(Mesa mesa) {

        try {
            BD_Mesa.add(mesa);
        }
        catch(Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao gravar mesa ! ");
        }
    }

    private static void removeMesa(int numeroMesa) {
        try {
            for (int i = 0; i < BD_Mesa.size(); i++) {
                Mesa mesaAtualNoVetor = BD_Mesa.get(i);
                if (mesaAtualNoVetor.getNumeroMesa() == numeroMesa) {
                    BD_Mesa.remove(i);
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao buscar Mesa pelo número ! ");
        }
    }

    private static ArrayList <Mesa> buscaMesas() {
        return BD_Mesa;
    }

    private static Mesa buscarMesaPeloNumero(int numeroMesaBuscado){
        Mesa mesaEncontrada = null;
        try {
            for(int i=0; i < BD_Mesa.size(); i++) {

                Mesa mesaAtualNoVetor = BD_Mesa.get(i);
                if(mesaAtualNoVetor.getNumeroMesa() == numeroMesaBuscado) {
                    mesaEncontrada = BD_Mesa.get(i);
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao buscar mesa pelo numero ! ");
        }
        return mesaEncontrada;
    }

    private static Mesa buscarMesaPelosAssentos(int assentosMesa){

        Mesa mesaPorAssentos = null;
        try {
            for (int i = 0; i < BD_Mesa.size(); i++) {

                Mesa mesaAtualNoVetor = BD_Mesa.get(i);
                if (mesaAtualNoVetor.getCapacidadeClientes() == assentosMesa) {
                    mesaPorAssentos = BD_Mesa.get(i);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Não há mesas com esta quantidade de assentos disponiveis ! ");
        }
        return mesaPorAssentos;
    }

    public static void mostraMenuPrincipal(){
        String menu =
                "\n\n1. Cadastro de garçom\n"
                        + "2. Remoção de garçom\n"
                        + "3. Buscar Garçom pelo codigo\n"
                        + "4. Buscar Garçom pelo email\n"
                        + "5. Relatórios de Garçons\n"
                        + "6. Cadastro de mesa\n"
                        + "7. Remoção de mesa\n"
                        + "8. Buscar mesa pelo número de mesa\n"
                        + "9. Buscar mesa pela capacidade de cliente\n"
                        + "10. Relatórios de mesas\n" //exibe todas as mesas
                        + "11. Sair MENU\n";

        System.out.println(menu);
    }
    public static void mostraMenuRelatorioGarcom(){
        String menuGarcom =
                "\n\n1. Exibir relatório de todos garçons\n"
                        + "2. Exibir relatório de todas as mesas que um garçom atende\n"
                        + "3. Voltar para o MENU principal\n";

        System.out.println(menuGarcom);
    }
    public static void mostraMenuRelatorioMesa(){
    String menuMesa =
            "\n\n1. Exibir relatório de mesas ocupadas\n"
                    + "2. Exibir relatório de mesas reservadas\n"
                    + "3. Exibir relatório de mesas livres\n"
                    + "4. Exibir relatório de todas as mesas\n"
                    + "5. Voltar para o MENU principal\n";

    System.out.println(menuMesa);
    }
}