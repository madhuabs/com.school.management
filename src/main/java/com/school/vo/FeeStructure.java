package com.school.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FeeStructure extends ValueObject {
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
	private String program;
	/* Academic Year */
	private String academicYear;
	private Date academicYearStart;
	private Date academicYearEnd;
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
	 * @return the academicYearStart
	 */
	public Date getAcademicYearStart() {
		return academicYearStart;
	}
	/**
	 * @return the academicYearEnd
	 */
	public Date getAcademicYearEnd() {
		return academicYearEnd;
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
	 * @param misc the misc to set
	 */
	public void setMisc(double misc) {
		this.misc = misc;
	}
	/**
	 * @param dayCareFee the dayCareFee to set
	 */
	public void setDayCareFee(double dayCareFee) {
		this.dayCareFee = dayCareFee;
	}
	/**
	 * @param foodFee the foodFee to set
	 */
	public void setFoodFee(double foodFee) {
		this.foodFee = foodFee;
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
	/**
	 * @param academicYearStart the academicYearStart to set
	 */
	public void setAcademicYearStart(Date academicYearStart) {
		this.academicYearStart = academicYearStart;
	}
	/**
	 * @param academicYearEnd the academicYearEnd to set
	 */
	public void setAcademicYearEnd(Date academicYearEnd) {
		this.academicYearEnd = academicYearEnd;
	}
}
