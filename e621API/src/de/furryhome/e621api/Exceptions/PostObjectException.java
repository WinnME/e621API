package de.furryhome.e621api.Exceptions;

/**
 * The class {@code PostObjectException} is a subclass from {@code Exception}.
 * It indicates Exceptions caused by content abbreviated objects like {@code ListItem}!
 * Further to the common exception class, it saves the initialized data into fields for future use!
 *
 * @author	Jens Eichler
 * @see		de.furryhome.e621api.Exceptions
 * @version	1.0
 */

public final class PostObjectException extends Exception {
	private static final long serialVersionUID = 6356853706129395330L;
	@SuppressWarnings("unused")
	private String message;
	@SuppressWarnings("unused")
	private Throwable cause;
	@SuppressWarnings("unused")
	private boolean enableSuppression, writableStackTrace;

    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param   message   the detail message. The detail message is saved for
     *          later retrieval by the {@link #getMessage()} method.
     * @since  1.0
     */
	public PostObjectException(String message) {
		super(message);
		this.message = message;
	}
	
    /**
     * Constructs a new exception with the specified cause and a detail
     * message of <tt>(cause==null ? null : cause.toString())</tt> (which
     * typically contains the class and detail message of <tt>cause</tt>).
     * This constructor is useful for exceptions that are little more than
     * wrappers for other throwables (for example, {@link
     * java.security.PrivilegedActionException}).
     *
     * @param  cause the cause (which is saved for later retrieval by the
     *         {@link #getCause()} method).  (A <tt>null</tt> value is
     *         permitted, and indicates that the cause is nonexistent or
     *         unknown.)
     * @since  1.0
     */
	public PostObjectException(Throwable cause) {
		super(cause);
		this.cause = cause;
	}
	
    /**
     * Constructs a new exception with the specified detail message and
     * cause.  <p>Note that the detail message associated with
     * {@code cause} is <i>not</i> automatically incorporated in
     * this exception's detail message.
     *
     * @param  message the detail message (which is saved for later retrieval
     *         by the {@link #getMessage()} method).
     * @param  cause the cause (which is saved for later retrieval by the
     *         {@link #getCause()} method).  (A <tt>null</tt> value is
     *         permitted, and indicates that the cause is nonexistent or
     *         unknown.)
     * @since  1.0
     */
	public PostObjectException(String message, Throwable cause) {
		super(message, cause);
		this.message = message;
		this.cause = cause;
	}
	
    /**
     * Constructs a new exception with the specified detail message,
     * cause, suppression enabled or disabled, and writable stack
     * trace enabled or disabled.
     *
     * @param  message the detail message.
     * @param cause the cause.  (A {@code null} value is permitted,
     * and indicates that the cause is nonexistent or unknown.)
     * @param enableSuppression whether or not suppression is enabled
     *                          or disabled
     * @param writableStackTrace whether or not the stack trace should
     *                           be writable
     * @since  1.0
     */
    protected PostObjectException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    	super(message, cause, enableSuppression, writableStackTrace);
    	this.message = message;
		this.cause = cause;
		this.enableSuppression = enableSuppression;
		this.writableStackTrace = writableStackTrace;
    }
}

  