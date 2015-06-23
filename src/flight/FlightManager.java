/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flight;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Robert
 */
public class FlightManager {
    private Ticket[] tickets=new Ticket[501];
    private int ticketCounter;
    
    public FlightManager(){
            
    boolean a= new File("tickets.txt").isFile();
     final JPanel panel = new JPanel();
    if(a==false) {JOptionPane.showMessageDialog(panel, "File Does not Exist", "Error", JOptionPane.ERROR_MESSAGE);}
    else{
    
   String line1="";
   String line2="";
   String line3="";
   String ticketnumtmp;
   String tktname="";
   String fltCode="";
   String orig="";
   String dest="";
   String depttime="";

int count=500;
    try{
    Scanner sc=new Scanner(new File("tickets.txt"));
    while(sc.hasNextLine()) {
        line1=sc.nextLine(); System.out.println(line1);
        line2=sc.nextLine();
        line3=sc.nextLine();
        Scanner sc1=new Scanner(line1).useDelimiter("#");
        ticketnumtmp=sc1.next();
        tktname=sc1.next();
        
        //line 2
        
        Scanner sc2=new Scanner(line2).useDelimiter("#");
        fltCode=sc2.next();
        orig=sc2.next();
        dest=sc2.next();
        depttime=sc2.next();
        String arrivaltime=sc2.next();
        double cost=sc2.nextDouble();
        
        Flight depFlight=new Flight(fltCode,orig,dest,depttime,arrivaltime,cost);
        //line 3
        
        Scanner sc3=new Scanner(line3).useDelimiter("#");
        String flightcdret=sc3.next();
        String origret=sc3.next();
        String destret=sc3.next();
        String depttimret=sc3.next();
        String arrtmret=sc3.next();
        Double costret=sc3.nextDouble();
        
        Flight retFlight=new Flight(flightcdret,origret,destret,depttimret,arrtmret,costret);
        
        Ticket ticket1=new Ticket(ticketnumtmp,tktname,retFlight,depFlight);
        
        tickets[count]=ticket1;
        count--;
    {
    
        
        
    }
    }
    }
    catch(FileNotFoundException e) {e.printStackTrace();}
    }
    
    
    }
    
    public String allTickets()
    {
        String ret = "";
        for(int i=0; i<=499; i++)
        {
          if(tickets[i] != null) {
              ret += tickets[i].toString()+"\n";
          }
        }
        return ret;
     
    }

public void sort() throws ParseException
{
    Ticket[] ticket2=new Ticket[1];
boolean swapped = true;
    int j = 0;
    long tmp;
    while (swapped) {
        swapped = false;
        j++;
        DateFormat format = new SimpleDateFormat("yyyy-mm-dd, HH-mm", Locale.ENGLISH);
        for (int i = 0; i < tickets.length - j; i++) {
            Date date=format.parse(tickets[i].getDepartingFlight().getDepartureTime());
            Date date1=format.parse(tickets[i+1].getDepartingFlight().getDepartureTime());
            long x=date.getTime();
            long y=date1.getTime();
            if (x > y) {
                ticket2[1]=tickets[i];
                tickets[i]=tickets[i+1];
                tickets[i+1]=ticket2[1];
                swapped = true;
                
            }
        }
    }
}
  public int FlightDuration(int a) throws ParseException
  {
      DateFormat format = new SimpleDateFormat("yyyy-mm-dd, HH-mm", Locale.ENGLISH);
       
            
            Date date1=format.parse(tickets[a].getDepartingFlight().getDepartureTime());
            Date date2=format.parse(tickets[a].getReturningFlight().getDepartureTime());
            long time=date1.getTime()-date2.getTime();
            int min=(int) (time/60);
  return min;
  }      
    
}






