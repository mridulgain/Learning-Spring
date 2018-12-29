package com.democompany.demoproject.dao;

import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.Map;
import java.util.Iterator;
import java.util.ArrayList;
import java.io.IOException;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class FileDAONoSqlImpl extends FileDAOImpl{
	@Autowired
	private MongoClientURI mongoClientURI;
	
	public void setMongoClientURI(MongoClientURI mongoClientURI) {
		this.mongoClientURI = mongoClientURI;
	}
	public boolean dbWrite(String fileName) {
		try {
			writeDocument(super.readExcel(fileName));
			return true;
		}
		catch(IOException e) {
			System.out.println("Failed reading file during dbwrite");
		}
		catch(Exception e) {
			System.out.println(e);
		}
    	return false;
	}
	public void writeDocument(ArrayList<Map<String, Object>> tempList) {
		MongoClient mongo = new MongoClient(mongoClientURI);
		MongoDatabase database = mongo.getDatabase(mongoClientURI.getDatabase());
	    //Retrieving a collection
	    MongoCollection<Document> collection = database.getCollection("testCollection");
	    Iterator<Map<String, Object>> tempItr = tempList.iterator();
	    while(tempItr.hasNext()) {
	    	Document tempDoc = new Document(tempItr.next());
    		collection.insertOne(tempDoc);
	    } 
	    mongo.close();
	}
}