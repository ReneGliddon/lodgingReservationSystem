import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.time.format.DateTimeFormatter; 
 
 // There are three types of accommodation reservations: hotel room reservation, cabin reservation, and house reservation.
public abstract class Reservation {
    
	//constructor with all parameters
    public Reservation(String accountNumber, String reservationNumber, Address lodgingPhysicalAddress, Address lodgingMailingAddress,  int numberOfNights,
            int lodgingSizeInSqFeet, double price, String reservationStatus) {

    	//Check the values. If valid, set values. Else, throw exception.
    	if(accountNumber!=null && reservationNumber != null && lodgingPhysicalAddress != null && lodgingMailingAddress != null  && numberOfNights != 0 
    			&& lodgingSizeInSqFeet != 0 && price != 0 &&reservationStatus != null ) {

    		//initialize the attributes to the parameters
    		this.accountNumber = accountNumber;
    		this.reservationNumber = reservationNumber;
    		this.lodgingPhysicalAddress = lodgingPhysicalAddress;
    		this.lodgingMailingAddress = lodgingMailingAddress;
    		this.numberOfNights = numberOfNights;
    		this.lodgingSizeInSqFeet = lodgingSizeInSqFeet;
    		this.price = price;
    		this.reservationStatus = reservationStatus;
    		
    		//check that the reservation status is "draft"
    		if(!reservationStatus.toLowerCase().equals("draft")) {
    			
    			reservationStatus = "draft";
    			throw new IllegalArgumentException("Reservation status must be \"draft\". Status changed to \"draft\".");
    		}
    
    	}
    	else {
    		throw new IllegalArgumentException("Reservation not saved. Values for Reservation cannot be blank.");
    	}
    }
    
    //constructor without a price but with a mailing address
    public Reservation(String accountNumber, String reservationNumber, Address lodgingPhysicalAddress, Address lodgingMailingAddress,  int numberOfNights,
                int lodgingSizeInSqFeet, String reservationStatus) {

        	//Check the values. If valid, set values. Else, throw exception.
        	if(accountNumber!=null && reservationNumber != null && lodgingPhysicalAddress != null && lodgingMailingAddress != null  && numberOfNights != 0 
        			&& lodgingSizeInSqFeet != 0  &&reservationStatus != null ) {

        		//initialize the attributes to the parameters
        		this.accountNumber = accountNumber;
        		this.reservationNumber = reservationNumber;
        		this.lodgingPhysicalAddress = lodgingPhysicalAddress;
        		this.lodgingMailingAddress = lodgingMailingAddress;
        		this.numberOfNights = numberOfNights;
        		this.lodgingSizeInSqFeet = lodgingSizeInSqFeet;
        		this.reservationStatus = reservationStatus;
        
        		//check that the reservation status is "draft"
        		if(!reservationStatus.toLowerCase().equals("draft")) {
        			
        			reservationStatus = "draft";
        			throw new IllegalArgumentException("Reservation status must be \"draft\". Status changed to \"draft\".");
        		}
        
        	}
        	else {
        		throw new IllegalArgumentException("Reservation not saved. Values for Reservation cannot be blank.");
        	}

}
    
  //Constructor without mailing address, but with price. Mailing address will be set to physical address
    public Reservation(String accountNumber, String reservationNumber, Address lodgingPhysicalAddress,  int numberOfNights,
                       int lodgingSizeInSqFeet, double price, String reservationStatus) {

            //Check the values. If valid, set values. Else, throw exception.
            if(accountNumber!=null && reservationNumber != null && lodgingPhysicalAddress != null && numberOfNights != 0 
           && lodgingSizeInSqFeet != 0 && price != 0 &&reservationStatus != null ) {
	   
            //initialize the attributes to the parameters
            this.accountNumber = accountNumber;
            this.reservationNumber = reservationNumber;
            this.lodgingPhysicalAddress = lodgingPhysicalAddress;
            this.lodgingMailingAddress = lodgingPhysicalAddress;
            this.numberOfNights = numberOfNights;
            this.lodgingSizeInSqFeet = lodgingSizeInSqFeet;
            this.price = price;
            this.reservationStatus = reservationStatus;
            
          //check that the reservation status is "draft"
    		if(!reservationStatus.toLowerCase().equals("draft")) {
    			
    			reservationStatus = "draft";
    			throw new IllegalArgumentException("Reservation status must be \"draft\". Status changed to \"draft\".");
    		}
    
        }
        else {
                throw new IllegalArgumentException("Reservation not saved. Values for Reservation cannot be blank.");
        }

       

    }
    
