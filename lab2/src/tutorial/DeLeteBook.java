package tutorial;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.opensymphony.xwork2.ActionSupport;

public class DeLeteBook extends ActionSupport{
	private String BookISBN;
	
	public String getBookISBN(){
		return BookISBN;
	}
	public void setBookISBN(String str){
        BookISBN=str;
	}
	public String execute() {
    	String result=ERROR;
    	String driver="com.mysql.jdbc.Driver";
    	String url="jdbc:mysql://sqld.duapp.com:4050/hZJiMbRobOzqUUlfOOGF?useUnicode=true&characterEncoding=utf-8&useSSL=false";
		String user="053e8a93abd747b38dee5619b2abe713";
		String password="e81c3dd3703a4d71b1e971ea03adb7e6";
		Connection con=null;
		int flag=0;
    	try {
    		Class.forName(driver);
            con=DriverManager.getConnection(url,user,password);
            if(BookISBN!=null){
               if(BookISBN.trim().equals("")){
            	   return "empty"; //error1
               }
            }
            String sql="select * from book where";
            sql+=" ISBN = ?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,BookISBN);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
            	sql="delete from book where";
                sql+=" ISBN = ?";
                ps=con.prepareStatement(sql);
                ps.setString(1,BookISBN);
                if (ps.executeUpdate()==1){   //被修改行数为1
                	result=SUCCESS;
                }
                flag=1;
            }
            if(flag==0){
            	result="ExistError";
            }
            flag=0;
            /*sql="select * from author where AuthorID in (select ISBN from book where";
            sql+=" ISBN = ?)";
            ps=con.prepareStatement(sql);
            ps.setString(1,BookISBN);
            rs=ps.executeQuery();
            while(rs.next()){
            	sql="delete from author where AuthorID in (select BookISBN from book where";
                sql+=" ISBN = ?)";
                ps=con.prepareStatement(sql);
                ps.setString(1,BookISBN);
                if (ps.executeUpdate()==1){   //被修改行数为1
                	result=SUCCESS;
                }
            }*/
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
               } catch (Exception e2) {
               }
            }
         }
         return result;  	
    }
}