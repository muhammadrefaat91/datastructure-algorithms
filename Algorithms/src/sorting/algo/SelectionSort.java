package sorting.algo;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int unsortedArray[] = {9,6,4,5,3,2,1};
		
		for (int i = 0; i < unsortedArray.length; i++) {
			for (int j = i+1; j < unsortedArray.length; j++) {
				if (unsortedArray[i] > unsortedArray[j]) {
					int temp = unsortedArray[j];
					unsortedArray[j] = unsortedArray[i];
					unsortedArray[i] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(unsortedArray));
	}

}
