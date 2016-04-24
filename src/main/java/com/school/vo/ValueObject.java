package com.school.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * This class represents in Java collections with wild card operators.
 * Serilizable all subclasses.
 * 
 * @author Madhu
 *
 */
public class ValueObject implements Serializable {
	protected Date creationDate;
	protected Date updatedDate;

	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @return the updatedDate
	 */
	public Date getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * @param creationDate
	 *            the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @param updatedDate
	 *            the updatedDate to set
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
}
