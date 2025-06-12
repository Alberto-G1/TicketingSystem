import ticketsystem.model.Ticket;
import ticketsystem.model.enums.Status;
import ticketsystem.model.enums.Priority;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    //List to temporarily store and hold the tickkets
    private static List<Ticket> tickets = new ArrayList<>();

    // Scanner object to allow user input
    private static Scanner scanner = new Scanner(System.in);

    // User choice selection menu
    private static void printMenu(){
        System.out.println("\n--- Call Center Ticket System ---");
        System.out.println("1. Create Ticket");
        System.out.println("2. View All Tickets");
        System.out.println("3. Update Ticket");
        System.out.println("4. Delete Ticket");
        System.out.println("5. Search Tickets");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }

    // Ticket creation
    private static void createTicket(){
        System.out.print("Customer Name: ");
        String customerName = scanner.nextLine();
        System.out.print("Contact: ");
        String contact = scanner.nextLine();
        System.out.print("Category: ");
        String category = scanner.nextLine();
        System.out.print("Description: ");
        String description = scanner.nextLine();

        Ticket ticket = new Ticket(customerName, contact, category, description);
        tickets.add(ticket);
        System.out.println("Ticket " + ticket + " was successfully created!");
    }

    public static void main(String[] args) {

        System.out.println("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {

            System.out.println("i = " + i);
        }
        scanner.close();
    }
}