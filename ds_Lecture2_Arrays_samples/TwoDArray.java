package ds_Lecture2_Arrays_samples;

public class TwoDArray {

	public static void main(String[] args) {
		String array= "";
		int values[][] = new int[][]{{1,2,3},{4,5,6}};
		for(int i=0;i<values.length;i++) {
			for(int j=0;j<values[i].length;j++) {
				array = array + Integer.toString(values[i][j]); 
			}
			array = array + "\n";
		}
		System.out.println(array);
	}

}
