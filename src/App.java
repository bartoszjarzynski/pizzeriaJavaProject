import java.io.*;
import java.util.Scanner;

// Base class representing a generic order
class Order {
    private long orderId;

    public Order() {
        // Generate unique order ID based on timestamp
        this.orderId = System.currentTimeMillis();
    }

    public long getOrderId() {
        return orderId;
    }
}

// Customer class
class Customer {
    private String name;
    private String surname;
    private String email;
    private String street;
    private String houseNumber;
    private String city;
    private String phoneNumber;

    public Customer(String name, String surname, String email, String street, String houseNumber, String city, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.street = street;
        this.houseNumber = houseNumber;
        this.city = city;
        this.phoneNumber = phoneNumber;
    }

    public String saveToTxt() {
        return "  \"customer\": {\n" +
                "    \"name\": \"" + name + "\",\n" +
                "    \"surname\": \"" + surname + "\",\n" +
                "    \"email\": \"" + email + "\",\n" +
                "    \"street\": \"" + street + "\",\n" +
                "    \"house_number\": \"" + houseNumber + "\",\n" +
                "    \"city\": \"" + city + "\",\n" +
                "    \"phone\": \"" + phoneNumber + "\"\n" +
                "  },\n";
    }
}

// Pizza class
class Pizza {
    private int number;
    private String name;

    public Pizza(int number) {
        this.number = number;
        this.name = getPizzaName(number);
    }

    private String getPizzaName(int pizzaNumber) {
        switch (pizzaNumber) {
            case 1: return "Margherita";
            case 2: return "Capricciosa";
            case 3: return "Funghi";
            case 4: return "Diavola";
            case 5: return "Quattro Stagioni";
            case 6: return "Prosciutto e Funghi";
            case 7: return "Quattro Formaggi";
            case 8: return "Hawaii";
            case 9: return "Calzone";
            case 10: return "Vegetariana";
            default: return "Niepoprawny wybór";
        }
    }

    public String saveToTxt() {
        return "  \"pizza\": {\n" +
                "    \"number\": " + number + ",\n" +
                "    \"name\": \"" + name + "\"\n" +
                "  }\n";
    }
}

// Main class
public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Witamy w pizzerii La Via e Bella!");
        System.out.println("Wybierz, co chciałbyś zrobić:");

        System.out.println("1. Zamów pizzę");
        System.out.println("2. Zobacz menu");
        System.out.println("3. Sprawdź historię zamówień");
        System.out.println("4. Wyjdź");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                orderPizza();
                break;
            case 2:
                showMenu();
                break;
            case 3:
                showOrderHistory();
                break;
            case 4:
                break;
            default:
                System.out.println("Niepoprawny wybór");
                break;
        }
        scanner.close();
    }

    public static void showMenu() {
        System.out.println("Menu:");
        System.out.println("1. Margherita");
        System.out.println("2. Capricciosa");
        System.out.println("3. Funghi");
        System.out.println("4. Diavola");
        System.out.println("5. Quattro Stagioni");
        System.out.println("6. Prosciutto e Funghi");
        System.out.println("7. Quattro Formaggi");
        System.out.println("8. Hawaii");
        System.out.println("9. Calzone");
        System.out.println("10. Vegetariana");
    }

    public static void orderPizza() {
        Scanner scanner = new Scanner(System.in);
        
        // Choose the pizza and show the menu
        System.out.println("Wybierz pizzę:");
        showMenu();
        int pizzaNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline character left by nextInt()

        // Gather customer information
        String name, surname, email, street, houseNumber, city, phoneNumber;

        do {
            System.out.println("Wpisz imię:");
            name = scanner.nextLine();
            if (name.isEmpty()) {
            System.out.println("Pole nie może być puste!");
            }
        } while (name.isEmpty());

        do {
            System.out.println("Wpisz nazwisko:");
            surname = scanner.nextLine();
            if (surname.isEmpty()) {
            System.out.println("Pole nie może być puste!");
            }
        } while (surname.isEmpty());

        do {
            System.out.println("Wpisz email:");
            email = scanner.nextLine();
            if (email.isEmpty()) {
            System.out.println("Pole nie może być puste!");
            } else if (!email.contains("@")) {
            System.out.println("Adres e-mail musi zawierać znak \"@\"!");
            }
        } while (email.isEmpty() || !email.contains("@"));

        do {
            System.out.println("Wpisz ulicę:");
            street = scanner.nextLine();
            if (street.isEmpty()) {
            System.out.println("Pole nie może być puste!");
            }
        } while (street.isEmpty());

        do {
            System.out.println("Wpisz numer domu:");
            houseNumber = scanner.nextLine();
            if (houseNumber.isEmpty()) {
            System.out.println("Pole nie może być puste!");
            }
        } while (houseNumber.isEmpty());

        do {
            System.out.println("Wpisz miasto:");
            city = scanner.nextLine();
            if (city.isEmpty()) {
            System.out.println("Pole nie może być puste!");
            }
        } while (city.isEmpty());

        do {
            System.out.println("Wpisz numer telefonu:");
            phoneNumber = scanner.nextLine();
            if (phoneNumber.isEmpty()) {
            System.out.println("Pole nie może być puste!");
            } else if (phoneNumber.length() != 9) {
            System.out.println("Numer telefonu musi składać z dokładnie 9 znaków!");
            }
        } while (phoneNumber.isEmpty() || phoneNumber.length() != 9);

        // Create customer and pizza objects
        Customer customer = new Customer(name, surname, email, street, houseNumber, city, phoneNumber);
        Pizza pizza = new Pizza(pizzaNumber);
        
        // Create order object and save it
        Order order = new Order();
        
        try (FileWriter writer = new FileWriter("order_history.txt", true)) {
            writer.write("{\n");
            writer.write("  \"order_id\": " + order.getOrderId() + ",\n");
            writer.write(customer.saveToTxt());
            writer.write(pizza.saveToTxt());
            writer.write("}\n");
        } catch (IOException e) {
            System.out.println("Błąd podczas zapisywania zamówienia.");
        }

        System.out.println("Zamówienie zostało zapisane!");
        scanner.close();
    }

    public static void showOrderHistory() {
        try (BufferedReader reader = new BufferedReader(new FileReader("order_history.txt"))) {
            String line;
            System.out.println("Historia zamówień:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Błąd podczas odczytu historii zamówień.");
        }
    }
}