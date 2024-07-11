package program1;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class prg21 {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/satish";
		String username = "root";
		String password = "Sasu@1209";
		String sql = "select * from employees;";
		Connection con=null;
		Statement st = null;
		ResultSet res =null;
		try {
		//	Class.forName("com.mysql.cj.jdbc.Driver");
		 con = DriverManager.getConnection(url,username,password);
		 st = con.createStatement();
		 res = st.executeQuery(sql);
		
		while(res.next())
		{
			int id = res.getInt("id");
			String name = res.getString("name");
			String department = res.getString("department");
			int salary = res.getInt("salary");
			System.out.printf("%d | %-7s | %-5s | %-7d |\n",id,name,department,salary);
		}

	}
		catch(SQLException e )
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(con!=null)
				{
					con.close();
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			try
			{
				if(st!=null)
				{
					con.close();
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			try
			{
				if(res!=null)
				{
					con.close();
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}

}































