Feature: Zadanie Warsztatowe 2

  Scenario Outline: Finalizacja tranzakcji

    Given Uzytkownik <login> <haslo> jest zalogowany na stronie myshop
    When Uzytkownik dodaj produkt do koszyka <size> <ammount> i finalizuje platnosc
    Then Zamowienie zostalo zrealizowane
    And Zrzut ekranu
    And Cena jest taka sama w historii zmaowien

    Examples:
      |login|haslo|size|ammount|
      |isdukmwpckgywtavyi@cazlq.com|12345|M|5|