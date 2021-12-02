package ds_labs;

public class ListMap implements Map {
	private LinkedList list = new LinkedList();
	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.size()==0;
	}

	@Override
	public Object get(Object k) {
		Position p = find(k);
		if(p==null) {
			return null;
		}
		return ((Entry)p.element()).value();
	}

	@Override
	public Object put(Object k, Object o) {
		Position p = find(k);
		if(p==null) {
			Entry e = new Entry(k,o);
			list.insertLast(e);
			return null;
		}else {
			Entry e = new Entry(k,o);
			list.insertAfter(p, e);
			list.remove(p);
			return ((Entry)p.element()).value();
		}
	}

	@Override
	public Object remove(Object k) {
		Position p=find(k);
		if(p==null) {
			return null;
		}else {
			list.remove(p);
		}
		return ((Entry)p.element()).value();
	}

	@Override
	public Position find(Object k) {
		Position p = list.first();
		Position last = list.last();
		while(p != last) {
			if(((Entry)p.element()).key() == k) {
				return p;
			}else {
				p=list.after(p);
			}
		}
		if(!list.isEmpty() && ((Entry)p.element()).key() == k) {
			return p;
		}else {
			return null;
		}
	}


}
