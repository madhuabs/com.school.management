package com.school.dao;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Projections;
import com.mongodb.client.result.UpdateResult;
import com.school.util.MongoDBConnection;
import com.school.vo.User;
import com.school.vo.ValueObject;

@Component
public class AdminDAOImpl implements AdminDAO {
	@Autowired
	private MongoDBConnection mongoDBConnection;
	ObjectMapper mapper = new ObjectMapper();

	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm a z");
		mapper.setDateFormat(dateFormat);
	}

	@Override
	public User fetchUser(User user) {

		MongoDatabase database = mongoDBConnection.getMongoDatabase();
		User result = null;
		FindIterable<Document> resultSet = database.getCollection("userCredentials")
				.find(new Document("userName", user.getUserName()));
		resultSet.projection(Projections.excludeId());
		MongoCursor<Document> iterator = resultSet.iterator();
		if (resultSet != null && iterator.hasNext()) {
			try {
				result = mapper.readValue(iterator.next().toJson(), User.class);
			} catch (JsonParseException e) {
				result = null;
			} catch (JsonMappingException e) {
				result = null;
			} catch (IOException e) {
				result = null;
			}
		}
		return result;
	}

	@Override
	public long passwordReset(User user) {
		MongoDatabase database = mongoDBConnection.getMongoDatabase();
		Document updateFiledsMap = new Document();
		updateFiledsMap.put("password", user.getPassword());
		updateFiledsMap.put("updatedDate", new Date());
		UpdateResult updateResult = database.getCollection("userCredentials")
				.updateOne(new Document("userName", user.getUserName()), new Document("$set", updateFiledsMap));
		return updateResult.getModifiedCount();
	}

	@Override
	public long deleteUser(User user) {
		MongoDatabase database = mongoDBConnection.getMongoDatabase();
		UpdateResult updateResult = database.getCollection("userCredentials").updateOne(
				new Document("userName", user.getUserName()), new Document("$set", new Document("active", "false")));
		return updateResult.getModifiedCount();
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
		long result = 0;
		List<Document> insertUserList = new ArrayList<Document>();
		for (ValueObject valueObject : list) {
			try {
				insertUserList.add(Document.parse(mapper.writeValueAsString(valueObject)));
			} catch (JsonProcessingException e) {
				result = -1;
			}
		}
		if (result == 0) {
			try {
				database.getCollection(collectionName).insertMany(insertUserList);
				result = 0;
			} catch (RuntimeException exception) {
				result = -1;
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
