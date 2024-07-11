package program1;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;  
//import java.sql.Statement; 
import java.sql.PreparedStatement;


public class pr3
{
	 public static void main(String[] args)
	 {
		 
		 String url ="jdbc:mysql://localhost:3306/satish";
		 String username = "root";
		 String password ="Sasu@1209";
		 String sql = "Insert into 'employees' values (?,?,?,?)";
		 try
		 {
		// class.forName("com.mysql.cj.jdbc.Driver");
			 		 
		    Connection con =  DriverManager.getConnection(url,username,password);
		    PreparedStatement st = con.prepareStatement(sql);
		    st.setInt(1, 7);
		    st.setString(2, "sall");
		    st.setString(3,"IT");
		    st.setInt(4, 40000);
		    
		    int res = st.executeUpdate();
		    System.out.println(res);
		 }
		 catch(SQLException e)
		 {
			  e.printStackTrace();
		 }
	 }
}