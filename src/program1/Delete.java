package program1;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class Delete {
	public static void main(String[] args)
	{
		String url = "jdbc:mysql://localhost:3306/satish";
		String username ="root";
		String password ="Sasu@1209";
		String sql = "Delete  from  employees where id = 15";
		
		
		try
		{	
			Connection con=DriverManager.getConnection(url,username,password);
			PreparedStatement st = con.prepareStatement(sql);
			int i = st.executeUpdate();
			System.out.println(i);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			
		}
	}

}
