package com.school.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

@Component
public class MongoDBConnection {
	private static MongoDatabase mongoDatabase = null;
	Logger logger = LoggerFactory.getLogger(MongoDBConnection.class);

	@PostConstruct
	public void init() {
		Properties prop = new Properties();
		InputStream in = getClass().getResourceAsStream("mongDB.properties");
		try {
			prop.load(in);
		} catch (IOException e) {
			logger.error("Error While loading Propertis File.");
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				logger.error("Error While closing Propertis input Stream.");
			}
		}
		mongoDatabase = new MongoClient(prop.getProperty("server"), Integer.valueOf(prop.getProperty("port")))
				.getDatabase(prop.getProperty("database"));
	}

	public MongoDatabase getMongoDatabase() {
		return mongoDatabase;
	}

}
