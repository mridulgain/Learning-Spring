import java.sql.*;
public class InsertSql{
	public static void main(String args[]){

	try{
		Class.forName("org.postgresql.Driver");
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/testdb", "testuser", "password");
		PreparedStatement pst = con.prepareStatement("Insert into testtable values(?,?)");
		pst.setInt(1, 5);
		pst.setString(2, "testentries");
		int status = pst.executeUpdate();
		if(status > 0)
			System.out.println("Successfully inserted");
		
	}
	catch(Exception e){
		System.out.println(e);
	}		
	}
}