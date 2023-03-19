package lodgingapp;


public class IllegalOperationException extends RuntimeException{

	//indicate the operation that was attempted, account id, reservation number, and details why exactly it failed.
	private String message;
	//The generated exception message should indicate the number of the account and/or reservation number and why it failed.
	IllegalOperationException(){
		//default
		}
		
	IllegalOperationException(String fileName, String operation){
			
			super();
			
			//res number
 			//String number = filename.substring(3,filename.length());
 			
 			//account number
 			//String account = filename.substring(0)
 		 			
			if(operation.equals("cancel")) {
				this.message = "Failed to cancel reservation " + fileName + ".";
			}
			else if(operation.equals("complete")) {
				this.message = "Failed to complete reservation " + fileName + ".";
			}
			else {
				this.message = "Failed to duplicate file " + fileName + ".";
			}		
			
		}
	IllegalOperationException(String fileName, String operation, String reason){
		
		super();
		
			//res number
			//String number = fileName.substring(3,fileName.length());
			
			//account number
			//String account = filename.substring(0)
		 			
		if(operation.equals("cancel")) {
			this.message = "Failed to cancel reservation " + fileName + " because " + reason + ".";
		}
		else if(operation.equals("complete")) {
			this.message = "Failed to complete reservation " + fileName + " because " + reason + ".";
		}
		else {
			this.message = "Failed to "+ operation + " file "+ fileName + " because " + reason + ".";
		}		
		
	}
		
		public String toString() {
			
			return message;
		}
	
}
