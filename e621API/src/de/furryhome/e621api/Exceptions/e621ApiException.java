package de.furryhome.e621api.Exceptions;

/**
 * A simple class to handle exceptions of the general API.
 *
 * @author Jens Eichler
 * @version 1.0
 */

public class e621ApiException extends Exception {
	private static final long serialVersionUID = 6356853706129395330L;
	String error;

	public e621ApiException() {super(); error = "unknown";}
	public e621ApiException(String err) {super(err); error = err;}
	  
	public String getError() {return error;}
}

  