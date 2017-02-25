package stackAndQueueAndList;
import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T>{

	Node<T> head;
	int size = 0;
	
	
	public void add(int val) {
		
		Node newNode = new Node<>();
		Node  headNode = head;

		if (headNode == null) {
			headNode = newNode;
			head = headNode;
		} else {
			if (headNode.next == null) {
				headNode.next = newNode;
			}else {
				while (headNode.next != null) {
					headNode = headNode.next;
				}
				headNode.next = newNode;
			}
		}
		
		newNode.data = val;
		size++;
	}

	public Node addInFront(int val) {
		
		Node newNode = new Node<>();
		Node  headNode = head;

		if (headNode == null) {
			head = newNode;
		} else {
 				newNode.next = headNode;
 				head = newNode;
		}
		newNode.data = val;
		size++;
		return newNode;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public Node addAtPosition(Node head, int data, int position) {
		Node newNode = new Node<>();
		Node nodeHead = head;
		if (checkIndex(position)) {
			if (position == 0 || head == null) {
				Node node = addInFront(data);
				nodeHead = node;
			} else {
				for(int i = 0; i < position-1; i++) {
					head = head.next;
				}
				
				newNode.next = head.next;
				head.next = newNode;
				newNode.data = data;
				size++;
			}
		} else {
			throw new  IndexOutOfBoundsException();
		}
		return nodeHead;
	}
	
	
	private boolean checkIndex(int pos) {
		return pos >= 0 && (pos <= size);  
	}
	
	public Object get(int index) {
		Node  headNode = head;
		
		for(int i = 0; i < index; i++) {
			if(headNode.next != null)
				headNode = headNode.next;
		}
		
		return headNode.data;
	}
	
	
	private class Node<T> {
		T data;
		Node next;
		
	}
	
	public static void main(String[] args) {
		MyLinkedList<Integer> list = new MyLinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.addInFront(4);
		list.addAtPosition(null, 5, 2);
		for (int i =0; i < list.size; i++) {
			System.out.println(list.get(i));
		}
	}

	@Override
	public Iterator<T> iterator() {
		return null;
	}

}
