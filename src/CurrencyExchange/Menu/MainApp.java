package CurrencyExchange.Menu;

import CurrencyExchange.Exchange.ExchangeHistory;
import CurrencyExchange.Exchange.UserInterface;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Класс представляет главное меню приложения обмена валюты.
 */
public class MainApp {

  private static final ExchangeHistory exchangeHistory = new ExchangeHistory();

  /**
   * Метод для выполнения опции обмена валюты.
   */
  private static void exchangeCurrencyOption() {
    Scanner scanner = new Scanner(System.in);

    // Ввод данных от пользователя
    System.out.print("Введите сумму для обмена: ");
    double amount = scanner.nextDouble();

    System.out.print("Введите валюту для обмена (USD, EUR, GBP, MDL, RON, UAH): ");
    String fromCurrency = scanner.next().toUpperCase();

    System.out.print("Введите валюту, которую хотите приобрести (USD, EUR, GBP, MDL, RON, UAH): ");
    String toCurrency = scanner.next().toUpperCase();

    // Вызов метода обмена в CurrencyExchange.Exchange.ExchangeHistory и сохранение результата
    double result = UserInterface.exchangeCurrency(amount, fromCurrency, toCurrency);
    exchangeHistory.saveExchange(amount, fromCurrency, toCurrency);
    // Вывод результата
    if (result != -1) {
      System.out.printf("%.2f %s равно %.2f %s%n", amount, fromCurrency, result, toCurrency);
    }
  }

  /**
   * Метод отображения главного меню.
   */
  public void display() {
    System.out.println("Главное меню:");
    System.out.println("1. Обмен валюты");
    System.out.println("2. История обменов");
    System.out.println("3. Выход");
    System.out.print("Выберите опцию: ");
  }

  /**
   * Метод запуска главного меню приложения.
   */
  public void runMainMenu() {
    while (true) {
      try {
        display();
        Scanner scanner = new Scanner(System.in);

        int choice = scanner.nextInt();
        System.out.println("Выбор: " + choice);

        switch (choice) {
          case 1:
            exchangeCurrencyOption();
            break;
          case 2:
            exchangeHistory.viewHistory();
            break;
          case 3:
            System.out.println("Выход из программы. До свидания!");
            System.exit(0);
          default:
            System.out.println("Неверный выбор. Пожалуйста, выберите снова.");
        }
      } catch (InputMismatchException e) {
        System.out.println("Ошибка ввода. Пожалуйста, введите корректное значение.");
      }
    }
  }
}