  //Constructor without mailing address and without price. Mailing address will be set to physical address
    public Reservation(String accountNumber, String reservationNumber, Address lodgingPhysicalAddress,  int numberOfNights,
                       int lodgingSizeInSqFeet, String reservationStatus) {

            //Check the values. If valid, set values. Else, throw exception.
            if(accountNumber!=null && reservationNumber != null && lodgingPhysicalAddress != null && numberOfNights != 0 
           && lodgingSizeInSqFeet != 0 &&reservationStatus != null ) {
	   
            //initialize the attributes to the parameters
            this.accountNumber = accountNumber;
            this.reservationNumber = reservationNumber;
            this.lodgingPhysicalAddress = lodgingPhysicalAddress;
            this.lodgingMailingAddress = lodgingPhysicalAddress;
            this.numberOfNights = numberOfNights;
            this.lodgingSizeInSqFeet = lodgingSizeInSqFeet;
            this.reservationStatus = reservationStatus;
            
          //check that the reservation status is "draft"
    		if(!reservationStatus.toLowerCase().equals("draft")) {
    			
    			reservationStatus = "draft";
    			throw new IllegalArgumentException("Reservation status must be \"draft\". Status changed to \"draft\".");
    		}
    
               
        }
        else {
                throw new IllegalArgumentException("Reservation not saved. Values for Reservation cannot be blank.");
        } 

    }
    
    //constructor that takes a formatted string
    public Reservation (String line) throws ParseException {
    	
    	//parse the line and set values
    	accountNumber = line.substring(line.indexOf("<accountNumber>") + 15, line.indexOf("</accountNumber>"));
    	
    	reservationNumber = line.substring(line.indexOf("<reservationNumber>") + 19, line.indexOf("</reservationNumber>"));
    	
    		//convert to an Address object
    		String newLodgingPhysicalAddress = line.substring(line.indexOf("<lodgingPhysicalAddress>") + 24, line.indexOf("</lodgingPhysicalAddress>"));
    		Address newAddress = new Address(newLodgingPhysicalAddress); 
    	lodgingPhysicalAddress = newAddress;
    	
    	
    		//convert to an Address object
			String newLodgingMailingAddress = line.substring(line.indexOf("<lodgingMailingAddress>") + 23, line.indexOf("</lodgingMailingAddress>"));
			Address newMailingAddress = new Address(newLodgingMailingAddress); 
		lodgingMailingAddress = newMailingAddress;
		
			//convert numberOfNights to an integer
		 	String numNightsAsString = line.substring(line.indexOf("<numberOfNights>") + 16, line.indexOf("</numberOfNights>"));
		 	int number = 0;
	        try{
	            number = Integer.parseInt(numNightsAsString);
	          
	        }
	        catch (NumberFormatException ex){
	            ex.printStackTrace();
	        }
		numberOfNights =  number;
		
			//convert lodging size to an integer
	 		String lodgingSizeAsString = line.substring(line.indexOf("<lodgingSizeInSqFeet>") + 21, line.indexOf("</lodgingSizeInSqFeet>"));
	 		int size = 0;
	 		try{
	 			size = Integer.parseInt(lodgingSizeAsString);
	 			}
	 		catch (NumberFormatException ex){
	 			ex.printStackTrace();
	 		}
		lodgingSizeInSqFeet = size;
		
			//convert to price to a double if there is a price at all
		String priceAsAString = line.substring(line.indexOf("<price>") + 7, line.indexOf("</price>"));
	
		if(!priceAsAString.equals("0.0")) {
			price = Double.parseDouble(priceAsAString); 
		}
		 	
		
		reservationStatus = line.substring(line.indexOf("<reservationStatus>") + 19, line.indexOf("</reservationStatus>"));
		
     if (accountNumber.length() == 0 || reservationNumber.length() == 0 || lodgingPhysicalAddress.getStreet().length() == 0 || lodgingMailingAddress.getStreet().length() == 0 
        		||  numberOfNights == 0 || lodgingSizeInSqFeet == 0
        		|| (!reservationStatus.toUpperCase().equals("DRAFT") && !reservationStatus.toUpperCase().equals("COMPLETED")&& !reservationStatus.toUpperCase().equals("CANCELLED")) )
       {
    	 throw new IllegalArgumentException("Parameter values cannot be null or empty strings");
    	 
        }

    	
    }

