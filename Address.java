package lodgingapp;

import java.io.*;
import java.util.*;

//A class to hold an address
public class Address {

    //Constructor with individual parameters
    public Address(String street, String city, String state, String zip){
          //Check the values. If valid, set values. Else, throw exception.
           if(street.length() !=  0 && city.length() != 0 && state.length() != 0 && zip.length() != 0) {

                 this.street = street;
                 this.city = city;
                 this.state = state;
                 this.zip = zip;               
            }
            else {
                throw new IllegalArgumentException("Address not saved. Values for address cannot be blank.");
            }
 
     
    }
    
    //toString() method will output the formatted address data to the screen. 
   public String toString() {
   	
   		//format data
   	 	String address = "<address>" +
   	 			"<street>" + street + "</street>" +
   	 			"<city>" + city + "</city>" +
   	 			"<state>" + state + "</state>" +
   	 			"<zip>" + zip + "</zip>" +
   	 			"</address>";
   	 
   	 	// Output the Address object's data to the screen as formatted data
   	 	System.out.println(address);
      
   	 	//return the address as a String
   	 	return address;
   
   }//end toString
   
   //toStringQuiet() method will return the data without outputting it. 
  public String toStringQuiet() {
  	
  		//format data
  	 	String address = "<address>" +
  	 			"<street>" + street + "</street>" +
  	 			"<city>" + city + "</city>" +
  	 			"<state>" + state + "</state>" +
  	 			"<zip>" + zip + "</zip>" +
  	 			"</address>";
     
  	 	//return the address as a String
  	 	return address;
  
  }//end toString

     public Address(String line) {
    	//parse the line and set values
    	 street = line.substring(line.indexOf("<street>") + 8, line.indexOf("</street>"));
         city = line.substring(line.indexOf("<city>") + 6, line.indexOf("</city>"));
         state = line.substring(line.indexOf("<state>") + 7, line.indexOf("</state>"));
         zip = line.substring(line.indexOf("<zip>") + 5, line.indexOf("</zip>"));

         if (street == null || city == null || state == null || zip == null
                 || street.length() == 0 || city.length() == 0 || state.length() == 0 || zip.length() == 0)
             throw new IllegalArgumentException("Parameter values cannot be null or empty strings");
    	 
	}

	// Name of the street
    private String street;

    //Name of the city
    private String city;

     //Name of the state
    private String state;

     //zip_code
    private String zip;
    
    //methods
    
    //get methods
    
    //get street name
    public String getStreet() {
    	
    	return this.street;
    }
    
  //get state
    public String getCity() {
    	
    	return this.city;
    }
    
    //get state
    public String getState() {
    	
    	return this.state;
    }
    
    //get zipcode
    public String getZip() {
    	
    	return this.zip;
    }
    
    //set methods
    
    //set street
    public void setStreet(String newStreet) {
    	if(newStreet!= null) {
    		
    		this.street = newStreet;
    	}
    	else {
    		
    		throw new IllegalArgumentException("Error: Street name cannot be blank.");
    	}
    	
    }
    
    //set state
    public void setCity(String newCity) {
    	if(newCity!= null) {
    		
    		this.city = newCity;
    	}
    	else {
    		
    		throw new IllegalArgumentException("Error: City cannot be blank.");
    	}
    	
    }
    
    //set state
    public void setState(String newState) {
    	if(newState!= null) {
    		
    		this.state = newState;
    	}
    	else {
    		
    		throw new IllegalArgumentException("Error: State cannot be blank.");
    	}
    	
    }
    
    //set zip code
    public void setZip(String newZip) {
    	if(newZip!= null) {
    		
    		this.zip = newZip;
    	}
    	else {
    		
    		throw new IllegalArgumentException("Error: Zip cannot be blank.");
    	}
    	
    }

     
 
    
  //create and return a copy of the object
	  public Address clone() {
		  
		  //create a copy
		  Address cloneAddress = new Address(this.street, this.city, this.state, this.zip);
		  
		  //return the copy
		  return cloneAddress;
		
	  }

}

