package tutorial;
//缺少：无信息时返回fail
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.opensymphony.xwork2.ActionSupport;
public class ShowDetails extends ActionSupport {
	
	private String BookISBN;
	private String BookTitle;
	private String AuthorID;
	private String BookPublisher;
	private String BookPublishDate;
	private double BookPrice;
	private String AuthorName;
	private int AuthorAge;
	private String AuthorCountry;
	
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
	
	public String getAuthorName(){
		return AuthorName;
	}
	public void setAuthorName(String str){
		AuthorName=str;
	}
	
	public int getAuthorAge(){
		return AuthorAge;
	}
	public void setAuthorAge(int age){
		AuthorAge=age;
	}
	
	public String getAuthorCountry(){
		return AuthorCountry;
	}
	public void setAuthorCountry(String str){
		AuthorCountry=str;
	}
	
	public String execute() {
    	String result=ERROR;
    	String driver="com.mysql.jdbc.Driver";
    	String url="jdbc:mysql://sqld.duapp.com:4050/hZJiMbRobOzqUUlfOOGF?useUnicode=true&characterEncoding=utf-8&useSSL=false";
		String user="053e8a93abd747b38dee5619b2abe713";
		String password="e81c3dd3703a4d71b1e971ea03adb7e6";
		int flag1=0;
		int flag2=0;
		Connection con=null;
    	
    	try {
    		Class.forName(driver);
            con=DriverManager.getConnection(url,user,password);
            if(BookISBN!=null && BookTitle!=null && AuthorID!=null && AuthorName!=null){
               if(BookISBN.trim().equals("")||BookTitle.trim().equals("")||AuthorID.trim().equals("")||AuthorName.trim().equals("")){
            	   return "empty";   //error1
               }
            }
            String sql="select * from book where";
            sql+=" ISBN = ?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,BookISBN);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
               BookISBN=rs.getString("ISBN");
               BookTitle=rs.getString("Title");
               AuthorID=rs.getString("AuthorID");
               BookPublisher=rs.getString("Publisher");
               BookPublishDate=rs.getString("PublishDate");
               BookPrice=rs.getDouble("Price");  
               flag1=1;
            }
            System.out.println("1");
            sql="select * from author where";
            sql+=" AuthorID = ?";
            ps=con.prepareStatement(sql);
            ps.setString(1,AuthorID);
            rs=ps.executeQuery();
            while (rs.next()){
            	AuthorName=rs.getString("Name");
                AuthorAge=rs.getInt("Age");
                AuthorCountry=rs.getString("Country");
                flag2=1;
            }
            System.out.println("2");
            if(flag1==1&&flag2==1){
            	result=SUCCESS;
            }
            else{
            	return "ExistError";
            }
            rs.close();
            ps.close();
            con.close();
         } catch (Exception e1) {
        	 e1.printStackTrace();
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
