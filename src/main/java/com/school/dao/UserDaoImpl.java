package com.school.dao;

import java.io.IOException;

import org.bson.Document;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Projections;
import com.school.vo.User;

@Component
public class UserDaoImpl extends AbstractDAOImpl implements UserDao {
	@Override
	public User fetchUser(User user) {

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

}
