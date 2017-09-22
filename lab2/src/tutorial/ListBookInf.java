package tutorial;  

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

public class ListBookInf extends ActionSupport 
{     
	private ArrayList<AllInfofBook> BookList=new ArrayList<AllInfofBook>();
	
	public ArrayList<AllInfofBook> getBookList() {
		return BookList;
	}
	public void setBookList(ArrayList<AllInfofBook> list) {
		BookList=list;
	}
	
	public String execute() {
    	String result=ERROR;
    	String driver="com.mysql.jdbc.Driver";
    	String url="jdbc:mysql://sqld.duapp.com:4050/hZJiMbRobOzqUUlfOOGF?useUnicode=true&characterEncoding=utf-8&useSSL=false";
		String user="053e8a93abd747b38dee5619b2abe713";
		String password="e81c3dd3703a4d71b1e971ea03adb7e6";
		Connection con=null;
    	
    	try {
    		Class.forName(driver);
            con=DriverManager.getConnection(url,user,password);
            String sql="select * from book";
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
               AllInfofBook temp=new AllInfofBook(rs.getString("ISBN"),rs.getString("Title"),rs.getString("AuthorID")
            		   ,rs.getString("Publisher"),rs.getString("PublishDate"),rs.getDouble("Price"));
               BookList.add(temp);  
               System.out.println("!");
            }
            result=SUCCESS;
            rs.close();
            ps.close();
            con.close();
         } catch (Exception e1) {
            result=ERROR;
         } finally {
            if (con!= null) {
               try {
                  con.close();
               } catch (Exception e2) {
            	   System.out.println(e2);
               }
            }
         }
         return result;  	
    }
}

class AllInfofBook{
	private String BookISBN;
	private String BookTitle;
	private String AuthorID;
	private String BookPublisher;
	private String BookPublishDate;
	private double BookPrice;
	
	AllInfofBook(String ISBN,String Title,String ID,String Publisher,String PublishDate,double Price) {
		BookISBN=ISBN;
		BookTitle=Title;
		AuthorID=ID;
		BookPublisher=Publisher;
		BookPublishDate=PublishDate;
		BookPrice=Price;
	}
	
	public String getBookISBN(){
		return BookISBN;
	}
	public void setBookISBN(String str){
        BookISBN=str;
	}
	
	public String getBookTitle(){
		return BookTitle;
	}
	public void setBookTitle(String str){
		BookTitle=str;
	}
	
	public String getAuthorID(){
		return AuthorID;
	}
	public void setAuthorID(String str){
		AuthorID=str;
	}
	
	public String getBookPublisher(){
		return BookPublisher;
	}
	public void setBookPublisher(String str){
		BookPublisher=str;
	}
	
	public String getBookPublishDate(){
		return BookPublishDate;
	}
	public void setBookPublishDate(String str){
		BookPublishDate=str;
	}
	
	public double getBookPrice(){
		return BookPrice;
	}
	public void setBookPrice(double price){
		BookPrice=price;
	}
}
