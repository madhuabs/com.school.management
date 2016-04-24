package com.school.service;

import com.school.vo.DayCareFee;
import com.school.vo.FeeDetails;
import com.school.vo.FeeStructure;
import com.school.vo.FoodFee;
import com.school.vo.Payment;
import com.school.vo.ProgramFee;
import com.school.vo.Status;
import com.school.vo.TransportFee;

public class paymentServiceImpl implements paymentService {
	/**
	 * This method calculates fee details based on Fee Structure of Program.
	 * 
	 * @return
	 */
	public FeeDetails getFeeDetails(String studentId, String program, String academicYear) {
		return null;
	}

	/**
	 * This method fetches Fee Structure of Program.
	 * 
	 * @return
	 */
	public FeeStructure getFeeStruture(String program, String academicYear) {
		return null;
	}

	/**
	 * This method calculates fee details based on Fee Structure of Program.
	 * 
	 * @return
	 */
	public Status saveFeeDetails(FeeDetails feeDetails) {
		return null;
	}

	public Status saveProgramFee(ProgramFee fee) {
		return null;
	}

	public Status saveDayCareFee(DayCareFee fee) {
		return null;
	}

	public Status saveTransportFee(TransportFee fee) {
		return null;
	}

	public Status saveFoodFee(FoodFee fee) {
		return null;
	}

	public Payment getUpcomingPayments(String program, String academicYear) {
		return null;
	}

	public Payment getPendingPayments(String program, String academicYear) {
		return null;
	}
}
