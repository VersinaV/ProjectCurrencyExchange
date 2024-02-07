package CurrencyExchange.Exchange;

import java.util.Date;

/**
 * Класс Exchange представляет информацию об одном обмене валюты.
 */
public class Exchange {

  private double amount;
  private String fromCurrency;
  private String toCurrency;
  private final Date dateTime;

  /**
   * Конструктор класса Exchange. Инициализирует объект обмена с заданными значениями суммы, валюты
   * отправителя и валюты получателя.
   *
   * @param amount       Сумма, которая была обменяна.
   * @param fromCurrency Валюта, которую пользователь обменял.
   * @param toCurrency   Валюта, которую пользователь получил в результате обмена.
   */
  public Exchange(double amount, String fromCurrency, String toCurrency) {
    this.amount = amount;
    this.fromCurrency = fromCurrency;
    this.toCurrency = toCurrency;
    this.dateTime = new Date();
  }

  /**
   * Метод для получения суммы обмена.
   *
   * @return Сумма обмена.
   */
  public double getAmount() {
    return amount;
  }

  /**
   * Метод для установки суммы обмена.
   *
   * @param amount Новая сумма обмена.
   */
  public void setAmount(double amount) {
    this.amount = amount;
  }

  /**
   * Метод для получения валюты отправителя.
   *
   * @return Валюта отправителя.
   */
  public String getFromCurrency() {
    return fromCurrency;
  }

  /**
   * Метод для установки валюты отправителя.
   *
   * @param fromCurrency Новая валюта отправителя.
   */
  public void setFromCurrency(String fromCurrency) {
    this.fromCurrency = fromCurrency;
  }

  /**
   * Метод для получения валюты получателя.
   *
   * @return Валюта получателя.
   */
  public String getToCurrency() {
    return toCurrency;
  }

  /**
   * Метод для установки валюты получателя.
   *
   * @param toCurrency Новая валюта получателя.
   */
  public void setToCurrency(String toCurrency) {
    this.toCurrency = toCurrency;
  }

  /**
   * Метод для получения времени и даты обмена.
   *
   * @return Объект Date, представляющий момент времени обмена.
   */
  public Date getDateTime() {
    return dateTime;
  }

  /**
   * Переопределение метода toString для представления информации об объекте Exchange в виде
   * строки.
   *
   * @return Строковое представление объекта Exchange.
   */
  @Override
  public String toString() {
    return "CurrencyExchange.Exchange{" +
        "amount=" + this.amount +
        ", fromCurrency='" + this.fromCurrency + '\'' +
        ", toCurrency='" + this.toCurrency + '\'' +
        ", dateTime=" + dateTime +
        '}';
  }
}