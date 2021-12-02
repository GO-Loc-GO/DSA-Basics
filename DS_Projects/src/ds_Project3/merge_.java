package ds_Project3;

public class merge_ {
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
	public static void merge(int[] f, int lo, int mid, int hi) {
		int length1=mid-lo+1;
		int length2=hi-mid;
		int[] c = new int[length1+length2];
		int j=0,i=0,k=0,n=lo;
	    while(i<length1 && j<length2 && k<c.length) {
	    	if(f[i+lo]<f[j+mid+1]) {
				c[k]=f[i+lo];
				i++;
				k++;
			}
			else if(f[i+lo]>f[j+mid+1]) {
				c[k]=f[j+mid+1];
				j++;
				k++;
			}
			else if(f[i+lo]==f[j+mid+1]) {
				c[k]=f[i+lo];
				c[k+1]=f[j+mid+1];
				i++;
				j++;
				k=k+2;
			}
	    }
	    if(i!=length1||j!=length2) {
	    	while(i!=length1) {
	    		c[k]=f[i+lo];
	    		i++;
	    		k++;
	    	}
	    	while(j!=length2) {
	    		c[k]=f[j+mid+1];
	    		j++;
	    		k++;
	    	}
	    }
	    for(k=0;k<c.length;k++) {
	    	f[n]=c[k];
	    	n++;
	    }
	}
	public static void mergeSort(int[] f, int lo, int hi) {
		if(f.length==0||lo==hi){
			return;
		}
		int length=hi-lo+1;
		int mid;
		if (length%2==0) {
			mid=lo+length/2-1;
		} else {
			mid=lo+length/2;
		}
		mergeSort(f,lo,mid);
		mergeSort(f,mid+1,hi);
		merge(f,lo,mid,hi);
	}

	public static void main(String[] args) {
		int i;
		int[] a= {31, 33, 27, 15, 42, 11, 40, 5, 19, 21};
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
		mergeSort(a,0,a.length-1);
		System.out.print("\nTest case 1 after quick sort: {");
		printArray(a);
		System.out.println("}");
		
		//for test case 2
		for(i=0;i<b.length;i++) {
			mergeSort(b[i],0,b[i].length-1);
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
