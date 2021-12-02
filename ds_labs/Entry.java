package ds_labs;

public class Entry {
	private Object key;
	private Object value;
	public Entry(Object k, Object v) {
		key = k;
		value = v;
	} 
	public Object key() {
		return key;
	}
	public Object value() {
		return value;
	}
}
