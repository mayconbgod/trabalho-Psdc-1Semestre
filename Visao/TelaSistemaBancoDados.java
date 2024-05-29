package provaA3.Visao;

import provaA3.Beans.Garcom;
import provaA3.Beans.GarcomDao;
import provaA3.Beans.Mesa;
import provaA3.Beans.MesaDao;

import java.util.List;
import java.util.Scanner;


public class TelaSistemaBancoDados {


    //COMPONENTES DO GRUPO:
    //Maycon Douglas Silva Bezerra RA: 202220869
    //João Pedro Castro Lima RA: 202217893
    //Henrique Oliveira Gobi RA: 202220731
    //Marcos Gabriel Silva sousa RA: 202218879

    /*
    CODIGO SQL feito no Workbench:

    create database Sistema;
    show databases;
    use Sistema;
    create table Garcom(
    codGarcom int primary key not null,
    nome VARCHAR(100),
    cpf VARCHAR(50),
    email VARCHAR(100),
    sexo VARCHAR(50),
    dtNascimento VARCHAR(50),
    telefone VARCHAR(50),
    salario int);

    create table Mesa(
    numeroMesa int primary key not null,
    capacidade int,
    statusMesa varchar(50),
    garcomResponsavelMesa int,
    foreign key (garcomResponsavelMesa) references Garcom (codGarcom));
    select database();
    show tables;
     */

    public static void main(String[] args) {

        mostraMenuPrincipal();
        Scanner sc = new Scanner(System.in);
        int opcao = sc.nextInt();

        while (opcao != 11) {
            switch (opcao) {
                case 1: {
                    Scanner criar = new Scanner(System.in);
                    GarcomDao.criarGarcom();

                    System.out.println("\nDeseja cadastrar outro garçom? Sim ou Não");
                    String entrada = criar.next();
                    while (entrada.equalsIgnoreCase("Sim")) {
                        GarcomDao.criarGarcom();
                        System.out.println("\nDeseja cadastrar outro garçom? Sim ou Não");
                        entrada = criar.next();
                    }
                    break;
                }

                case 2: {
                    Scanner remove = new Scanner(System.in);
                    System.out.println("\nInforme o codigo do garçom a ser removido :");
                    int codigoGarcom = remove.nextInt();
                    GarcomDao.removeGarcom(codigoGarcom);
                    break;
                }

                case 3: {
                    Scanner procurar = new Scanner(System.in);
                    System.out.println("\nDigite o codigo do garçom que deseja encontrar :");
                    int garcomBuscado = procurar.nextInt();

                    Garcom garcomEncontrado = GarcomDao.buscaGarcomPeloCodigo(garcomBuscado);
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

                    Garcom garcomEncontrado = GarcomDao.buscaGarcomPeloEmail(garcomBuscado);
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
                            List<Garcom> vetorGarcons = GarcomDao.buscaGarcons();
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
                                break;
                        }

                        case 2: { GarcomDao.RelatorioMesaGarcomAtende();
                            break;
                        }
                    }
                    break;
                }

                case 6: {
                    Scanner criar = new Scanner(System.in);
                    MesaDao.criarMesa();

                    System.out.println("\nDeseja cadastrar outra mesa ? Sim ou Não");
                    String entrada = criar.next();
                    while (entrada.equalsIgnoreCase("Sim")) {
                        MesaDao.criarMesa();
                        System.out.println("\nDeseja cadastrar outra Mesa? Sim ou Não");
                        entrada = criar.next();
                    }
                    break;
                }

                case 7: {
                    Scanner remove = new Scanner(System.in);
                    System.out.println("Informe o numero da mesa a ser removido :");
                    int numeroMesa = remove.nextInt();
                    MesaDao.removeMesa(numeroMesa);
                    System.out.println("\nDeseja remover outra mesa ? Sim ou Não");
                    String entrada = remove.next();
                    break;
                }

                case 8: {
                    Scanner busca = new Scanner(System.in);

                    System.out.println("\nDigite o número da mesa que deseja encontrar :");
                    int numeroMesa = busca.nextInt();

                    Mesa mesaEncontrada = MesaDao.buscarMesaPeloNumero(numeroMesa);
                    if (mesaEncontrada == null) {
                        System.out.println("\n\nNão foi encontrada uma mesa com esse numero!");
                    } else {
                        System.out.println("\n\nNumero de mesa: " + mesaEncontrada.getNumeroMesa());
                        System.out.println("Assentos : " + mesaEncontrada.getCapacidadeClientes());
                        System.out.println("Situção de mesa : " + mesaEncontrada.getStatusMesa());
                        System.out.println("Codigo Garçom responsável por mesa : " + mesaEncontrada.getGarcomResponsavelMesa().getCodigoGarcom());
                    }
                    break;
                }

                case 9: {
                    Scanner buscaPeloNumero = new Scanner(System.in);
                    System.out.println("\nInforme a quantidade de assentos desejados: ");
                    int assentos = buscaPeloNumero.nextInt();

                    Mesa mesaPorAssentos = MesaDao.buscarMesaPelosAssentos(assentos);
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
                        case 1: { String ocup = "ocupada";
                            MesaDao.buscaMesasOcupadas(ocup);
                            break;
                        }
                        case 2: { String res = "reservada";
                            MesaDao.buscaMesasReservadas(res);
                            break;
                        }

                        case 3: { String liv = "ocupada";
                            MesaDao.buscaMesasLivres(liv);
                            break;
                        }

                        case 4:{
                            List <Mesa> vetMesas = MesaDao.buscaMesas();

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