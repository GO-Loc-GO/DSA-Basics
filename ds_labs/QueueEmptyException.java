package ds_labs;

public class QueueEmptyException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public QueueEmptyException() {
		super("The queue is empty");
	}
}
