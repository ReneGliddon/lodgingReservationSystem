import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
//import java.text.SimpleDateFormat;
/**
 * House reservation
 */

public class HouseReservation extends Reservation {
	
	//Constructors

     //Constructor without mailing address, bed, bedroom and bathroom number
    public HouseReservation(String accountNumber, String reservationNumber, Address lodgingPhysicalAddress, int numberOfNights,
    int lodgingSizeInSqFeet, double price, String reservationStatus, Date startDate,  int numberOfFloors) {

        super(accountNumber, reservationNumber, lodgingPhysicalAddress, numberOfNights,lodgingSizeInSqFeet, price, reservationStatus);

        //Check the additional values. If valid, set values. Else, throw exception.
        if(numberOfFloors != 0) {

            // validate that source and destination are not the same
        	this.startDate = startDate;
        	
            //initialize the attributes to the parameters
            //default values to be set:
            this.numberOfFloors = numberOfFloors;

            // Number of beds (default 2)
            this.numberOfBeds = 2;

            // Number of bedrooms (default 1)
            this.numberOfBedrooms = 1;

            // Number of bathrooms (default 1)
            this.numberOfBathrooms = 1;
    
            
        }
        else {
                throw new IllegalArgumentException("Reservation not saved. Please indicate the number of floors for a house reservation.");
        }
    }
    
    //Constructor without mailing address, price, bed, bedroom and bathroom number
    public HouseReservation(String accountNumber, String reservationNumber, Address lodgingPhysicalAddress, int numberOfNights,
    int lodgingSizeInSqFeet, String reservationStatus, Date startDate,  int numberOfFloors) {

        super(accountNumber, reservationNumber, lodgingPhysicalAddress, numberOfNights,lodgingSizeInSqFeet, reservationStatus);

        //Check the additional values. If valid, set values. Else, throw exception.
        if(numberOfFloors != 0) {

            // validate that source and destination are not the same
        	this.startDate = startDate;
        	
            //initialize the attributes to the parameters
            //default values to be set:
            this.numberOfFloors = numberOfFloors;

            // Number of beds (default 2)
            this.numberOfBeds = 2;

            // Number of bedrooms (default 1)
            this.numberOfBedrooms = 1;

            // Number of bathrooms (default 1)
            this.numberOfBathrooms = 1;
    
            
        }
        else {
                throw new IllegalArgumentException("Reservation not saved. Please indicate the number of floors for a house reservation.");
        }
    }

    //Constructor with mailing address, price, bed, bedroom and bathroom number
   public HouseReservation(String accountNumber, String reservationNumber, Address lodgingPhysicalAddress, Address lodgingMailingAddress, int numberOfNights,
   int lodgingSizeInSqFeet, double price, String reservationStatus,  Date startDate, int numberOfFloors) {

       super(accountNumber, reservationNumber, lodgingPhysicalAddress,  numberOfNights,lodgingSizeInSqFeet, price, reservationStatus);

       //Check the additional values. If valid, set values. Else, throw exception.
       if(numberOfFloors != 0) {

           // validate that source and destination are not the same
    	   this.startDate =  startDate;
           //initialize the attributes to the parameters
           //default values to be set:
           this.numberOfFloors = numberOfFloors;

           // Number of beds (default 2)
           this.numberOfBeds = 2;

           // Number of bedrooms (default 1)
           this.numberOfBedrooms = 1;

           // Number of bathrooms (default 1)
           this.numberOfBathrooms = 1;
   
           
       }
       else {
               throw new IllegalArgumentException("Reservation not saved. Please indicate the number of floors for a house reservation.");
       }
   }
    
   //Constructor with mailing address, bed, bedroom and bathroom number but not price
  public HouseReservation(String accountNumber, String reservationNumber, Address lodgingPhysicalAddress, Address lodgingMailingAddress, int numberOfNights,
  int lodgingSizeInSqFeet, String reservationStatus,  Date startDate, int numberOfFloors) {

      super(accountNumber, reservationNumber, lodgingPhysicalAddress,  numberOfNights,lodgingSizeInSqFeet, reservationStatus);

      //Check the additional values. If valid, set values. Else, throw exception.
      if(numberOfFloors != 0) {

          // validate that source and destination are not the same
   	   this.startDate =  startDate;
          //initialize the attributes to the parameters
          //default values to be set:
          this.numberOfFloors = numberOfFloors;

          // Number of beds (default 2)
          this.numberOfBeds = 2;

          // Number of bedrooms (default 1)
          this.numberOfBedrooms = 1;

          // Number of bathrooms (default 1)
          this.numberOfBathrooms = 1;
  
          
      }
      else {
              throw new IllegalArgumentException("Reservation not saved. Please indicate the number of floors for a house reservation.");
      }
  }
   
