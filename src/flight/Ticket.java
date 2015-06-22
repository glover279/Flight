/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flight;

/**
 *
 * @author Robert
 */
public class Ticket {
    private String ticketID;
    private String name;
    private Flight departingFlight;
    private Flight returningFlight;
    
    

    public Ticket(String ticketID, String name, Flight returningFlight, Flight departingFlight) {
        this.ticketID = ticketID;
        this.name = name;
        this.returningFlight = returningFlight;
        this.departingFlight= departingFlight;
    }
    public String getName(){return name;}

    public Flight getDepartingFlight() {
        return departingFlight;
    }

    public Flight getReturningFlight() {
        return returningFlight;
    }
    public double getTotalCost(){return getDepartingFlight().getCost()+getReturningFlight().getCost();}
    public String toString(){return ticketID+"  "+name+"    "+getTotalCost()+""
            + getDepartingFlight().toString()
            +getReturningFlight().toString();}
}
