package program1;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

public class Batchfile {
	public static void main(String[] args)
	{
		String url = "jdbc:mysql://localhost:3306/satish";
		String username = "root";
		String password = "Sasu@1209";
		String sql1 = "Insert into employees (id,name,department,salary) values (15,'kanna','fin',300000)";
		String sql2 = "Insert into employees (id,name,department,salary) values (16,'govind','hr',300000)";
		String sql3 = "Insert into employees (id,name,department,salary) values (17,'kesava','IT',300000)";
		String sql4 = "Insert into employees (id,name,department,salary) values (18,'hari','Manager',300000)";
		Connection con =null;
		Statement st =null;
		
	
	
		
		try
		{
			 con=DriverManager.getConnection(url,username,password);
			st = con.createStatement();
			 st.addBatch(sql1);
			 st.addBatch(sql2);
			 st.addBatch(sql3);
			 st.addBatch(sql4);
			 int[] ar = st.executeBatch();
			 for(int i=0;i<ar.length;i++)
			 {
				 System.out.println(ar[i]+" ");
			 }
			
			
		}
		catch(SQLException | NullPointerException e)
		{
			e.printStackTrace();
		}
	}

}
