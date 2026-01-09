import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Conexao conexao = new Conexao();
        Scanner scanner = new Scanner(System.in);

        String API_KEY = "8957fbe1af4729686c37ea77";
        String url;

        double valor;
        double taxa;
        double valorConvertido;

        int opc = 0;

        while (opc != 7) {
            System.out.println("*******************************************************");
            System.out.println("Seja bem vindo ao Conversor de Moedas!\n");
            System.out.println("1) Dólar -> Peso Argentino");
            System.out.println("2) Peso Argentino -> Dólar");
            System.out.println("3) Dólar -> Real Brasileiro");
            System.out.println("4) Real Brasileiro -> Dólar");
            System.out.println("5) Dólar -> Peso Colombiano");
            System.out.println("6) Peso Colombiano -> Dólar");
            System.out.println("7) Sair");
            System.out.print("Escolha uma opção válida: ");

            opc = scanner.nextInt();

            if (opc == 7) {
                System.out.println("Encerrando o programa...");
                break;
            }

            switch (opc) {

                case 1:
                    System.out.print("\nDigite o valor que deseja converter: ");
                    valor = scanner.nextDouble();

                    url = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/USD/ARS";
                    taxa = conexao.getTaxaDeConversao(url);

                    if (taxa < 0) {
                        System.out.println("Erro ao obter a taxa de conversão.");
                        break;
                    }

                    valorConvertido = valor * taxa;
                    System.out.printf(
                            "Valor %.2f [USD] corresponde ao valor de %.2f [ARS]%n",
                            valor, valorConvertido
                    );
                    break;

                case 2:
                    System.out.print("\nDigite o valor que deseja converter: ");
                    valor = scanner.nextDouble();

                    url = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/ARS/USD";
                    taxa = conexao.getTaxaDeConversao(url);

                    if (taxa < 0) {
                        System.out.println("Erro ao obter a taxa de conversão.");
                        break;
                    }

                    valorConvertido = valor * taxa;
                    System.out.printf(
                            "Valor %.2f [ARS] corresponde ao valor de %.2f [USD]%n",
                            valor, valorConvertido
                    );
                    break;

                case 3:
                    System.out.print("\nDigite o valor que deseja converter: ");
                    valor = scanner.nextDouble();

                    url = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/USD/BRL";
                    taxa = conexao.getTaxaDeConversao(url);

                    if (taxa < 0) {
                        System.out.println("Erro ao obter a taxa de conversão.");
                        break;
                    }

                    valorConvertido = valor * taxa;
                    System.out.printf(
                            "Valor %.2f [USD] corresponde ao valor de %.2f [BRL]%n",
                            valor, valorConvertido
                    );
                    break;

                case 4:
                    System.out.print("\nDigite o valor que deseja converter: ");
                    valor = scanner.nextDouble();

                    url = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/BRL/USD";
                    taxa = conexao.getTaxaDeConversao(url);

                    if (taxa < 0) {
                        System.out.println("Erro ao obter a taxa de conversão.");
                        break;
                    }

                    valorConvertido = valor * taxa;
                    System.out.printf(
                            "Valor %.2f [BRL] corresponde ao valor de %.2f [USD]%n",
                            valor, valorConvertido
                    );
                    break;

                case 5:
                    System.out.print("\nDigite o valor que deseja converter: ");
                    valor = scanner.nextDouble();

                    url = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/USD/COP";
                    taxa = conexao.getTaxaDeConversao(url);

                    if (taxa < 0) {
                        System.out.println("Erro ao obter a taxa de conversão.");
                        break;
                    }

                    valorConvertido = valor * taxa;
                    System.out.printf(
                            "Valor %.2f [USD] corresponde ao valor de %.2f [COP]%n",
                            valor, valorConvertido
                    );
                    break;

                case 6:
                    System.out.print("\nDigite o valor que deseja converter: ");
                    valor = scanner.nextDouble();

                    url = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/COP/USD";
                    taxa = conexao.getTaxaDeConversao(url);

                    if (taxa < 0) {
                        System.out.println("Erro ao obter a taxa de conversão.");
                        break;
                    }

                    valorConvertido = valor * taxa;
                    System.out.printf(
                            "Valor %.2f [COP] corresponde ao valor de %.2f [USD]%n",
                            valor, valorConvertido
                    );
                    break;

                default:
                    System.out.println("Opção inválida. Escolha uma opção entre 1 e 7.");
            }

            System.out.println();
        }

        scanner.close();
    }
}
