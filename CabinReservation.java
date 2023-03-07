import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.Date;
/**
 * Cabin reservation
 */
public class CabinReservation extends Reservation {

     //Constructor without mailing address and with default values.
		public CabinReservation(String accountNumber, String reservationNumber, Address lodgingPhysicalAddress, Date startDate, int numberOfNights,
				int lodgingSizeInSqFeet, double price, String reservationStatus, Boolean fullKitchen, Boolean loft) {

				super(accountNumber, reservationNumber, lodgingPhysicalAddress,  numberOfNights,lodgingSizeInSqFeet, price, reservationStatus);
				
				//Check the additional values. If valid, set values. Else, throw exception.
				if((fullKitchen == false || fullKitchen == true) && (loft == true || loft == false)) {
    
				//initialize the attributes to the parameters
					this.fullKitchen = fullKitchen;
					this.loft = loft;       
					this.startDate =startDate;
					//default values to be set
					numberOfBathrooms = 1;
					numberOfBedrooms = 1;
					numberOfBeds = 2;
      
            
        }
        else {
                throw new IllegalArgumentException("Reservation not saved. Please indicate whether there is a full kitchen and/or a loft.");
        }
	}

	//Constructor without mailing address and price and with default values.
	public CabinReservation(String accountNumber, String reservationNumber, Address lodgingPhysicalAddress, Date startDate, int numberOfNights,
			int lodgingSizeInSqFeet,  String reservationStatus, Boolean fullKitchen, Boolean loft) {

			super(accountNumber, reservationNumber, lodgingPhysicalAddress,  numberOfNights,lodgingSizeInSqFeet, reservationStatus);
						
			//Check the additional values. If valid, set values. Else, throw exception.
			if((fullKitchen == false || fullKitchen == true) && (loft == true || loft == false)) {
		    
				//initialize the attributes to the parameters
				this.fullKitchen = fullKitchen;
				this.loft = loft;       
				this.startDate =startDate;
				//default values to be set
				numberOfBathrooms = 1;
				numberOfBedrooms = 1;
				numberOfBeds = 2;
		     }
		     else {
		              throw new IllegalArgumentException("Reservation not saved. Please indicate whether there is a full kitchen and/or a loft.");
		        }
    }

    //Constructor with mailing address, price and default values
    public CabinReservation(String accountNumber, String reservationNumber, Address lodgingPhysicalAddress, Address lodgingMailingAddress, Date startDate, int numberOfNights,
    int lodgingSizeInSqFeet, double price, String reservationStatus, Boolean fullKitchen, Boolean loft) {

        super(accountNumber, reservationNumber, lodgingPhysicalAddress, lodgingMailingAddress, numberOfNights,lodgingSizeInSqFeet, price, reservationStatus);

         //Check the additional values. If valid, set values. Else, throw exception.
         if((fullKitchen == false || fullKitchen == true) && (loft == true || loft == false)) {
    
            //initialize the attributes to the parameters
            this.fullKitchen = fullKitchen;
            this.loft = loft;       
            this.startDate =  startDate;
            
            //default values to be set
            numberOfBathrooms = 1;
            numberOfBedrooms = 1;
            numberOfBeds = 2;
      
            
        }
        else {
                throw new IllegalArgumentException("Reservation not saved. Please indicate whether there is a full kitchen and/or a loft.");
        }
    }
    
    //Constructor with mailing address, and default values but without price
    public CabinReservation(String accountNumber, String reservationNumber, Address lodgingPhysicalAddress, Address lodgingMailingAddress, Date startDate, int numberOfNights,
    int lodgingSizeInSqFeet, String reservationStatus, Boolean fullKitchen, Boolean loft) {

        super(accountNumber, reservationNumber, lodgingPhysicalAddress, lodgingMailingAddress, numberOfNights,lodgingSizeInSqFeet, reservationStatus);

         //Check the additional values. If valid, set values. Else, throw exception.
         if((fullKitchen == false || fullKitchen == true) && (loft == true || loft == false)) {
    
            //initialize the attributes to the parameters
            this.fullKitchen = fullKitchen;
            this.loft = loft;       
            this.startDate =  startDate;
            
            //default values to be set
            numberOfBathrooms = 1;
            numberOfBedrooms = 1;
            numberOfBeds = 2;
      
            
        }
        else {
                throw new IllegalArgumentException("Reservation not saved. Please indicate whether there is a full kitchen and/or a loft.");
        }
    }

