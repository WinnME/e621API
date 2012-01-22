package de.furryhome.e621api.Exceptions;

public class e621apiObjectException extends Exception {
	private static final long serialVersionUID = 6356853706129395330L;
	String error;

	public e621apiObjectException() {super(); error = "unknown";}
	public e621apiObjectException(String err) {super(err); error = err;}
	  
	public String getError() {return error;}
}

  