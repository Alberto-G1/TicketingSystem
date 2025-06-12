package ticketsystem.model;

import ticketsystem.model.enums.Status;
import ticketsystem.model.enums.Priority;


public class Ticket {
    private static int idCounter = 1;

    private int ticketId;
    private String customerName;
    private String contact;
    private String category;
    private String description;
    private Status status;
    private Priority priority;

    public Ticket (String customerName, String contact, String category, String description){
        this.ticketId = idCounter++;

        this.customerName = customerName;
        this.contact = contact;
        this.category = category;
        this.description = description;
        this.status = Status.OPEN;
        this.priority = Priority.MEDIUM;
    }

    //Getters

    public void setStatus(Status status){
        this.status = status;
    }

    public void setPriority(Priority priority){
        this.priority = priority;
    }

    public int getTicketId() {
        return ticketId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getContact() {
        return contact;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
    }

    public Priority getPriority() {
        return priority;
    }
    @Override
    public String toString(){
        return "Ticket " + ticketId + " : "  + category + " for " + customerName + " [ " + status + ", " + priority + "]";
    }
}
