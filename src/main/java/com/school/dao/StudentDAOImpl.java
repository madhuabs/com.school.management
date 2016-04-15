package com.school.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Projections;
import com.school.vo.Student;

@Component
public class StudentDAOImpl extends AbstractDAOImpl implements StudentDAO {
	private static final String ROLL_NUM_PREFIX = "KC";
	Logger logger = LoggerFactory.getLogger(StudentDAOImpl.class);

	@Override
	public long enrollStudent(Student student) {
		List<Student> list = new ArrayList<Student>();
		// FIXME Find last record and find the Roll Number
		String studentRollNum = null;
		/*
		 * Create Spring configurations for Roll Number and export as
		 * properties file
		 */
		long rollNum = 150000;
		if (studentRollNum != null) {
			rollNum = new Integer(studentRollNum.substring(2, studentRollNum.length()));
			rollNum++;
		}
		/*
		 * Create Spring configurations for Roll Number Prefix and export as
		 * properties file
		 */
		student.setStudentRollNumber(ROLL_NUM_PREFIX + rollNum);
		list.add(student);
		return insertManyDocuments("student", list);
	}

	@Override
	public List<Student> fetchStudent(String studentRollNumber, String studentName, String program, Date dateStart,
			Date dateEnd) {
		Map<String, Object> searchCriteria = new HashMap<String, Object>();
		if (studentRollNumber != null) {
			searchCriteria.put("studentRollNumber", studentRollNumber);
		}
		if (studentName != null) {
			searchCriteria.put("studentName", studentName);
		}
		if (program != null) {
			searchCriteria.put("program", program);
		}
		if (dateStart != null) {
			searchCriteria.put("creationDate", dateStart);
		}
		if (dateEnd != null) {
			searchCriteria.put("updatedDate", dateEnd);
		}
		Document document = new Document(searchCriteria);
		List<Student> result = new ArrayList<Student>();
		FindIterable<Document> facilityIdCollection = database.getCollection("student").find(document);
		facilityIdCollection.projection(Projections.excludeId());
		MongoCursor<Document> studentDetails = facilityIdCollection.iterator();
		while (studentDetails.hasNext()) {
			try {
				Student student = mapper.readValue(studentDetails.next().toJson(), Student.class);
				result.add(student);
			} catch (JsonParseException e) {
				logger.error("JSON Parse Exception::while Loading Student Details" + e);
			} catch (JsonMappingException e) {
				logger.error("JSON Mapping Exception::while Loading Student Details" + e);
			} catch (IOException e) {
				logger.error("IO Exception::while Loading Student Details" + e);
			}
		}
		return result;
	}
}
