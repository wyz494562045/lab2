package tutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.opensymphony.xwork2.ActionSupport;

public class UpdateBook extends ActionSupport{
	
	private String BookISBN;
	private String BookTitle;
	private String AuthorID;
	private String BookPublisher;
	private String BookPublishDate;
	private String BookPrice;
	private String AuthorName;
	private String AuthorAge;
	private String AuthorCountry;
	
	public String AuthorName(){
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
	
	public String getBookPrice(){
		return BookPrice;
	}
	public void setBookPrice(String price){
		BookPrice=price;
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
    public String execute() {
    	String ret=ERROR;
    	String driver="com.mysql.jdbc.Driver";
    	String url="jdbc:mysql://sqld.duapp.com:4050/hZJiMbRobOzqUUlfOOGF?useUnicode=true&characterEncoding=utf-8&useSSL=false";
		String user="053e8a93abd747b38dee5619b2abe713";
		String password="e81c3dd3703a4d71b1e971ea03adb7e6";
		Connection con=null;
        int flag=0,flag1=0,flag2=0;
        if(BookISBN!=null && BookTitle!=null && AuthorName!=null){
            if(BookISBN.trim().equals("")||BookTitle.trim().equals("")||AuthorName.trim().equals("")){
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
            PreparedStatement ps=null;
            String sql=null;
            if(AuthorID!=null && !AuthorID.trim().equals("")){
            	sql="select * from author where";
                sql+=" AuthorID = ?";
                ps=con.prepareStatement(sql);
                ps.setString(1,AuthorID);
                ResultSet rs=ps.executeQuery();
                while(rs.next()){
                	flag=1;
                }
        		ps=con.prepareStatement(sql);
        		if(flag==0){
        			sql="insert into author(AuthorID,Name,Age,Country) values(?,?,?,?)"; 
        			ps=con.prepareStatement(sql);
        			ps.setString(1,AuthorID);
                    ps.setString(2,AuthorName);
                    if (AuthorAge!=null &&!AuthorAge.trim().equals(""))
                    	ps.setString(3,AuthorAge);
                    else
                    	ps.setString(3,"0");
                    ps.setString(4,AuthorCountry);
                    if(ps.executeUpdate()==1){
                    	flag1=1;
                    } 
        		}
        		else{
        			sql ="update author set Name=?,Age=?,Country=? where";
                    sql+=" AuthorID = ?";
                    ps=con.prepareStatement(sql);
                    ps.setString(1,AuthorName);
                    if (AuthorAge!=null &&!AuthorAge.trim().equals(""))
                    	ps.setString(2,AuthorAge);
                    else
                    	ps.setString(2,"0");
                    ps.setString(3,AuthorCountry);
                    ps.setString(4,AuthorID);
                    if(ps.executeUpdate()==1){
                    	flag1=1;
                    } 
        		}
            }
            else{
            	sql="update author set Name=?,Age=?,Country=? where AuthorID in (select AuthorID from book where";
                sql+=" ISBN = ?)";
                ps=con.prepareStatement(sql);
                ps.setString(1,AuthorName);
                if (AuthorAge!=null &&!AuthorAge.trim().equals(""))
                	ps.setString(2,AuthorAge);
                else
                	ps.setString(2,"0");
                ps.setString(3,AuthorCountry);
                ps.setString(4,BookISBN);
                if(ps.executeUpdate()==1){
                	flag1=1;
                } 
            }
            if(BookTitle!=null && !BookTitle.trim().equals("")){
            	sql = "update book set Title=? where";
                sql+=" ISBN = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, BookTitle);
                ps.setString(2, BookISBN);
                ps.executeUpdate();
            }
            if(AuthorID!=null && !AuthorID.trim().equals("")){
            	sql = "update book set AuthorID=? where";
                sql+=" ISBN = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, AuthorID);
                ps.setString(2, BookISBN);
                ps.executeUpdate();
            }
            sql = "update book set Publisher=?,PublishDate=?,Price=? where";
            sql+=" ISBN = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, BookPublisher);
            ps.setString(2, BookPublishDate);
            if (BookPrice!=null &&!BookPrice.trim().equals(""))
            	ps.setString(3,BookPrice);
            else
            	ps.setString(3,"0");
            ps.setString(4, BookISBN);
            if(ps.executeUpdate()==1){
            	flag2=1;
            }
            if(flag1==1 && flag2==1){
            	ret=SUCCESS;
            }
            ps.close();
            con.close();
         } catch (Exception e1) {
            ret = ERROR;
            e1.printStackTrace();
         } finally {
            if (con != null) {
               try {
                  con.close();
               } catch (Exception e2) {
            	   e2.printStackTrace();
               }
            }
         }
         return ret;  	
    }
}
/*if(BookTitle==null ||BookTitle.trim().equals("")){
	sql = "update book set AuthorID=?,Publisher=?,PublishDate=?,Price=? where";
    sql+=" ISBN = ?";
    ps.setString(1, AuthorID);
    ps.setString(2, BookPublisher);
    ps.setString(3, BookPublishDate);
    ps.setString(4,Double.toString(BookPrice));
    ps.setString(5, BookISBN);
}
else{
	sql = "update book set Title=?,AuthorID=?,Publisher=?,PublishDate=?,Price=? where";
    sql+=" ISBN = ?";
    ps.setString(1, BookTitle);
    ps.setString(2, AuthorID);
    ps.setString(3, BookPublisher);
    ps.setString(4, BookPublishDate);
    ps.setString(5,Double.toString(BookPrice));
    ps.setString(6, BookISBN);
}*/