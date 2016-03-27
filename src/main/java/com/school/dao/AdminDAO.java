package com.school.dao;

import java.util.List;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.school.vo.User;
import com.school.vo.ValueObject;

public interface AdminDAO {
	public User fetchUser(User user);

	public long passwordReset(User user);

	long deleteUser(User user);

	public List<String> getListOfCollections();

	public void createCollection(String collectionName);

	long insertManyDocuments(String collectionName, List<? extends ValueObject> list);

	FindIterable<Document> getCollection(String collectionName);

}