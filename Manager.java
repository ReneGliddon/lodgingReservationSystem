package lodgingapp;

import java.io.*;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

//Manager class stores and manages accounts and reservations
public class Manager {

	//Constructor
    public Manager() throws IOException{
    	
    //manager has a list of accounts to manage
    accounts = new ArrayList<Account>();
    
  //manager has a list of reservations to manage
    reservations = new ArrayList<Reservation>();
   
    }//end of Manager()
    
    // store and manage a single account.Account object at a time
    public Account account;
    
    //account number
    public String accountNumber;

    //directory path
   File myFile = new File("");
   String directory = myFile.getCanonicalPath() + "\\accounts\\"; //can't make a relative path static, so using a private variable with no set method instead
   

    //List<Account> accounts is a list of all accounts 
    private List<Account> accounts;
    
    //List<Account> accounts is a list of all accounts 
    private List<Reservation> reservations;
    
    
    //get the directory path
    public String getDirectory() {
	   
	   return this.directory;
   }
    
    //return a copied list of all accounts
    public List<Account> getAccounts(){
    
    	
    	List<Account> copy = new ArrayList<>(accounts);
    	
    	return copy;
    	
    }
	   
	  
//Retrieve a loaded account object that matches a specific account number 
public Account getAccount(String accountNumber) {
 	
 	Account cloneAccount;
 	String accountString = "";
 	
     // get requested account
 	for(int i = 0; i < accounts.size(); i++) {
 		if(accountNumber.equals(accounts.get(i).getAccountNumber())) {
 			
 			accountString = accounts.get(i).toString();
   			
 		}
 	}
 
 	cloneAccount = new Account (accountString);

     //return requested account
     return cloneAccount;
 }

    //return a copied list of all reservations
    public List<Reservation> getReservations(){
    
    	
    	List<Reservation> copy = new ArrayList<>(reservations);
 
    	return copy;
    	
    }
    
	public void printAccountValues(Account account)	{
		
		System.out.println("\nAccount number: "+account.getAccountNumber()+"\nAccount email: "+ account.getEmailAddress()+"\nAccount phone number: "+account.getPhoneNumber()+"\nAccount address:"+account.getMailingAddress().getStreet()+" "+  account.getMailingAddress().getCity()+" "+account.getMailingAddress().getState()+" "+account.getMailingAddress().getZip());
		System.out.println("Account Reservations: "+account.getReservations());
	}

	public void printHotelReservationValues(HotelReservation reservation) {
		
		//print all values for the object
		System.out.println("\nHotel values from the HotelReservation object:");
		System.out.println("Account number: "+reservation.getAccountNumber());
		System.out.println("Reservation  number: "+ reservation.getReservationNumber());
		System.out.println("Mailing address: "+reservation.getLodgingMailingAddress().getStreet()+" "+reservation.getLodgingMailingAddress().getCity()+" "+reservation.getLodgingMailingAddress().getState()+" "+reservation.getLodgingMailingAddress().getZip());
		System.out.println("Physical address: "+reservation.getLodgingPhysicalAddress().getStreet()+" "+reservation.getLodgingPhysicalAddress().getCity()+" "+reservation.getLodgingPhysicalAddress().getState()+" "+reservation.getLodgingPhysicalAddress().getZip());
		System.out.println("Lodging size in sq feet: "+reservation.getLodgingSizeInSquareFeet());
		System.out.println("Reservation status: "+ reservation.getReservationStatus());
		System.out.println("Start date: "+ reservation.getStartDate());
		System.out.println("Number of bathrooms: "+ reservation.getNumberOfBathrooms());
		System.out.println("Number of bedrooms: "+ reservation.getNumberofBedrooms());
		System.out.println("Number of beds: "+ reservation.getNumberOfBeds());
		System.out.println("Number of nights: "+ reservation.getNumberOfNights());
		System.out.println("Kitchenette: "+ reservation.getKitchenette());
	}
    
	public void printHouseReservationValues(HouseReservation reservation) {
		
		//print all values for the object
		System.out.println("\nHouse values from the HouseReservation object:");
		System.out.println("Account number: "+reservation.getAccountNumber());
		System.out.println("Reservation  number: "+ reservation.getReservationNumber());
		System.out.println("Mailing address: "+reservation.getLodgingMailingAddress().getStreet()+" "+reservation.getLodgingMailingAddress().getCity()+" "+reservation.getLodgingMailingAddress().getState()+" "+reservation.getLodgingMailingAddress().getZip());
		System.out.println("Physical address: "+reservation.getLodgingPhysicalAddress().getStreet()+" "+reservation.getLodgingPhysicalAddress().getCity()+" "+reservation.getLodgingPhysicalAddress().getState()+" "+reservation.getLodgingPhysicalAddress().getZip());
		System.out.println("Lodging size in sq feet: "+reservation.getLodgingSizeInSquareFeet());
		System.out.println("Reservation status: "+ reservation.getReservationStatus());
		System.out.println("Start date: "+ reservation.getStartDate());
		System.out.println("Number of bathrooms: "+ reservation.getNumberOfBathrooms());
		System.out.println("Number of bedrooms: "+ reservation.getNumberofBedrooms());
		System.out.println("Number of beds: "+ reservation.getNumberOfBeds());
		System.out.println("Number of nights: "+ reservation.getNumberOfNights());
		System.out.println("Number of floors: "+ reservation.getNumberOfFloors());
	}
    
