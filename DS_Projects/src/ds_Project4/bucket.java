package ds_Project4;

import ds_labs.LinkStack;
import ds_labs.StackEmptyException;

public class bucket {
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
	public static void bucketSort(int[] f) throws StackEmptyException {
		int i,j,k=0,max=f[0],min=f[0];         //STEP1
		for(i=1;i<f.length;i++) {
			if(f[i]>max) {
				max=f[i];
			}else if(f[i]<min) {
				min=f[i];
			}
		}
		
		
		if(min<0) {                                                 //if minimum<0, then it means an array of LinkStacks 
			LinkStack[] buckets_for_minus0 = new LinkStack[-min+1];  //need to be created to store the numbers that are minus zero,
			for(i=0;i<buckets_for_minus0.length;i++) {               //then these numbers are output from the largest index to the smallest,
				buckets_for_minus0[i] = new LinkStack();             //which is in reverse order compared to the way of outputting numbers that are 
			}                                                        //bigger than zero.
			for(i=0;i<f.length;i++) {
				if(f[i]<0) {
					buckets_for_minus0[-f[i]].push(f[i]);
				}
			}
			
			for(i=buckets_for_minus0.length-1;i>-1;i--) {
				if(buckets_for_minus0[i].isEmpty()==true) {
					continue;
				}else{
					for(j=0;j<buckets_for_minus0[i].size();j++) {
						f[k]=(int)buckets_for_minus0[i].pop();
						k++;
					}
				}
			}
		}
		
		
        if(max>=0) {
        	LinkStack[] buckets = new LinkStack[max+1];
    		for(i=0;i<buckets.length;i++) {
    			buckets[i] = new LinkStack();
    		}
    		for(i=0;i<f.length;i++) {
    			if(f[i]>=0) {
    				buckets[f[i]].push(f[i]);
    			}
    		}
    		for(i=0;i<buckets.length;i++) {             //STEP5
    			if(buckets[i].isEmpty()==true) {
    				continue;
    			}else{
    				for(j=0;j<buckets[i].size();j++) {
    					f[k]=(int)buckets[i].pop();
    					k++;
    				}
    			}
    		}
        }
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
		try {
			bucketSort(a);
		} catch (StackEmptyException e) {
			e.printStackTrace();
		}
		System.out.print("\nTest case 1 after quick sort: {");
		printArray(a);
		System.out.println("}");
		
		//for test case 2
		for(i=0;i<b.length;i++) {
			try {
				bucketSort(b[i]);
			} catch (StackEmptyException e) {
				e.printStackTrace();
			}
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