    //Attributes

    // Account number to which the reservation belongs
    protected String accountNumber;

    //Reservation number generated by UI 
    protected String reservationNumber;

    // Lodging's physical address, stored in an Address object
    protected Address lodgingPhysicalAddress;

    // Lodging's mailing address, stored in an Address object 
    protected Address lodgingMailingAddress;

    // Number of nights of the reservation
    protected int numberOfNights;

    // Number of beds (default 2)
    protected int numberOfBeds = 2;

    // Number of bedrooms (default 1)
    protected int numberOfBedrooms = 1;

    // Number of bathrooms (default 1)
    protected int numberOfBathrooms = 1;

    // Lodging size in square feet
    protected int lodgingSizeInSqFeet;

    // Price of the reservation
    protected double price;

    //reservation status (draft, completed, or cancelled)
    protected String reservationStatus;

    // Methods
    
    //get methods

    //get account number
    public String getAccountNumber(){
    	
    	return this.accountNumber;
    }
    
    //get reservation number
    public String getReservationNumber(){
    	
    	return this.reservationNumber;
    }
    
    //get lodging physical address
    public Address getLodgingPhysicalAddress(){
    	
    	return this.lodgingPhysicalAddress;
    }
    
    //get lodging mailing address
    public Address getLodgingMailingAddress(){
    	
    	return this.lodgingMailingAddress;
    }
    
    //get number of nights
    public int getNumberOfNights() {
    	
    	return this.numberOfNights;
    }
    
    //get number of beds
    public int getNumberOfBeds() {
    	
    	return this.numberOfBeds;
    }
    
    //get number of bedrooms
    public int getNumberofBedrooms() {
    	
    	return this.numberOfBedrooms;
    }
    
    //get number of bathrooms
    public int getNumberOfBathrooms() {
    	
    	return this.numberOfBathrooms;
    }
    
    //get lodging size in square feet
    public int getLodgingSizeInSquareFeet() {
    	
    	return this.lodgingSizeInSqFeet;
    }
    
    //get price
    public double getPrice() {
    	
    	//double priceCalculation
    	return this.price;
    }
    
    //get reservation status
    public String getReservationStatus() {
    	
    	return this.reservationStatus;
    }
    
    //set methods. 
    
    
    //set lodging physical address
    public void setLodgingPhysicalAddress(Address newAddress) {
    	
    	if(newAddress!=null) {
    		
    		this.lodgingPhysicalAddress = newAddress;
    	}
    	else {
    		
    		throw new IllegalArgumentException("Error. The physical address cannot be set to a blank address.");
    	}
    	
    }
    