     //Constructor without mailing address, but with price, bed, bedroom and bathroom number
    public HouseReservation(String accountNumber, String reservationNumber, Address lodgingPhysicalAddress,  int numberOfNights,
    int lodgingSizeInSqFeet, double price, String reservationStatus, Date startDate, int numberOfFloors, int numberOfBeds, int numberOfBedrooms, int numberOfBathrooms) {

        super(accountNumber, reservationNumber, lodgingPhysicalAddress,  numberOfNights,lodgingSizeInSqFeet, price, reservationStatus);

        //Check the additional values. If valid, set values. Else, throw exception.
        if(numberOfFloors != 0 && numberOfBedrooms !=0 && numberOfBedrooms != 0 && numberOfBathrooms != 0) {

            // validate that source and destination are not the same
        	this.startDate = startDate;
        	
            //Initialize the attributes to the parameters
            //default values to be set:
            this.numberOfFloors = numberOfFloors;

            // Number of beds (default 2)
            this.numberOfBeds = numberOfBeds;

            // Number of bedrooms (default 1)
            this.numberOfBedrooms = numberOfBedrooms;

            // Number of bathrooms (default 1)
            this.numberOfBathrooms = numberOfBathrooms;   
            
        }
        else {
                throw new IllegalArgumentException("Reservation not saved. The number of floors, beds, bedrooms and bathrooms cannot be 0.");
        }

      
    }
    
    //Constructor without mailing address and price, but with bed, bedroom and bathroom number
    public HouseReservation(String accountNumber, String reservationNumber, Address lodgingPhysicalAddress,  int numberOfNights,
    int lodgingSizeInSqFeet, String reservationStatus, Date startDate, int numberOfFloors, int numberOfBeds, int numberOfBedrooms, int numberOfBathrooms) {

        super(accountNumber, reservationNumber, lodgingPhysicalAddress,  numberOfNights,lodgingSizeInSqFeet,  reservationStatus);

        //Check the additional values. If valid, set values. Else, throw exception.
        if(numberOfFloors != 0 && numberOfBedrooms !=0 && numberOfBedrooms != 0 && numberOfBathrooms != 0) {

            // validate that source and destination are not the same
        	this.startDate = startDate;
        	
            //Initialize the attributes to the parameters
            //default values to be set:
            this.numberOfFloors = numberOfFloors;

            // Number of beds (default 2)
            this.numberOfBeds = numberOfBeds;

            // Number of bedrooms (default 1)
            this.numberOfBedrooms = numberOfBedrooms;

            // Number of bathrooms (default 1)
            this.numberOfBathrooms = numberOfBathrooms;   
            
        }
        else {
                throw new IllegalArgumentException("Reservation not saved. The number of floors, beds, bedrooms and bathrooms cannot be 0.");
        }

      
    }
    //Default constructor with mailing address, bed, bedroom and bathroom number (all data)
   public HouseReservation(String accountNumber, String reservationNumber, Address lodgingPhysicalAddress, Address lodgingMailingAddress, int numberOfNights,
   int lodgingSizeInSqFeet, double price, String reservationStatus, Date startDate, int numberOfFloors,  int numberOfBeds, int numberOfBedrooms, int numberOfBathrooms) {

       super(accountNumber, reservationNumber, lodgingPhysicalAddress, lodgingMailingAddress,  numberOfNights,lodgingSizeInSqFeet, price, reservationStatus);

       //Check the additional values. If valid, set values. Else, throw exception.
       if(numberOfFloors != 0) {

           // validate that source and destination are not the same
    	   this.startDate = startDate;
    	   
    	   //Initialize the attributes to the parameters
           this.numberOfFloors = numberOfFloors;

           // Number of beds (default 2)
           this.numberOfBeds = numberOfBeds;

           // Number of bedrooms (default 1)
           this.numberOfBedrooms = numberOfBedrooms;

           // Number of bathrooms (default 1)
           this.numberOfBathrooms = numberOfBathrooms;  
   
           
       }
       else {
               throw new IllegalArgumentException("Reservation not saved. Please indicate the number of floors for a house reservation.");
       }
   }
   
