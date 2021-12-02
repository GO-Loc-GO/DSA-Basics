package ds_labs;

public class Huffman {
	
	private static DLListMap distinctCharacters(String text) {
		DLListMap map = new DLListMap();
		char[] t = text.toCharArray();
		for(int i = 0;i<text.length();i++) {
			if(map.find(t[i])==null) {
				map.put(t[i], 1);
			}else {
				map.put(t[i], ((int) map.get(t[i]))+1);
			}
		}
		
		return map;
	}
	
	private static Node HuffmanEncoding(String text){
		DLListMap map = distinctCharacters(text);
		PriorityQueue Q = new PriorityQueue();
		Position p = map.list.first();
		while(p!=null) {
			
		}
		return null;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