  //set lodging mailing address
    public void setMailingAddress(Address newAddress) {
    	
    	if(newAddress!=null) {
    		
    		this.lodgingMailingAddress = newAddress;
    	}
    	else {
    		
    		throw new IllegalArgumentException("Error. The mailing address cannot be set to a blank address.");
    	}
    	
    	
    }
    
    
    //set number of nights
    public void setNumberOfNights(int newNumber) {
    	
    	if(newNumber > 0) {
    		
    		this.numberOfNights = newNumber;
    	}
    	else {
    		
    		throw new IllegalArgumentException("Error. The number of nights must be greater than 0.");
    	}
    	
    	
    }

    //set number of beds
    public void setNumberOfBeds(int newNumber) {
    	
    	if(newNumber > 0) {
    		
    		this.numberOfBeds = newNumber;
    	}
    	else {
    		
    		throw new IllegalArgumentException("Error. The number of beds must be greater than 0.");
    	}
    	
    }

    //set number of bedrooms
    public void setNumberOfBedrooms(int newNumber) {
    	
    	if(newNumber > 0) {
    		
    		this.numberOfBedrooms = newNumber;
    	}
    	else {
    		
    		throw new IllegalArgumentException("Error. The number of bedrooms must be greater than 0.");
    	}
    	
    }
    
    //set number of bathrooms
    public void setNumberOfBathrooms(int newNumber) {
    	
    	if(newNumber > 0 ) {
    		this.numberOfBathrooms = newNumber;
    	}
    	else {
    		throw new IllegalArgumentException("Number of bathrooms must be greater than 0.");
    	}
    }
    
    
    //set lodging size in square feet
    public void setLodgingSizeInSquareFeet(int newSize) {
    	if(newSize > 1) {
    		this.lodgingSizeInSqFeet = newSize;
    	}
    	else {
    		throw new IllegalArgumentException("Invalid value for lodging size in square feet.");
    	}
    }
    
    
    public double calculateReservationPrice() {
    	
    	//Basic price is $120 with an additional fee of $15 if the lodging size is greater than 900 square feet.
    	
    	//Set basic price
    	double newPriceCalculation = 120;
    	
    	//if it is large, set the boolean to true
    	if(lodgingSizeInSqFeet > 900) {
    		newPriceCalculation += 15;
    	}
    	
    	return newPriceCalculation; 
    }
       
    //set price
    public void setPrice(double newPrice) {
    	
    	//check if the reservation has been completed
    	if(this.reservationStatus.toLowerCase() == "completed") {
    		
    		this.price = newPrice;
    	}
    	else {
    		throw new IllegalArgumentException("Price can only be set when reservation is complete. Try calculating the price instead.");
    	}
    	
    }
    
    //abstract method to create and return a copy of the object
    abstract public Reservation clone();

    // toString() method will output the class’s formatted data to the screen, and return it. 
    public String toString() {
    	
    	//format the data    
   	 		String reservation = "<reservation>" +
   	 				"<accountNumber>" + accountNumber + "</accountNumber>" +
   	 				"<reservationNumber>" + reservationNumber + "</reservationNumber>" +
   	 				"<lodgingPhysicalAddress>" + lodgingPhysicalAddress + "</lodgingPhysicalAddress>" +
   	 				"<lodgingMailingAddress>" + lodgingMailingAddress+ "</lodgingMailingAddress>" +
   	 				"<numberOfNights>" + numberOfNights + "</numberOfNights>" +
   	 				"<lodgingSizeInSqFeet>" + lodgingSizeInSqFeet + "</lodgingSizeInSqFeet>" +
   	 				"<price>" + price + "</price>" +
   	 				"<reservationStatus>" + reservationStatus + "</reservationStatus>" +
   	 				"</reservation>";
   	 	
   	 		// Output the Address object's data to the screen as formatted data
   	 		System.out.println(reservation);   
  
       
       //return the address as a String
        return reservation;
    	
    }

	protected abstract void setReservationStatus(String string);
	

        
}