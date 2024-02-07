package CurrencyExchange.Menu;

import CurrencyExchange.Exchange.ExchangeHistory;

/**
 * Класс, представляющий главное меню программы обмена валютой.
 */
public class MainMenu {

  /**
   * Главный метод программы.
   *
   * @param args Параметры командной строки.
   */
  public static void main(String[] args) {
    // Создание объекта для основного меню
    MainApp mainMenu = new MainApp();
    // Запуск главного меню
    mainMenu.runMainMenu();
    // Создание объекта для истории обмена валюты
    ExchangeHistory exchangeHistory = new ExchangeHistory();
    // Отображение главного меню
    mainMenu.display();
    // Просмотр истории обмена валюты
    exchangeHistory.viewHistory();
  }
}