package program1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class transactions {

	//public static void main(String[] args) {
		// TODO Auto-generated method stub
		private static Connection con;
		//private static Statement st;
		private static PreparedStatement st2;
		//private static final Scanner;
		Scanner scan =new Scanner(System.in);
		public static void main(String[] args)
		{
			String url="jdbc:mysql://localhost:3306/satish";
			String username ="root";
			String password ="Sasu@1209";
			try
			{
				con = DriverManager.getConnection(url,username,password);
				transaction();
				
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
			
		
		static void  transaction() throws SQLException
		{
			Scanner scan2 = new Scanner(System.in);
			con.setAutoCommit(false);
			System.out.println("Enter the user name:  ");
			//String user = scan2.next();
			System.out.println("Enter the sender name:  ");
			String sender =scan2.next();
			System.out.println("Enter the receiver name:  ");
			String receiver =scan2.next();
			
			int amount = scan2.nextInt();
			int i = updatedAmount(sender,-(amount));
			int j = updatedAmount(receiver,amount);
			scan2.close();
			
			if(isConfirm(i,j))
			{
				con.commit();
			}
			else
			{
				con.rollback();
			}
			
			
			
			
			
		}
		static int  updatedAmount(String user,int amount)  throws SQLException
		{
			String sql = "update employees set salary=salary+ ?  where name =? ";
			st2 = con.prepareStatement(sql);
			st2.setInt(1,amount);
			st2.setString(2,user);
			int i = st2.executeUpdate();
			return i;
			
			
		}
		static boolean isConfirm(int i,int j)
		{
			Scanner scan3 = new Scanner(System.in);
			System.out.println("Do you want to do transaction: (yes || No");
			String choice = scan3.next();
			scan3.close();
			return choice.equalsIgnoreCase("yes") && i==1 && j==1;
			
		}
	
		
		
		
	}


