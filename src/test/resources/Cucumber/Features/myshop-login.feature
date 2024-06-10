Feature:Zadanie Warsztatowe 1

  Scenario Outline:LogInAndAddAdress

    Given przegladarka jest otworzona na stronie myshop
    When uzytkownik przechodzi do okna logowania i wpisuje dane <login> <haslo>
    Then uzytkownik jest przekierowany na strone glowna
    When uzytkownik dodaje adres <alias> <adress> <city> <postalcode> <phone>
    Then adres zostal stworzony z poprawnymi danymi <alias> <adress> <city> <postalcode> <phone>



    Examples:
      |login|haslo|alias|adress|city|postalcode|phone|
      |isdukmwpckgywtavyi@cazlq.com|12345|Jajeczko|Kiszona|Sloje|09-876|000999888|


    Scenario Outline: UsuwanieAdresu
    Given uzytkownik jest zalogowany na stronie myshop i dodal wczesniej adres
    When uzytkownik loguje sie <login> <password>
    And uzytkownik usuwa adres
    Then adress zostal usuniety

    Examples:
      |login|password|
      |isdukmwpckgywtavyi@cazlq.com|12345|

