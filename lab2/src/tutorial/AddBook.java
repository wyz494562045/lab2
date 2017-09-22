package tutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Pattern;

import com.opensymphony.xwork2.ActionSupport;

public class AddBook extends ActionSupport{
   
	private String BookISBN;
	private String BookTitle;
	private String AuthorID;
	private String BookPublisher;
	private String BookPublishDate;
	private String BookPrice;
	private String AuthorName;
	private String AuthorAge;
	private String AuthorCountry;
	
	public String getBookISBN(){
		return BookISBN;
	}
	public void setBookISBN(String BookISBN){
        this.BookISBN=BookISBN;
	}
	
	public String getBookTitle(){
		return BookTitle;
	}
	public void setBookTitle(String BookTitle){
		this.BookTitle=BookTitle;
	}
	
	public String getAuthorID(){
		return AuthorID;
	}
	public void setAuthorID(String AuthorID){
		this.AuthorID=AuthorID;
	}
	
	public String getBookPublisher(){
		return BookPublisher;
	}
	public void setBookPublisher(String BookPublisher){
		this.BookPublisher=BookPublisher;
	}
	
	public String getBookPublishDate(){
		return BookPublishDate;
	}
	public void setBookPublishDate(String BookPublishDate){
		this.BookPublishDate=BookPublishDate;
	}
	
	public String getBookPrice(){
		return BookPrice;
	}
	public void setBookPrice(String BookPrice){
		this.BookPrice=BookPrice;
	}
	
	public String getAuthorName(){
		return AuthorName;
	}
	public void setAuthorName(String AuthorName){
		this.AuthorName=AuthorName;
	}
	
	public String getAuthorAge(){
		return AuthorAge;
	}
	public void setAuthorAge(String AuthorAge){
		this.AuthorAge=AuthorAge;
	}
	
	public String getAuthorCountry(){
		return AuthorCountry;
	}
	public void setAuthorCountry(String AuthorCountry){
		this.AuthorCountry=AuthorCountry;
	}
	public String execute(){
		String result=ERROR;
		String driver="com.mysql.jdbc.Driver";
    	String url="jdbc:mysql://sqld.duapp.com:4050/hZJiMbRobOzqUUlfOOGF?useUnicode=true&characterEncoding=utf-8&useSSL=false";
		String user="053e8a93abd747b38dee5619b2abe713";
		String password="e81c3dd3703a4d71b1e971ea03adb7e6";
		Connection con=null;
		int flag1=0,flag2=0;
		if(BookISBN!=null && BookTitle!=null && AuthorID!=null && AuthorName!=null){
            if(BookISBN.trim().equals("")||BookTitle.trim().equals("")||AuthorID.trim().equals("")||AuthorName.trim().equals("")){
         	   return "empty";   //error1
            }
         }
		if (AuthorAge!=null &&!AuthorAge.trim().equals("")) {  
       	 Pattern pattern=Pattern.compile("^[-\\+]?[\\d]*$"); 
       	 if(!pattern.matcher(AuthorAge).matches()){
       		 return "typeerror";
       	 }
       }
       if (BookPrice!=null &&!BookPrice.trim().equals("")) {  
       	 Pattern pattern=Pattern.compile("^[-\\+]?[.\\d]*$");
      	  if(!pattern.matcher(BookPrice).matches()){
      		    return "typeerror";
      	    }
        }  
    	try {
    		Class.forName(driver);
            con=DriverManager.getConnection(url,user,password);
            String sql="select * from author where";
            sql+=" AuthorID = ?";
            PreparedStatement  ps=con.prepareStatement(sql);
            ps.setString(1,AuthorID);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
            	flag2=1;
            }
            if(flag2==0){
                sql="insert into author(AuthorID,Name,Age,Country) values(?,?,?,?)";
                ps=con.prepareStatement(sql);
                ps.setString(1,AuthorID);
                ps.setString(2,AuthorName);
                if (AuthorAge!=null &&!AuthorAge.trim().equals(""))
                	ps.setString(3,AuthorAge);
                else
                	ps.setString(3,"0");
                ps.setString(4,AuthorCountry);
                if(ps.executeUpdate()!=1){
                	result=ERROR;
                }
            }
            sql="select * from book where";
            sql+=" ISBN = ?";
            ps=con.prepareStatement(sql);
            ps.setString(1,BookISBN);
            rs=ps.executeQuery();
            while(rs.next()){
            	flag1=1;
                return "Repeat";
            }
            if(flag1==0){
            	sql="insert into book(ISBN,Title,AuthorID,Publisher,PublishDate,Price) values(?,?,?,?,?,?)";
                ps=con.prepareStatement(sql);
                ps.setString(1,BookISBN);
                ps.setString(2,BookTitle);
                ps.setString(3,AuthorID);
                ps.setString(4,BookPublisher);
                ps.setString(5,BookPublishDate);
                if (BookPrice!=null &&!BookPrice.trim().equals(""))
                	ps.setString(6,BookPrice);
                else
                	ps.setString(6,"0");
                if(ps.executeUpdate()==1){
                	result=SUCCESS;
                }
            }
            rs.close();  
            ps.close(); 
            con.close();
         } catch (Exception e1) {
        	 e1.printStackTrace();;
            result=ERROR;
         } finally {
            if (con!= null) {
               try {
                  con.close();
               } catch (Exception e2) {
               }
            }
         }
         return result;  	
    }
}
