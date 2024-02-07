package CurrencyExchange.Menu;

import CurrencyExchange.Exchange.ExchangeHistory;

public class MainMenu { // Основное меню программы

  public static void main(String[] args) {
    MainApp mainMenu = new MainApp(); // Создание объекта для основного меню
    mainMenu.runMainMenu();          // Запуск главного меню
    ExchangeHistory exchangeHistory = new ExchangeHistory();  // Создание объекта для истории обмена валюты
    mainMenu.display(); // Отображение главного меню
    exchangeHistory.viewHistory(); // Просмотр истории обмена валюты
  }
}