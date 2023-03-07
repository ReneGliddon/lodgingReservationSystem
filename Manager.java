import java.io.*;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.util.*;
import java.io.BufferedWriter;
import java.io.IOException;
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
    
    //return a copied list of all reservations
    public List<Reservation> getReservations(){
    
    	
    	List<Reservation> copy = new ArrayList<>(reservations);
 
    	return copy;
    	
    }
    
  //setUp will  load all files from the folders  
  public void setUp() {
    	
    	//get the account folder path
        String path = getDirectory();
        
        //Create a new folder for the accounts
    	String newDirectory = this.getDirectory();  
    	File newAccountFile = new File(newDirectory);
    	newAccountFile.mkdir();
    	
    	//Create a folder for the addresses
    	int index = newDirectory.indexOf("accounts");
    	newDirectory = newDirectory.substring(0,index);
    	newDirectory = newDirectory + "addresses";
    
    	File newAddressFile = new File(newDirectory);  
    	newAddressFile.mkdir();
    				
        
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
	   
	  
  //Retrieve a loaded account object that matches a specific account number 
  public Account getAccount(String accountNumber) {
    	
    	Account theAccount;
    	String accountString = "";
    	
        // get requested account
    	for(int i = 0; i < accounts.size(); i++) {
    		if(accountNumber.equals(accounts.get(i).getAccountNumber())) {
    			
    			accountString = accounts.get(i).toString();
      			
    		}
    	}
    
    	theAccount = new Account (accountString);

        //return requested account
        return theAccount;
    }
    
    //Write a new reservation to a file 
    public void addNewReservation(String newReservation) throws DuplicateObjectException, ParseException{
    	
    	//get the folder name
    	String folderName = newReservation.substring(newReservation.indexOf("<accountNumber>") + 15, newReservation.indexOf("</accountNumber>"));  	
    	
    	//get the file name
    	String filename = newReservation.substring(newReservation.indexOf("<reservationNumber>") + 19, newReservation.indexOf("</reservationNumber>"));
    	
    	//set a full file name in case of an exception
    	String resFile = "res"+filename;
    	
    	//Find the path to the account folder
		String newDirectory = this.getDirectory() + "acc" + folderName;		
		
		//find the path to the account file
		String accDirectory = newDirectory + "\\acc" + folderName +".txt";
		
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
        
        //add to the reservations list (duplication checking is handled by the method)
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
        
        	try  {  		
        
        		//create a text file path
    			String fileDirectory = newDirectory + "\\res"+ filename +".txt";	
    					
    			//write to the file
    			BufferedWriter writer;
				try {
						writer = new BufferedWriter(new FileWriter(fileDirectory));
						writer.write(newReservation);
						writer.close();
				} catch (IOException e) {//end of try to write to the file
					
					e.printStackTrace();
				}//end of catch
				
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
				
				
				//change the -99 if applicable
        		
				BufferedReader br = null;
        		
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
 	    					
 	    					//find the object in the list
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
				
			
        		}catch(DuplicateObjectException e){//end of try after unique
        			//recapture the file name
        			//get the file name
        	    	
        			throw new DuplicateObjectException(resFile);
        		}
        	
        	}//end of if it is unique
        else {//if it is not unique
       
        	throw new DuplicateObjectException(resFile);
        }
        		
    }//end of add a new reservation
    
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
    	
    	//check that  this account is not already in the list
    	for (int i = 0; i < accounts.size(); i++) {
    		
    		if (accounts.get(i).getAccountNumber().equals(newAccount.getAccountNumber())) {
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
    			//change status
    			reservation.setReservationStatus("Completed");
    	
    			// Set reservation price
    			double cost = calculateTotalReservationCost(reservation);
    			reservation.setPrice(cost);
    		} catch(Exception e) {
    			throw new IllegalOperationException(reservation.reservationNumber, "complete");
    		}
        
    }
    
    public void completeReservation(HotelReservation reservation) {
      	try {
      			//change status
      			reservation.setReservationStatus("Completed");
        	
      			// Set reservation price
      			double cost = calculateTotalReservationCost(reservation);
      			reservation.setPrice(cost);
        	} catch(Exception e) {
        			throw new IllegalOperationException(reservation.reservationNumber, "complete");
        	}
    }
    
    public void completeReservation(CabinReservation reservation) {
      	try {
      			//change status
      			reservation.setReservationStatus("Completed");
        	
      			// Set reservation price
      			double cost = calculateTotalReservationCost(reservation);
      			reservation.setPrice(cost);
      		} catch(Exception e) {
        			throw new IllegalOperationException(reservation.reservationNumber, "complete");
        	}

    }
    
     //Cancel reservation that is associated with an account
    public void cancelReservation(HouseReservation reservation) {
    	
    	//change its status
		reservation.setReservationStatus("cancelled");
    }
    
    //Cancel reservation that is associated with an account
    public void cancelReservation(HotelReservation reservation) {
    	
    	//change its status
		reservation.setReservationStatus("cancelled");
    }
     
    //Cancel reservation that is associated with an account
    public void cancelReservation(CabinReservation reservation) {
    	
    	//change its status
		reservation.setReservationStatus("cancelled");
    }
     

