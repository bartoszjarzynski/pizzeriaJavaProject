Pizzeria La Vita e Bella

Opis projektu

Projekt “Pizzeria La Via e Bella” to aplikacja konsolowa stworzona w języku Java, która umożliwia użytkownikowi składanie zamówień na pizzę, przeglądanie menu oraz sprawdzanie historii zamówień. Program korzysta z prostych operacji na plikach tekstowych, aby zapisać zamówienia w formacie JSON (zapisywane w pliku .txt). Program wykorzystuje podstawowe zasady programowania obiektowego, takie jak klasy, dziedziczenie oraz enkapsulacja.

Funkcjonalności
1.	Składanie zamówienia: Użytkownik wybiera pizzę z menu, a następnie wprowadza swoje dane (imię, nazwisko, e-mail, adres oraz numer telefonu). Program zapisuje dane zamówienia w pliku order_history.txt w formacie JSON.
2.	Przeglądanie menu: Użytkownik może zapoznać się z dostępnymi pizzami w menu (np. Margherita, Capricciosa, Quattro Stagioni itp.).
3.	Historia zamówień: Użytkownik może wyświetlić całą historię zamówień, która jest zapisywana w pliku tekstowym. Każde zamówienie zawiera informacje o kliencie oraz wybranej pizzy.

Struktura aplikacji

Projekt składa się z kilku klas:
1.	Order: Klasa bazowa, która generuje unikalny identyfikator dla każdego zamówienia.
2.	Customer: Klasa, która zawiera dane klienta (imię, nazwisko, e-mail, adres, telefon). Zawiera również metodę saveToTxt(), która zapisuje dane w formacie JSON.
3.	Pizza: Klasa, która zawiera dane o pizzy (numer, nazwa). Zawiera metodę saveToTxt(), która zapisuje dane w formacie JSON na podstawie numeru pizzy.
4.	App (główna klasa): Klasa główna, w której odbywa się interakcja z użytkownikiem. Umożliwia składanie zamówień, przeglądanie menu i wyświetlanie historii zamówień. Obsługuje także walidację danych wprowadzonych przez użytkownika, np. sprawdzenie poprawności adresu e-mail czy numeru telefonu.

Jak uruchomić projekt

1.	Pobierz projekt: Skopiuj lub pobierz kod z GitHub.

2.	Skonfiguruj środowisko: Upewnij się, że masz zainstalowane środowisko Java (JDK) na swoim komputerze. Możesz sprawdzić, czy Java jest zainstalowana, uruchamiając polecenie:

java -version

3.	Uruchom projekt: Otwórz terminal w katalogu z projektem i uruchom aplikację za pomocą następującego polecenia:

javac App.java
java App



Przykład działania
1.	Użytkownik uruchamia program i widzi menu:

Witamy w pizzerii La Via e Bella!
Wybierz, co chciałbyś zrobić:

1. Zamów pizzę
2. Zobacz menu
3. Sprawdź historię zamówień
4. Wyjdź


	2.	Po wyborze opcji “1” (Zamów pizzę), użytkownik wybiera numer pizzy z menu, a następnie wprowadza swoje dane (imię, nazwisko, email, adres, numer telefonu). Program zapisuje te dane w pliku order_history.txt.
	3.	Użytkownik może później wybrać opcję “3” (Sprawdź historię zamówień) i wyświetlić wszystkie zapisane zamówienia.

Struktura pliku order_history.txt

Każde zamówienie jest zapisane w formacie JSON, na przykład:

{
  "order_id": 1633036742721,
  "customer": {
    "name": "Jan",
    "surname": "Kowalski",
    "email": "jan@example.com",
    "street": "ul. Przykładowa 1",
    "house_number": "12",
    "city": "Warszawa",
    "phone": "123456789"
  },
  "pizza": {
    "number": 7,
    "name": "Quattro Formaggi"
  }
}

Technologie
	•	Java 8+: Aplikacja jest napisana w języku Java i wykorzystuje klasy do modelowania zamówień.
	•	Pliki tekstowe: Dane o zamówieniach są przechowywane w plikach .txt w formacie JSON.