    //Constructor without mailing address, but with price, and number of beds,bathrooms, and bedrooms.
     public CabinReservation(String accountNumber, String reservationNumber, Address lodgingPhysicalAddress, Date startDate, int numberOfNights,
                            int lodgingSizeInSqFeet, double price, String reservationStatus, Boolean fullKitchen, Boolean loft, int numberOfBedrooms, int numberOfBeds, int numberOfBathrooms) {
    
            super(accountNumber, reservationNumber, lodgingPhysicalAddress, numberOfNights,lodgingSizeInSqFeet, price, reservationStatus);

            //Check the additional values. If valid, set values. Else, throw exception.
             if(numberOfBedrooms !=0 && numberOfBeds != 0 && numberOfBathrooms != 0 && (fullKitchen == false || fullKitchen == true) && (loft == true || loft == false)) {
    
            //initialize the attributes to the parameters
            
            //start date
            this.startDate = startDate;
            
            // Number of bedrooms
             this.numberOfBedrooms = numberOfBedrooms;

            // Number of beds
            this.numberOfBeds = numberOfBeds;

            // Number of bathrooms
            this.numberOfBathrooms = numberOfBathrooms;   
    
            //full  kitchen and/or loft
            this.fullKitchen = fullKitchen;
            this.loft = loft;                 
                
            }
            else {
                    throw new IllegalArgumentException("Reservation not saved. Please indicate whether there is a full kitchen and/or a loft, " + 
                                                        "as well as the number of beds, bedrooms and bathrooms (cannot be 0).");
            }
    
            
        }
     
     //Constructor without mailing address and price, and with number of beds,bathrooms, and bedrooms.
     public CabinReservation(String accountNumber, String reservationNumber, Address lodgingPhysicalAddress, Date startDate, int numberOfNights,
                            int lodgingSizeInSqFeet, String reservationStatus, Boolean fullKitchen, Boolean loft, int numberOfBedrooms, int numberOfBeds, int numberOfBathrooms) {
    
            super(accountNumber, reservationNumber, lodgingPhysicalAddress, numberOfNights,lodgingSizeInSqFeet,  reservationStatus);
            

            //Check the additional values. If valid, set values. Else, throw exception.
             if(numberOfBedrooms !=0 && numberOfBeds != 0 && numberOfBathrooms != 0 && (fullKitchen == false || fullKitchen == true) && (loft == true || loft == false)) {
    
            	 //initialize the attributes to the parameters
            
            	 //start date
            	 this.startDate = startDate;
            
            	 // Number of bedrooms
            	 this.numberOfBedrooms = numberOfBedrooms;

            	 // Number of beds
            	 this.numberOfBeds = numberOfBeds;

            	 // Number of bathrooms
            	 this.numberOfBathrooms = numberOfBathrooms;   
    
            	 //full  kitchen and/or loft
            	 this.fullKitchen = fullKitchen;
            	 this.loft = loft;                 
                
            }
            else {
                    throw new IllegalArgumentException("Reservation not saved. Please indicate whether there is a full kitchen and/or a loft, " + 
                                                        "as well as the number of beds, bedrooms and bathrooms (cannot be 0).");
            }
    
            
        }


