package tutorial;  

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

public class ListAuthorInf extends ActionSupport 
{     
	private ArrayList<AllInfofAuthor> AuthorList=new ArrayList<AllInfofAuthor>();
	
	public ArrayList<AllInfofAuthor> getAuthorList() {
		return AuthorList;
	}
	public void setAuthorList(ArrayList<AllInfofAuthor> list) {
		AuthorList=list;
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
            String sql="select * from author";
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
            	AllInfofAuthor temp=new AllInfofAuthor(rs.getString("AuthorID"),rs.getString("Name"),rs.getString("Age")
            		   ,rs.getString("Country"));
               AuthorList.add(temp); 
               System.out.println("!");
            }
            result=SUCCESS; 
            rs.close();
            ps.close();
            con.close();
         } catch (Exception e1) {
            result=ERROR;
            e1.printStackTrace();
         } finally {
            if (con!= null) {
               try {
                  con.close();
               } catch (Exception e) {
               }
            }
         }
         return result;  	
    }
}

class AllInfofAuthor{
	private String AuthorID;
	private String AuthorName;
	private String AuthorAge;
	private String AuthorCountry;
	
	AllInfofAuthor(String ID,String Name,String Age,String Country) {
		AuthorID=ID;
		AuthorName=Name;
		AuthorAge=Age;
		AuthorCountry=Country;
	}
	
	public String getAuthorID(){
		return AuthorID;
	}
	public void setAuthorID(String str){
		AuthorID=str;
	}
	
	public String getAuthorName(){
		return AuthorName;
	}
	public void setAuthorName(String str){
		AuthorName=str;
	}
	
	public String getAuthorAge(){
		return AuthorAge;
	}
	public void setAuthorAge(String age){
		AuthorAge=age;
	}
	
	public String getAuthorCountry(){
		return AuthorCountry;
	}
	public void setAuthorCountry(String str){
		AuthorCountry=str;
	}
}
