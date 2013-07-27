package dm.colorboard.component;

public class FormatException extends Exception {
	private static final long serialVersionUID = -4852675731773446455L;
	
	public FormatException() { super(); }
	public FormatException(String message) { super(message); }
	public FormatException(String message, Throwable cause) { super(message, cause); }
	public FormatException(Throwable cause) { super(cause); }
}