public void deleteFile(String path, String reservation) throws Exception {
	
	try {
        Files.deleteIfExists(
            Paths.get(path));
    }
    catch (IOException e) {
    	throw new Exception("No such file exists");
    }
    

    System.out.println("Deletion successful.");
}
   



    /**
     * Change reservation values that can be changed 
     * If reservation is cancelled,  completed, or for past date, it is considered an error
     * Request that Manager updates specific account’s files with data stored in memory
     * @param reservationNumber 
     * @return a boolean indicating whether the values were successfully changed (1) or not (0);
     * @throws ParseException 
     */
    public void changeReservationValues(HouseReservation houseRes) throws ParseException {
    	
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
					}
					//if the reservation date is  in the past, or today, then do not cancel it, but rather send an error message
					else {
			    		throw new IllegalArgumentException("Cannot change the reservation status to \"cancelled\" as it is in the past or currently occurring.");
					}
			} catch(ParseException e) {
				throw new ParseException(line, 0);
			}
    	
			for(int i = 0; i <reservations.size(); i++) {
    		
				if(reservations.get(i).getReservationStatus().toLowerCase().equals("cancelled") || reservations.get(i).getReservationStatus().toLowerCase().equals("completed")) {
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
						
						//rewrite the file 
						addNewReservation(houseRes.toString());
						
						//add updated reservation to managers reservation list
						addToReservationsList(houseRes);
						
					}
				}
				
				//rewrite the file and add to the reservations list
				line = houseRes.toString();
				addNewReservation(line);
				
			}
    	
		}//end if found is true
		else {
			throw new IllegalOperationException("res"+houseRes.getReservationNumber(), "change", "This reservation does not exist. Please create a new reservation, rather than attempting to change a  onexistant one");
		}//end else if the reservation was not found
    }

public void changeReservationValues(HotelReservation hotelRes) throws ParseException {
    	
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
			if(reservations.get(i).getReservationNumber().equals(hotelRes.getReservationNumber())) {
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
					}
					//if the reservation date is  in the past, or today, then do not cancel it, but rather send an error message
					else {
			    		throw new IllegalArgumentException("Cannot change the reservation status to \"cancelled\" as it is in the past or currently occurring.");
					}
			} catch(ParseException e) {
				throw new ParseException(line, 0);
			}
    	
			for(int i = 0; i <reservations.size(); i++) {
    		
				if(reservations.get(i).getReservationStatus().toLowerCase().equals("cancelled") || reservations.get(i).getReservationStatus().toLowerCase().equals("completed")) {
					change = false;
				}
    			
			}//end for for search the status of the reservation
    	
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
						
						//rewrite the file 
						addNewReservation(hotelRes.toString());
						
						//add updated reservation to managers reservation list
						addToReservationsList(hotelRes);
						
					}
				}
				
				//rewrite the file and add to the reservations list
				line = hotelRes.toString();
				addNewReservation(line);
				
			}
    	
		}//end if found is true
		else {
			throw new IllegalOperationException("res"+hotelRes.getReservationNumber(), "change", "This reservation does not exist. Please create a new reservation, rather than attempting to change a  onexistant one");
		}//end else if the reservation was not found
    }
    
