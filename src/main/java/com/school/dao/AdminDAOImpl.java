package com.school.dao;

import java.util.Date;

import org.bson.Document;
import org.springframework.stereotype.Component;

import com.mongodb.client.result.UpdateResult;
import com.school.vo.User;

@Component
public class AdminDAOImpl extends AbstractDAOImpl implements AdminDAO {
	AdminDAOImpl() {

	}

	@Override
	public long passwordReset(User user) {
		Document updateFiledsMap = new Document();
		updateFiledsMap.put("password", user.getPassword());
		updateFiledsMap.put("updatedDate", new Date());
		UpdateResult updateResult = database.getCollection("userCredentials")
				.updateOne(new Document("userName", user.getUserName()), new Document("$set", updateFiledsMap));
		return updateResult.getModifiedCount();
	}

	@Override
	public long deleteUser(User user) {
		UpdateResult updateResult = database.getCollection("userCredentials").updateOne(
				new Document("userName", user.getUserName()), new Document("$set", new Document("active", "false")));
		return updateResult.getModifiedCount();
	}

}
