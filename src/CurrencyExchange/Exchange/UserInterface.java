package CurrencyExchange.Exchange;

import java.util.HashMap;
import java.util.Map;

public class UserInterface {

  /**
   * Класс UserInterface предоставляет методы для обмена валюты на основе фиксированных курсов
   * обмена. Приложение поддерживает обмен между несколькими предопределенными типами валют
   * (например, USD, EUR, GBP и т.д.). Курсы обмена могут быть зафиксированы в коде или получены из
   * внешнего источника (например, файла или API онлайн обменника). После ввода данных
   * пользователем, приложение вычисляет и отображает результат обмена.
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

  /**
   * Метод для обмена валюты.
   *
   * @param amount       Сумма, которую пользователь хочет обменять.
   * @param fromCurrency Валюта, которую пользователь хочет обменять.
   * @param toCurrency   Валюта, которую пользователь хочет приобрести.
   * @return Результат обмена в указанной валюте.
   */
  public static double exchangeCurrency(double amount, String fromCurrency, String toCurrency) {
    // Проверка поддерживаем ости введенных валют
    if (!exchangeRates.containsKey(fromCurrency) || !exchangeRates.containsKey(toCurrency)) {
      System.out.println("Неподдерживаемая валюта");
      return -1;
    }
    // Вычисление курса обмена и возвращение результата
    double rate = exchangeRates.get(toCurrency) / exchangeRates.get(fromCurrency);
    return amount * rate;
  }
}

