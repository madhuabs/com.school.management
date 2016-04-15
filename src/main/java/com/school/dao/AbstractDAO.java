package com.school.dao;

import java.util.List;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.school.vo.ValueObject;

public interface AbstractDAO {
	public List<String> getListOfCollections();

	public void createCollection(String collectionName);

	long insertManyDocuments(String collectionName, List<? extends ValueObject> list);

	FindIterable<Document> getCollection(String collectionName);
}