   //constructor that takes a formatted string
   public HouseReservation(String line) throws ParseException
   {
   	super(line);     

   	numberOfFloors  = Integer.parseInt(line.substring(line.indexOf("<numberOfFloors>") + 16, line.indexOf("</numberOfFloors")));    
   	numberOfBeds = Integer.parseInt(line.substring(line.indexOf("<numberOfBeds>") + 14, line.indexOf("</numberOfBeds>")));
   	numberOfBedrooms = Integer.parseInt(line.substring(line.indexOf("<numberOfBedrooms>") + 18, line.indexOf("</numberOfBedrooms>")));
   	numberOfBathrooms = Integer.parseInt(line.substring(line.indexOf("<numberOfBathrooms>") + 19, line.indexOf("</numberOfBathrooms>")));      

       // validate values
   	if (numberOfFloors <= 0 || numberOfBeds <= 0 || numberOfBedrooms <= 0 || numberOfBathrooms <= 0)
   		throw new IllegalArgumentException("Values cannot be null or empty strings");
   	
   }
    
    //Additional attributes

    //An integer to indicate how many floors the house has
    private int numberOfFloors;

    private Date startDate;

    // Methods
    
    //get start date
    public Date getStartDate() {
    	return this.startDate;
    }
    
    //get numberOfFloors
    public int getNumberOfFloors() {
    	
    	return this.numberOfFloors;   	
    	    	
    }
    
   
    
  //set reservation status
    public void setReservationStatus(String newStatus) {
   
    	  
    	//check the status is valid
    	if(newStatus.toLowerCase() == "draft" || newStatus.toLowerCase() == "completed" || newStatus.toLowerCase() == "cancelled") {
    		
    		//check the date if the new status is "cancelled"
    		if(newStatus.toLowerCase() == "cancelled") {
    			
    			//current date
    			Date now = new Date(System.currentTimeMillis());
    			
    			//format the reservation date
    			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    			
    			//send the reservation to the toString
				String line = this.toString();
				
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
    	
    	//Basic price is $120 with an additional fee of $15 if the lodging size is greater than 900 square feet.
    	double newPriceCalculation = super.calculateReservationPrice();
    	
    	
    	return newPriceCalculation; 
    }
       
 public void setPrice(double newPrice) 
 {
	 //Reservation will set the price  
	 super.setPrice(newPrice);
 }
    //set numberOfFloors
    public void setNumberOfFloors(int newNumber) {
    	
    	if(newNumber > 0) {
    		
    		this.numberOfFloors = newNumber;
    	}
    	else {
    		
    		throw new IllegalArgumentException("Error. The number of floors must be greater than 0.");
    	}

    }
    
    // toString() method will output the class’s data to the screen and return formatted data 
    public String toString()  {
    	//format data
    	SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    	
    	 String houseReservation =  "<houseReservation>" +
                 super.toString() + 
                 "<startDate>" + formatter.format(startDate )+ "</startDate>" +
                 "<numberOfFloors>" + numberOfFloors + "</numberOfFloors>" +
                 "<numberOfBeds>" + numberOfBeds + "</numberOfBeds>" +
                 "<numberOfBedrooms>" + numberOfBedrooms + "</numberOfBedrooms>" +
                 "<numberOfBathrooms>" + numberOfBathrooms + "</numberOfBathrooms>" +
                 "</houseReservation>";                	   	 	

        // Output the class's data to the screen as formatted data
    	 System.out.println(houseReservation);
    	 
        
        return houseReservation;
    }
    
 
    //TODO create file writing methods to simplify the other methods
    // save the object data to the provided file
  /*  public void saveToFile(String fileName, String writeThis) throws Exception
    {
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
   public HouseReservation clone() {
	   
	   //create a new object with copied attributes	
	   HouseReservation newHouseRes = new HouseReservation(this.accountNumber, this.reservationNumber, this.lodgingPhysicalAddress, 
			   							this.lodgingMailingAddress, this.numberOfNights, this.lodgingSizeInSqFeet, this.price, this.reservationStatus, this.startDate, this.numberOfFloors,
			   							this.numberOfBeds, this.numberOfBedrooms, this.numberOfBathrooms);
	   //return new object
	   return newHouseRes;
   }
   
  
}
