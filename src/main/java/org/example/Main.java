package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        try {
            String url = System.getenv("DB_URL");
            String user1 = System.getenv("DB_USER");
            String password = System.getenv("DB_PASSWORD");



            Connection conexao = DriverManager.getConnection(url, user1, password);

            UserDAO dao = new UserDAO(conexao);
            pedidoDAO pdao = new pedidoDAO(conexao);

            int opcao;


            do {
                System.out.println("1 - Cadastrar usuário");
                System.out.println("2 - Listar usuários");
                System.out.println("3 - Deletar usuário");
                System.out.println("4 - Atualizar usuário");
                System.out.println("5 - Criar Pedido");
                System.out.println("0 - Sair");

                opcao = sc.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.println("Cadastrar Usuário");
                        sc.nextLine();

                        System.out.print("Nome:");
                        String nome = sc.nextLine();

                        System.out.print("Idade:");
                        int idade = sc.nextInt();

                        User user = new User(nome, idade);
                        dao.inserir(user);

                        System.out.println("Usuário Cadastrado!!");
                        break;

                    case 2:
                        System.out.println("Listar Usuários");
                        List<User> lista = dao.listar();

                        for (User u : lista) {
                            System.out.println(u.getNome() + " - " + u.getIdade());
                        }
                        break;

                    case 3:
                        System.out.print("Digite o id do usuário que você deseja deletar:");
                        int id = sc.nextInt();

                        int result = dao.deletar(id);

                        if (result > 0) {
                            System.out.println("Usuário deletado!!!");
                        } else {
                            System.out.println("Usuário não encontrado!!!!");
                        }
                        break;

                    case 4:
                        System.out.print("me informe o ID d usuário que será atualizado: ");
                        int id1 = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Me informe o novo nome: ");
                        String name = sc.nextLine();

                        System.out.print("Me informe a nova idade:");
                        int age = sc.nextInt();

                        int result1 = dao.atualizar(id1, name, age);

                        if (result1 > 0) {
                            System.out.println("Usuário atualizado com sucesso!!!");
                        } else {
                            System.out.println("Usuário não encontrado!!!");
                        }

                        break;

                    case 5:
                        System.out.print("Me informe o seu ID de usuário: ");
                        int user_id = sc.nextInt();
                        sc.nextLine();

                        System.out.println("Me informe o ID do produto que quer comprar:");
                        int pedido_id = sc.nextInt();
                        sc.nextLine();

                        System.out.println("Me informe a quantidade do produto selecionado:");
                        int quantidade = sc.nextInt();

                        Pedido pedido = new Pedido(user_id, pedido_id, quantidade);

                        int presult = pdao.inserir(pedido);


                        if (presult > 0) {
                            System.out.println("Pedido realizado com sucesso ");

                        } else {
                            System.out.println("Ocorreu um erro na hora da realização do pedido !!");
                        }
                        break;


                    case 0:
                        System.out.println("Saindo...");
                        break;

                    default:
                        System.out.println("Opção inválida");

                }


            } while (opcao != 0);
            conexao.close();

        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
        }


    }

}
