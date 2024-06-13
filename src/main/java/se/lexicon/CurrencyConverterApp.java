package se.lexicon;

import java.util.Scanner;

public class CurrencyConverterApp {

    static final double SEK_TO_USD_RATE = 0.097851038;
    static final double USD_TO_SEK_RATE = 10.2189;
    static final double SEK_TO_EURO_RATE = 0.089541932;
    static final double EURO_TO_SEK_RATE = 11.1680;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            performOperations(choice, scanner);
        } while (choice != 0);
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("Currency Converter App");
        System.out.println("1. Convert SEK to USD");
        System.out.println("2. Convert USD to SEK");
        System.out.println("3. Convert SEK to Euro");
        System.out.println("4. Convert Euro to SEK");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void performOperations(int operationNumber, Scanner scanner) {
        double usdAmount, sekAmount, euroAmount;

        switch (operationNumber) {
            case 1:
                sekAmount = getAmount("SEK", scanner);
                usdAmount = convertSekToUsd(sekAmount);
                displayConversionResult(sekAmount, usdAmount, "SEK", "USD");
                break;
            case 2:
                usdAmount = getAmount("USD", scanner);
                sekAmount = convertUsdToSek(usdAmount);
                displayConversionResult(usdAmount, sekAmount, "USD", "SEK");
                break;
            case 3:
                sekAmount = getAmount("SEK", scanner);
                euroAmount = convertSekToEuro(sekAmount);
                displayConversionResult(sekAmount, euroAmount, "SEK", "Euro");
                break;
            case 4:
                euroAmount = getAmount("Euro", scanner);
                sekAmount = convertEuroToSek(euroAmount);
                displayConversionResult(euroAmount, sekAmount, "Euro", "SEK");
                break;
            case 0:
                System.out.println("Exiting the currency converter app. Goodbye.");
                break;
            default:
                System.out.println("Invalid choice. Please enter a valid option.");
        }
    }

    private static double getAmount(String currency, Scanner scanner) {
        System.out.print("Enter amount in " + currency + ": ");
        return scanner.nextDouble();
    }

    private static void displayConversionResult(double fromAmount, double toAmount, String fromCurrency, String toCurrency) {
        System.out.println(fromAmount + " " + fromCurrency + " is equal to " + toAmount + " " + toCurrency + ".");
    }

    private static double convertSekToUsd(double sekAmount) {
        return sekAmount * SEK_TO_USD_RATE;
    }

    private static double convertUsdToSek(double usdAmount) {
        return usdAmount * USD_TO_SEK_RATE;
    }

    private static double convertSekToEuro(double sekAmount) {
        return sekAmount * SEK_TO_EURO_RATE;
    }

    private static double convertEuroToSek(double euroAmount) {
        return euroAmount * EURO_TO_SEK_RATE;
    }
}
