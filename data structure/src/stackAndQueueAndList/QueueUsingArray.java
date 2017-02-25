package stackAndQueueAndList;

public class QueueUsingArray {

	int front;
	int rear;
	int elements[];
	
	public QueueUsingArray(int size) {
		elements = new int[size];
		front = 0;
		rear = 0;
	}
	
	public void enqueue(int val) {
		elements[rear] = val;
		rear ++;
	}
	
	public int dequeue() {
		int element = elements[front];
		front ++;
		return element;
	}
	
	public static void main(String[] args) {
		QueueUsingArray queueUsingArray = new QueueUsingArray(3);
		queueUsingArray.enqueue(1);
		queueUsingArray.enqueue(2);
		queueUsingArray.enqueue(3);
		System.out.println(queueUsingArray.dequeue());
		for (int i = 0; i < queueUsingArray.elements.length; i++) {
			int element = queueUsingArray.elements[i];
			System.out.println(element);
		}
	}

}
