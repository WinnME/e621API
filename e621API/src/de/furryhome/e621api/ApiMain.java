package de.furryhome.e621api;

/**
 * The superclass for all other API relevant functions.
 *
 * @author Jens Eichler
 * @version 1.0
 */

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import de.furryhome.e621api.Exceptions.e621ApiException;

class ApiMain {
	private static String Username = "";
	private static String PasswordHash = "";
	private static boolean isLoginCredentialsSet = false;
	
	/*
	 * Getter
	 */
	public static final boolean isLoginCredentialsSet() { return isLoginCredentialsSet; }
	protected static final String getPasswordHash() { return PasswordHash; }
	protected static final String getUsername() { return Username; }
	
	/*
	 * Setter
	 */
	private static final void setPasswordHash(String passwordHash) { PasswordHash = passwordHash; }
	private static final void setUsername(String username) { Username = username; }
	private static final void setLoginCredentialsSet(Boolean Value) { isLoginCredentialsSet = Value; }
	
	public final void setLogincredentials(String Username, String Password) throws e621ApiException {
		if (Username.length() == 0 || Password.length() == 0) { throw new e621ApiException("Username or password may not be empty."); }
		setLoginCredentialsSet(true);
		setUsername(Username);
		setPasswordHash(this.HashPassword(Password));
	}

	/*
	 * Helferfunktionen
	 */
	private final String HashPassword(String Password) {
        MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException e) {
			System.err.println("ERROR: Alghorithm SHA-1 not found!");
			setLoginCredentialsSet(false);
			return "";
		}
        md.update(Password.getBytes());
        byte byteData[] = md.digest();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
}
