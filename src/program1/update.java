package program1;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class update
{
	public static void main(String[] args)
	{
		String url = "jdbc:mysql://localhost:3306/satish";
		String username = "root";
		String password ="Sasu@1209";
		String sql = "update employees set salary = salary+? where department=?";
		
		
		try {
			Scanner scan = new Scanner(System.in);
		    Connection con=DriverManager.getConnection(url,username,password);
		    PreparedStatement st = con.prepareStatement(sql);
		    st.setInt(1, scan.nextInt());
		    st.setString(2, scan.next());
		    int i = st.executeUpdate();
		    System.out.println(i);
		    scan.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}
}