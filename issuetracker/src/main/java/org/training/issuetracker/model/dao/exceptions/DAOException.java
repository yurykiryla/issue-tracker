/**
 * 
 */
package org.training.issuetracker.model.dao.exceptions;

/**
 * @author Yury Kiryla
 *
 */
public class DAOException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7956193327329329367L;

	/**
	 * 
	 */
	public DAOException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public DAOException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public DAOException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public DAOException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public DAOException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
