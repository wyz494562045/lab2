package tutorial;

import com.opensymphony.xwork2.ActionSupport;

public class ConfirmUpdateAuthor extends ActionSupport{
    private String AuthorID;
 	
 	public String getAuthorID(){
 		return AuthorID;
 	}
 	public void setAuthorID(String str){
 		AuthorID=str;
 	};
 	public String execute() {
 		if(AuthorID.trim().equals("")){
        	return "empty";   //error1
    	}else{
    		return SUCCESS;
    	}
    }
}
