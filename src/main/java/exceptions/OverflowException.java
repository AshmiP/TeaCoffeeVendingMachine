package exceptions;

public class OverflowException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public OverflowException(String msg) {
		super(msg);
	}
}
