package com.school.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.school.util.MongoDBConnection;
import com.school.vo.ValueObject;

public abstract class AbstractDAOImpl implements AbstractDAO {
	@Autowired
	protected MongoDBConnection mongoDBConnection;

	protected ObjectMapper mapper = new ObjectMapper();
	protected MongoDatabase database = null;

	@PostConstruct
	public void postConstruct() {
		database = mongoDBConnection.getMongoDatabase();
	}

	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm a z");
		mapper.setDateFormat(dateFormat);
	}

	public List<String> getListOfCollections() {
		MongoDatabase database = mongoDBConnection.getMongoDatabase();
		MongoIterable<String> collections = database.listCollectionNames();
		List<String> dbCollections = new ArrayList<String>();
		if (collections != null) {
			for (String col : collections) {
				dbCollections.add(col);
			}
		}
		return dbCollections;
	}

	@Override
	public long insertManyDocuments(String collectionName, List<? extends ValueObject> list) {
		MongoDatabase database = mongoDBConnection.getMongoDatabase();
		long parseResult = 0;
		List<Document> insertUserList = new ArrayList<Document>();
		for (ValueObject valueObject : list) {
			try {
				insertUserList.add(Document.parse(mapper.writeValueAsString(valueObject)));
				parseResult = 1;
			} catch (JsonProcessingException e) {
				parseResult = -1;
			}
		}
		long result = 0;
		if (parseResult > 0) {
			try {
				database.getCollection(collectionName).insertMany(insertUserList);
				result = 1;
			} catch (RuntimeException exception) {
				result = -1;
				// FIXME: Rollback Transactions on failure.
			}
		}
		return result;
	}

	public FindIterable<Document> getCollection(String collectionName) {
		MongoDatabase database = mongoDBConnection.getMongoDatabase();
		return database.getCollection(collectionName).find();
	}

	@Override
	public void createCollection(String collectionName) {
		MongoDatabase database = mongoDBConnection.getMongoDatabase();
		database.createCollection(collectionName);

	}

	public MongoDBConnection getMongoDBConnection() {
		return mongoDBConnection;
	}

	public void setMongoDBConnection(MongoDBConnection mongoDBConnection) {
		this.mongoDBConnection = mongoDBConnection;
	}
}