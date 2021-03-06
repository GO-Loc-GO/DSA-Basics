package ds_Lecture5_Sorting_samples;

import java.util.Arrays;

public class RadixSort {
	public static void radixSort(int[] num) {
		if (isEmpty(num))

            return;

        int tmp = getMax(num);

        // get loop count

        int loop = 0;

        do {

            loop++;

        } while ((tmp = tmp / 10) > 0);

        int count = 1, k, lsd;

        int[][] bubble = new int[10][num.length];

        int[] order = new int[10];

        tmp = 1;

        while (count <= loop) {

            for (int i = 0; i < num.length; i++) {

                lsd = (num[i] / tmp) % 10;

                bubble[lsd][order[lsd]] = num[i];

                order[lsd]++;

            }

            k = 0;

            for (int i = 0; i < 10; i++) {

                if (order[i] != 0) {

                    for (int j = 0; j < order[i]; j++) {

                        num[k] = bubble[i][j];

                        k++;

                    }

                }

                order[i] = 0;

            }

            tmp *= 10;

            count++;

        }

    }

 

    private static int getMax(int[] num) {

        if (isEmpty(num)) {

            throw new IllegalArgumentException();

        }

        int max = num[0];

        for (int i = 1; i < num.length; i++) {

            if (max < num[i])

                max = num[i];

        }

        return max;

    }

 

    private static boolean isEmpty(int[] num) {

        return num == null || num.length == 0;

    }
	
	public static void main(String[] args) {
		int[] data= {5,3,0,2,4,1,0,5,2,3,1,4}; 
		 
	      System.out.println("Before: " + Arrays.toString(data));
	      radixSort(data);
	      System.out.println("After:  " + Arrays.toString(data));

	}

}
