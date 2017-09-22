package tutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Pattern;

import com.opensymphony.xwork2.ActionSupport;

public class UpdateAuthor extends ActionSupport{
	

	private String AuthorID;
	private String AuthorName;
	private String AuthorAge;
	private String AuthorCountry;
	
	
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
	
	public String execute(){
		String result=ERROR;
		String driver="com.mysql.jdbc.Driver";
    	String url="jdbc:mysql://sqld.duapp.com:4050/hZJiMbRobOzqUUlfOOGF?useUnicode=true&characterEncoding=utf-8&useSSL=false";
		String user="053e8a93abd747b38dee5619b2abe713";
		String password="e81c3dd3703a4d71b1e971ea03adb7e6";
		Connection con=null;
		int flag=0;
		if(AuthorID!=null){
            if(AuthorID.trim().equals("")){
         	   return "empty";   //error1
            }
         }
		if (AuthorAge!=null &&!AuthorAge.trim().equals("")) {  
       	 Pattern pattern=Pattern.compile("^[-\\+]?[\\d]*$"); 
       	 if(!pattern.matcher(AuthorAge).matches()){
       		 return "typeerror";
       	 }
       }
    	try {
    		Class.forName(driver);
            con=DriverManager.getConnection(url,user,password);
            String sql="select * from author where";
            sql+=" AuthorID = ?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,AuthorID);
            ResultSet rs=ps.executeQuery();
            System.out.println("AuthorID:"+AuthorID);
            while(rs.next()){
            	System.out.println("ppppppp");
            	sql="update author set Name=?,Age=?,Country=? where";
            	sql+=" AuthorID = ?";
            	ps=con.prepareStatement(sql);
                ps.setString(1,AuthorName);
                if (AuthorAge!=null &&!AuthorAge.trim().equals(""))
                	ps.setString(2,AuthorAge);
                else
                	ps.setString(2,"0");
                ps.setString(3,AuthorCountry);
            	ps.setString(4,AuthorID);
            	System.out.println(ps.executeUpdate());
                if(ps.executeUpdate()==1){
                	result=SUCCESS;
                }
                flag=1;
            }
            if(flag==0){
            	result="ExistError";
            }
            sql="update book set AuthorID=? where AuthorID in (select AuthorID from author where";
            sql+=" AuthorID = ?)";
            ps=con.prepareStatement(sql);
            ps.setString(1,AuthorID);
            ps.setString(2,AuthorID);
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
