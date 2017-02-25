package stackAndQueueAndList;


import java.util.NoSuchElementException;
import java.util.Scanner;

public class TextEditorUsingStack {
	char elements[];
	int top = 0;
	int backCount = 0;
	int size = 10000000;
	int indexOfBackup = 0;
	TextEditorUsingStack textEditorBackups[];

	public TextEditorUsingStack() {
		elements = new char[size];
		textEditorBackups = new TextEditorUsingStack[size];
	}

	public void append(char w) {
		push(w);
	}

	void addbackup(int backupCount) {
		checkCapacityOfBackups();
		TextEditorUsingStack editor = new TextEditorUsingStack();
		editor.elements = elements;
		editor.top = top;
		this.textEditorBackups[backupCount] = editor;
		indexOfBackup++;
	}

	// delete from last of array
	// K number of deleted chars
	public void delete(int k) {
		for (int i = 0; i < k; i++) {
			pop();
		}
	}

	public void print(int pos) {
		if (pos >= 0 && pos <= top) {
			System.out.println(elements[pos - 1]);
		} else {
			throw new NoSuchElementException();
		}
	}

	public void undo(int backupCount) {
		if (backupCount > 0) {
			TextEditorUsingStack currentTextEditor = textEditorBackups[backupCount];
			currentTextEditor = textEditorBackups[--backupCount];
			this.top = currentTextEditor.top;
			this.elements = currentTextEditor.elements;
		}
	}

	public void push(char val) {
		checkCapacity();
		elements[top++] = val;
	}

	public void pop() {
		if (top > 0) {
			top--;
			char oldElments[] = new char[elements.length + 1];
			for (int i = 0; i < top; i++) {
				oldElments[i] = elements[i];
			}
			elements = oldElments;
		} else {
			throw new ArrayIndexOutOfBoundsException("-1");
		}
	}

	public void checkCapacity() {
		if (top >= elements.length) {
			char oldElements[] = elements;
			elements = new char[elements.length * 2 + 1];
			for (int i = 0; i < oldElements.length; i++) {
				elements[i] = oldElements[i];
			}
			oldElements = null;
		}
	}

	void checkCapacityOfBackups() {
		if (indexOfBackup > textEditorBackups.length) {
			TextEditorUsingStack[] oldTextEditorsBackup = textEditorBackups;
			textEditorBackups = new TextEditorUsingStack[textEditorBackups.length * 2 + 1];
			for (int i = 0; i < oldTextEditorsBackup.length; i++) {
				textEditorBackups[i] = oldTextEditorsBackup[i];
			}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		TextEditorUsingStack textEditor = new TextEditorUsingStack();
		int backupCount = 0;
		int n = scan.nextInt();
		for (int i = 0; i < n; i++) {
			int op = scan.nextInt();
			if (op == 1) {
				String c = scan.next();
				char elements[] = c.toCharArray();
				for (int j = 0; j < elements.length; j++) {
					textEditor.append(elements[j]);
				}
				textEditor.addbackup(backupCount++);
			}
			if (op == 2) {
				int k = scan.nextInt();
				textEditor.delete(k);
				textEditor.addbackup(backupCount++);
			}

			if (op == 3) {
				int pos = scan.nextInt();
				textEditor.print(pos);
			}
			if (op == 4) {
				textEditor.undo(--backupCount);
			}
		}

	}
}
