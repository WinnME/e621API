package de.furryhome.e621api.Exceptions;

public class postObjectException extends Exception {
	private static final long serialVersionUID = -7533337827331833701L;
	String error;

	public postObjectException() {super(); error = "unknown";}
	public postObjectException(String err) {super(err); error = err;}
	  
	public String getError() {return error;}
}

  