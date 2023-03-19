package lodgingapp;


public class IllegalLoadException extends RuntimeException {
	
	private String message;
//The exception message should indicate what failed (account file versus reservation file) and the filename that could not be loaded. The message should include the account’s number that was being loaded.
	IllegalLoadException(){
	//default
	}
	
	IllegalLoadException(String fileName){
		
		super();
		
		String type = fileName.substring(0,3);
		if(type.equals("acc")) {
			this.message ="Load failed for file type account with file name "+ fileName;
		}
		else if(type.equals("res")) {
			this.message ="Load failed for file type reservation with file name "+ fileName;
		}
		else {
			this.message ="Load failed for undefined file type with file name "+ fileName;
		}		
		
	}
	

	public String toString() {
		
		return message;
	}

}
