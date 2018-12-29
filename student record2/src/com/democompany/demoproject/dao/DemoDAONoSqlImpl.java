package com.democompany.demoproject.dao;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import java.util.List;
import java.util.ArrayList;

import com.democompany.demoproject.model.Student;
@Component
public class DemoDAONoSqlImpl implements DemoDAO{
	@Autowired
	private MongoClientURI mongoClientURI;

	public boolean dbWrite(Student stud) {
		MongoClient mongo = new MongoClient(mongoClientURI);
		MongoDatabase database = mongo.getDatabase(mongoClientURI.getDatabase());
	    //Retrieving a collection
	    MongoCollection<Document> collection = database.getCollection("testCollection");
	    Document document = new Document("roll", stud.getRollNo())
	    	      				.append("first_name", stud.getFirstName())
	    	      					.append("last_name", stud.getLastName());
	    collection.insertOne(document); 
	    mongo.close();
	    return true;
	}
	public List<Document> getAll(String roll) {
		MongoClient mongo = new MongoClient(mongoClientURI);
		MongoDatabase database = mongo.getDatabase(mongoClientURI.getDatabase());
	    //Retrieving a collection
	    MongoCollection<Document> collection = database.getCollection("testCollection");
	    MongoCursor<Document> iterator;
	    if(roll == null)
	    	iterator = collection.find().iterator();
	    else
	    	iterator = collection.find(Filters.eq("roll", roll)).iterator();
	    List<Document> tempList = new ArrayList<Document>();
	    while(iterator.hasNext()) {
	    	Document document = iterator.next();
	    	tempList.add(document);
	    	System.out.println(document);
	    }
	    mongo.close();
	    return tempList;
	}
	
}