     //Constructor with mailing address, price, number of beds,bathrooms, and bedrooms.
     public CabinReservation(String accountNumber, String reservationNumber, Address lodgingPhysicalAddress, Address lodgingMailingAddress, Date startDate, int numberOfNights,
    		 int lodgingSizeInSqFeet, double price, String reservationStatus, Boolean fullKitchen, Boolean loft, int numberOfBedrooms, int numberOfBeds, int numberOfBathrooms) {

    	 	super(accountNumber, reservationNumber, lodgingPhysicalAddress, lodgingMailingAddress, numberOfNights,lodgingSizeInSqFeet, price, reservationStatus);

    	 	//Check the additional values. If valid, set values. Else, throw exception.
    	 	if(numberOfBedrooms !=0 && numberOfBeds != 0 && numberOfBathrooms != 0 && (fullKitchen == false || fullKitchen == true) && (loft == true || loft == false)) {

    	 		//initialize the attributes to the parameters
    	 		this.startDate = startDate;
    	 		// Number of bedrooms
    	 		this.numberOfBedrooms = numberOfBedrooms;

    	 		// Number of beds
    	 		this.numberOfBeds = numberOfBeds;

    	 		// Number of bathrooms
    	 		this.numberOfBathrooms = numberOfBathrooms;   

    	 		//full  kitchen and/or loft
    	 		this.fullKitchen = fullKitchen;
    	 		this.loft = loft;                 

    	 	}
    	 	else {
    	 		throw new IllegalArgumentException("Reservation not saved. Please indicate whether there is a full kitchen and/or a loft, " + 
                                 "as well as the number of beds, bedrooms and bathrooms (cannot be 0).");
    	 	}

     }
     

     //Constructor with mailing address, number of beds,bathrooms, and bedrooms, but without price.
     public CabinReservation(String accountNumber, String reservationNumber, Address lodgingPhysicalAddress, Address lodgingMailingAddress, Date startDate, int numberOfNights,
    		 int lodgingSizeInSqFeet, String reservationStatus, Boolean fullKitchen, Boolean loft, int numberOfBedrooms, int numberOfBeds, int numberOfBathrooms) {

    	 	super(accountNumber, reservationNumber, lodgingPhysicalAddress, lodgingMailingAddress, numberOfNights,lodgingSizeInSqFeet, reservationStatus);
    	 	
    	 	//Check the additional values. If valid, set values. Else, throw exception.
    	 	if(numberOfBedrooms !=0 && numberOfBeds != 0 && numberOfBathrooms != 0 && (fullKitchen == false || fullKitchen == true) && (loft == true || loft == false)) {
    	 		
    	 		//initialize the attributes to the parameters
    	 		this.startDate = startDate;
    	 		// Number of bedrooms
    	 		this.numberOfBedrooms = numberOfBedrooms;

    	 		// Number of beds
    	 		this.numberOfBeds = numberOfBeds;

    	 		// Number of bathrooms
    	 		this.numberOfBathrooms = numberOfBathrooms;   

    	 		//full  kitchen and/or loft
    	 		this.fullKitchen = fullKitchen;
    	 		this.loft = loft;                 

    	 	}
    	 	else {
    	 		throw new IllegalArgumentException("Reservation not saved. Please indicate whether there is a full kitchen and/or a loft, " + 
                                 "as well as the number of beds, bedrooms and bathrooms (cannot be 0).");
    	 	}

     }
   //constructor that takes a formatted string
     public  CabinReservation (String line) throws ParseException
     {
    	 
     	super(line);  

     	numberOfBeds = Integer.parseInt(line.substring(line.indexOf("<numberOfBeds>") + 14, line.indexOf("</numberOfBeds>")));
     	numberOfBedrooms = Integer.parseInt(line.substring(line.indexOf("<numberOfBedrooms>") + 18, line.indexOf("</numberOfBedrooms>")));
     	numberOfBathrooms = Integer.parseInt(line.substring(line.indexOf("<numberOfBathrooms>") + 19, line.indexOf("</numberOfBathrooms>")));   
     	fullKitchen = Boolean.parseBoolean(line.substring(line.indexOf("<fullKitchen>") + 13, line.indexOf("</fullKitchen>")));
     	loft = Boolean.parseBoolean(line.substring(line.indexOf("<loft>") + 6, line.indexOf("</loft>")));
     	
         // validate values
     	if ((fullKitchen != true && fullKitchen != false) || (loft != true && loft!= false) || numberOfBeds <= 0 || numberOfBedrooms <= 0 || numberOfBathrooms <= 0)
     		throw new IllegalArgumentException("Values cannot be null or empty strings");
     }

    //Additional attributes

    // Indication if there is full kitchen or not
    private Boolean fullKitchen;

    //  Indication if cabin includes a loft or not
    private Boolean loft;
    
    //start date
    private Date startDate;
    
    //Methods
    
    //get fullKitchen boolean
    public Boolean getFullKitchen() {
    	
    	return this.fullKitchen;   	
    	    	
    }
    
