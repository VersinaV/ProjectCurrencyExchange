package CurrencyExchange.Exchange;

import java.util.HashMap;
import java.util.Map;

public class UserInterface {
    /*
Приложение должно поддерживать обмен между несколькими предопределенными типами валют (например, USD, EUR, GBP и т.д.).
Курс обмена может быть зафиксирован в коде или получен из файла.
Дополнительное задание особой сложности: получить этот курс валют из API любого онлайн обменника.
После ввода данных пользователем, приложение должно вычислить и показать результат обмена.
   */

  // Фиксированные курсы валют

  private static final Map<String, Double> exchangeRates = new HashMap<>();

  static {
    exchangeRates.put("USD", 1.0);
    exchangeRates.put("EUR", 0.85);
    exchangeRates.put("GBP", 0.74);
    exchangeRates.put("MDL", 18.24);
    exchangeRates.put("RON", 5.74);
    exchangeRates.put("UAH", 40.64);
  }

  public static double exchangeCurrency(double amount, String fromCurrency, String toCurrency) {
    if (!exchangeRates.containsKey(fromCurrency) || !exchangeRates.containsKey(toCurrency)) {
      System.out.println("Неподдерживаемая валюта");
      return -1;
    }

    double rate = exchangeRates.get(toCurrency) / exchangeRates.get(fromCurrency);
    return amount * rate;
  }
}

