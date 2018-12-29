package com.democompany.demoproject.dao;

import java.util.List;
import org.bson.Document;

import com.democompany.demoproject.model.Student;
//db writer interface
public interface DemoDAO{
	boolean dbWrite(Student stud);
	List<Document> getAll(String roll);
}