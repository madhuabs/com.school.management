package com.school.dao;

import java.io.IOException;

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
import com.mongodb.client.result.UpdateResult;
import com.school.util.MongoDBConnection;
import com.school.vo.User;

@Component
public class AdminDAOImpl implements AdminDAO {
	@Autowired
	private MongoDBConnection mongoDBConnection;
	ObjectMapper mapper = new ObjectMapper();

	@Override
	public User fetchUser(User user) {
		User result = null;
		MongoDatabase database = mongoDBConnection.getMongoDatabase();
		FindIterable<Document> resultSet = database.getCollection("userCredentials")
				.find(new Document("userName", user.getUserName()));
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
		UpdateResult updateResult = database.getCollection("userCredentials").updateOne(
				new Document("userName", user.getUserName()),
				new Document("$set", new Document("password", user.getPassword())));
		return updateResult.getModifiedCount();
	}

	@Override
	public long deleteUser(User user) {
		MongoDatabase database = mongoDBConnection.getMongoDatabase();
		UpdateResult updateResult = database.getCollection("userCredentials").updateOne(
				new Document("userName", user.getUserName()), new Document("$set", new Document("active", "false")));
		return updateResult.getModifiedCount();
	}

	@Override
	public long createUser(User user) {
		long success = 0;
		try {
			MongoDatabase database = mongoDBConnection.getMongoDatabase();
			database.getCollection("userCredentials").insertOne(Document.parse(mapper.writeValueAsString(user)));
			success = 1;
		} catch (RuntimeException exception) {
			success = -1;
		} catch (JsonProcessingException e) {
			success = -1;
		}
		return success;
	}

	public MongoDBConnection getMongoDBConnection() {
		return mongoDBConnection;
	}

	public void setMongoDBConnection(MongoDBConnection mongoDBConnection) {
		this.mongoDBConnection = mongoDBConnection;
	}
}
