package com.school.util;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

@Component
public class MongoDBConnection {
	private static MongoDatabase mongoDatabase = null;

	@SuppressWarnings("resource")
	@PostConstruct
	private static void init() {
		// FIXME: Add properties file to load mongo db details with credentials

		mongoDatabase = new MongoClient("localhost", 27017).getDatabase("schooldb");
	}

	public static MongoDatabase getMongoDatabase() {
		return mongoDatabase;
	}

}
