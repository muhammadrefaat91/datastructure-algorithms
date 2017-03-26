package sorting.algo;

import java.util.Arrays;

public class CountSort {

	public static void main(String[] args) {
		int unsortedArray[] = {9,6,4,5,3,2,1,7,8};
		int result [] = new int[unsortedArray.length];
		int count[] = new int[unsortedArray.length];
		
		
		for (int i = 0; i < unsortedArray.length; i++) {
			int repeat = count[unsortedArray[i]-1];
			count[unsortedArray[i]-1] = ++repeat;
		}
		
		for (int i = 0; i < count.length; i++) {
			int pos = unsortedArray[i];
			int repeat = count[i];
			while (repeat > 0) {
				result[pos-1] = unsortedArray[i];
				repeat--;
				pos+=1;
			}
		}
		System.out.println(Arrays.toString(result));
	}

}
