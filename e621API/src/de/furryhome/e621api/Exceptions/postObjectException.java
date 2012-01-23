package de.furryhome.e621api.Exceptions;

/**
 * A simple exception class to handle exceptions around the objects of a post / item from e621.
 *
 * @author Jens Eichler
 * @version 1.0
 */

public class postObjectException extends Exception {
	private static final long serialVersionUID = -7533337827331833701L;
	String error;

	public postObjectException() {super(); error = "unknown";}
	public postObjectException(String err) {super(err); error = err;}
	  
	public String getError() {return error;}
}

  