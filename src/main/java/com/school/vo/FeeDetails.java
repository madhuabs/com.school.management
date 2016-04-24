package com.school.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FeeDetails extends ValueObject {
	/* Registration Fee */
	private double regFee;
	/* Admission Fee/ Annual Fee */
	private double amf;
	/* Kit Fee(Bag, Dress,) */
	private double kitFee;
	private double tutionFee;
	/* Transport Fee */
	private double tranFee;
	private double misc;
	private double dayCareFee;
	private double foodFee;
	/* Registration Fee Discount (d) % */
	private double regFeed;
	/* Admission Fee/ Annual Fee Discount (d) % */
	private double amfd;
	/* Kit Fee(Bag, Dress,) Discount (d) % */
	private double kitFeed;
	private double tutionFeed;
	/* Transport Fee Discount (d)% */
	private double tranFeed;
	private double dayCareFeed;
	private double foodFeed;
	private double installementOne;
	private double installementTwo;
	private double installementThree;
	private Date dayCareDurationStart;
	private Date foodDurationStart;  
	private Date dayCareDurationEnd;
	private Date foodDurationEnd;
	private double totalFee;
	private String program;
	/* Academic Year */
	private String academicYear;
	private String studentId;
	private String studentName;

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
	 * @return the misc
	 */
	public double getMisc() {
		return misc;
	}

	/**
	 * @return the dayCareFee
	 */
	public double getDayCareFee() {
		return dayCareFee;
	}

	/**
	 * @return the foodFee
	 */
	public double getFoodFee() {
		return foodFee;
	}

	/**
	 * @return the regFeed
	 */
	public double getRegFeed() {
		return regFeed;
	}

	/**
	 * @return the amfd
	 */
	public double getAmfd() {
		return amfd;
	}

	/**
	 * @return the kitFeed
	 */
	public double getKitFeed() {
		return kitFeed;
	}

	/**
	 * @return the tutionFeed
	 */
	public double getTutionFeed() {
		return tutionFeed;
	}

	/**
	 * @return the tranFeed
	 */
	public double getTranFeed() {
		return tranFeed;
	}

	/**
	 * @return the dayCareFeed
	 */
	public double getDayCareFeed() {
		return dayCareFeed;
	}

	/**
	 * @return the foodFeed
	 */
	public double getFoodFeed() {
		return foodFeed;
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
	 * @param regFee
	 *            the regFee to set
	 */
	public void setRegFee(double regFee) {
		this.regFee = regFee;
	}

	/**
	 * @param amf
	 *            the amf to set
	 */
	public void setAmf(double amf) {
		this.amf = amf;
	}

	/**
	 * @param kitFee
	 *            the kitFee to set
	 */
	public void setKitFee(double kitFee) {
		this.kitFee = kitFee;
	}

	/**
	 * @param tutionFee
	 *            the tutionFee to set
	 */
	public void setTutionFee(double tutionFee) {
		this.tutionFee = tutionFee;
	}

	/**
	 * @param tranFee
	 *            the tranFee to set
	 */
	public void setTranFee(double tranFee) {
		this.tranFee = tranFee;
	}

	/**
	 * @param misc
	 *            the misc to set
	 */
	public void setMisc(double misc) {
		this.misc = misc;
	}

	/**
	 * @param dayCareFee
	 *            the dayCareFee to set
	 */
	public void setDayCareFee(double dayCareFee) {
		this.dayCareFee = dayCareFee;
	}

	/**
	 * @return the totalFee
	 */
	public double getTotalFee() {
		return totalFee;
	}

	/**
	 * @param totalFee the totalFee to set
	 */
	public void setTotalFee(double totalFee) {
		this.totalFee = totalFee;
	}

	/**
	 * @param foodFee
	 *            the foodFee to set
	 */
	public void setFoodFee(double foodFee) {
		this.foodFee = foodFee;
	}

	/**
	 * @param regFeed
	 *            the regFeed to set
	 */
	public void setRegFeed(double regFeed) {
		this.regFeed = regFeed;
	}

	/**
	 * @param amfd
	 *            the amfd to set
	 */
	public void setAmfd(double amfd) {
		this.amfd = amfd;
	}

	/**
	 * @param kitFeed
	 *            the kitFeed to set
	 */
	public void setKitFeed(double kitFeed) {
		this.kitFeed = kitFeed;
	}

	/**
	 * @param tutionFeed
	 *            the tutionFeed to set
	 */
	public void setTutionFeed(double tutionFeed) {
		this.tutionFeed = tutionFeed;
	}

	/**
	 * @param tranFeed
	 *            the tranFeed to set
	 */
	public void setTranFeed(double tranFeed) {
		this.tranFeed = tranFeed;
	}

	/**
	 * @param dayCareFeed
	 *            the dayCareFeed to set
	 */
	public void setDayCareFeed(double dayCareFeed) {
		this.dayCareFeed = dayCareFeed;
	}

	/**
	 * @param foodFeed
	 *            the foodFeed to set
	 */
	public void setFoodFeed(double foodFeed) {
		this.foodFeed = foodFeed;
	}

	/**
	 * @param installementOne
	 *            the installementOne to set
	 */
	public void setInstallementOne(double installementOne) {
		this.installementOne = installementOne;
	}

	/**
	 * @param installementTwo
	 *            the installementTwo to set
	 */
	public void setInstallementTwo(double installementTwo) {
		this.installementTwo = installementTwo;
	}

	/**
	 * @param installementThree
	 *            the installementThree to set
	 */
	public void setInstallementThree(double installementThree) {
		this.installementThree = installementThree;
	}

	/**
	 * @param program
	 *            the program to set
	 */
	public void setProgram(String program) {
		this.program = program;
	}

	/**
	 * @param academicYear
	 *            the academicYear to set
	 */
	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
	}

	/**
	 * @return the dayCareDurationStart
	 */
	public Date getDayCareDurationStart() {
		return dayCareDurationStart;
	}

	/**
	 * @return the foodDurationStart
	 */
	public Date getFoodDurationStart() {
		return foodDurationStart;
	}

	/**
	 * @return the dayCareDurationEnd
	 */
	public Date getDayCareDurationEnd() {
		return dayCareDurationEnd;
	}

	/**
	 * @return the foodDurationEnd
	 */
	public Date getFoodDurationEnd() {
		return foodDurationEnd;
	}

	/**
	 * @param dayCareDurationStart
	 *            the dayCareDurationStart to set
	 */
	public void setDayCareDurationStart(Date dayCareDurationStart) {
		this.dayCareDurationStart = dayCareDurationStart;
	}

	/**
	 * @param foodDurationStart
	 *            the foodDurationStart to set
	 */
	public void setFoodDurationStart(Date foodDurationStart) {
		this.foodDurationStart = foodDurationStart;
	}

	/**
	 * @param dayCareDurationEnd
	 *            the dayCareDurationEnd to set
	 */
	public void setDayCareDurationEnd(Date dayCareDurationEnd) {
		this.dayCareDurationEnd = dayCareDurationEnd;
	}

	/**
	 * @param foodDurationEnd
	 *            the foodDurationEnd to set
	 */
	public void setFoodDurationEnd(Date foodDurationEnd) {
		this.foodDurationEnd = foodDurationEnd;
	}
}
