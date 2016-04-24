package com.school.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProgramFee extends ValueObject {
	/* Registration Fee */
	private double regFee;
	/* Admission Fee/ Annual Fee */
	private double amf;
	/* Kit Fee(Bag, Dress,) */
	private double kitFee;
	private double tutionFee;
	/* Transport Fee */
	private double tranFee;

	private double installementOne;
	private double installementTwo;
	private double installementThree;
	private String studentId;
	private String studentName;
	private String program;
	/* Academic Year */
	private String academicYear;
	/**
	 * @return the regFee
	 */
	public double getRegFee() {
		return regFee;
	}
	/**
	 * @return the amf
	 */
	public double getAmf() {
		return amf;
	}
	/**
	 * @return the kitFee
	 */
	public double getKitFee() {
		return kitFee;
	}
	/**
	 * @return the tutionFee
	 */
	public double getTutionFee() {
		return tutionFee;
	}
	/**
	 * @return the tranFee
	 */
	public double getTranFee() {
		return tranFee;
	}
	/**
	 * @return the installementOne
	 */
	public double getInstallementOne() {
		return installementOne;
	}
	/**
	 * @return the installementTwo
	 */
	public double getInstallementTwo() {
		return installementTwo;
	}
	/**
	 * @return the installementThree
	 */
	public double getInstallementThree() {
		return installementThree;
	}
	/**
	 * @return the studentId
	 */
	public String getStudentId() {
		return studentId;
	}
	/**
	 * @return the studentName
	 */
	public String getStudentName() {
		return studentName;
	}
	/**
	 * @return the program
	 */
	public String getProgram() {
		return program;
	}
	/**
	 * @return the academicYear
	 */
	public String getAcademicYear() {
		return academicYear;
	}
	/**
	 * @param regFee the regFee to set
	 */
	public void setRegFee(double regFee) {
		this.regFee = regFee;
	}
	/**
	 * @param amf the amf to set
	 */
	public void setAmf(double amf) {
		this.amf = amf;
	}
	/**
	 * @param kitFee the kitFee to set
	 */
	public void setKitFee(double kitFee) {
		this.kitFee = kitFee;
	}
	/**
	 * @param tutionFee the tutionFee to set
	 */
	public void setTutionFee(double tutionFee) {
		this.tutionFee = tutionFee;
	}
	/**
	 * @param tranFee the tranFee to set
	 */
	public void setTranFee(double tranFee) {
		this.tranFee = tranFee;
	}
	/**
	 * @param installementOne the installementOne to set
	 */
	public void setInstallementOne(double installementOne) {
		this.installementOne = installementOne;
	}
	/**
	 * @param installementTwo the installementTwo to set
	 */
	public void setInstallementTwo(double installementTwo) {
		this.installementTwo = installementTwo;
	}
	/**
	 * @param installementThree the installementThree to set
	 */
	public void setInstallementThree(double installementThree) {
		this.installementThree = installementThree;
	}
	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	/**
	 * @param studentName the studentName to set
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	/**
	 * @param program the program to set
	 */
	public void setProgram(String program) {
		this.program = program;
	}
	/**
	 * @param academicYear the academicYear to set
	 */
	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
	}
}
