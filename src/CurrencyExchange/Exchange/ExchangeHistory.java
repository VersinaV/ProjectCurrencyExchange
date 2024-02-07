package CurrencyExchange.Exchange;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 * Класс ExchangeHistory предоставляет функциональность для сохранения и просмотра истории обмена
 * валюты. История включает дату и время обмена, сумму и типы обмениваемых валют. Для просмотра
 * истории предусмотрено консольное меню.
 */
public class ExchangeHistory {

  private final ArrayList<Exchange> exchangeHistory;
  private final File file;

  /**
   * Конструктор класса ExchangeHistory. Инициализирует список для хранения истории обмена и файл
   * для сохранения истории в файле.
   */
  public ExchangeHistory() {
    this.exchangeHistory = new ArrayList<>();
    this.file = new File("file.exchangeHistory");
  }

  public void saveExchange(double amount, String fromCurrency, String toCurrency) {
    Exchange exchange = new Exchange(amount, fromCurrency, toCurrency);
    exchangeHistory.add(exchange);
    System.out.println("Обмен сохранен в истории.");

  }

  /**
   * Метод для сохранения информации об обмене в истории.
   */
  public void viewHistory() {
    if (exchangeHistory.isEmpty()) {
      System.out.println("История обменов пуста.");
    } else {
      System.out.println("История обменов: ");
      for (Exchange exchange : exchangeHistory) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currentDate = new Date();
        String formattedDate = sdf.format(currentDate);
        String exchangeInfo = String.format("Сумма: %.2f %s обменяли в %.2f %s%n",
            exchange.getAmount(), exchange.getFromCurrency(),
            UserInterface.exchangeCurrency(exchange.getAmount(),
                exchange.getFromCurrency(), exchange.getToCurrency()),
            exchange.getToCurrency());
        System.out.println(formattedDate);
        System.out.println(exchangeInfo);

        writeToFile(exchangeInfo);
      }
    }
  }

  /**
   * Метод для просмотра истории обмена. Отображает дату, время и детали каждого обмена в консоли и
   * записывает в файл.
   */
  private String getFormattedDate() {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date currentDate = new Date();
    return sdf.format(currentDate);
  }

  /**
   * Метод для записи информации об обмене в файл.
   *
   * @param exchangeInfo Информация об обмене для записи.
   */
  private void writeToFile(String exchangeInfo) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
      String formattedDate = getFormattedDate();
      bw.write(formattedDate + " " + exchangeInfo);
      bw.newLine();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}