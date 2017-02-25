package sorting.algo;

import java.util.Arrays;

public class BubleSort {

	public static void main(String[] args) {
		int unsortedArray[] = {9,6,4,5,3,2,1};
		
		for (int i = 0; i < unsortedArray.length; i++) {
			boolean swapped = false;
			for (int j = 0; j < unsortedArray.length-1; j++) {
				if (unsortedArray[j] > unsortedArray[j+1]) {
					int temp = unsortedArray[j];
					unsortedArray[j] = unsortedArray[j+1];
					unsortedArray[j+1] = temp;
					swapped = true;
				}
			}
			if (!swapped) {
				break;
			}
		}
		
		System.out.println(Arrays.toString(unsortedArray));
		
	}
}
