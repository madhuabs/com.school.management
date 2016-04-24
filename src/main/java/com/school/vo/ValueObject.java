package com.school.vo;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * This class represents in Java collections with wild card operators.
 * Serilizable all subclasses.
 * 
 * @author Madhu
 *
 */
public class ValueObject implements Serializable {
	protected LocalDate creationDate;
	protected LocalDate updatedDate;

	/**
	 * @return the creationDate
	 */
	public LocalDate getCreationDate() {
		return creationDate;
	}

	/**
	 * @return the updatedDate
	 */
	public LocalDate getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * @param creationDate
	 *            the creationDate to set
	 */
	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @param updatedDate
	 *            the updatedDate to set
	 */
	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}
}