	public void printCabinReservationValues(CabinReservation reservation) {
		
		//print all values for the object
		System.out.println("\nCabin values from the CabinReservation object:");
		System.out.println("Account number: "+reservation.getAccountNumber());
		System.out.println("Reservation  number: "+ reservation.getReservationNumber());
		System.out.println("Mailing address: "+reservation.getLodgingMailingAddress().getStreet()+" "+reservation.getLodgingMailingAddress().getCity()+" "+reservation.getLodgingMailingAddress().getState()+" "+reservation.getLodgingMailingAddress().getZip());
		System.out.println("Physical address: "+reservation.getLodgingPhysicalAddress().getStreet()+" "+reservation.getLodgingPhysicalAddress().getCity()+" "+reservation.getLodgingPhysicalAddress().getState()+" "+reservation.getLodgingPhysicalAddress().getZip());
		System.out.println("Lodging size in sq feet: "+reservation.getLodgingSizeInSquareFeet());
		System.out.println("Reservation status: "+ reservation.getReservationStatus());
		System.out.println("Start date: "+ reservation.getStartDate());
		System.out.println("Number of bathrooms: "+ reservation.getNumberOfBathrooms());
		System.out.println("Number of bedrooms: "+ reservation.getNumberofBedrooms());
		System.out.println("Number of beds: "+ reservation.getNumberOfBeds());
		System.out.println("Number of nights: "+ reservation.getNumberOfNights());
		System.out.println("Full kitchen: "+ reservation.getFullKitchen());
		System.out.println("Loft: "+ reservation.getLoft());
	}
  //setUp will  load all files from the folders  
  public void setUp() throws ParseException, IOException {
    	 
    	//get the account folder path
        String path = getDirectory();
        
        //Create a new folder for the accounts
    	String newDirectory = this.getDirectory();  
    	File newAccountFile = new File(newDirectory);
    	newAccountFile.mkdir();
    	
    	//Create a folder for the addresses and accounts
    	int index = newDirectory.indexOf("accounts");
    	newDirectory = newDirectory.substring(0,index);
    	newDirectory = newDirectory + "addresses";
    
    	File newAddressFile = new File(newDirectory);  
    	newAddressFile.mkdir();
    	
    	//test the file reading
    	testFileReading();
    				      
        //get all account numbers from the accounts folder
        //find out how many files there are to load in the directory folder
        File folder = new File(getDirectory());   	
    	File[] listOfFiles = folder.listFiles();
    	
    	//first load account files
        	for (int i = 0; i < listOfFiles.length; i++) {
        		
        		if (listOfFiles[i].isFile()) {
        			
        			System.out.println("File " + listOfFiles[i].getName());
        			
        		} else if (listOfFiles[i].isDirectory()) {
        		
        			//create a path for each file to be loaded
        			String directory = path  + listOfFiles[i].getName();
        
        			//send the path of each file to load
        			try {
        				
        				//load account and its reservations
        				System.out.println("We are going to load the files from the accounts folder. This will READ the files and add them to the Manager's lists.");
        				loadAccounts(directory);
        				
        			} catch (Exception e) {
        				
        				//IllegalLoadException thrown from loadAccounts
        				e.printStackTrace();
        			}
        		}//end if/else block
      
        	}//end for loop
        	
        	//then load reservation files
        	for (int i = 0; i < listOfFiles.length; i++) {
        		
        		if (listOfFiles[i].isFile()) {
        			
        			System.out.println("File " + listOfFiles[i].getName());
        			
        		} else if (listOfFiles[i].isDirectory()) {
        		
        			//create a path for each file to be loaded
        			String directory = path  + listOfFiles[i].getName();
        
        			//send the path of each file to load
        			try {
        				
        				//load account and its reservations
        				loadReservations(directory);
        				
        			} catch (Exception e) {
        				
        				//IllegalLoadException thrown from loadAccounts
        				e.printStackTrace();
        			}
        		}//end if/else block
      
        	}//end for loop
    	
    }
    
//this method adds an initial account and reservation to test the reading of files, and the toString function
public void testFileReading() throws ParseException, IOException {

	System.out.println("\nWe will make an address, account, and reservation file before loading the files, to TEST THE READING functionalities of this program.\n");
	
 //A new Address object
    Address newAddress = new Address("123 Reading Road", "Baltimore", "MD", "11122");
    String address = newAddress.toString();
    System.out.println("\n");
    
 //New Account object
    Account acc = new Account("0987", newAddress, "sampleemail@email.com", "111 222 3333");
    String account = acc.toString();
    System.out.println("\n");
    
 //New Reservation object  
    //formatter
	SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
	//sample hotel reservation
	HotelReservation hotelRes = new HotelReservation("0987", "0000", newAddress, newAddress, 1, 50, 100.90, "draft", formatter.parse("01/01/2023"), true);
    String hotelReservation = hotelRes.toString();
    System.out.println("\n");
    
 //Add these objects to the file only
    
 //address   
  //get the filename
	String filename = address.substring(address.indexOf("<street>") + 8, address.indexOf("</street>"));
	
	//create a name for the possible exception
	String addFile = "add"+filename;

	//Store the file directory
	String newDirectory = getDirectory();
	int index = newDirectory.indexOf("accounts");
	newDirectory = newDirectory.substring(0,index);
	newDirectory = newDirectory + "addresses";
				
	//If there is already an address with the same name, this is an error and the action must not be completed. Rather, send an error.
	try  {  
			
			//add the address file to the new folder
			newDirectory = newDirectory + "\\"+ filename +".txt";
					
			//write to the file
			BufferedWriter writer;
			
			try {
				writer = new BufferedWriter(new FileWriter(newDirectory));
				String addString = newAddress.toString();
    			writer.write(addString);
    			writer.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			

		} catch (DuplicateObjectException e){  
					
			throw new DuplicateObjectException(addFile);
		}
	
	//write the account to the file for later reading
    writeAccountToFile(account);
	writeReservationToFile(hotelReservation);
}

	//loadAccounts is a method to load the accounts upon startup, called by setUp()
    public void loadAccounts (String fileName) throws Exception {
    	
    	//a list to store all the file names
    	List<String> filenames = new ArrayList<String>();
    	
    	//System.out.println("file name received " + fileName);
    	 
    	File[] readFile = new File(fileName).listFiles();
 	    
 	    for(File file : readFile) {
 	    	
 	    	if(file.isFile()) {
 	    		
 	    		filenames.add(file.getName());
 	    		String fullPath = fileName+"\\"+file.getName();
 	    		String type = file.getName();    
 	    		
 	    		BufferedReader br = null;
 	    		//read the files, test for type, add to the correct lists
 	    		try {        		
 	    			
 	    				FileInputStream fis = new FileInputStream(fullPath);
 	    				br = new BufferedReader(new InputStreamReader(fis));
 	    				String line = null;
 	    			
 	    				// read first line and load trip level attributes
 	    				line = br.readLine();
    	        
 	    				//check the type of file
 	    				String typeTest = type.substring(0,3);
    	        
 	    				//add new accounts to account array
 	    				if(typeTest.equals("acc") ){
 	    					
 	    					//String of the account values in XML
 	    					accountNumber  = line.substring(line.indexOf("<accountNumber>") + 15, line.indexOf("</accountNumber>"));
 	    				
 	    					//Create the account object using the String value
 	    					Account newAccount = new Account(line);
 	    				
 	    					//add this account to the list managed by the manager. We will load all text files. 
 	    					addToAccountsList(newAccount);
 	    				}
 	    		
 	    			//close the reader	
 	    			br.close();             
 	    		} catch (Exception e) {  // caught an error so can close file
 	    			// log an error
 	    			throw new IllegalLoadException(type);
 	    		}//end catch
 	    	}//end 	if(file.isFile()) {
 	    }//end  for(File file : readFile
   }//end loadAccounts
   
 //loadReservations is a method to load all methods from the files AFTER all accounts have been loaded so that there is an account to associate the reservation with
   public void loadReservations (String fileName) throws Exception {  
	 //a list to store all the file names
   	List<String> filenames = new ArrayList<String>();
   	 
   	File[] readFile = new File(fileName).listFiles();
	    
	    for(File file : readFile) {
	    	
	    	if(file.isFile()) {
	    		
	    		filenames.add(file.getName());
	    		String fullPath = fileName+"\\"+file.getName();
	    		String type = file.getName();    
	    		
	    		BufferedReader br = null;
	    		//read the files, test for type, add to the correct lists
	    		try {        		
	    			
	    				FileInputStream fis = new FileInputStream(fullPath);
	    				br = new BufferedReader(new InputStreamReader(fis));
	    				String line = null;
	    			
	    				// read first line and load trip level attributes
	    				line = br.readLine();
   	        
	    				//check the type of file
	    				String typeTest = type.substring(0,3);
	    				if (typeTest.equals("res")) {
	 	    				
 	    					//find the reservation  numbers
 	    					
 	    					//account number
 	    					String findNum = fullPath.substring(fullPath.indexOf("accounts") + 12, fullPath.indexOf("res") -1);
 	    				
 	    					if (line.substring(0, 18).equals("<hotelReservation>"))   // found hotel reservation so call its constructor
 	    					{
 	    						//send the XML data to the String constructor
 	    						HotelReservation hr = new HotelReservation(line);
 	    						
 	    						//add the reservation to the reservations list
 	    						addToReservationsList(hr);
 	    					
 	    						//find the account object to add the reservation number to its list
 	    						for(int i = 0; i < accounts.size(); i++) {
 	    							
 	    							String thisNum = accounts.get(i).getAccountNumber();
 	    							int index = accounts.get(i).getAccountNumber().indexOf("-99");
 	    							if(index != -1) {
 	    								thisNum = thisNum.substring(0,index);
 	    							}
 	    							
 	    							if(thisNum.equals(findNum)) {
 	    								//check that it is not already on the list
 	    								for(int j = 0; j < accounts.get(i).getReservations().size(); j++) {
 	    									if(accounts.get(i).getReservations().get(j).equals(hr.getReservationNumber())) {
 	    										throw new DuplicateObjectException(hr.getReservationNumber());
 	    									}
 	    									
 	    								}
 	    								accounts.get(i).getReservations().add(hr.getReservationNumber());
 	    							}
 	    								
 	    								//accounts.get(i).getReservations().add(hr.getReservationNumber());
 	    						}//end for
 	    					}//end if (int i = 0 ...)
 	    					else if (line.substring(0, 18).equals("<cabinReservation>")) // found cab reservation so call its constructor
 	    					{
 	    						CabinReservation cr = new CabinReservation(line);
 	    					
 	    						//add the reservation to the reservations list
 	    						addToReservationsList(cr);
 	    					
 	    						//find the account object to add the reservation number to its list
 	    						for(int i = 0; i < accounts.size(); i++) {
 	    							
 	    							String thisNum = accounts.get(i).getAccountNumber();
 	    							int index = accounts.get(i).getAccountNumber().indexOf("-99");
 	    							if(index != -1) {
 	    								thisNum = thisNum.substring(0,index);
 	    							}
 	    							
 	    							if(thisNum.equals(findNum)) {
 	    								
 	    								//check that it is not already on the list
 	    								for(int j = 0; j < accounts.get(i).getReservations().size(); j++) {
 	    									if(accounts.get(i).getReservations().get(j).equals(cr.getReservationNumber())) {
 	    										throw new DuplicateObjectException(cr.getReservationNumber());
 	    									}
 	    									
 	    									
 	    								}//end if
 	    								accounts.get(i).getReservations().add(cr.getReservationNumber());
 	    								
 	    							}//end if (int i = 0...)
 	    						}//end for
 	    					}//end else if we have a cabin reservation
 	    					else if (line.substring(0, 18).equals("<houseReservation>")) // found house reservation so call its constructor
 	    					{
 	    						HouseReservation hsr = new HouseReservation(line);
 	    					
 	    						//add the reservation to the reservations list
 	    						addToReservationsList(hsr);
 	    					
 	    						//find the account object to add the reservation number to its list
 	    						for(int i = 0; i < accounts.size(); i++) {
 	    	
 	    							String thisNum = accounts.get(i).getAccountNumber();
 	    							int index = accounts.get(i).getAccountNumber().indexOf("-99");
 	    							if(index != -1) {
 	    								thisNum = thisNum.substring(0,index);
 	    							}
 	    							
 	    							if(thisNum.equals(findNum))  {
 	    								//check that it is not already on the list
 	    								for(int j = 0; j < accounts.get(i).getReservations().size(); j++) {
 	    									if(accounts.get(i).getReservations().get(j).equals(hsr.getReservationNumber())) {
 	    										throw new DuplicateObjectException(hsr.getReservationNumber());
 	    									}
 	    								
 	    							}//end if
 	    								accounts.get(i).getReservations().add(hsr.getReservationNumber());
 	    						}//end for               
 	    					}//end else if
 	    				}//end else if we have a res file
	    			}
 	    			//close the reader	
 	    			br.close();             
 	    		} catch (Exception e) {  // caught an error so can close file
 	    			// log an error
 	    			throw new IllegalLoadException(type);
 	    		}//end catch
 	    	}//end 	if(file.isFile()) {
 	    }//end  for(File file : readFile
   }//end loadReservations


  //this method adds a new reservation to the file only, and does not add it to the list
  public void writeReservationToFile(String newReservation) {
	
	 //get the folder name
  	String folderName = newReservation.substring(newReservation.indexOf("<accountNumber>") + 15, newReservation.indexOf("</accountNumber>"));  	
  	
  	//get the file name
  	String filename = newReservation.substring(newReservation.indexOf("<reservationNumber>") + 19, newReservation.indexOf("</reservationNumber>"));
  	
  	//set a full file name in case of an exception
  	String resFile = "res"+filename;
  	
  	//Find the path to the account folder
	String newDirectory = this.getDirectory() + "acc" + folderName;		
		
	//create a text file path
	String fileDirectory = newDirectory + "\\res"+ filename +".txt";	
	
	Boolean unique = true;
	
	//Read the files to test if this file has already been created
  	File folder = new File(getDirectory());   	
	File[] listOfFiles = folder.listFiles();
		//check the account folder for the account
		if(listOfFiles!=null) {
			for (int i = 0; i < listOfFiles.length; i++) {

				//check the account's folder for this res file
	  			if(listOfFiles[i].getName().equals("acc" + folderName)){
	  				File accFolder = new File(getDirectory()+"\\"+"acc"+folderName);   	
	  				File[] listOfResFiles = accFolder.listFiles();
	  				
	  				if(listOfResFiles!=null) {
	  				//search each res file for a duplicate name
	  					for(int j = 0; j<listOfResFiles.length; j++) {
	  						if(listOfResFiles[j].getName().equals(resFile)) {
	  							unique = false;
	  						}//end if
	  					}//end for
	  				}//end if
	  			}//end f
		
			}//end for
		}//end if the list is not null
	
		//write the res file if it is unique
	if(unique.equals(true)) {	
		//write to the file
		BufferedWriter writer;
		try {
				writer = new BufferedWriter(new FileWriter(fileDirectory));
				writer.write(newReservation);
				writer.close();
			} catch (IOException e) {//end of try to write to the file
			
			e.printStackTrace();
		}//end of catch
		
		//remove the -99 if applicable
		remove99(newReservation);
	}//end write if unique

 }//end writeToReservationFile
  
  //this method adds a new account to the file only, and does not add it to the list
  public void writeAccountToFile(String newAccount) throws IOException {
	  
	  //get the filename by first extracting the account number
      String filename = newAccount.substring(newAccount.indexOf("<accountNumber>") + 15, newAccount.indexOf("</accountNumber>"));
      
      //a file can be filled or empty, we need to check for both in the current list
      String filenameAlt = "";
      
      //string for a possible exception
      String accFile = "acc"+filename;
      
      //a boolean to indicate if the new account is a unique account
      Boolean unique = true;
      
      //create a possible alternative filename that is actually the same account number
      if(filename.contains("-99")) {
      	
      	int index = filename.indexOf("-99");
      	filenameAlt = filename.substring(0, index);
      }
      else {
      	filenameAlt = filename + "-99";
      }
      
      //Read the files to test if this file has already been created
      	File folder = new File(getDirectory());   	
  		File[] listOfFiles = folder.listFiles();
  		
  		if(listOfFiles!=null) {
  			for (int i = 0; i < listOfFiles.length; i++) {
  	  			//System.out.println(listOfFiles[i].getName());
  	  			//System.out.println(filename+" "+filenameAlt);
  	  			if(listOfFiles[i].getName().equals("acc"+filename)||listOfFiles[i].getName().equals("acc" + filenameAlt)){
  	  				unique = false;
  	  			}//end if
  			}//end for
  		
  		}//end read the list
  		
    //if we have a unique account, then create the file
      if(unique.equals(true)) {
      
      	try  {  	
  		
      		//a new account file will always have "-99", so we can assume it contains -99
      		
  			//Make the path without the -99
      		int index = filename.indexOf("-99");
      		filename = filename.substring(0,index);
      
      		//Create a new file name
      		String newDirectory = this.getDirectory() + "acc" + filename;
      	
      		//create a file  using the path
      		File newAccountFile = new File(newDirectory);  
      	
  			//add a new folder for this account to the accounts folder
  			newAccountFile.mkdir();
  					
  			//add the account file to the new folder
  			
  			//create a text file path
  			newDirectory = newDirectory + "\\acc"+ filename +".txt";			
  					
  			//write to the file
  			BufferedWriter writer = new BufferedWriter(new FileWriter(newDirectory));
  			
  			//Write the string to the new text file
  			writer.write(newAccount);
  			
  			//close the writer
  			writer.close();

  		} catch (DuplicateObjectException e){  
  					
  			throw new DuplicateObjectException(accFile);
  		}  
      	
      }
      //if it is not unique, then throw a DuplicateObjectException
      else
      	throw new DuplicateObjectException(accFile);
  }
  
    
    //Write a new reservation to a file 
    public void addNewReservation(String newReservation) throws DuplicateObjectException, ParseException{
    	
    	//get the folder name
    	String folderName = newReservation.substring(newReservation.indexOf("<accountNumber>") + 15, newReservation.indexOf("</accountNumber>"));  	
    	
    	//get the file name
    	String filename = newReservation.substring(newReservation.indexOf("<reservationNumber>") + 19, newReservation.indexOf("</reservationNumber>"));
    	
    	//set a full file name in case of an exception
    	//String resFile = "res"+filename;
    	
    	//Find the path to the account folder
		String newDirectory = this.getDirectory() + "acc" + folderName;		
		
		//find the path to the account file
		//String accDirectory = newDirectory + "\\acc" + folderName +".txt";
		
		//a boolean to indicate if this is a unique reservation (true), or a duplicate (false). Default = unique/true
		Boolean unique = true;
				
		//search the reservations  list to see if we already have this reservation before we create a duplicate
        for(int i = 0; i < reservations.size(); i ++) {
        	
        	//search for the file name
        	if(reservations.get(i).getReservationNumber().equals(filename)) {
        		//if we find a match, then the account number is not unique and we can't create it
        		unique = false;
        	}
        	
        }
        
        //add to the reservations list (duplication checking is handled by the method addToRservationsList)
        if(newReservation.contains("<houseReservation>")) {
        	HouseReservation tempHouse = new HouseReservation(newReservation);
        	addToReservationsList(tempHouse);
        }
        else if (newReservation.contains("<hotelReservation>")) {
        
        	HotelReservation tempHotel = new HotelReservation(newReservation);
        	addToReservationsList(tempHotel);
        }
        else if(newReservation.contains("<cabinReservation>")) {
        	CabinReservation tempCabin = new CabinReservation(newReservation);
        	addToReservationsList(tempCabin);
        	
        }
        
        
        //if we have a unique account, then create the file, add to the accounts list
        if(unique.equals(true)) {
        
        	
        	writeReservationToFile(newReservation);
        	
        		//add to the accounts list of reservation numbers
				for(int i = 0; i < accounts.size(); i++) {
					
					int index = accounts.get(i).getAccountNumber().indexOf("-99");
					String newAccountNum =accounts.get(i).getAccountNumber();
					
					if(index != -1) {
						newAccountNum = accounts.get(i).getAccountNumber().substring(0, index);
					}
					
					//if we have a unique value, add it to the accounts list, otherwise, we have an error
					//search the account list for the right account
					if(newAccountNum.equals(folderName)) {
						
						//search the account;s reservation list for any duplicates
						for(int j = 0; j < accounts.get(i).getReservations().size(); j++) {
							//any duplicate means this is not unique
							if(accounts.get(i).getReservations().get(j).equals(filename)) {
								unique = false;
							}
						}
						//if it is unique, add to the accounts list of reservations
						if(unique.equals(true)){
							accounts.get(i).getReservations().add(filename);
							
						}//end if unique, add to list
					}//end search the account 
				}//end search all accounts for correct account
        }
        		
    }//end of add a new reservation
    
    //after adding a reservation, check the account number and change if it has a -99
    public void remove99(String newReservation){
    			
		BufferedReader br = null;
    	
    	//get the folder name
    	String folderName = newReservation.substring(newReservation.indexOf("<accountNumber>") + 15, newReservation.indexOf("</accountNumber>"));  	
    	
    	//Find the path to the account folder
		String newDirectory = this.getDirectory() + "acc" + folderName;		
		
		//find the path to the account file
		String accDirectory = newDirectory + "\\acc" + folderName +".txt";
    	
    	//read the files, test account number for -99, and change if found
		try {  
 		
 				FileInputStream fis = new FileInputStream(accDirectory);
 				br = new BufferedReader(new InputStreamReader(fis));
 				String line = null;
 			
 				// read first line 
 				line = br.readLine();
 					
 				//String of the account number
 				accountNumber  = line.substring(line.indexOf("<accountNumber>") + 15, line.indexOf("</accountNumber>"));
 			
 				//check if the account number has a -99 in it, if it does, change it as it is no longer empty
 				if(accountNumber.contains("-99")) {
 					
 					//find the object in the list and update its number
 					for(int i = 0; i < accounts.size(); i++) {    					
 						
 						if(accounts.get(i).getAccountNumber().equals(accountNumber) ){
 							
 							//change the account number in the accounts list
 							accounts.get(i).updateAccountNumber();
 						}
 					}//end find object in list
 				
 					//next, rewrite the contents of the file to update the account number 
 				
 					//get the first part of the string in the file
 					int begin = line.indexOf("<accountNumber>");
 					String start = line.substring(0, begin + 15);
 				
 					//get the end of the string in the file, without the -99 account number
 					int end = line.indexOf("</accountNumber>");
 					String stop = line.substring(end, line.length());
 					
 					//new account string
 					String newLine = start + folderName + stop;
 					
 					//rewrite the file to change the account number

 					//create a text file path
 					newDirectory = newDirectory + "\\acc"+ folderName +".txt";
 					
 					BufferedWriter writer;
 	    					
 					//write to the file
 					writer = new BufferedWriter(new FileWriter(newDirectory));
 	    			
 					//Write the updated string to the text file
 					writer.write(newLine);
 	    			
 					//close the writer
 					writer.close();
 					
 					}//end if the account number contains a -99 	    				
 					
 			}catch (IOException e) {//end of read the files, test account number for -99, and change if found
			
 				e.printStackTrace();
 			}//end of catch
    }
    
    //Write a new address to a file
    public void addNewAddress(String newAddress) throws DuplicateObjectException {
        
    	//get the filename
    	String filename = newAddress.substring(newAddress.indexOf("<street>") + 8, newAddress.indexOf("</street>"));
    	
    	//create a name for the possible exception
    	String addFile = "add"+filename;
   
    	//Store the file directory
    	String newDirectory = this.getDirectory();
    	int index = newDirectory.indexOf("accounts");
    	newDirectory = newDirectory.substring(0,index);
    	newDirectory = newDirectory + "addresses";
    				
    	//If there is already an address with the same name, this is an error and the action must not be completed. Rather, send an error.
    	try  {  
    			
    			//add the address file to the new folder
    			newDirectory = newDirectory + "\\"+ filename +".txt";
    					
    			//write to the file
    			BufferedWriter writer;
    			
				try {
					writer = new BufferedWriter(new FileWriter(newDirectory));
					String addString = newAddress.toString();
	    			writer.write(addString);
	    			writer.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
    			

    		} catch (DuplicateObjectException e){  
    					
    			throw new DuplicateObjectException(addFile);
    		}   
    }
    
   //Write a new Account object to a file in a new folder
    public void addNewAccount(String newAccount) throws Exception {
    	
        //get the filename by first extracting the account number
        String filename = newAccount.substring(newAccount.indexOf("<accountNumber>") + 15, newAccount.indexOf("</accountNumber>"));
        
        //a file can be filled or empty, we need to check for both in the current list
        String filenameAlt = "";
        
        //string for a possible exception
        String accFile = "acc"+filename;
        
        //a boolean to indicate if the new account is a unique account
        Boolean unique = true;
        
        //create a possible alternative filename that is actually the same account number
        if(filename.contains("-99")) {
        	
        	int index = filename.indexOf("-99");
        	filenameAlt = filename.substring(0, index);
        }
        else {
        	filenameAlt = filename+"-99";
        }
        
        //search the accounts list to see if we already have this account before we create a duplicate
        for(int i = 0; i < accounts.size(); i ++) {
        	
        	//search for the file name as well as its possible alternative file name
        	if(accounts.get(i).getAccountNumber().equals(filename) || accounts.get(i).getAccountNumber().equals(filenameAlt)) {
        		//if we find a match, then the account number is not unique and we can't create it
        		unique = false;
        	}
        	
        }
        
        //if we have a unique account, then create the file and add to the accounts list
        if(unique.equals(true)) {
        
        	try  { 
        		
        		writeAccountToFile(newAccount);
    			
    			//create a temporary object
    	    	Account tempAccount = new Account(newAccount);
    	    	
    	    	//Add the account to the list array
    	    	addToAccountsList(tempAccount);

    		} catch (DuplicateObjectException e){  
    					
    			throw new DuplicateObjectException(accFile);
    		}  
        	
        }
        //if it is not unique, then throw a DuplicateObjectException
        else
        	throw new DuplicateObjectException(accFile);
    	
    }
    	
    //add a new account to the list array managed by an instance of Manager
    public void addToAccountsList(Account newAccount) throws Exception {

    	Boolean unique = true;
    	
    	String option1 = newAccount.getAccountNumber();
    	String option2 ="";
    	
    	if(option1.contains("-99")) {
    		
    		int index = option1.indexOf("-99");
    		option2 = option1.substring(0,index);
    	
    	}
    	else {
    		option2 = option1+"-99";
    	}

    	//check that  this account is not already in the list
    	for (int i = 0; i < accounts.size(); i++) {

    		if (accounts.get(i).getAccountNumber().equals(option1)||accounts.get(i).getAccountNumber().equals(option2)) {
    			unique = false;
    			throw new DuplicateObjectException("acc"+newAccount.getAccountNumber());
    			
    		}
    			
    	}

    	//if not already in the list, then add it
    	if(unique.equals(true)) {
    	
    		accounts.add(newAccount);   

    	}
 
    		
   }
    
 //add a new reservation to the list managed by Manager
   public void addToReservationsList(Reservation reservation) {
	
	Boolean unique = true;
	
	 //check that  this is not already in the list
   	for(int i = 0; i < reservations.size(); i++) {
		
   		if (reservations.get(i).getReservationNumber().equals(reservation.getReservationNumber())) {
   			
   			unique = false;
   			throw new DuplicateObjectException("res"+reservation.getReservationNumber());
   		}
   	}
   	
   	//if not, then add it
   	if(unique.equals(true)) {
 
   		reservations.add(reservation);   	

   	}
  }
   
 
    //Complete reservation that is associated with an account
    public void completeReservation(HouseReservation reservation) {
    	
    	//try to complete reservation, else throw an IllegalOperationException
    	 	try {
    	
    	 		//change status, which automatically sets the price
    			reservation.setReservationStatus("completed");
    			overwriteReservationFile(reservation);
    			for(int i = 0; i <reservations.size(); i++) {
      				if(reservations.get(i).getReservationNumber().equals(reservation.getReservationNumber())) {
      					reservations.remove(i);
      				}
      			}
      			reservations.add(reservation);
    		
    		} catch(Exception e) {
    			throw new IllegalOperationException(reservation.reservationNumber, "complete");
    		}
        
    }
    
    public void completeReservation(HotelReservation reservation) {
      	try {
      			//change status
      			reservation.setReservationStatus("Completed");
        	     			
      			overwriteReservationFile(reservation);
      			
      			for(int i = 0; i <reservations.size(); i++) {
      				if(reservations.get(i).getReservationNumber().equals(reservation.getReservationNumber())) {
      					reservations.remove(i);
      				}
      			}
      			reservations.add(reservation);
      	
      			
        	} catch(Exception e) {
        			throw new IllegalOperationException(reservation.reservationNumber, "complete");
        	}
    }
    
    public void completeReservation(CabinReservation reservation) {
      	try {
      			//change status
      			reservation.setReservationStatus("completed");
      			overwriteReservationFile(reservation);
      			
      			for(int i = 0; i <reservations.size(); i++) {
      				if(reservations.get(i).getReservationNumber().equals(reservation.getReservationNumber())) {
      					reservations.remove(i);
      				}
      			}
      			reservations.add(reservation);
      		
      			
      		} catch(Exception e) {
        			throw new IllegalOperationException(reservation.reservationNumber, "complete");
        	}

    }
    
     //Cancel reservation that is associated with an account
    public void cancelReservation(HouseReservation reservation) throws Exception {
    	
    	//change its status
		reservation.setReservationStatus("cancelled");
		
		overwriteReservationFile(reservation);
		//since this was updated by value in this scope, we do need to remove the old object and replace it with the object created in this scope
		//remove the old reservation from the reservation list and add the updates reservation
		for(int i = 0; i <reservations.size(); i++) {
			if(reservations.get(i).getReservationNumber().equals(reservation.getReservationNumber())) {
				reservations.remove(i);
			}
		}
		reservations.add(reservation);
    }////end cancelReservation
   
    
    //Cancel reservation that is associated with an account
    public void cancelReservation(HotelReservation reservation) throws Exception {
    	
    	//change its status
		reservation.setReservationStatus("cancelled");
		
		overwriteReservationFile(reservation);
			
		//remove the old reservation from the reservation list and add the updates reservation
				for(int i = 0; i <reservations.size(); i++) {
					if(reservations.get(i).getReservationNumber().equals(reservation.getReservationNumber())) {
						reservations.remove(i);
					}
				}
		reservations.add(reservation);
    }//end cancelReservation
   
     
    //Cancel reservation that is associated with an account
    public void cancelReservation(CabinReservation reservation) throws Exception {
    	
    	//change its status
		reservation.setReservationStatus("cancelled");

		overwriteReservationFile(reservation);	
		
		//remove the old reservation from the reservation list and add the updates reservation
		for(int i = 0; i <reservations.size(); i++) {
			if(reservations.get(i).getReservationNumber().equals(reservation.getReservationNumber())) {
				reservations.remove(i);
			}
		}
		
		reservations.add(reservation);

    }//end cancelReservation



    public void removeReservation(String reservationNumber) throws Exception {
	
    	//remove from the list and delete the file
    	for (int i = 0; i < reservations.size(); i++) {
    		if(reservations.get(i).getReservationNumber().equals(reservationNumber)) {
    			
    			//get the account number for the path
    			String account = reservations.get(i).getAccountNumber();
    			String resNum = reservations.get(i).getReservationNumber();
			
    			//remove the object from the list
    			reservations.remove(i);
			
    			//create the path to the reservation in the file
    			String path = getDirectory() + "acc" + account + "\\" + "res"+resNum +".txt";
			
    			//call the method to delete the file
    			try {
    				deleteFile(path);
    			} catch (IllegalOperationException e) {
    				throw new IllegalOperationException(reservationNumber, "delete", "file does not exist");
    			}// end catch
    		}//end if we found the reservation number in the list
    	}//end search the reservation list
    	
    	//remove from accounts list
    	for(int j = 0; j<accounts.size(); j++){
    		if(accounts.get(j).getAccountNumber().equals(account)){
    			for(int k = 0; k < accounts.get(j).getReservations().size(); k++) {
    				if(accounts.get(j).getReservations().get(k).equals(reservationNumber)) {
    					 accounts.get(j).getReservations().remove(k);
    				}//end if
    						
    			}//end for
    		}//end if
    	}//end for
    	
}//end the removeReservation method

public void deleteFile(String path) throws Exception {
	
	//delete the file at the received path if it exists
	try {
        Files.deleteIfExists(
            Paths.get(path));
        System.out.println("Deletion successful.");
    }//end try
	//if the file does not exist, throw an error
    catch (IOException e) {
    	throw new Exception("No such file exists");
    }
  
}

//print all accounts
public void printAccounts() {
	
	System.out.println("\nHere are all account objects from the manager's accounts list. All accounts without any reservations should have a -99 value.");
	for(int i =  0; i < getAccounts().size(); i++) {
			System.out.println("acc"+getAccounts().get(i).getAccountNumber());
	}
}

//print all reservations
public void printReservations() {
	System.out.println("\nHere are all reservation objects from the manager's reservations list:");
	for(int i = 0; i < getReservations().size(); i++) {
		System.out.println("res"+getReservations().get(i).getReservationNumber());
	}
}
   
//print all accounts with their respective reservations
public void printAccountsAndReservations() {
	  System.out.println("\nWe are going to print all account objects found in the manager's list, and then print all the reservations associated with those accounts as found in the account's list of reservations.\n");
	    for(int i =  0; i < getAccounts().size(); i++) {
	    	System.out.println("acc"+getAccounts().get(i).getAccountNumber()+" has the following reservations:");
	    	for(int j = 0; j < getAccounts().get(i).getReservations().size(); j++) {
	    		System.out.println("res"+ getAccounts().get(i).getReservations().get(j));
	    	}//end get all reservations
	    	System.out.println("\n");
	    }//end get all the accounts
}

//read all reservations that are in the files
public void printReservationsInFiles() {
	
//	String fileName;	
System.out.println("\nHere are all reservation files found in the files:");
	//Read the files 
  	File folder = new File(getDirectory());   	
		File[] listOfFiles = folder.listFiles();
		
		if(listOfFiles!=null) {
			for (int i = 0; i < listOfFiles.length; i++) {
				
				String path = getDirectory()+"\\"+listOfFiles[i].getName();
				File innerFolder = new File(path);
			 	
				//List<String> filenames = new ArrayList<String>();
			   	 File[] readFile = innerFolder.listFiles();
				    
				    for(File file : readFile) {
				    	
				    	if(file.isFile()) {
				    		if(file.getName().substring(0,3).equals("res")) {
				    			System.out.println(file.getName());    
				    		}

				    	}//end if
				    }//end for
		
				}//end for - read the list
		}//end if the list of files is not null
}// end printreservationsInFiles

//read all files
public void printAllFiles() {
	
	System.out.println("\nHere are all the files that were found:");
	//Read the files 
  	File folder = new File(getDirectory());   	
		File[] listOfFiles = folder.listFiles();
		
		if(listOfFiles!=null) {
			for (int i = 0; i < listOfFiles.length; i++) {
				
				String path = getDirectory()+"\\"+listOfFiles[i].getName();
				File innerFolder = new File(path);
			 	
				//List<String> filenames = new ArrayList<String>();
			   	 File[] readFile = innerFolder.listFiles();
				    
				    for(File file : readFile) {
				    	
				    	if(file.isFile()) {
				    			System.out.println(file.getName());    
				    		}
				    }//end for
		
				}//end for - read the list
		}//end if the list of files is not null
	
}

//check reservations are saved in a separate file
public void printAllFileDirectories() throws IOException {
	
	System.out.println("We are going to print the directories of the files, to show that the reservations and accounts are in the same folder, but in separate files.");
	//Read the files 
	File folder = new File(getDirectory());   	
		File[] listOfFiles = folder.listFiles();
		
		if(listOfFiles!=null) {
			for (int i = 0; i < listOfFiles.length; i++) {
				
				String path = getDirectory()+"\\"+listOfFiles[i].getName();
				File innerFolder = new File(path);
			 	
				//List<String> filenames = new ArrayList<String>();
			   	 File[] readFile = innerFolder.listFiles();
				    
				    for(File file : readFile) {
				    	
				    	if(file.isFile()) {
				    			System.out.println(file.getCanonicalPath());    
				    		}
				    }//end for
		
				}//end for - read the list
		}//end if the list of files is not null
	
}

    /**
     * Change reservation values that can be changed.  If reservation is cancelled,  completed, or for past date, it is considered an error
     * Request that Manager updates specific account’s files with data stored in memory
     * @throws Exception 
     */
   
    
//a method to update an account by rewriting the file    
public void updateAccountValues(Account account) throws Exception {


	String num = account.getAccountNumber();
	
	String altNum = "";
	
	Boolean empty = false;
	
	//string for a possible alternative number if empty
	if(num.contains("-99")) {
		int index = num.indexOf("-99");
		altNum = num.substring(0,index);
		empty = true;
	}//end altNum
	
	for(int i = 0; i < accounts.size(); i++) {

		if(accounts.get(i).getAccountNumber().equals(num) ||accounts.get(i).getAccountNumber().equals(altNum) ) {
			
			//overwrite old file
			String path = getDirectory()+"acc"+account.getAccountNumber()+"\\acc"+account.getAccountNumber()+".txt";
			
			if(empty) {
				path = getDirectory()+"acc"+altNum+"\\acc"+altNum+".txt";
			}
			
			File overwrite = new File(path);
			FileWriter rewriter = new FileWriter(overwrite, false); 
			String line = account.toString();                                          
			rewriter.write(line);
			rewriter.close();

		}//end if we find the account in the list
	}//end search for the account (for loop)
	
}//end updateAccountValues

public void overwriteReservationFile(HotelReservation reservation) throws IOException{
	
	//overwrite the reservation text file
		for(int i = 0; i < reservations.size(); i++) {

			if(reservations.get(i).getReservationNumber().equals(reservation.getReservationNumber()) ) {
				
				//overwrite old file
				String path = getDirectory()+"acc"+reservation.getAccountNumber()+"\\res"+reservation.getReservationNumber()+".txt";
				
				File overwrite = new File(path);
				FileWriter rewriter = new FileWriter(overwrite, false); 
				String line = reservation.toString();                                          
				rewriter.write(line);
				rewriter.close();

			}//end if we find the reservation in the list
		}//end search for the reservation (for loop)
		
}


public void overwriteReservationFile(HouseReservation reservation) throws IOException{
	
	//overwrite the reservation text file
		for(int i = 0; i < reservations.size(); i++) {

			if(reservations.get(i).getReservationNumber().equals(reservation.getReservationNumber()) ) {
				
				//overwrite old file
				String path = getDirectory()+"acc"+reservation.getAccountNumber()+"\\res"+reservation.getReservationNumber()+".txt";
				
				File overwrite = new File(path);
				FileWriter rewriter = new FileWriter(overwrite, false); 
				String line = reservation.toString();                                          
				rewriter.write(line);
				rewriter.close();

			}//end if we find the reservation in the list
		}//end search for the reservation (for loop)
		
}


public void overwriteReservationFile(CabinReservation reservation) throws IOException{
	
	//overwrite the reservation text file
		for(int i = 0; i < reservations.size(); i++) {

			if(reservations.get(i).getReservationNumber().equals(reservation.getReservationNumber()) ) {
				
				//overwrite old file
				String path = getDirectory()+"acc"+reservation.getAccountNumber()+"\\res"+reservation.getReservationNumber()+".txt";
			
				File overwrite = new File(path);
				FileWriter rewriter = new FileWriter(overwrite, false); 
				String line = reservation.toString();                                          
				rewriter.write(line);
				rewriter.close();

			}//end if we find the reservation in the list
		}//end search for the reservation (for loop)
		
}

public void updateReservation(HouseReservation houseRes) throws Exception {
	
    // Check if reservation is cancelled,  completed, or for past date using a boolean
	
	//a boolean to indicate if the reservations values can be changed
	Boolean change = true;
	
	//a Boolean to indicate if the reservation was found
	Boolean found = false;
	
	//first get the date
	
	//current date
	Date now = new Date(System.currentTimeMillis());
	
	//format the reservation date
	SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
	
	//the string of the reservation
	String line ="";
	
	//send the reservation to the toString if the reservation already exists
	for(int i = 0; i <reservations.size(); i++) {
		if(reservations.get(i).getReservationNumber().equals(houseRes.getReservationNumber())) {
			line = reservations.get(i).toString();
			found = true;
		}
	}
	
	if(found.equals(true)) {
		//declare a date variable
		Date beginDate;
	
		//extract and compare the date
		try {
				//extract
				beginDate = formatter.parse(line.substring(line.indexOf("<startDate>") + 11, line.indexOf("</startDate>")));
			
				//test if the reservation date is before the current date, if s o, no changes can  be made
				if(beginDate.before(now)) {
					change = false;
					throw new IllegalArgumentException("Cannot change the reservation status to \"cancelled\" as it is in the past or currently occurring.");
				}
			
		} catch(ParseException e) {
			throw new ParseException(line, 0);
		}
	
		for(int i = 0; i <reservations.size(); i++) {
		
			if(reservations.get(i).getReservationNumber().equals(houseRes.getReservationNumber()) &&  (reservations.get(i).getReservationStatus().toLowerCase().equals("cancelled") || reservations.get(i).getReservationStatus().toLowerCase().equals("completed"))) {
				change = false;
			}
			
		}//end for for search the status of the reservation
	
		//if any of the above states are true, send an error
		if(change.equals(false)) {
			throw new IllegalOperationException("res"+houseRes.getReservationNumber(), "change", "Either this reservation has been cancelled or completed, or it is in teh past. No changes can be made.");
		}   //else change the values of the reservation
		else {
			
			//remove old file from reservations list, and add new file to list
			for(int i = 0; i <reservations.size(); i++) {
				if(reservations.get(i).getReservationNumber().equals(houseRes.getReservationNumber())) {
					//remove old reservation from managers reservations list
					reservations.remove(i);				
				}//end if we found the reservation in the list, remove it 
			}//end for in i for removal of the object from the list

			//delete old file
			//determine the path to the file
			//String path = getDirectory()+"acc"+houseRes.getAccountNumber()+"\\res"+houseRes.getReservationNumber()+".txt";
			
			//delete the out-dated file
			//deleteFile(path);
			overwriteReservationFile(houseRes);
			
			//rewrite the file 
			addNewReservation(houseRes.toString());
		}//end else if we can change the values, then change them
	
	}//end if found is true
	else {
		throw new IllegalOperationException("res"+houseRes.getReservationNumber(), "change", "This reservation does not exist. Please create a new reservation, rather than attempting to change a  onexistant one");
	}//end else if the reservation was not found
	
	//return change;
}
//this method overwrites the text file
public void updateReservation(HotelReservation hotelRes) throws Exception {
    		
        // Check if reservation is cancelled,  completed, or for past date using a boolean
 
    	//a boolean to indicate if the reservations values can be changed
    	Boolean change;
    	
    	//a Boolean to indicate if the reservation was found
    	Boolean found = false;
    	
    	//first get the date
    	
    	//current date
		Date now = new Date(System.currentTimeMillis());
		
		//format the reservation date
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		
		//the string of the reservation
		String line ="";
		
		//send the reservation to the toString if the reservation already exists,this is for the date and other reasons
		for(int i = 0; i <reservations.size(); i++) {
			
			if(reservations.get(i).getReservationNumber().equals(hotelRes.getReservationNumber())) {
				line = reservations.get(i).toString();
				found = true;
			}
		}
		
		//we can only change an already existing reservation, otherwise it should be created and not changed
		if(found.equals(true)) {
			//declare a date variable
			Date beginDate;
    	
			//extract and compare the date
			try {
					//extract
					beginDate = formatter.parse(line.substring(line.indexOf("<startDate>") + 11, line.indexOf("</startDate>")));
					
					//test if the reservation date is before the current date, if so, no changes can  be made
					if(!beginDate.before(now)) {
						change = true;
					}
					//if the reservation date is  in the past, or today, then do not cancel it, but rather send an error message
					else {
			    		throw new IllegalArgumentException("Cannot change the reservation status to \"cancelled\" as it is in the past or currently occurring.");
					}
			} catch(ParseException e) {
				throw new ParseException(line, 0);
			}

			for(int i = 0; i <reservations.size(); i++) {
				//check if this reservation's status is set to cancelled or completed, in which case we cannot change the values
				if(reservations.get(i).getReservationNumber().equals(hotelRes) && (reservations.get(i).getReservationStatus().toLowerCase().equals("cancelled") || reservations.get(i).getReservationStatus().toLowerCase().equals("completed"))) {
					change = false;
				}//end if the reservation's status is cancelled or completed
			}	
			//if any of the above states are true, send an error
			if(change.equals(false)) {
				throw new IllegalOperationException("res"+hotelRes.getReservationNumber(), "change", "Either this reservation has been cancelled or completed, or it is in teh past. No changes can be made.");
			}   //else change the values of the reservation
			else {
				
				
					//remove old file from reservations list, and add new file to list
					for(int i = 0; i <reservations.size(); i++) {
						if(reservations.get(i).getReservationNumber().equals(hotelRes.getReservationNumber())) {
							//remove old reservation from managers reservations list
							reservations.remove(i);				
						}//end if we found the reservation in the list, remove it 
					}//end for in i for removal of the object from the list
		
					//delete old file
					//determine the path to the file
					//String path = getDirectory()+"acc"+hotelRes.getAccountNumber()+"\\res"+hotelRes.getReservationNumber()+".txt";
					
					//delete the out-dated file
					//deleteFile(path);
					
					//rewrite the file 
					addNewReservation(hotelRes.toString());
					
					overwriteReservationFile(hotelRes);
				}//end else if we can change the values, then change them
		}//end if found is true
		else {
			throw new IllegalOperationException("res"+hotelRes.getReservationNumber(), "change", "This reservation does not exist. Please create a new reservation, rather than attempting to change a  onexistant one");
		}//end else if the reservation was not found
		
		//return change;
}//end changeReservationValues for a HotelReservation
    
public Boolean updateReservation(CabinReservation cabinRes) throws Exception {
	
    // Check if reservation is cancelled,  completed, or for past date using a boolean
	
	//a boolean to indicate if the reservations values can be changed
	Boolean change = true;

	//a Boolean to indicate if the reservation was found
	Boolean found = false;
	
	//first get the date
	
	//current date
	Date now = new Date(System.currentTimeMillis());
	
	//format the reservation date
	SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
	
	//the string of the reservation
	String line ="";
	
	//send the reservation to the toString if the reservation already exists
	for(int i = 0; i <reservations.size(); i++) {
		if(reservations.get(i).getReservationNumber().equals(cabinRes.getReservationNumber())) {
			line = reservations.get(i).toString();
			found = true;
		}
	}
	
	if(found.equals(true)) {
		//declare a date variable
		Date beginDate;
		
		//extract and compare the date
		try {
				//extract
				beginDate = formatter.parse(line.substring(line.indexOf("<startDate>") + 11, line.indexOf("</startDate>")));
			
				//test if the reservation date is before the current date, if s o, no changes can  be made
				if(beginDate.before(now)) {
					change = false;
					throw new IllegalArgumentException("Cannot change the reservation status to \"cancelled\" as it is in the past or currently occurring.");
				}
		} catch(ParseException e) {
			throw new ParseException(line, 0);
		}

		for(int i = 0; i <reservations.size(); i++) {
		
			if(reservations.get(i).getReservationNumber().equals(cabinRes.getReservationNumber()) &&  (reservations.get(i).getReservationStatus().toLowerCase().equals("cancelled") || reservations.get(i).getReservationStatus().toLowerCase().equals("completed"))) {
				change = false;
				System.out.println("change is "+change);
			
			}
			
		}//end for for search the status of the reservation
	
		//if any of the above states are true, send an error
		if(change.equals(false)) {
			throw new IllegalOperationException("res"+cabinRes.getReservationNumber(), "change", "Either this reservation has been cancelled or completed, or it is in the past. No changes can be made.");
		}   //else change the values of the reservation
		else {
			
			//remove old file from reservations list, and add new file to list
			for(int i = 0; i <reservations.size(); i++) {
				if(reservations.get(i).getReservationNumber().equals(cabinRes.getReservationNumber())) {
					//remove old reservation from managers reservations list
					reservations.remove(i);				
				}//end if we found the reservation in the list, remove it 
			}//end for in i for removal of the object from the list
			
			//rewrite the file 
			addNewReservation(cabinRes.toString());
			
			//overwrite the reservation file
			overwriteReservationFile(cabinRes);
		}//end else if we can change the values, then change them
	
	}//end if found is true
	else {
		throw new IllegalOperationException("res"+ cabinRes.getReservationNumber(), "change", "This reservation does not exist. Please create a new reservation, rather than attempting to change a  onexistant one");
	}//end else if the reservation was not found
	
	return change;
}
    	
     //Request for price per night to be calculated and returned for a specific reservation (indicated by reservationNumber)
    public double calculatePricePerNight(HouseReservation reservation) {
        // Basic price =   $120 
    	double price = 120.00;
    	System.out.println("res"+reservation.getReservationNumber()+" is a house reservation with a basic price of $120 per night.");
  	
        // Additional fee of $15 if the lodging size is greater than 900 square feet
    	if(reservation.getLodgingSizeInSquareFeet() > 900) {
    		price += 15;
    		System.out.println("This house reservation is over 900 square feet, increasing the cost by $15.");
    	}

        //return the price
        return price;
    }
    
    public double calculatePricePerNight(HotelReservation reservation) {
        //Hotel has an additional flat fee of $50 plus $10 for kitchenette
    	System.out.println("res"+reservation.getReservationNumber()+" is a hotel reservation with a basic price of $170 per night.");
 	   //basic price
 	    double price = 120.00 + 50;
 	    
 	    if(reservation.getKitchenette().equals(true)) {
 	    	price += 10;
 	    	System.out.println("This hotel reservation has a kitchenette, increasing the cost by $10.");
 	    }
 

 	    // Additional fee of $15 if the lodging size is greater than 900 square feet
 	   if(reservation.getLodgingSizeInSquareFeet() > 900) {
 	    		price += 15;
 	    		System.out.println("This hotel reservation is over 900 square feet, increasing the cost by $15.");
 	    }
 	   
 	    //return the price
 	    return price;
 	 }
     
 

    public double calculatePricePerNight(CabinReservation reservation) {
    
	   //basic price
	    double price = 120.00;
	    System.out.println("res"+reservation.getReservationNumber()+" is a cabin reservation with a basic price of $120 per night.");

	    // Additional fee of $15 if the lodging size is greater than 900 square feet
	   if(reservation.getLodgingSizeInSquareFeet() > 900) {
	    		price += 15;
	    		System.out.println("This cabin reservation is over 900 square feet, increasing the cost by $15.");
	    	}
	   	
	   //an additional fee of $20 for full kitchen
	   if(reservation.getFullKitchen().equals(true)) {
		   price += 20;
		   System.out.println("This cabin reservation has a full kitchen, increasing the cost by $20.");
	   }
	   
	   //each additional bathroom adds $5
	   if(reservation.getNumberOfBathrooms() > 1) {
		   int additionalBathrooms = reservation.getNumberOfBathrooms() - 1;
		   price += (additionalBathrooms * 5);
		   System.out.println("This cabin reservation has "+ reservation.getNumberOfBathrooms()+" bathrooms, increasing the cost by $"+ (reservation.getNumberOfBathrooms()-1) * 5);
	   }
	   
	   //return the price
	   return price;
  
    }
 
 	//Total cost to be calculated and returned for a specific reservation
   public double calculateTotalReservationCost(HouseReservation reservation) {
    	
        //calculate total price of reservation
	   System.out.println("This calculateTotalReservationCost method calls the \"calculatePricePerNight\" method, and will print out that information.");

        double totalCost = calculatePricePerNight(reservation);
        totalCost = totalCost * reservation.numberOfNights;
        
        // return total price of the reservation
        return totalCost;
    }
    
   public double calculateTotalReservationCost(HotelReservation reservation) {
	   System.out.println("This calculateTotalReservationCost method calls the \"calculatePricePerNight\" method, and will print out that information.");
	   //calculate total price of reservation
       double totalCost = calculatePricePerNight(reservation);
       totalCost = totalCost * reservation.numberOfNights;
       
       // return total price of the reservation
       return totalCost;
    }
   
   public double calculateTotalReservationCost(CabinReservation reservation) {
	   System.out.println("This calculateTotalReservationCost method calls the \"calculatePricePerNight\" method, and will print out that information.");
	   //calculate total price of reservation
       double totalCost = calculatePricePerNight(reservation);
       totalCost = totalCost * reservation.numberOfNights;
       
       // return total price of the reservation
       return totalCost;
   }

   
   
   
  }

