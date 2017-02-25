package stackAndQueueAndList;

public class StackUsingArray {

	int top;
	int elements []; 
	
	public StackUsingArray(int size) {
		elements = new int[size];
		top = 0;
	}
	
	
	public void push(int val) {
		elements[top] = val;
		top++;
	}
	
	public int pop() {
		top--;
		int lastVal = elements[top];
		int oldElments[] = new int[top]; 
		for (int i = 0; i < top; i++) {
			oldElments[i] = elements[i];
		}
		elements = oldElments;
		return lastVal;
	}
	
	public int peek() {
		top--;
		int lastVal = elements[top];
		return lastVal;
	}
	
	public static void main(String[] args) {
		StackUsingArray stackArray = new StackUsingArray(3);
		stackArray.push(1);
		stackArray.push(2);
		stackArray.push(3);
		stackArray.pop();
		stackArray.pop();
		for (int element : stackArray.elements) {
			System.out.println(element);
		}
		System.out.println(stackArray.peek());
	}

}
