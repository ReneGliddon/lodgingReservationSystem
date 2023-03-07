
public class DuplicateObjectException extends RuntimeException {
		
		private String message;
	//The generated exception message should indicate the number of the account and/or reservation number and why it failed.
		DuplicateObjectException(){
		//default
		}
		
		DuplicateObjectException(String fileName){
			
			super();
			
			//a string to check the type of file
 			String typeTest = fileName.substring(0,3);
 			String number = fileName.substring(3,fileName.length());
 		 			
			if(typeTest.equals("acc")) {
				this.message = "Duplicate account number " + number + ". Failed to duplicate this account";
			}
			else if(typeTest.equals("res")) {
				this.message = "Duplicate reservation number " + number + ". Failed to duplicate this reservation";
			}
			else {
				this.message = "Failed to duplicate address file "+ number + ".";
			}		
			
		}
		
		public String toString() {
			
			return message;
		}



}
