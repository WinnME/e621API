package de.furryhome.e621api;

/**
 * The class  {@code ApiMain} serves as superclass for all other API relevant functional classes.
 *
 * @author	Jens Eichler
 * @see		de.furryhome.e621api
 * @version	1.0
 */

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class ApiMain {
	
    /**
     * A static field, initialized with an empty string, to hold the e621.net account username.
     *
     * @since	1.0
     */
	private static String Username = "";
	
    /**
     * A static field, initialized with an empty string, to hold the e621.net account password hash.
     *
     * @since	1.0
     */
	private static String PasswordHash = "";
	
    /**
     * A static field, initialized with {@code false}, to hold the information<br>
     * if all needed credentials to log into an e621.net account were set.
     *
     * @since	1.0
     */
	private static boolean isLoginCredentialsSet = false;
	
    /**
     * A public method to retrieve the status if account-credentials were set.
     *
     * @return	the casual statement if credentials were set by {@link #setLoginCredentials}
     *
     * @since	1.0
     */
	public static final boolean isLoginCredentialsSet() {
		return isLoginCredentialsSet;
	}
	
    /**
     * A protected method to retrieve the <u>(SHA1 hashed)</u> e621.net account password.
     *
     * @return	The SHA1 password-hash from the set of credentials,<br>
     *			or an empty string if no credentials being set.
     * 
     * @since	1.0
     */
	protected static final String getPasswordHash() {
		return PasswordHash;
	}
	
    /**
     * A protected method to retrieve the e621.net account username.
     *
     * @return	The username from the set of credentials,<br>
     *			or an empty string if no credentials being set.
     * 
     * @since	1.0
     */
	protected static final String getUsername() {
		return Username;
	}
	
    /**
     * A private method to set the string value to the field {@link #PasswordHash}
     *
     *
     * @param	PasswordHash				A string consisting of the e621.net account password <u>(hashed to SHA1)</u>.
     * 
     * @throws	IllegalArgumentException	Is thrown when an empty string is being supplied.
     *
     * @since	1.0
     */
	private static final void setPasswordHash(String PasswordHash) throws IllegalArgumentException {
		if (PasswordHash.length() == 0) { throw new IllegalArgumentException("empty password is not valid"); }
		ApiMain.PasswordHash = PasswordHash;
	}
	
    /**
     * A private method to set the string value to the field {@link #Username}
     *
     *
     * @param	Username					A string consisting of the e621.net account username.
     * 
     * @throws	IllegalArgumentException	Is thrown when an empty string is being supplied.
     *
     * @since	1.0
     */
	private static final void setUsername(String Username) throws IllegalArgumentException {
		if (Username.length() == 0) { throw new IllegalArgumentException("empty username is not valid"); }
		ApiMain.Username = Username;
	}
	
    /**
     * A private method to set the boolean value to the field {@link #isLoginCredentialsSet},<br>
     * if the full set of credentials are being<br>
     * set by {@link #setLoginCredentials(String, String)}.
     *
     *
     * @param	isSet	A boolean value, telling if the complete credentials were set.
     *
     * @since	1.0
     */
	private static final void setLoginCredentialsSet(Boolean isSet) {
		isLoginCredentialsSet = isSet;
	}
	
    /**
     * The public method allows all subclasses to set e621.net login-credentials to be used by further API functions.<br>
     * It throws exceptions accordingly if anything goes wrong,<br>
     * and sets {@link #isLoginCredentialsSet} to {@code true} at the end to ensure<br>
     * setting of the fields {@link #Username} and {@link #PasswordHash} was successful.
     *
     *
     * @param	Username					A String consisting of the e621.net account username.
     * @param	Password					A String consisting of the e621.net <u>cleartext</u> account password. 
     *
     * @throws	IllegalArgumentException	Is thrown when either a blank username or password is being supplied.
     *
     * @since	1.0
     */
	public final void setLoginCredentials(String Username, String Password) throws IllegalArgumentException {
		if (Username.length() == 0) { throw new IllegalArgumentException("empty username is not valid"); }
		if (Password.length() == 0) { throw new IllegalArgumentException("empty password is not valid"); }
		setUsername(Username);
		setPasswordHash(this.HashSHA1(Password));
		setLoginCredentialsSet(true);
	}

    /**
     * A method to hash the supplied String using SHA1 digest.<br>
     * If an empty string is supplied, the method returns prematurely an empty string, skipping all logic.
     * Theoretically an empty string will be returned if SHA-1 digest is not available to the system!
     * This should be pure theory because every system has that, thus i saved on additional exception handling.
     * 
     * 
     * @param	InputString					Any String to be hashed
     *
     * @return	The SHA1 hashed inputString or an empty string, if the provided input was also empty.
     * 
     * @since	1.0
     */
	protected final String HashSHA1(String InputString) {
		if (InputString.length() == 0) {
			return "";
		}
        MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-1");
			md.update(InputString.getBytes());
	        byte byteData[] = md.digest();
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < byteData.length; i++) {
	        	sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
	        }
	        return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			return "";
		} //SHA-1 should be available on all JRE's
    }
}
