package exceptions;

public class UnderflowException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UnderflowException(String msg) {
		super(msg);
	}
}
