class Node {
	public Application jobApp;
	public int priority;
	public Node next;

	public void displayNodeData() {
		System.out.println("{ " + jobApp.toString() + ", " + priority + " } ");
	}
}

public class PriorityQueue {
	public Node head;
	int size;

	public PriorityQueue() {
		super();
	}

	public void enqueue(Application jobApp, int priority) {
		Node newNode = new Node();
		newNode.jobApp = jobApp;
		newNode.priority = priority;
		if (size == 0) {
			head = newNode;
			size++;
		} else if (head.priority < priority) {
			newNode.next = head;
			head = newNode;
			size++;
		} else {
			Node temp = head;
			while (temp.next != null && temp.next.priority >= priority) {
				temp = temp.next;
			}
			newNode.next = temp.next;
			temp.next = newNode;
			size++;
		}
	}

	public String peek() {
		Node current = head;
		if (head == null)
			return null;
		return current.jobApp.toString();
	}

	public Application dequeue() {
		if (size == 0)
			return null;
		Node temp = head;
		head = head.next;
		size--;
		return temp.jobApp;
	}

	public int size() {
		return size;
	}

	public String print() {
		String content;
		Node current = head;
		content = current.jobApp.toString();
		while (current.next != null) {
			current = current.next;
			content = content + " : " + current.jobApp.toString();
		}
		return content;
	}
}