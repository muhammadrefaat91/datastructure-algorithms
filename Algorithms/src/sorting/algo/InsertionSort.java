package sorting.algo;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int unsortedArray[] = {9,6,4,5,3,2,1};

		for (int i = 1; i < unsortedArray.length; i++) {
			int minimum = unsortedArray[i];
			int j;
			for (j = i-1; j >= 0 && unsortedArray[j] > minimum; j--) {
				unsortedArray[j+1] = unsortedArray[j];
			}
			unsortedArray[j+1] = minimum;
			
		}
		System.out.println(Arrays.toString(unsortedArray));
	}

}