    //get loft boolean
    public Boolean getLoft() {
    	
    	return this.loft;   	
    	    	
    }
    
  //get startDate
    public Date getStartDate() {
    	
    	return startDate;
    }
    
   
    //set fullKitchen
    public void setFullKitchen(Boolean newBool) {
    	
    	if(newBool == true || newBool == false) {
    		
    		this.fullKitchen = newBool;
    	}
    	else {
    		
    		throw new IllegalArgumentException("Error. Please indicate whether or not there is a full kitchen.");
    	}
    }
    
    //set numberOfFloors
    public void setLoft(Boolean newBool) {
    	
    	if(newBool == true || newBool == false) {
    		
    		this.loft = newBool;
    	}
    	else {
    		
    		throw new IllegalArgumentException("Error. Please indicate whether or not there is a loft.");
    	}
    }
    
  //set reservation status
    public void setReservationStatus(String newStatus) {

    	  
    	//check the status is valid
    	if(newStatus.toLowerCase() == "draft" || newStatus.toLowerCase() == "completed" || newStatus.toLowerCase() == "cancelled") {
    		
    		//check the date if the new status is "cancelled"
    		if(newStatus.toLowerCase() == "cancelled") {
    			
    			//current date
    			Date now = new Date(System.currentTimeMillis());
    			System.out.println("The surrent date is "+ now);
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
    		if(this.reservationStatus.toLowerCase() == "completed") {
    		
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
    	
    	//Cabin has an additional fee of $20 for full kitchen and $5 for each additional bathroom
    	if (this.fullKitchen==true) {
    		newPriceCalculation = newPriceCalculation + 20;
    	}
    	
    	if(this.numberOfBathrooms > 1) {
    		int additionalBathrooms =  this.numberOfBathrooms -1;
    		newPriceCalculation = newPriceCalculation + (additionalBathrooms * 5);
    	}
    	
    	return newPriceCalculation; 
    }
 
 public void setPrice(double newPrice) 
 {
	 //Reservation will set the price  
	 super.setPrice(newPrice);
 }
    
     //toString() method will output the class’s formatted data to the screen, as well as return it.  
  public String toString() {

    	SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    	
        //Format the data
    	String cabinReservation =  "<cabinReservation>" +   super.toString() +  
    	 "<startDate>" + formatter.format(startDate )+ "</startDate>" +
          "<numberOfBeds>" + numberOfBeds + "</numberOfBeds>" + 
    	  "<numberOfBedrooms>" + numberOfBedrooms + "</numberOfBedrooms>" +
          "<numberOfBathrooms>" + numberOfBathrooms + "</numberOfBathrooms>" + 
    	  "<fullKitchen>" + fullKitchen + "</fullKitchen>" +
          "<loft>" + loft + "</loft>" + "</cabinReservation>";
    	
        // Output the class's data to the screen as formatted data
        System.out.println(cabinReservation);
        
      
       //return the String
       return cabinReservation;
       
    }//end toString() 
    
    // TODO:write a method to write to a file to simplify other code save the object data to the provided file
  /*  public void saveToFile(String fileName, String writeThis) throws Exception
    {
    	System.out.println("saving to a file");
    	PrintWriter out = null;
        try
        {
	        // create/override a file given the fileName
	        out = new PrintWriter(fileName);
	        
	        // write out the trip level information using the xml format
	        out.println(writeThis);
	        
	        // close the file
	        out.close();
        }
        catch (Exception e)  // caught an error so can close file
        {
            System.out.println("Error " + e.getMessage());
            if (out != null)
            	out.close();  // close file
            throw e;  // to let UI know there is an issue
        }
    }*/
    
    //create and return a copy of the object
    public CabinReservation clone() {
  
    	//create a clone of the object
    	CabinReservation newCabRes = new CabinReservation(this.accountNumber, this.reservationNumber, this.lodgingPhysicalAddress, this.lodgingMailingAddress, this.startDate, this.numberOfNights,
    								this.lodgingSizeInSqFeet, this.price, this.reservationStatus, this.fullKitchen, this.loft, this.numberOfBedrooms, this.numberOfBeds, this.numberOfBathrooms);
    	//return cloned object
    	return newCabRes;
    } //end clone
    
  
}
