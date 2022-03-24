package connectiondb;
import java.sql.*;

public class connect {

	public static void main(String[] args) {
		
		try 
		
		{
			//driver
			System.out.print("before driver\n");
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.print("driver loadded susfully\n");
			
			//connection
		    String url = "jdbc:mysql://localhost:3306/school";//database_name after port no
		    String user = "root";
		    String password = "root";
		    
		    Connection con = DriverManager.getConnection(url, user, password);
		    
//		    ResultSet rs = null;
//		    ResultSet rs2 = null;
//		    ResultSet rs3 = null;
		    
		    //executing java string on database or statement
		    String s = "select * from  stuedent_info";
		    Statement st = con.createStatement();
		    ResultSet rs =st.executeQuery(s);
		    while(rs.next()) 
		    {
		    	System.out.print("\n"+rs.getInt(1)+" "+rs.getString(2)+rs.getString(3)+" "+rs.getString(4));
		    	
		    }
		    
		    String s12 = "update stuedent_info set city='jalagaon' where roll_no=103";
		    Statement s1 = con.createStatement();
		    int i = s1.executeUpdate(s12);
		    if(i!=0)
		    {
		    	System.out.print("\n success");
		    }
		    else {
		    	System.out.print("failure");
		    
		    }
		    System.out.print("\n after upadating ");
//		    String afterupdate = "select * from stuedent_info";
//		    rs2 =s1.executeQuery(afterupdate);
//		    
//		    while(rs2.next()) 
//		    {
//		    	System.out.print("\n"+rs.getInt(1)+" "+rs.getString(2)+rs.getString(3)+" "+rs.getString(4));
//		    	
//		    }
		    rs =st.executeQuery(s);
		    while(rs.next()) 
		    {
		    	System.out.print("\n"+rs.getInt(1)+" "+rs.getString(2)+rs.getString(3)+" "+rs.getString(4));
		    	
		    }
		    
		    
		    String sdel = "delete from stuedent_info where roll_no =104";
		    Statement s2 = con.createStatement();
		    int i2 = s2.executeUpdate(sdel);
		    if(i2 !=0)
		    {
		    	System.out.print("\n deleted");
		    }
		    else {
		    	System.out.print("\n check your roll number");
		    	
		    }
		    System.out.print("\n after deleting");
		    String afterdele = "select * from stuedent_info";
//		    rs3 =st.executeQuery(afterdele);
//		    
//		    while(rs3.next()) 
//		    {
//		    	System.out.print("\n"+rs.getInt(1)+" "+rs.getString(2)+rs.getString(3)+" "+rs.getString(4));
//		    	
//		    }
		    rs =st.executeQuery(s);
		    while(rs.next()) 
		    {
		    	System.out.print("\n"+rs.getInt(1)+" "+rs.getString(2)+rs.getString(3)+" "+rs.getString(4));
		    	
		    }
//		    
			
		}
		catch(Exception e) 
		
		{
		   e.printStackTrace();	
		}

	

	}

}

