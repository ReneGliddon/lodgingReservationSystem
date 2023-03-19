package lodgingapp;

import java.io.*;
import java.util.*;

public class Account {

    
    // Constructor
    public Account(String accountNumber, Address mailingAddress, String emailAddress, String phoneNumber){

        //Check the values. If valid, set values. Else, throw exception.
        if(accountNumber!=null && mailingAddress != null && emailAddress != null && phoneNumber != null) {
	   
            //initialize the attributes to the parameters
            this.accountNumber = accountNumber +"-99";
            this.mailingAddress = mailingAddress;
            this.emailAddress = emailAddress;
            this.phoneNumber = phoneNumber;

            //Create a blank list as new account has no reservations.
            this.reservations = new ArrayList<String>();
           
           //send this object to the toString method
           //this.toString();
           
               
        }
        else {
                throw new IllegalArgumentException("Account not saved. Values for Account cannot be blank.");
        }
    }
    
    //toString() method will output the class’s data to the screen and return formatted data 
    public String toString() {

      	//format data
      	 String account = "<account>" + 
      		"<accountNumber>" + accountNumber + "</accountNumber>" +
           "<mailingAddress>" + mailingAddress + "</mailingAddress>" +
           "<emailAddress>" + emailAddress + "</emailAddress>" +
           "<phoneNumber>" + phoneNumber + "</phoneNumber>" +
           "</account>";      	 	
      	
      	 
        // Output the class's data to the screen as formatted data
      	System.out.println(account);

        //return the String
        return account;
  
    }
    
    //a constructor that takes a single XML formatted string value
    public Account(String line) {

    	//parse the line and set values
    	
    	//account number value
    	this.accountNumber = line.substring(line.indexOf("<accountNumber>") + 15, line.indexOf("</accountNumber>"));
    	
    	//mailing address value
    	
    		//extract the address as a string
    		String newMailingAddress = line.substring(line.indexOf("<mailingAddress>") + 16, line.indexOf("</mailingAddress>"));
    	
    		//convert to an Address object
    		Address newAddress = new Address(newMailingAddress); 
    	
    	//save the variable as an Address object
    	this.mailingAddress = newAddress;
    	 
    	 //email address value
    	this.emailAddress = line.substring(line.indexOf("<emailAddress>") + 14, line.indexOf("</emailAddress>"));
    	
    	//phone number value
    	this.phoneNumber = line.substring(line.indexOf("<phoneNumber>") + 13, line.indexOf("</phoneNumber>"));
    	
    	//create a new blank reservations list
    	 this.reservations = new ArrayList<String>();
    	

        if (accountNumber == null || mailingAddress == null || emailAddress == null || phoneNumber == null
                || accountNumber.length() == 0 || newMailingAddress.length() == 0 || emailAddress.length() == 0 || phoneNumber.length() == 0)
            throw new IllegalArgumentException("Parameter values cannot be null or empty strings");
    }

    //Attributes

    //accountNumber is a unique number generated and provided by UI.
    private String accountNumber;

    //mailingAddress is the mailing address for the Account
    private Address mailingAddress;

    //emailAddress is the email address associated with the account
    private String emailAddress;

     //phoneNumber is the phone number associated with the account
    private String phoneNumber;

     //List<String> reservations is a list holding the reservation numbers of the reservations associated with an account.
    //private List<Reservation> reservations;
    private List<String> reservations;

    //Methods
    
    //get methods
    
    public String getAccountNumber() {
    	
    	return this.accountNumber;
    }
    
    public Address getMailingAddress() {
    	
    	return this.mailingAddress;
    }
    
    public String getEmailAddress() {
    	
    	return this.emailAddress;
    }
    
    public String getPhoneNumber() {
    	
    	return this.phoneNumber;
    }
    
    public List<String> getReservations(){
    	
    	return this.reservations;
    }
   
    
    //set methods
    
    //set mailing address
    public void setMailingAddress(Address newMailingAddress) {
    	try {
    			this.mailingAddress = newMailingAddress;
    	}catch(Exception e) {
    			throw new IllegalStateException("Cannot change the mailing address");
    	}
    }
    
    
    public void setEmailAddress(String newEmail) {
    	
    	//check the format of the email address
    	int end = newEmail.length();
    	int start = end - 4;
    	int atIndex = newEmail.indexOf('@');
    	Boolean at = newEmail.contains("@");
    	
    	String email = newEmail.substring(start, end);
    	
    	if(email.equals(".com") && at.equals(true) && atIndex < start) {
    	
    		this.emailAddress = newEmail;
    	}
    	else {
    		throw new IllegalArgumentException("Invalid email address");
    	}
    }
    
    //set phone number
    public void setPhoneNumber(String newPhoneNumber) {
    	
    	//check if the phone number is long enough
    	if(newPhoneNumber.length() < 10) {
    		
    		throw new IllegalArgumentException("Invalid phone number");
    	}
    	else {
    		
    		this.phoneNumber = newPhoneNumber;
    	}
    	
    }
    
    //set (add) a reservation into the list
    public void addReservation(String newReservation){
    	
    	if(newReservation != null) {
    		
    		//if the list was empty before, then change the account number after adding a reservation
    		if(this.reservations.isEmpty()) {
    	  	
    			this.reservations.add(newReservation);
    		    			
    			//find the - from "-99" and remove the "-99"
    			int index = this.accountNumber.indexOf('-');
    			this.accountNumber = this.accountNumber.substring(0,index);
    			
    			//TODO: rewrite the file
    			
    		}
    		else
    			this.reservations.add(newReservation);
    	}
    	else {
    		throw new IllegalArgumentException("Invalid reservation");
    	}
    		
  
    }
    
   //in the case of changing from an empty to non-empty reservation list, change account number
    public void updateAccountNumber() {
    	
    	int index = this.accountNumber.indexOf("-99");
    	
    	if(index != 0) {
    		this.accountNumber = this.accountNumber.substring(0,index);
    	}
    }
    
    //create and return a clone of the object
    public Account clone() {
    	
    	//create a clone object
        	
    	String cloneString = this.toString();
    	Account cloneAccount  = new Account(cloneString);
    	
    	//return the clone object
    	return cloneAccount;
    	
    }

}