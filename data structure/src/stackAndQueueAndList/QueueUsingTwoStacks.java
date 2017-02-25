package stackAndQueueAndList;


import java.util.Scanner;
import java.util.Stack;

public class QueueUsingTwoStacks {

	public static void main(String[] args) {
		Stack<Object> enqueu = new Stack<>();
		Stack<Object> dequeu = new Stack<>();
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		for (int i = 0; i < n; i++) {
			int op = scan.nextInt();
			if (op == 1) {
				int element = scan.nextInt();
				enqueu.push(element);
			}
			if (op == 2) {
				if (!dequeu.isEmpty()) {
					dequeu.pop();
				} else {
					while (!enqueu.isEmpty()) {
						dequeu.push(enqueu.pop());
					}
					dequeu.pop();
				}
			}
			if (op == 3) {
				Object val;
				if (!dequeu.isEmpty()) {
					val = dequeu.peek();
				} else {
					while (!enqueu.isEmpty()) {
						dequeu.push(enqueu.pop());
					}
					val = dequeu.peek();
				}
					System.out.println(val);
			}
		}
	}

}
