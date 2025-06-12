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
        System.out.println(ticket + " was successfully created!");
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

    // DELETING TICKET
    private static void deleteTicket(){
        System.out.print("Enter ID for the ticket to delete: ");
        int id = scanner.nextInt();
        Ticket ticket = findTicketById(id);
        if (ticket == null){
            System.out.println("Ticket not found");
            return;
        }
        tickets.remove(ticket);
        System.out.println("Ticket successfully deleted.");
    }

    //SEARCH OF TICKETS
    private static void searchTickets(){
        System.out.print("Search by customer name: ");
        String searchName = scanner.nextLine().toLowerCase();

        List<Ticket> foundTickets = new ArrayList<>();
        for (Ticket t  : tickets){
            if (t.getCustomerName().toLowerCase().contains(searchName)){
                foundTickets.add(t);
            }
        }
        if (foundTickets.isEmpty()){
            System.out.println("Customer " + searchName + " has no tickets ");
        } else {
            System.out.println("The found tickets for :" + searchName);
            for (Ticket t : foundTickets){
                System.out.println(t);
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("Hello and welcome!");

        boolean running = true;
        while (running) {
            printMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    createTicket();
                    break;
                case "2":
                    viewTickets();
                    break;
                case "3":
                    updateTicket();
                    break;
                case "4":
                    deleteTicket();
                    break;
                case "5":
                    searchTickets();
                    break;
                case "0":
                    running = false;
                    System.out.println("Exiting system......");
                    break;
                default:
                    System.out.println("Invalid choice....Please try again.");
            }
        }
        scanner.close();
    }
}