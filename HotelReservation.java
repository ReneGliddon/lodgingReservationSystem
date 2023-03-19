package lodgingapp;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.time.LocalDate;
/**
 * Hotel reservation
 */
public class HotelReservation extends Reservation {

    
     // Constructor with mailing address
     //Hotel reservation can only be reserved for single bedroom, single bathroom, and two beds.
     public HotelReservation(String accountNumber, String reservationNumber, Address lodgingPhysicalAddress, Address lodgingMailingAddress,  int numberOfNights,
     int lodgingSizeInSqFeet, double price, String reservationStatus, Date startDate, boolean kitchenette) {
 
         super(accountNumber, reservationNumber, lodgingPhysicalAddress, lodgingMailingAddress, numberOfNights,lodgingSizeInSqFeet, price, reservationStatus);
        
         //Check the additional values. If valid, set values. Else, throw exception.
        if(kitchenette == true || kitchenette == false) {

        // validate that source and destination are not the same

        //initialize the attributes to the parameters
        this.startDate = startDate;
        
         //default values to be set:
         numberOfBathrooms = 1;
         numberOfBedrooms = 1;
         numberOfBeds = 2;

         //kitchenette
         this.kitchenette = kitchenette;
     
        }
        else {
            throw new IllegalArgumentException("Reservation not saved. Please indicate whether there is a kitchenette or not.");
        }
        
     }
     
  // Constructor with mailing address and without price
     //Hotel reservation can only be reserved for single bedroom, single bathroom, and two beds.
     public HotelReservation(String accountNumber, String reservationNumber, Address lodgingPhysicalAddress, Address lodgingMailingAddress,  int numberOfNights,
     int lodgingSizeInSqFeet, String reservationStatus, Date startDate, boolean kitchenette) {
 
         super(accountNumber, reservationNumber, lodgingPhysicalAddress, lodgingMailingAddress, numberOfNights,lodgingSizeInSqFeet, reservationStatus);
        
         //Check the additional values. If valid, set values. Else, throw exception.
        if(kitchenette == true || kitchenette == false) {

        // validate that source and destination are not the same

        //initialize the attributes to the parameters
        this.startDate = startDate;
         //default values to be set:
         numberOfBathrooms = 1;
         numberOfBedrooms = 1;
         numberOfBeds = 2;

         //kitchenette
         this.kitchenette = kitchenette;
     
        }
        else {
            throw new IllegalArgumentException("Reservation not saved. Please indicate whether there is a kitchenette or not.");
        }
        
     }


    
     //Constructor without mailing address but with price
     //Hotel reservation can only be reserved for single bedroom, single bathroom, and two beds.
    public HotelReservation(String accountNumber, String reservationNumber, Address lodgingPhysicalAddress,  int numberOfNights,
    int lodgingSizeInSqFeet, double price, String reservationStatus, Date startDate, boolean kitchenette) {

        super(accountNumber, reservationNumber, lodgingPhysicalAddress, numberOfNights,lodgingSizeInSqFeet, price, reservationStatus);
        
        //Check the additional values. If valid, set values. Else, throw exception.
        if(kitchenette == true || kitchenette == false) {

        // validate that source and destination are not the same

        //Initialize the attributes to the parameters
        this.startDate = startDate;
        
        //default values to be set:
        numberOfBathrooms = 1;
        numberOfBedrooms = 1;
        numberOfBeds = 2;

        //kitchenette
        this.kitchenette = kitchenette;
 
        }
        else {
            throw new IllegalArgumentException("Reservation not saved. Please indicate whether there is a kitchenette or not.");
        }

    }
    
    //Constructor without mailing address and without price
    //Hotel reservation can only be reserved for single bedroom, single bathroom, and two beds.
   public HotelReservation(String accountNumber, String reservationNumber, Address lodgingPhysicalAddress,  int numberOfNights,
   int lodgingSizeInSqFeet, String reservationStatus, Date startDate, boolean kitchenette) {

       super(accountNumber, reservationNumber, lodgingPhysicalAddress, numberOfNights,lodgingSizeInSqFeet, reservationStatus);
       
       //Check the additional values. If valid, set values. Else, throw exception.
       if(kitchenette == true || kitchenette == false) {

       // validate that source and destination are not the same

       //Initialize the attributes to the parameters
       this.startDate = startDate;
       
       //default values to be set:
       numberOfBathrooms = 1;
       numberOfBedrooms = 1;
       numberOfBeds = 2;

       //kitchenette
       this.kitchenette = kitchenette;

       }
       else {
           throw new IllegalArgumentException("Reservation not saved. Please indicate whether there is a kitchenette or not.");
       }

   }
    
    //constructor that takes a formatted string
    public HotelReservation(String line) throws ParseException
    {
    	super(line);     
    	
    	SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
   
    	startDate = formatter.parse(line.substring(line.indexOf("<startDate>") + 11, line.indexOf("</startDate>")));
    	
    	numberOfBeds = Integer.parseInt(line.substring(line.indexOf("<numberOfBeds>") + 14, line.indexOf("</numberOfBeds>")));
    	
    	numberOfBedrooms = Integer.parseInt(line.substring(line.indexOf("<numberOfBedrooms>") + 18, line.indexOf("</numberOfBedrooms>")));
    	
    	numberOfBathrooms = Integer.parseInt(line.substring(line.indexOf("<numberOfBathrooms>") + 19, line.indexOf("</numberOfBathrooms>")));   
    	
    	kitchenette = Boolean.parseBoolean(line.substring(line.indexOf("<kitchenette>") + 13, line.indexOf("</kitchenette>")));
        // validate values
    	if ((kitchenette != true && kitchenette != false) || numberOfBeds <= 0 || numberOfBedrooms <= 0 || numberOfBathrooms <= 0)
    		throw new IllegalArgumentException("Values cannot be null or empty strings");
    		
    }

