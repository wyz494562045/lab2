package tutorial;
import com.opensymphony.xwork2.ActionSupport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class FindbyAuthor extends ActionSupport{
	private String AuthorName;
	private ArrayList<InfofBook> BookList=new ArrayList<InfofBook>();
	
	public String getAuthorName(){
		return AuthorName;
	}
	
	public void setAuthorName(String str){
		AuthorName=str;
	}
	
	public ArrayList<InfofBook> getBookList() {
		return BookList;
	}

	public void setBookList(ArrayList<InfofBook> list) {
		BookList=list;
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
            if(AuthorName!=null){
              if(AuthorName.trim().equals("")){
            	  return "empty";   //error1
              }
            }
            String sql="select AuthorID from author where";
            sql+=" Name = ?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,AuthorName);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
            	String sql2="select ISBN,Title from book where";
            	sql2+=" AuthorID = ?";
            	PreparedStatement ps2=con.prepareStatement(sql2);
            	ps2.setString(1,rs.getString("AuthorID"));
            	ResultSet rs2=ps2.executeQuery();
            	while (rs2.next()){
                    InfofBook temp=new InfofBook(rs2.getString("Title"),rs2.getString("ISBN"),rs.getString("AuthorID"));
                    BookList.add(temp);
                    result=SUCCESS;   //成功，即找到该作者书的状态；失败，即该作者没有书的状态
                    flag=1;
                 }
            }
            /*String sql="select ISBN,Title from book where AuthorID in (select AuthorID from author where";
            sql+=" Name = ?)";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,AuthorName);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
               InfofBook temp=new InfofBook(rs.getString("Title"),rs.getString("ISBN"));
               BookList.add(temp);
               result=SUCCESS;   //成功，即找到该作者书的状态；失败，即该作者没有书的状态
               flag=1;
            }*/
            if(flag==0){
            	return "NotExist";
            }
            rs.close();
            ps.close();
            con.close();
         } catch (Exception e1) {
            result=ERROR;
            System.out.println(e1);
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
class InfofBook{
	private String BookISBN;
	private String BookTitle;
	private String AuthorID;
	
	InfofBook(String name, String ISBN,String ID) {
		BookISBN=ISBN;
		BookTitle=name;
		AuthorID=ID;
	}
	
	public String getBookTitle(){
		return BookTitle;
	}
	
	public void setBookTitle(String str){
		BookTitle=str;
	}
	
	public String getBookISBN(){
		return BookISBN;
	}
	
	public void setBookISBN(String str){
        BookISBN=str;
	}
	public String getAuthorID(){
		return AuthorID;
	}
	
	public void setAuthorID(String str){
		AuthorID=str;
	}
	
}
