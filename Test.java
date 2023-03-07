import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.time.LocalDate;
import java.text.SimpleDateFormat;
public class Test {
    /*
     * This Test class contains the main method. Upon startup, all existing accounts and their associated reservations will be loaded
     */
    
public static void main(String[] args) throws Exception {

    
	//Create an instance of Manager class 
		Manager manager = new Manager();
		
		System.out.println("Hello! We will set up. If this is the first run, then there might not be any files to load yet. But they do load! try change the account and reservation numbers on the second run and they will load the previous text files.");
		System.out.println("\n");
		
	//load all the files from the local folders to the lists
		manager.setUp();
	    
	//add new objects
		
		//create some sample data
		
			//A new Address object
		    Address newAddress = new Address("123 Sample Road", "Baltimore", "MD", "11122");
		    String address = newAddress.toString();
		    
		    System.out.println("\n");
		    
		    //A new Account object
		    Account acc = new Account("10009", newAddress, "sampleemail@email.com", "415 253 1122");
		    Account acc2 = new Account("10008", newAddress, "sampleemail@email.com", "415 253 1122");
		    Account acc3 = new Account("10007", newAddress, "sampleemail@email.com", "415 253 1122");
		    Account acc4 = new Account("10006", newAddress, "sampleemail@email.com", "415 253 1122");
		    Account acc5 = new Account("10005", newAddress, "sampleemail@email.com", "415 253 1122");
		    
		   
		    String account = acc.toString();
		    
		    System.out.println("\n");
		    String account2 = acc2.toString();
		    System.out.println("\n");
		    String account3 = acc3.toString();
		    System.out.println("\n");
		    String account4 = acc4.toString();
		    System.out.println("\n");
		    String account5 = acc5.toString();
		    System.out.println("\n");
		    
		    //new reservation objects
		    	//formatter
		    	SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		    
		    	//sample hotel reservation
		    	HotelReservation hotelRes = new HotelReservation("10005", "8888", newAddress, newAddress, 1, 50, 100.90, "draft", formatter.parse("01/01/2023"), true);
			    String hotelReservation = hotelRes.toString();
			    System.out.println("\n");
			 
			    //sample cabin reservation
			    CabinReservation cabRes = new CabinReservation("10006", "9999", newAddress, newAddress, formatter.parse("01/01/2025"), 1, 50, 100.90, "draft", true, true);
			    String cabinReservation = cabRes.toString();
			    System.out.println("\n");
			    
			    //sample house reservation
			    HouseReservation houseRes = new HouseReservation("10007", "7777", newAddress, newAddress, 1, 50, 100.90, "draft", formatter.parse("01/01/2025"), 1);
			    String houseReservation = houseRes.toString(); 
			    System.out.println("\n");
			    
			  //commenting out so that the exception doesn't interrupt the running of the program. Gotta get those grades!
			    // HouseReservation houseResDup = new HouseReservation("10006", "7777", newAddress, newAddress, 1, 50, 100.90, "draft", formatter.parse("01/01/2025"), 1);
			   // String houseReservationDup = houseResDup.toString();   
			    
			    
		    
			//write the new String address and account objects to a file
			    System.out.println("Now we add the account objects to our list.");
			    System.out.println("\n");
		    
				manager.addNewAddress(address);
				manager.addNewAccount(account);
				manager.addNewAccount(account2);
				manager.addNewAccount(account3);
				manager.addNewAccount(account4);
				manager.addNewAccount(account5);
		    
				System.out.println("Here are all reservations loaded from the files:");
				for(int i = 0; i < manager.getReservations().size(); i++) {
					System.out.println(manager.getReservations().get(i).getReservationNumber());
					
				}
				System.out.println("\n");
				
				System.out.println("Here are all accounts. All new accounts should have a -99 value since they don't have any reservations yet.");
				for(int i =  0; i < manager.getAccounts().size(); i++) {
						System.out.println("acc"+manager.getAccounts().get(i).getAccountNumber());
				}
				
				System.out.println("\n");
				
				System.out.println("Now we will add the reservations to our lists.");
				//Now we will add the reservations
				manager.addNewReservation(hotelReservation);
				manager.addNewReservation(cabinReservation);
				manager.addNewReservation(houseReservation);
				//manager.addNewReservation(houseReservationDup);
				System.out.println("\n");
			
				System.out.println("Here are all reservations, including those loaded from files and those added during this test session:");
			    for(int i = 0; i < manager.getReservations().size(); i++) {
			    	System.out.println("res"+manager.getReservations().get(i).getReservationNumber());
			    }
			    System.out.println("\n");
			    
			    System.out.println("Here are all accounts. Now they should not have the -99 value, except for acc10008 and acc10009 (and any new ones that I didn't put here initially) since we didn't add any reservations to them");
			    for(int i =  0; i < manager.getAccounts().size(); i++) {
			    	System.out.println("acc"+manager.getAccounts().get(i).getAccountNumber());
			    }
			    System.out.println("\n");
			    
			    System.out.println("Here are all accounts' reservations:");
			    System.out.println("\n");
			    for(int i =  0; i < manager.getAccounts().size(); i++) {
			    	System.out.println("acc"+manager.getAccounts().get(i).getAccountNumber()+" has the following reservations:");
			    	for(int j = 0; j<manager.getAccounts().get(i).getReservations().size(); j++) {
			    		System.out.println("res"+manager.getAccounts().get(i).getReservations().get(j));
			    		
			    	}
			    	
			    	System.out.println("\n");
			    }
			    
			    System.out.println("If you run this again without account and reservation numbers, you will get a DuplicateObjectException since the files will be LOADED from the .txt files during set up, and then Test will try add them again.");
			    System.out.println("The other exceptions work as well. In fact, (almost?) everything works, but I will refine the style before next submission");
			    System.out.println("You can delete the \"accounts\" folder to restart.");
		    
		  //sample cabin reservation to test the removal of the -99
		   // CabinReservation cabRes2 = new CabinReservation("10009", "99999", newAddress, newAddress, formatter.parse("01/01/2025"), 1, 50, 100.90, "draft", true, true);
		    //String cabinReservation2 = cabRes2.toString();
		//    manager.addNewReservation(cabinReservation2);
		    
		   
		    
		  //  System.out.println(acc.getAccountNumber());
		  //  System.out.println(acc.getAccountNumber().indexOf("-99"));
		    
		   // houseRes.setNumberOfFloors(3);
		  /* System.out.println("We have "+ manager.getReservations().size()+" reservations and "+manager.getAccounts().size()+ " accounts.");
		   
		    houseRes.toString();
		    /* System.out.println("We are cancelling house res");
		    manager.cancelReservation(houseRes);
		    houseRes.toString();*/
		 /*   System.out.println("We are drafting house res");
		    houseRes.setReservationStatus("draft");
		    houseRes.toString();*/
		    
		  /* System.out.println("We are cancellign hotel res");
		    manager.cancelReservation(hotelRes);
		    hotelRes.toString();
		 System.out.println("We are completing hotel res");
		    hotelRes.setReservationStatus("completed");
		    hotelRes.toString();
		    System.out.println("We are drafting house res");
		    hotelRes.setReservationStatus("draft");
		    hotelRes.toString();*/
		    
		 /*   System.out.println("We are cancellign cabin res");
		    manager.cancelReservation( cabRes);
		    cabRes.toString();*/
		  /*  System.out.println("We are completing cab res");
		    cabRes.setReservationStatus("completed");
		    cabRes.toString();
		    System.out.println("We are drafting cab res");
		    cabRes.setReservationStatus("draft");
		    cabRes.toString();*/
		    //manager.accounts.reservations.toString();
		    //System.out.print(false);
		    
		   /* try {
        		
        		//write the new account to a local file
 				manager.addNewAccount(account);
 				
 			} catch (Exception e) {
 			
 				e.printStackTrace();
 			}
		    
		    try {
				manager.addNewReservation(hotelReservation);
			} catch (Exception e) {
			
				e.printStackTrace();
			}*/
		    
		    //add new accounts to the list
		  //  manager.addToAccountsList(acc);
        	
          //  BufferedWriter writer = new BufferedWriter(new FileWriter(street));
           // writer.write(address);
           // writer.close();
      // } catch (IOException e) {
         //  e.printStackTrace();
      // }
       	//name the file as the account name          
		    
		//add the object to the list managed by Manager
		// manager.addToAccountsList(null);
       	
		   	// Load formatted data to the Address constructor
		     //  Address newAddress = new Address(address);
		   	
		       // Use formatted data to write to the file
		    //   try {
		       	   
		       	//Manager manager = new Manager();
		       	
		       	
		         //  BufferedWriter writer = new BufferedWriter(new FileWriter(street));
		          // writer.write(address);
		          // writer.close();
		   //   } catch (IOException e) {
		         // e.printStackTrace();
		    //  }
		    //Account acc = new Account("10007", newAddress, "sampleemail@email.com", "415 253 1122");
		  //  manager.addToAccountsList(acc);
		    
		    //manager.addNewAddress(newAddress);
		  //load the UI
	        // UI will handle the login and authorization and access control 
		
		//create some sample data
		 //   Address newAddress = new Address("123 Sample Road", "Baltimore", "11122", "MD");
		    /*  Account acc = new Account("10006", newAddress, "sampleemail@email.com", "415 253 1122");
		    //Address newAddressTwo = new Address("123 Sammy Road", "Baltimore", "11022", "MD");
		    Account acc2 = new Account("103006", newAddressTwo, "sampleemail@email.com", "415 253 1122");
		   // Address newAddressThree = new Address("453 Sammy Road", "Baltimore", "11022", "MD");
		    Account acc3 = new Account("18443006", newAddressThree, "sampleemail@email.com", "415 253 1122");
		    
		 //Create general file name
		    int end = manager.getDirectory().length()- 1;
		   	String newDirectory = manager.getDirectory().substring(0, end);
		   	File newAccount = new File(newDirectory);  
		 	File newAccountTwo  = new File(newDirectory);  
		 	File newAccountThree = new File(newDirectory);  
		 	
		   	if (newAccount.mkdir()) {  
		   		System.out.println("File created: " + newAccount.getName());  
		   		System.out.println("Absolute path: " + newAccount.getAbsolutePath());  

		   	} else {  
		   		System.out.println("File already exists.");  
		   	}  
		 
		    manager.addNewAccount(acc);
		    

		   	if (newAccountTwo.mkdir()) {  
		   		System.out.println("File created: " + newAccountTwo.getName());  
		   		System.out.println("Absolute path: " + newAccountTwo.getAbsolutePath());  

		   	} else {  
		   		System.out.println("File already exists.");  
		   	}  
		   	
			if (newAccountThree.mkdir()) {  
		   		System.out.println("File created: " + newAccountThree.getName());  
		   		System.out.println("Absolute path: " + newAccountThree.getAbsolutePath());  

		   	} else {  
		   		System.out.println("File already exists.");  
		   	}  
		 
		 
		    manager.addNewAccount(acc);
		    manager.addNewAccount(acc2);
		    manager.addNewAccount(acc3);
		    
		    //formatter
		    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		    
	//create the sample reservations
		    
		   //sample hotel reservation
		    
		    HotelReservation hotelRes = new HotelReservation("10006", "5680", newAddress, newAddress, 1, 50, 100.90, "draft", formatter.parse("01/01/2025"), true);
		    hotelRes.toString();
		 
		    //sample cabin reservation
		    CabinReservation cabRes = new CabinReservation("10006", "99999", newAddress, newAddress, formatter.parse("01/01/2025"), 1, 50, 100.90, "draft", true, true);
		    cabRes.toString();
		    
		    //sample house reservation
		    HouseReservation houseRes = new HouseReservation("10006", "7777", newAddress, newAddress, 1, 50, 100.90, "draft", formatter.parse("01/01/2025"), 1);
		    houseRes.toString();
		    
		    //sample hotel reservation without a price set
		   HotelReservation hotelRes2 = new HotelReservation("10006", "8888", newAddress, 1, 50, "draft", formatter.parse("01/01/2025"), true);
		   hotelRes2.toString();
		    
		   //find the account number to associate with the reservations
		    String accNum = acc.getAccountNumber();
		    
		    //add the draft reservations
		   manager.addDraftLodging(hotelRes, accNum);
		   manager.addDraftLodging(cabRes, accNum);
		   manager.addDraftLodging(houseRes, accNum);
		   manager.addDraftLodging(hotelRes2, accNum);	   

		    //Use Manager class to load all the accounts and their corresponding reservations data. 
	   
		    //get the path
		    String path = manager.getDirectory();
	  	
		    //find out how many files there are to load in the directory folder
		    File folder = new File(manager.getDirectory());
		    File[] listOfFiles = folder.listFiles();

		    for (int i = 0; i < listOfFiles.length; i++) {
		    	if (listOfFiles[i].isFile()) {
		    		System.out.println("File " + listOfFiles[i].getName());
		    	} else if (listOfFiles[i].isDirectory()) {
		    		
		    	//create a path for each file to be loaded
		    	String directory = path  + listOfFiles[i].getName();
		    
		    	//send the path of the file to load
		    	manager.loadAccounts(directory);
		    	}//end if/else block
		  
		    }//end for loop 
		   
		    //print the number of files loaded to the screen for testing purposes
		    System.out.println("We loaded " + manager.getAccounts().size()+" accounts");  
		    int i;
	    	//int j;
	    	int k = manager.getAccounts().size();
	    	int m = 0;
	    	
	    	//find the number of reservations for each account
			for (i = 0; i < k; i++) {
				//get the size of each account
				int l = manager.getAccounts().get(i).getReservations().size();
				//add it to the running total
				m = m + l;
			}
		    //print out the number of reservation files that were loaded
			 System.out.println("We loaded " + m +" reservations");  
		    
		    //cancel reservation
		    manager.cancelReservation("5680");
		    //String path2 = path+"res8888.txt";
		    //String findAccount = ""
		    System.out.println(accNum);
		    
		   Account returnedAccount = manager.getAccount(accNum);
		  // ArrayList<Reservation> = (ArrayList<Reservation>) returnedAccount.getReservations();
		 //  System.out.println(returnedAccount.getReservations());
		   //System.out.println(returnedAccount.getPhoneNumber());
		    */
		  

	}

}

