package ds_labs;

public class EmptyDequeException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmptyDequeException() {
		super("The deque is empty");
	}
}
