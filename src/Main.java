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

    // View tickets
    private static void viewTickets(){
        if (tickets.isEmpty()){
            System.out.println("No tickets found");
            return;
        }
        System.out.println("\nAll Tickets");
        for (Ticket t: tickets){
            System.out.println(t);
        }
    }

    //GETTING THE TICKETS
    private static Ticket findTicketById(int id){
        for (Ticket t : tickets){
            if (t.getTicketId() == id){
                return t;
            }
        }
        return null;
    }

    // UPDATING TICKET
    private static void updateTicket(){
        //Getting Ticket to update
        System.out.print("Enter ID for the Ticket to update: ");
        int id = scanner.nextInt();
        Ticket ticket = findTicketById(id);
        if (ticket == null){
            System.out.println("Ticket is not foud");
            return;
        }

        //Updating current status if ticket id is found
        System.out.println("Current status: " + ticket.getStatus());
        System.out.print("Enter new status (OPEN, PENDING, CLOSED): ");
        String statusString = scanner.nextLine();


        //Updating priority of the ticket
        System.out.println("Current Priority: " + ticket.getPriority());
        System.out.print("Enter the new Priority (LOW, MEDIUM, HIGH): ");
        String priorityString = scanner.nextLine();

        System.out.println("Ticket Successfully updated to " + ticket);
    }

    public static void main(String[] args) {

        System.out.println("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {

            System.out.println("i = " + i);
        }
        scanner.close();
    }
}