package program1;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String url = "jdbc:mysql://localhost:3306/ satish";
		String username = "root";
		String pw = "Sasu@1209";

		Scanner sc = new Scanner(System.in);
		String sql = "insert into employees(id,name,department,salary) values(?,?,?,?)";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver is loaded");
			Connection con = DriverManager.getConnection(url,username,pw);
			PreparedStatement st = con.prepareStatement(sql);
			
			String s;
			do
			{
				
			
		
			//System.out.print("Do you want insert values more then enter yes: ");
			//String s = sc.next();
			System.out.println("Please enter details: ");
			st.setInt(1, sc.nextInt());
			st.setString(2,sc.next());
			st.setString(3, sc.next());
			st.setInt(4, sc.nextInt());
			st.addBatch();
			System.out.print("Do you want insert values more then enter yes: ");
			

			s=sc.next();
			//sc.close();
			}
			
			while(s.equalsIgnoreCase("yes"));
			
			int[] updat = st.executeBatch();
			for(int i=0;i<updat.length;i++)
			{
				System.out.println(i);
				
			}
			
	
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

	}

}
