package lodgingapp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.time.LocalDate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class Test {
     static /*
     * This Test class contains the main method. Upon startup, all existing accounts and their associated reservations will be loaded
     * We have 9 test cases. Test case 2 is done in main for access to the objects. Due to a Duplicate Object Exception, we cannot recreate these files or objects each time we need them in a method, so they need to be in scope for all methods 
     */
	//Create an instance of Manager class
	Manager manager;
    
public static void main(String[] args) throws Exception {

	
	manager = new Manager();
	
	
	//test case 1:  calls manager.setUp, which loads data from files
		//manager.setUp();
		//testCase1();
		testLoadingFromFiles();
	
		
		
	//test case 2: add new objects: this test case adds new objects, writes the data to files and automatically adds object to the manager class
		//this is DONE IN MAIN as there is a DUplicateObjectException, meaning that these objects cannot be recreated each time we need them like in the To.java example given.
		//Create and add objects to the list and create the files for these objects
				System.out.println("\nTest case 2: Create new objects, add them to the lists, which automatically writes their files. This tests the (a) TOSTRING(), (c) WRITING, and (a)ADDING OBJECTS functionality of this program\n");
			 
				//add new objects
				
					//A new Address object
				    Address newAddress = new Address("123 Sample Road", "Baltimore", "MD", "11122");
				    System.out.println("\nTesting the toString() method for Address.");
				    String address = newAddress.toString();
				    
				    //New Account objects
				    Account acc = new Account("1111", newAddress, "sampleemail@email.com", "415 253 1122");
				    Account acc2 = new Account("2222", newAddress, "sampleemail@email.com", "415 253 1122");
				    Account acc3 = new Account("3333", newAddress, "sampleemail@email.com", "415 253 1122");
				    Account acc4 = new Account("4444", newAddress, "sampleemail@email.com", "415 253 1122");
				    Account acc5 = new Account("5555", newAddress, "sampleemail@email.com", "415 253 1122");
				    
				    //test the toString function()
				    System.out.println("\nTesting the toString() method for 5 Account objects.\n");
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
				    
				    //add the account objects to the list and create the files
				    //write the new String address and account objects to a file
				    System.out.println("Now we WRITE the address and account objects to a file, and ADD them to our list.");
				    manager.addNewAddress(address);
					manager.addNewAccount(account);
					manager.addNewAccount(account2);
					manager.addNewAccount(account3);
					manager.addNewAccount(account4);
					manager.addNewAccount(account5); 
					
					manager.printAccounts();
					
					System.out.println("\nNext, we create 3 Reservation objects, testing their toString() methods, and their writing methods.");
					
					//new reservation objects
			    	//formatter
			    	SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			    
			    	//sample hotel reservations
			    	HotelReservation hotelRes = new HotelReservation("1111", "1212", newAddress, newAddress, 3, 1050, "draft", formatter.parse("01/01/2024"), true);
			    	System.out.println("\nTesting the toString() method for HotelReservation");
				    String hotelReservation = hotelRes.toString();
				    
				    HotelReservation hotelRes2 = new HotelReservation("2222", "1213", newAddress, newAddress, 3, 1050, "draft", formatter.parse("01/01/2024"), true);
			    	System.out.println("\nTesting the toString() method for HotelReservation");
				    String hotelReservation2 = hotelRes2.toString();

				    //sample cabin reservations
				    CabinReservation cabRes = new CabinReservation("3333", "2113", newAddress, newAddress, formatter.parse("01/01/2025"), 4, 901, 100.90, "draft", true, true, 2, 4, 5);
				    System.out.println("\nTesting the toString() method for CabinReservation");
				    String cabinReservation = cabRes.toString();
				    
				    CabinReservation cabRes2 = new CabinReservation("3333", "1231", newAddress, newAddress, formatter.parse("01/01/2025"), 4, 901, 100.90, "draft", true, true, 2, 4, 5);
				    System.out.println("\nTesting the toString() method for CabinReservation");
				    String cabinReservation2 = cabRes2.toString();
				    
				    //sample house reservations
				    HouseReservation houseRes = new HouseReservation("4444", "1234", newAddress, newAddress, 1, 50, "draft", formatter.parse("01/01/2025"), 1);
				    System.out.println("\nTesting the toString() method for HouseReservation");
				    String houseReservation = houseRes.toString(); 	
				    
				    HouseReservation houseRes2 = new HouseReservation("4444", "1235", newAddress, newAddress, 1, 50, "draft", formatter.parse("01/01/2025"), 1);
				    System.out.println("\nTesting the toString() method for HouseReservation");
				    String houseReservation2 = houseRes2.toString();
			    
				    //Now we will add the reservations
				    System.out.println("\nNow we will WRITE the reservations to a file, and ADD them to our lists.");
					manager.addNewReservation(hotelReservation);
					manager.addNewReservation(hotelReservation2);
					manager.addNewReservation(cabinReservation);
					manager.addNewReservation(cabinReservation2);
					manager.addNewReservation(houseReservation);
					manager.addNewReservation(houseReservation2);
					
					System.out.println("\nHere are all the accounts with their reservation lists:");
					manager.printAccountsAndReservations();
					
	//test case 2: proving the above objects were written to files and added to the manager's list
		testNewObjectsWereAddedToListsAndWrittenToFilesWithCorrectNamingConventions();
					
	//test case 3: removes object from manager. We will remove hotelRes
		testRemovingObjects(hotelRes.getReservationNumber());
//		testRemovingObjects(cabRes2.getReservationNumber());
//		testRemovingObjects(houseRes2.getReservationNumber());
		
	//test case 4: retrieves and returns data 
		testRetrieveObjectAndReturnData(houseRes);
//		testRetrieveObjectAndReturnData(hotelRes2);
//		testRetrieveObjectAndReturnData(cabRes2);
		
	//test case 5: cancel a reservation 
		testCancelReservation(cabRes);
//		testCancelReservation(hotelRes2);
//		testCancelReservation(houseRes2);
		
	//test case 6: complete a reservation. 
		testCompleteReservation(houseRes);
//		testCompleteReservation(cabRes2);
///		testCompleteReservation(hotelRes2);
		
	//test case 7: update a reservation 		
		testUpdateReservation(hotelRes2);
		//testUpdateReservation(cabRes2);
		//testUpdateReservation(houseRes2);
		
	//test case 8: update an account
		testUpdateAccount(acc);
		
	//test case 9: calculates a reservation price per night and also for the whole reservation
		testCalculatePricePerNightAndForWholeReservation(hotelRes2);
		//testCalculatePricePerNightAndForWholeReservation(cabRes2);
		//testCalculatePricePerNightAndForWholeReservation(houseRes2);
			
		System.out.println("\nIf you run this again without changing account and reservation numbers, you will get a DuplicateObjectException since the files will be LOADED from the .txt files during set up, and then Test will try add them again.");
		   
		System.out.println("You can delete the \"accounts\" folder to restart.");		    



		
}	



//testCase1 tests the loading functionality of the code. This test case loads all account and reservation files. Initially, this will be only 1 account and 1 reservation file for testing
		
		static void testLoadingFromFiles() throws ParseException, IOException {
			
			System.out.println("*********************************************************************************************************************************************************************");
			
			//files that are found
			System.out.println("test case 1: Testing the loading functionality of the code. This method will call setUp(), which in turn calls testFileReading(), and then calls loadAccounts(), and finally calls loadReservations().");
			System.out.println("testFileReading() will CREATE AN ACCOUNT FILE and a RESERVATION FILE. ");
			System.out.println("loadAccounts() will LOAD the account FILES to the manager's LIST as Account objects.");	
			System.out.println("loadReservations() will LOAD the reservation FILES to the manager's LIST as Reservation objects.\n");	
			
			//load account and reservation files
			manager.setUp();
			
			//files
			manager.printAllFiles();
			
			
			//test that the files were read
			//manager's lists
			manager.printAccounts();
			manager.printReservations();
			
			
			System.out.println("*********************************************************************************************************************************************************************");

		}
		
		//Test case 2: we are going to add new files, both account and reservation. This method tests the adding of objects to the manager's lists, but also tests the writing of these objects to the files
		static void testNewObjectsWereAddedToListsAndWrittenToFilesWithCorrectNamingConventions() throws IOException {
			//Print the accounts and reservations loaded from files
			System.out.println("\nTest case 2: testing that (a) the new objects were WRITTEN to FILES, (b)the account and reservation files were WRITTEN TO SEPARATE FILES, but ORGANIZED under the APPROPRIATE ACCOUNT'S FOLDER.");
			System.out.println("that (c) the new objects were also ADDED TO LISTS: accounts to manager's accounts list, and reservations both to manager's reservations list and account's reservations list.");
			System.out.println("that (d) the new account objects and files have a -99 VALUE when they have no reservations, and then have the -99 REMOVED once reservations are added to their list.");
			System.out.println("and that (e) the objects and files follow the correct NAMING CONVENTIONS of \"acc\" + account number for accounts, and \"res\"+reservation number for reservations.");
			
			//accounts
			manager.printAccounts();
			
			//reservations
			manager.printReservations();
			System.out.println("\n");
			
			
		//test naming conventions, as well as file locations 
			
			//Account files name convention should be “acc-“ followed by the account number and the appropriate file extension (html, txt, or json). The reservation file name convention should be “res-“ followed by the reservation number and appropriate file extension. 
			//Each account’s data should be saved in a separate directory named as the account’s number. Account’s information should be saved in one file and then each reservation that belongs to that account in separate file. 
			manager.printAllFileDirectories();
		//	System.out.println("Here are all files that have been written:");
			manager.printAllFiles();
			//test that the objects were all added to the correct places. The reservations must be added to the correct account's "reservations" list
			System.out.println("\nNext, we will print out all accounts' reservations.");
			manager.printAccountsAndReservations(); 
			
			System.out.println("*********************************************************************************************************************************************************************");	
			//The account’s file should have all the reservation numbers associated with the account but no other reservation data.
			
		}
		
		//test case 3: removes object from manager. We will remove houseRes
		static void testRemovingObjects(String removeReservation) throws Exception {
			
			//print all reservations
			System.out.println("\nTest case 3: We will test the OBJECT REMOVAL functionality of this code.");
			System.out.println("\nBefore we remove Reservation object res"+ removeReservation);
			manager.printReservations();
			manager.printReservationsInFiles();
			
			System.out.println("\nDeleting...\n");
			manager.removeReservation(removeReservation);
			
			System.out.println("\nAfter we remove a Reservation object:");
			manager.printReservations();
			manager.printReservationsInFiles();

			System.out.println("*********************************************************************************************************************************************************************");	
			
		}
		
		//test case 4: retrieves and returns data 
		static void testRetrieveObjectAndReturnData(Reservation reservation) throws ParseException {
			

			System.out.println("\nTest case 4: We will test the retrieve method in 2 ways: 1) We will RETRIEVE an ACCOUNT object, 2) We will RETRIEVE each type of RESERVATION object, and 3) We will retrieve a specific object that was pass in as a parameter. This object is reservation res"+reservation.getReservationNumber());
			System.out.println("We will print their values to the screen.");
			
			//retrieve the first account in the list
			for(int i = 0; i < 1; i++) {
				System.out.println("\nCase 4.1) We are retrieving an account: ");
			
				System.out.println("Account number: "+manager.getAccounts().get(i).getAccountNumber());
				System.out.println("Email address: "+manager.getAccounts().get(i).getEmailAddress());
				System.out.println("Mailing address: " + manager.getAccounts().get(i).getMailingAddress().getStreet() + " " + manager.getAccounts().get(i).getMailingAddress().getCity() + " " + manager.getAccounts().get(i).getMailingAddress().getState()+ " " + manager.getAccounts().get(i).getMailingAddress().getZip());
				System.out.println("Phone number: " + manager.getAccounts().get(i).getPhoneNumber());
				for (int j = 0; j < manager.getAccounts().get(i).getReservations().size(); j++) {
						System.out.println("Reservation found for this account: "+ manager.getAccounts().get(i).getReservations().get(i));
			}
				
			int houseCount = 0;
			int hotelCount = 0;
			int cabinCount = 0;
			
			//retrieve each type of reservation
			for(int j = 0; j < manager.getReservations().size(); j++) {			
				String convertedToString = "" + manager.getReservations().get(j).getClass();   //method 2
				if(convertedToString.contains("HouseReservation") && houseCount == 0) {
					System.out.println("\nCase 4.2) We are retrieving a HouseReservation: ");
					//since we retrieved a Reservation object, we must convert it to a HouseReservation object
					Reservation s = new HouseReservation(manager.getReservations().get(j).toStringQuiet());
					HouseReservation h = (HouseReservation)s;
					//once we have converted the object type, we can print its values
					manager.printHouseReservationValues(h);   
					
					//increase the count
					houseCount++;			
					
				}
				else if(convertedToString.contains("HotelReservation") && hotelCount == 0) {
						System.out.println("\nCase 4.2) We are retrieving a HotelReservation: ");
						//since we retrieved a Reservation object, we must convert it to a HotelReservation object
						Reservation r = new HotelReservation(manager.getReservations().get(j).toStringQuiet());  
				        HotelReservation h = (HotelReservation)r;   
				        //once we have converted the object type, we can print its values
				        manager.printHotelReservationValues(h);
				        
				        //increase the count
				        hotelCount++;
				}
				else if(convertedToString.contains("CabinReservation") && cabinCount == 0) {
					System.out.println("\nCase 4.2) We are retrieving a CabinReservation: ");
					//since we retrieved a Reservation object, we must convert it to a Cabin Reservation object
					Reservation r = new CabinReservation(manager.getReservations().get(j).toStringQuiet());  
			        CabinReservation c = (CabinReservation)r;  
			      //once we have converted the object type, we can print its values
			        manager.printCabinReservationValues(c);
			        
			        //increase the count
			        cabinCount++;
				}
			
			}
			
			System.out.println("\nCase 3) We are retrieving Reservation res"+reservation.getReservationNumber()+" that was passed in as a parameter.");
			
			String convertedToString = "" + reservation.getClass();   
			
			if(convertedToString.contains("HouseReservation")) {
				System.out.println("\nWe are retrieving a HouseReservation from a parameter that was passed: ");
				//since we retrieved a Reservation object, we must convert it to a HouseReservation object
				Reservation s = new HouseReservation(reservation.toStringQuiet());
				HouseReservation h = (HouseReservation)s;
				//once we have converted the object type, we can print its values
				manager.printHouseReservationValues(h);   
				
				
			}
			else if(convertedToString.contains("HotelReservation")) {
					System.out.println("\nWe are retrieving a HotelReservation from a parameter that was passed: ");
					//since we retrieved a Reservation object, we must convert it to a HotelReservation object
					Reservation r = new HotelReservation(reservation.toStringQuiet());  
			        HotelReservation h = (HotelReservation)r;   
			        //once we have converted the object type, we can print its values
			        manager.printHotelReservationValues(h);
			}
			else if(convertedToString.contains("CabinReservation")) {
				System.out.println("\nWe are retrieving a CabinReservation from a parameter that was passed: ");
				//since we retrieved a Reservation object, we must convert it to a Cabin Reservation object
				Reservation r = new CabinReservation(reservation.toStringQuiet());  
		        CabinReservation c = (CabinReservation)r;  
		      //once we have converted the object type, we can print its values
		        manager.printCabinReservationValues(c);
			}
		
			
			
		}
			System.out.println("*********************************************************************************************************************************************************************");
			
}
		//test case 5: cancels a reservation 
		static void testCancelReservation(Reservation cancelReservation) throws Exception {
			
			System.out.println("\nTest case 5: CANCELLING a reservation. We are canceling res"+cancelReservation.getReservationNumber()+" from account acc" + cancelReservation.getAccountNumber()+ ". This involves checking that a) the date has not passed, b) changing its status if dat has not passed, and c) updating its file if cancelled.\n");
			
			System.out.println("\nBefore cancelling, the reservation's status is: "+ cancelReservation.getReservationStatus()+"\n");
			
			String convertedToString = "" + cancelReservation.getClass();   
			
			if(convertedToString.contains("HouseReservation")) {
				System.out.println("\nWe are cancelling a HouseReservation from a parameter that was passed. \n");
				//since we retrieved a Reservation object, we must convert it to a HouseReservation object
				Reservation s = new HouseReservation(cancelReservation.toStringQuiet());
				HouseReservation h = (HouseReservation)s;
				//once we have converted the object type, we can cancel it
				manager.cancelReservation(h); 
			}
			else if(convertedToString.contains("HotelReservation")) {
					System.out.println("\nWe are cancelling a HotelReservation from a parameter that was passed. \n");
					//since we retrieved a Reservation object, we must convert it to a HotelReservation object
					Reservation r = new HotelReservation(cancelReservation.toStringQuiet());  
			        HotelReservation h = (HotelReservation)r;   
			        //once we have converted the object type, we can cancel it
			        manager.cancelReservation(h); 
			}
			else if(convertedToString.contains("CabinReservation")) {
				System.out.println("\nWe are cancelling a CabinReservation from a parameter that was passed. \n");
				//since we retrieved a Reservation object, we must convert it to a Cabin Reservation object
				Reservation r = new CabinReservation(cancelReservation.toStringQuiet());  
		        CabinReservation c = (CabinReservation)r;  
		      //once we have converted the object type, we can cancel it
		        manager.cancelReservation(c); 
			}
			

			//check the reservations list for the changed object, and print out its new status and the set price.
			for(int i = 0; i <manager.getReservations().size(); i++) {
				if(manager.getReservations().get(i).getReservationNumber().equals(cancelReservation.getReservationNumber())){
					System.out.println("\nReservation status is now "+manager.getReservations().get(i).getReservationStatus() + ".");
				}//end if
			}//end for
			
			System.out.println("\n*********************************************************************************************************************************************************************");
			
		   
		}		


		//test case 6: completes a reservation
		static void testCompleteReservation(Reservation thisRes) throws ParseException{
		
			System.out.println("\nTest case 6: COMPLETING a reservation. We are completing res"+thisRes.getReservationNumber()+". This includes a) changing its status, b) calculating its total price, c) setting this price, and d) updating the file\n");
			
			System.out.println("\nBefore completing the reservation, the reservation status is "+thisRes.getReservationStatus() + " and the price is "+thisRes.getPrice());
			
			String convertedToString = "" + thisRes.getClass();   
			
			if(convertedToString.contains("HouseReservation")) {
				System.out.println("\nWe are completing a HouseReservation from a parameter that was passed. \n");
				
				//since we retrieved a Reservation object, we must convert it to a HouseReservation object
				Reservation s = new HouseReservation(thisRes.toStringQuiet());
				HouseReservation h = (HouseReservation)s;
				
				//once we have converted the object type, we can complete it
				manager.completeReservation(h); 
				
				
				
			}//end if house reservation
			else if(convertedToString.contains("HotelReservation")) {
					System.out.println("\nWe are completing a HotelReservation from a parameter that was passed. \n");
					
					//since we retrieved a Reservation object, we must convert it to a HotelReservation object
					Reservation r = new HotelReservation(thisRes.toStringQuiet());  
			        HotelReservation h = (HotelReservation)r;   
			        
			        //once we have converted the object type, we can complete it
			        manager.completeReservation(h); 
			}
			else if(convertedToString.contains("CabinReservation")) {
				System.out.println("\n We are completing a CabinReservation from a parameter that was passed. \n");
				
				//since we retrieved a Reservation object, we must convert it to a Cabin Reservation object
				Reservation r = new CabinReservation(thisRes.toStringQuiet());  
		        CabinReservation c = (CabinReservation)r;  
		      //once we have converted the object type, we can complete it
		        manager.completeReservation(c); 
			}
			
			
			//check the reservations list for the changed object, and print out its new status and the set price.
			for(int i = 0; i <manager.getReservations().size(); i++) {
				if(manager.getReservations().get(i).getReservationNumber().equals(thisRes.getReservationNumber())){
					System.out.println("\nReservation status is now "+manager.getReservations().get(i).getReservationStatus() + " and the price was set to " + manager.getReservations().get(i).getPrice() + ".");
				}//end if
			}//end for
			System.out.println("\n*********************************************************************************************************************************************************************");
		}//end test case 6
				
		//test case 7: updates a reservation
		static void testUpdateReservation(Reservation reservation) throws Exception {

		    System.out.println("\nTest case 7: UPDATE a reservation. This involves a) setting new values for a reservation IFF the reservation has not passed, is not \"cancelled\", and is not \"completed\" and b) rewriting the file to reflect the changes.");		  
		    
		    String convertedToString = "" + reservation.getClass();   
			
			if(convertedToString.contains("HouseReservation")) {
				System.out.println("\nWe are updating a HouseReservation from a parameter that was passed. \n");
				//since we retrieved a Reservation object, we must convert it to a HouseReservation object
				Reservation s = new HouseReservation(reservation.toString());
				HouseReservation h = (HouseReservation)s;
				
				//once we have converted the object type, we can update it
				
				 //print out the original values
			    System.out.println("\nBefore updating the reservation, the reservation values are: ");
			    manager.printHouseReservationValues(h);
	
			    //set the new values
				h.setLodgingSizeInSquareFeet(1500);
				h.setNumberOfBathrooms(90);
				h.setNumberOfBedrooms(5);
				h.setNumberOfBeds(90);
				h.setNumberOfFloors(10);
				h.setNumberOfNights(7);
				
				  //call updateReservation which checks if the reservation is past the date, cancelled, or completed and sends an error, also makes the update in the manager's list, and overwrites the text file
				manager.updateReservation(h);
		
				//check the reservations list for the changed object, and print out its new status and the set price.
				for(int i = 0; i <manager.getReservations().size(); i++) {
					if(manager.getReservations().get(i).getReservationNumber().equals(reservation.getReservationNumber())){
						
						Reservation t = new HouseReservation(manager.getReservations().get(i).toString());  
				        HouseReservation w = (HouseReservation)t;   
				        manager.updateReservation(w);
				        System.out.println("\nAfter updating, the values of the HouseReservation reservations are: ");
					     manager.printHouseReservationValues(w);
					     
					}//end if
				}//end for
			
			}//end if its a house
			
			else if(convertedToString.contains("HotelReservation")) {
					System.out.println("\nWe are updating a HotelReservation from a parameter that was passed. \n");
					//since we retrieved a Reservation object, we must convert it to a HotelReservation object
					Reservation r = new HotelReservation(reservation.toString());  
			        HotelReservation h = (HotelReservation)r;   
			        
			        //once we have converted the object type, we can update it
			        
			        //print out the original values
			        System.out.println("\nBefore updating the reservation, the reservation values are: ");
			        manager.printHotelReservationValues(h);
			        
			        //set the new values
			        h.setKitchenette(false);
			        h.setLodgingSizeInSquareFeet(2000);
			        h.setNumberOfBathrooms(100);
			        h.setNumberOfNights(50);
			        h.setNumberOfBedrooms(10);
			        h.setNumberOfBeds(10);
			        
			      //call updateReservation which checks if the reservation is past the date, cancelled, or completed and sends an error, also makes the update in the manager's list, and overwrites the text file
			        manager.updateReservation(h);
			
			      //check the reservations list for the changed object, and print out its new status and the set price.
					for(int i = 0; i <manager.getReservations().size(); i++) {
						if(manager.getReservations().get(i).getReservationNumber().equals(reservation.getReservationNumber())){
							
							Reservation s = new HotelReservation(manager.getReservations().get(i).toString());  
					        HotelReservation w = (HotelReservation)s;   
					        System.out.println("\nAfter updating, the values of the HotelReservation reservation are: ");
						     manager.printHotelReservationValues(w);
						     
						}//end if
					}//end for
			}// end else if it's a hotel
			
			else if(convertedToString.contains("CabinReservation")) {
				System.out.println("\nWe are updating a CabinReservation from a parameter that was passed. \n");
				
				//since we retrieved a Reservation object, we must convert it to a Cabin Reservation object
				Reservation r = new CabinReservation(reservation.toString());  
		        CabinReservation c = (CabinReservation)r;  
		        
		        //print out the original values
		        System.out.println("\nBefore updating the reservation, the reservation values are: ");
		        manager.printCabinReservationValues(c);
		        
		        //set the new values
		        c.setFullKitchen(false);
		        c.setLoft(false);
		        c.setNumberOfBathrooms(50);
		        c.setNumberOfBedrooms(20);
		        c.setNumberOfBeds(1);
		        c.setNumberOfNights(10);
		        
		        //call updateReservation which checks if the reservation is past the date, cancelled, or completed and sends an error, also makes the update in the manager's list, and overwrites the text file
		        manager.updateReservation(c);
		       
		      //check the reservations list for the changed object, and print out its new status and the set price.
				for(int i = 0; i <manager.getReservations().size(); i++) {
					if(manager.getReservations().get(i).getReservationNumber().equals(reservation.getReservationNumber())){
						
						Reservation s = new CabinReservation(manager.getReservations().get(i).toString());  
				        CabinReservation w = (CabinReservation)s;   
				        System.out.println("\nAfter updating, the values of the CabinReservation reservation are: ");
					     manager.printCabinReservationValues(w);
					     
					}//end if
				}//end for

			}//end else if its a cabin
			System.out.println("\n*********************************************************************************************************************************************************************");
		}//end test case 7 update a reservation 
				
	//test case 8: update an account
	static void testUpdateAccount(Account account) throws Exception {	
			 
			System.out.println("\nTest case 8: Update an account.\n");
			
			//the object will be from the original created account object, since it was sent from main (scope)
			//remove the -99 
			int index = account.getAccountNumber().indexOf("-99");
			String accountNumber = account.getAccountNumber().substring(0,index);
			
			System.out.println("\nValues of account acc"+accountNumber+" before updating:");
			
			//search for the object in the manager's list of accounts as it will be the correct object
			for(int i = 0; i<manager.getAccounts().size(); i++) {
				
				if(manager.getAccounts().get(i).getAccountNumber().equals(accountNumber) || manager.getAccounts().get(i).getAccountNumber().equals(account.getAccountNumber())) {
					
					//System.out.println("In for loop in test");
					manager.printAccountValues(manager.getAccounts().get(i));
					
					//set the values
					manager.getAccounts().get(i).setEmailAddress("updatedaccount@account.com");
					manager.getAccounts().get(i).setPhoneNumber("1112223456");
					//new address, add and set
					Address updatedAccount = new Address("456 Updated Road", "Baltimore", "MD", "11122");
					manager.addNewAddress(updatedAccount.toString());
					manager.getAccounts().get(i).setMailingAddress(updatedAccount);
					
					//call the updateaccountValues method, which will rewrite the file 
					manager.updateAccountValues(manager.getAccounts().get(i));
			
				}//end if we find the account
			}//end for loop to search manager's account list
			
			
		
			 //check the accounts list for the changed object, and print out its new values.
			for(int i = 0; i <manager.getAccounts().size(); i++) {
			
				if(manager.getAccounts().get(i).getAccountNumber().equals(account.getAccountNumber()) ||manager.getAccounts().get(i).getAccountNumber().equals(accountNumber)){
					System.out.println("\nValues of account acc" + accountNumber + " after updating:");
				     manager.printAccountValues(manager.getAccounts().get(i));
				}//end if
			}//end for

		System.out.println("\n*********************************************************************************************************************************************************************");
			
			
		}//end testUpdateAccount
		
		//test case 9: calculates a reservation price per night and also for the whole reservation
		static void testCalculatePricePerNightAndForWholeReservation(Reservation reservation) throws ParseException {
			
			 System.out.println("\nTest case 9: Calculate the prices for a reservation.");		  
		    
		    String convertedToString = "" + reservation.getClass();   
			
			if(convertedToString.contains("HouseReservation")) {
				System.out.println("\nWe are calculating the prices for a HouseReservation from a parameter that was passed. \n");
				
				//since we retrieved a Reservation object, we must convert it to a HouseReservation object
				Reservation s = new HouseReservation(reservation.toString());
				HouseReservation h = (HouseReservation)s;
				
				//once we have converted the object type, we can calculate it
				
				//first the price per night
				System.out.println("\nThe price per night is "+ manager.calculatePricePerNight(h));
				
				//then the total price, which calls the price per night method, so some info will be repeated.
				System.out.println("\nThe number of nights are "+ h.getNumberOfNights() +" and the total price of the reservation is "+manager.calculateTotalReservationCost(h));
				
			}
			else if(convertedToString.contains("HotelReservation")) {
				System.out.println("\nWe are calculating the prices for a HotelReservation from a parameter that was passed. \n");
				//since we retrieved a Reservation object, we must convert it to a HotelReservation object
				Reservation r = new HotelReservation(reservation.toString());  
		        HotelReservation h = (HotelReservation)r;   
		        
		    	//once we have converted the object type, we can calculate it
		        
		    	//first the price per night
				System.out.println("\nThe price per night is "+ manager.calculatePricePerNight(h));
				
				//then the total price, which calls the price per night method, so some info will be repeated.
				System.out.println("\nThe number of nights are "+ h.getNumberOfNights() +" and the total price of the reservation is "+manager.calculateTotalReservationCost(h));
				
			}
			else if(convertedToString.contains("CabinReservation")) {
				System.out.println("\nWe are calculating the prices for a CabinReservation from a parameter that was passed. \n");
				//since we retrieved a Reservation object, we must convert it to a Cabin Reservation object
				Reservation r = new CabinReservation(reservation.toString());  
		        CabinReservation h = (CabinReservation)r;
		        
		    	//once we have converted the object type, we can calculate it
		        
				//first the price per night
				System.out.println("\nThe price per night is "+ manager.calculatePricePerNight(h));
				
				//then the total price, which calls the price per night method, so some info will be repeated.
				System.out.println("\nThe number of nights are "+ h.getNumberOfNights() +" and the total price of the reservation is "+manager.calculateTotalReservationCost(h));
				
		        
			}//end else if we have a cabin reservation
			
			
		}//end testCalculatePricePerNightAndForWholeReservation


}

