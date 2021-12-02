package ds_labs;

public interface Map {
	public int size();
	public boolean isEmpty();
	public Object get(Object k);
	public Object put(Object k, Object o);
	public Object remove(Object k);
	public Position find(Object k);
	
}
