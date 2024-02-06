package CurrencyExchange.Menu;

import CurrencyExchange.Exchange.ExchangeHistory;

public class MainMenu {

  public static void main(String[] args) {
    MainApp mainMenu = new MainApp();
    mainMenu.runMainMenu();
    ExchangeHistory exchangeHistory = new ExchangeHistory();
    mainMenu.display();
    exchangeHistory.viewHistory();
  }
}