    //Additional attributes

    //A Boolean to indicate whether the hotel reservation has a kitchenette or not
    private boolean kitchenette;
    
    private Date startDate;
    
    // Methods
    
    //get kitchenette boolean
    public Boolean getKitchenette() {
    	
    	return this.kitchenette;   	
    	    	
    }
    
    //get startDate
    public Date getStartDate() {
    	
    	return startDate;
    }
    
    //set numberOfFloors
    public void setKitchenette(Boolean newBool) {
    	
    	if(newBool == true || newBool == false) {
    		
    		this.kitchenette = newBool;
    	}
    	else {
    		
    		throw new IllegalArgumentException("Error. Please indicate whether or not there is a kitchenette.");
    	}
    }
    
  //set reservation status
    public void setReservationStatus(String newStatus) {
    	  
    	//check the status is valid
    	if(newStatus.toLowerCase().equals("draft") || newStatus.toLowerCase().equals("completed") || newStatus.toLowerCase().equals("cancelled")) {
    		
    		//check the date if the new status is "cancelled"
    		if(newStatus.toLowerCase().equals("cancelled")) {
    			
    			//current date
    			Date now = new Date(System.currentTimeMillis());
    			
    			//format the reservation date
    			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    			
    			//send the reservation to the toString
				String line = this.toString();
				
				//System.out.println("We printed the reservation and npw to FORMAT");
				
				//declare a date variable
		    	Date beginDate;
		    	
		    	//extract and compare the date, set the status if in the future, else send an error
				try {
						//extract
						beginDate = formatter.parse(line.substring(line.indexOf("<startDate>") + 11, line.indexOf("</startDate>")));
						
						//test if the reservation date is after the current date
						if(beginDate.after(now)) {
								//if the reservation is in the future, change the status to "cancelled"
								this.reservationStatus = newStatus;
						}
						//if the reservation date is  in the past, or today, then do not cancel it, but rather send an error message
						else {
					    		throw new IllegalArgumentException("Cannot change the reservation status to \"cancelled\" as it is in the past or currently occurring.");
					    }
							
					//}//end catch	
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}//end catch
				
    		}//end if the new status is cancelled
    		//if the new status is valid, but is not "cancelled", then set the new status without future testing
    		else {
    			this.reservationStatus = newStatus;
    		}
 
    		//if reservation is completed, set the price
    		if(this.reservationStatus.toLowerCase().equals("completed")) {
    		
    			//first calculate the price
    			double thePrice = calculateReservationPrice();
    		
    			//set the price
    			setPrice(thePrice);
    		}//end if the new status is completed
    	}
   }//end setReservationStatus
    
    
 public double calculateReservationPrice() {
    	
    	//Set basic price
    	double newPriceCalculation = super.calculateReservationPrice();
    	
    	//additional flat fee of $50 plus $10 for kitchenette
    	newPriceCalculation = newPriceCalculation + 50;
    	
    	if (this.kitchenette==true) {
    		newPriceCalculation = newPriceCalculation + 10;
    	}
    	
    	return newPriceCalculation; 
    }
       
 public void setPrice(double newPrice) 
 {
	 //Reservation will set the price  
	 super.setPrice(newPrice); 
 }
    
   //toString() method will output the class’s data to the screen and return formatted data 
    public String toString() {

    	SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    	
        //format data
   	 	String hotelReservation =  "<hotelReservation>" +
                super.toString() +
                		"<startDate>" + formatter.format(startDate) + "</startDate>" +
               	        "<numberOfBeds>" + numberOfBeds + "</numberOfBeds>" +
               	        "<numberOfBedrooms>" + numberOfBedrooms + "</numberOfBedrooms>" +
               	        "<numberOfBathrooms>" + numberOfBathrooms + "</numberOfBathrooms>" +
               	        "<kitchenette>" + kitchenette + "</kitchenette>" +
               	        "</hotelReservation>" ;      
  
   	 	// Output the class's data to the screen as formatted data
   	 	System.out.println(hotelReservation);
  
       //return the String
       
       return hotelReservation;
    }
    
    //toString() method will output the class’s data to the screen and return formatted data 
    public String toStringQuiet() {

    	SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    	
        //format data
   	 	String hotelReservation =  "<hotelReservation>" +
                super.toString() +
                		"<startDate>" + formatter.format(startDate) + "</startDate>" +
               	        "<numberOfBeds>" + numberOfBeds + "</numberOfBeds>" +
               	        "<numberOfBedrooms>" + numberOfBedrooms + "</numberOfBedrooms>" +
               	        "<numberOfBathrooms>" + numberOfBathrooms + "</numberOfBathrooms>" +
               	        "<kitchenette>" + kitchenette + "</kitchenette>" +
               	        "</hotelReservation>" ;      
    
       //return the String
       
       return hotelReservation;
    }
    
    //create and return a copy of the object
    public HotelReservation clone() {
    	
    	//create a new object with copied attributes	
    	HotelReservation newHotelRes = new HotelReservation(this.accountNumber, this.reservationNumber, this.lodgingPhysicalAddress, 
    				   							this.lodgingMailingAddress, this.numberOfNights, this.lodgingSizeInSqFeet, this.price, this.reservationStatus,  this.startDate,
    				   							this.kitchenette);
   	   //return new object
   	   return newHotelRes;
   
    }
    
   
    
    

    
}

