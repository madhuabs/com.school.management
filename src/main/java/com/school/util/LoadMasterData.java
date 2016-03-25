package com.school.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.bson.Document;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.school.vo.Facilities;
import com.school.vo.Program;
import com.school.vo.UserRoles;

public class LoadMasterData {
	public static Map<Integer, String> rolesMap = new HashMap<Integer, String>();
	public static Map<Integer, String> programsMap = new HashMap<Integer, String>();
	public static Map<Integer, String> faciliteisMap = new HashMap<Integer, String>();
	static ObjectMapper mapper = new ObjectMapper();

	static {
		// Load User Roles
		MongoDatabase mongoDatabase = MongoDBConnection.getMongoDatabase();
		FindIterable<Document> userRolesCollection = mongoDatabase.getCollection("userRoles").find();
		MongoCursor<Document> userRolesList = userRolesCollection.iterator();
		if (userRolesList.hasNext()) {
			try {
				UserRoles result = mapper.readValue(userRolesList.next().toJson(), UserRoles.class);
				rolesMap.put(result.getRoleId(), result.getRoleName());
			} catch (JsonParseException e) {
			} catch (JsonMappingException e) {
			} catch (IOException e) {
			}
		}
		// Load Programs
		FindIterable<Document> programsCollection = mongoDatabase.getCollection("program").find();
		MongoCursor<Document> programList = programsCollection.iterator();
		if (programList.hasNext()) {
			try {
				Program result = mapper.readValue(programList.next().toJson(), Program.class);
				programsMap.put(result.getProgramId(), result.getProgramName());
			} catch (JsonParseException e) {
			} catch (JsonMappingException e) {
			} catch (IOException e) {
			}
		}
		// Load Programs
		FindIterable<Document> facilityIdCollection = mongoDatabase.getCollection("facilityId").find(Document.class);
		MongoCursor<Document> facilitiesList = facilityIdCollection.iterator();
		if (facilitiesList.hasNext()) {
			try {
				Facilities result = mapper.readValue(programList.next().toJson(), Facilities.class);
				faciliteisMap.put(result.getFacilityId(), result.getFacilityName());
			} catch (JsonParseException e) {
			} catch (JsonMappingException e) {
			} catch (IOException e) {
			}
		}
	}
}
