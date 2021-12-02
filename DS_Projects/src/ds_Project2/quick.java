package ds_Project2;

public class quick {
	public static void printArray(int[] f) {
		int i;
		System.out.print('[');
		for(i=0;i<f.length;i++) {
			if(i==f.length-1) {
				System.out.print(f[i]);
			}else {
				System.out.print(f[i]);
				System.out.print(',');
				System.out.print(' ');
			}
		}
		System.out.print(']');
	}
	public static void swap1(int f[], int i, int j) {		//to swap the elements in a 1D array
		int temp=f[i];
		f[i]=f[j];
		f[j]=temp;
	}
	public static void quicksort(int[] f, int lo, int hi) {
        if(lo>=hi) {
        	return;
        }
        int head = lo;
        int tail = hi;
        int pivot=f[head];
        while(lo<hi) {
        	while(lo<hi&&f[hi]>=pivot) {
        		hi--;
        	}
        	swap1(f,hi,lo);
        	while(lo<hi&&f[lo]<=pivot) {
        		lo++;
        	}
        	swap1(f,lo,hi);
//        	quicksort(f,head,lo-1);          optional choice mentioned in the configuration report
//        	quicksort(f,lo+1,tail);   
        }
        quicksort(f,head,lo-1);
    	quicksort(f,lo+1,tail);
	}

	public static void main(String[] args) {
		int i;
		int[] a = {31, 33, 27, 15, 42, 11, 40, 5, 19, 21};
		int[][] b = {{98,  34,  100,  36,  44,  64,  3,  99,  59},
				     {20,  88,  55,   91,  14,  58,  25, 29,  44},
				     {66,  62,  4,    65,  49,  71,  71, 24,  12},
				     {14,  3,   58,   23,  12,  66,  11, 45,  36},
				     {55,  64,  35,   24,  85,  73,  33, 85,  46},
				     {94,  76,  23,   36,  57,  26,  8,  92,  17},
				     {85,  68,  52,   34,  53,  93,  4,  37,  34},
				     {70,  9,   15,   42,  31,  16,  72, 61,  62},
				     {11,  38,  34,   21,  81,  9,   45, 68,  11},
				     {20,  83,  27,   6,   69,  26,  5,  31,  8},
				     {74,  97,  11,   60,  1,   68,  14, 27,  46}};
		System.out.print("Test case 1 before sorting: {");
		printArray(a);
		System.out.println("}");
		System.out.print("Test case 2 before sorting: \n{");
			for(i=0;i<b.length;i++) {
				printArray(b[i]);
				if(i!=b.length-1) {
					System.out.print(",\n");
				}else {
					System.out.print('}');
				}
			}
		//for test case 1
		quicksort(a,0,a.length-1);
		System.out.print("\nTest case 1 after quick sort: {");
		printArray(a);
		System.out.println("}");
		
		//for test case 2
		for(i=0;i<b.length;i++) {
			quicksort(b[i],0,b[i].length-1);
		}

		System.out.print("Test case 2 after quick sort: \n{");
		for(i=0;i<b.length;i++) {
			printArray(b[i]);
			if(i!=b.length-1) {
				System.out.print(",\n");
			}else {
				System.out.print('}');
			}
		}
		
		
		
		
	}

}
