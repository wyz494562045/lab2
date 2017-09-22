package tutorial;

import com.opensymphony.xwork2.ActionSupport;

public class ConfirmUpdateBook extends ActionSupport{
    private String BookISBN;
 	
 	public String getBookISBN(){
 		return BookISBN;
 	}
 	public void setBookISBN(String str){
         BookISBN=str;
 	};
 	public String execute() {
 		if(BookISBN.trim().equals("")){
        	return "empty";   //error1
    	}else{
    		return SUCCESS;
    	}
    }
}