public void changeReservationValues(CabinReservation cabinRes) throws ParseException {
	
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
				}
				//if the reservation date is  in the past, or today, then do not cancel it, but rather send an error message
				else {
		    		throw new IllegalArgumentException("Cannot change the reservation status to \"cancelled\" as it is in the past or currently occurring.");
				}
		} catch(ParseException e) {
			throw new ParseException(line, 0);
		}
	
		for(int i = 0; i <reservations.size(); i++) {
		
			if(reservations.get(i).getReservationStatus().toLowerCase().equals("cancelled") || reservations.get(i).getReservationStatus().toLowerCase().equals("completed")) {
				change = false;
			}
			
		}//end for for search the status of the reservation
	
		//if any of the above states are true, send an error
		if(change.equals(false)) {
			throw new IllegalOperationException("res"+cabinRes.getReservationNumber(), "change", "Either this reservation has been cancelled or completed, or it is in teh past. No changes can be made.");
		}   //else change the values of the reservation
		else {
			
			//remove old file from reservations list, and add new file to list
			for(int i = 0; i <reservations.size(); i++) {
				if(reservations.get(i).getReservationNumber().equals(cabinRes.getReservationNumber())) {

					//remove old reservation from managers reservations list
					reservations.remove(i);
					
					//rewrite the file 
					addNewReservation(cabinRes.toString());
					
					//add updated reservation to managers reservation list
					addToReservationsList(cabinRes);
					
				}
			}
			
			//rewrite the file and add to the reservations list
			line = cabinRes.toString();
			addNewReservation(line);
			
		}
	
	}//end if found is true
	else {
		throw new IllegalOperationException("res"+ cabinRes.getReservationNumber(), "change", "This reservation does not exist. Please create a new reservation, rather than attempting to change a  onexistant one");
	}//end else if the reservation was not found
}

     //Request for price per night to be calculated and returned for a specific reservation (indicated by reservationNumber)
    public double calculatePricePerNight(HouseReservation reservation) {
        // Basic price =   $120 
    	double price = 120.00;

        // Additional fee of $15 if the lodging size is greater than 900 square feet
    	if(reservation.getLodgingSizeInSquareFeet() > 900) {
    		price += 15;
    	}

        //return the price
        return price;
    }
    
    public double calculatePricePerNight(HotelReservation reservation) {
        //Hotel has an additional flat fee of $50 plus $10 for kitchenette
    	
 	   //basic price
 	    double price = 120.00 + 50;
 	    
 	    if(reservation.getKitchenette().equals(true)) {
 	    	price += 10;
 	    }
 

 	    // Additional fee of $15 if the lodging size is greater than 900 square feet
 	   if(reservation.getLodgingSizeInSquareFeet() > 900) {
 	    		price += 15;
 	    }
 	   
 	    //return the price
 	    return price;
 	 }
     
 

    public double calculatePricePerNight(CabinReservation reservation) {
    
	   //basic price
	    double price = 120.00;

	    // Additional fee of $15 if the lodging size is greater than 900 square feet
	   if(reservation.getLodgingSizeInSquareFeet() > 900) {
	    		price += 15;
	    	}
	   	
	   //an additional fee of $20 for full kitchen
	   if(reservation.getFullKitchen().equals(true)) {
		   price += 20;
	   }
	   
	   //each additional bathroom adds $5
	   if(reservation.getNumberOfBathrooms() > 1) {
		   price += (reservation.getNumberOfBathrooms() * 5);
	   }
	   
	   //return the price
	   return price;
  
    }
    
 	//Total cost to be calculated and returned for a specific reservation
    public double calculateTotalReservationCost(HouseReservation reservation) {
    	
        //calculate total price of reservation
        double totalCost = calculatePricePerNight(reservation);
        totalCost = totalCost * reservation.numberOfNights;
        
        // return total price of the reservation
        return totalCost;
    }
    
   public double calculateTotalReservationCost(HotelReservation reservation) {
    	
	   //calculate total price of reservation
       double totalCost = calculatePricePerNight(reservation);
       totalCost = totalCost * reservation.numberOfNights;
       
       // return total price of the reservation
       return totalCost;
    }
   
   public double calculateTotalReservationCost(CabinReservation reservation) {
   	
	   //calculate total price of reservation
       double totalCost = calculatePricePerNight(reservation);
       totalCost = totalCost * reservation.numberOfNights;
       
       // return total price of the reservation
       return totalCost;
   }

   //TODO: add file writing methods to simplify other methods
   //these changes can all be made by the "set  methods"
    /**
     * An account's mailing address can be changed at any time
     * @param accountNumber number of the account requiring the changed mailing address
     * @param newAddress  the new mailing address
     */
   // public void changeMailingAddress(String accountNumber, Address newAddress) {

        // change the mailing address associated with the account given to the address given
        
   // }

    /**
     * An account's email address can  be changed at any time
     * @param accountNumber number of the account requiring the changed email address
     * @param newEmailAddress the new email address
     */
  //  public void changeEmailAddress(String accountNumber, String newEmailAddress) {
        
        // change the email address associated with the account given to the address given
    
   // }

    /**
     * An account's phone number can  be changed at any time
     * @param accountNumber number of the account requiring the changed phone number 
     * @param newPhoneNumber the new phone number 
     * @return
     */
   // public void changePhoneNumber(String accountNumber, String newPhoneNumber) {
        
        //change the phone number associated with the account given to the address given

  //  }

}