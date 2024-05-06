import java.io.IOException;
import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int option;
        do {
            System.out.println("***** Seja bem-vindo ao conversor de moeda *****");
            //System.out.println("Selecione uma opção:");
            System.out.println("1. Dólar USD >>> Peso Argentino ARS");
            System.out.println("2. Peso Argentino ARS >>> para Dólar USD");
            System.out.println("3. Dólar USD >>> Real BRL");
            System.out.println("4. Real BRL >>> Dólar USD");
            System.out.println("5. Dólar USD >>> Peso Colombiano COP");
            System.out.println("6. Peso Colombiano COP >>> Dólar USD");
            System.out.println("0. Sair");
            System.out.print("Selecione uma opção: ");


            option = scanner.nextInt();

            switch (option) {
                case 1:
                    convertCurrency("USD", "ARS");
                    break;
                case 2:
                    convertCurrency("ARS", "USD");
                    break;
                case 3:
                    convertCurrency("USD", "BRL");
                    break;
                case 4:
                    convertCurrency("BRL", "USD");
                    break;
                case 5:
                    convertCurrency("USD", "COP");
                    break;
                case 6:
                    convertCurrency("COP", "USD");
                    break;
                case 0:
                    System.out.println("*********** Até uma próxima cotação! ***********");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

            System.out.println();
        } while (option != 0);

        scanner.close();
    }

    private static void convertCurrency(String baseCurrency, String targetCurrency) {
        try {
            double exchangeRate = ExchangeRateAPI.getExchangeRate(baseCurrency, targetCurrency);
            System.out.print("Informe o valor em " + baseCurrency + ": ");
            Scanner scanner = new Scanner(System.in);
            double amount = scanner.nextDouble();

            double convertedAmount = amount * exchangeRate;
            System.out.println(amount + " " + baseCurrency + " = " + convertedAmount + " " + targetCurrency);
        } catch (IOException e) {
            System.out.println("Erro ao obter a cotação: " + e.getMessage());
        }
    }
}
