import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("org.mariadb.jdbc.Driver");

			String url = "jdbc:mariadb://localhost:3306/Bank";
			String user = "root";
			String passwd = "sohankenji";

			Connection conn = DriverManager.getConnection(url, user, passwd);
			System.out.println("Connexion faite");
			Statement statement = conn.createStatement();
			
			System.out.println("");
			
			//ResultSet result=statement.executeQuery("INSERT INTO T_Customers(Name,FirstName) VALUES ('Carre','jim');");
			//ResultSet result=statement.executeQuery("DELETE from T_Customers where IdCust=6;");
			 //ResultSet result=statement.executeQuery("UPDATE T_Customers SET Name= 'Laude'WHERE IdCust= 1;");
			//  ResultSet result=statement.executeQuery("SELECT * from T_Customers INNER JOIN T_Accounts on T_Customers.IdCust = T_Accounts.IdCust WHERE T_Customers.FirstName = 'Neo';");
			    ResultSet result=statement.executeQuery("SELECT * from T_Accounts inner join T_Operations ON T_Accounts.NumAt= T_Operations.NumAt where T_Operations.NumAt=100;");
			//result=statement.executeQuery("select * from T_Customers;");
			ResultSetMetaData resultBank=result.getMetaData(); 
			
			
			while (result.next()) {
				//System.out.println(result.getInt(1)+" "+result.getString(2)+" "+result.getString(3)+result.getInt(4)+" "+result.getDate(5)+" "+result.getInt(6)+" "+result.getInt(7));
				System.out.println(result.getInt(1)+" "+result.getDate(2)+result.getInt(3)+" "+result.getInt(4)+" "+result.getInt(5)+" "+result.getInt(6)+" "+result.getInt(7));
			}

			
		} catch (Exception e) { 
			e.printStackTrace();
		}

	}

}


