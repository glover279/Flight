/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flight;

import java.text.ParseException;

/**
 *
 * @author Robert
 */
public class Flight {
private String code;
private String origin;
private String destination;
private String departureTime;
private String arrivalTime;
private double cost;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
FlightManager flightman=new FlightManager(); 
flightman.allTickets();
flightman.sort();
    }
    public Flight(String code1, String origin1, String destination1, String departureTime1, String arrivaltime1, double cost1 ) {
    code=code1;
    origin=origin1;
    destination=destination1;
    departureTime=departureTime1;
    arrivalTime=arrivaltime1;
    cost=cost1;
    }
    
    public String getCode(){return code;}
    public double getCost(){return cost;}
    public String getDepartureTime(){return departureTime;}
    public String toString(){return code+"  "+origin+" "+departureTime+"    "+destination+" "+arrivalTime;}
}
