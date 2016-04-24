package com.school.vo;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Student extends ValueObject {
	public Student() {

	}

	private String studentRollNumber;
	private String firstName;
	private String lastName;
	private String middleName;
	private String fatherName;
	private String motherName;
	private long fatherPhoneNumber;
	private long motherPhoneNumber;
	private long homeLandline;
	private long officeLandLine;
	private long emergencyContact;
	private String emergencyContactName;
	private String program;
	private boolean dayCare;
	private String accademicYear;
	private String gender;
	private boolean transport;
	private boolean food;
	private String fatherOccupation;
	private String motherOccupation;
	private LocalDate doj;
	private LocalDate dob;
	private List<Address> addressList;
	private String studentName;

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public long getFatherPhoneNumber() {
		return fatherPhoneNumber;
	}

	public long getMotherPhoneNumber() {
		return motherPhoneNumber;
	}

	public long getHomeLandline() {
		return homeLandline;
	}

	public long getOfficeLandLine() {
		return officeLandLine;
	}

	public long getEmergencyContact() {
		return emergencyContact;
	}

	public String getEmergencyContactName() {
		return emergencyContactName;
	}

	public String getProgram() {
		return program;
	}

	public boolean isDayCare() {
		return dayCare;
	}

	public String getAccademicYear() {
		return accademicYear;
	}

	public String getGender() {
		return gender;
	}

	public boolean isTransport() {
		return transport;
	}

	public boolean isFood() {
		return food;
	}

	public String getFatherOccupation() {
		return fatherOccupation;
	}

	public String getMotherOccupation() {
		return motherOccupation;
	}

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public void setFatherPhoneNumber(long fatherPhoneNumber) {
		this.fatherPhoneNumber = fatherPhoneNumber;
	}

	public LocalDate getDoj() {
		return doj;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}

		public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public void setMotherPhoneNumber(long motherPhoneNumber) {
		this.motherPhoneNumber = motherPhoneNumber;
	}

	public void setHomeLandline(long homeLandline) {
		this.homeLandline = homeLandline;
	}

	public void setOfficeLandLine(long officeLandLine) {
		this.officeLandLine = officeLandLine;
	}

	public void setEmergencyContact(long emergencyContact) {
		this.emergencyContact = emergencyContact;
	}

	public void setEmergencyContactName(String emergencyContactName) {
		this.emergencyContactName = emergencyContactName;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public void setDayCare(boolean dayCare) {
		this.dayCare = dayCare;
	}

	public void setAccademicYear(String accademicYear) {
		this.accademicYear = accademicYear;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setTransport(boolean transport) {
		this.transport = transport;
	}

	public void setFood(boolean food) {
		this.food = food;
	}

	public void setFatherOccupation(String fatherOccupation) {
		this.fatherOccupation = fatherOccupation;
	}

	public void setMotherOccupation(String motherOccupation) {
		this.motherOccupation = motherOccupation;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

	/**
	 * @return the studentRollNumber
	 */
	public String getStudentRollNumber() {
		return studentRollNumber;
	}

	/**
	 * @param studentRollNumber
	 *            the studentRollNumber to set
	 */
	public void setStudentRollNumber(String studentRollNumber) {
		this.studentRollNumber = studentRollNumber;
	}

	/**
	 * @return the studentName
	 */
	public String getStudentName() {
		return new StringBuilder(firstName).append(" ").append(middleName).append(" ").append(lastName).toString();
	}

	/**
	 * @param studentName
	 *            the studentName to set
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
}
