import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
//db writer interface
public interface DbWriter{
	boolean dbWrite(String roll, String firstName, String lastName);
}
//Write into mongodb
class NoSqlWriter implements DbWriter{
	String roll, firstName, lastName;
	public NoSqlWriter() {
		this.roll = "";
		this.firstName = "";
		this.lastName = "";
	}
	public boolean dbWrite(String roll, String firstName, String lastName) {
		
		MongoClientURI mongouri= new MongoClientURI("mongodb://localhost:27017/testdb");
	    /*// Creating a Mongo client 
	    MongoClient mongo = new MongoClient( "localhost" , 27017 );
	   	// Accessing the database 
	    MongoDatabase database = mongo.getDatabase("testdb");*/
		MongoClient mongo = new MongoClient(mongouri);
		MongoDatabase database = mongo.getDatabase(mongouri.getDatabase());
	    //Retrieving a collection
	    MongoCollection<Document> collection = database.getCollection("testCollection");
	    Document document = new Document("roll", roll)
	    	      				.append("first name", firstName)
	    	      					.append("last name", lastName);
	    collection.insertOne(document); 
	    mongo.close();
	    return true;
	}
}
//write into postgresql
class SqlWriter implements DbWriter{
	String roll, firstName, lastName;
	public SqlWriter() {
		this.roll = "";
		this.firstName = "";
		this.lastName = "";
	}
	public boolean dbWrite(String roll, String firstName, String lastName) {
		try{
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/testdb", "testuser", "password");
			PreparedStatement pst = con.prepareStatement("Insert into testTable2 values(?, ?, ?)");
			pst.setString(1, roll);
			pst.setString(2, firstName);
			pst.setString(3, lastName);
			int status = pst.executeUpdate();
			if(status > 0)
				return true;		
		}
		catch(Exception e){
			System.out.println(e);
		}
		return false;
	}
}