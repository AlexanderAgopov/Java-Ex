package list.dynamic;

public class DynamicList {

	private class Node {
		Object element;
		Node next;

		Node(Object element, Node prevNode) {
			this.element = element;
			prevNode.next = this;
		}

		Node(Object element) {
			this.element = element;
			next = null;
		}
	}

	private Node head;
	private Node tail;
	private int count;

	public DynamicList(Node head, Node tail, int count) {
		this.head = null;
		this.tail = null;
		this.count = 0;
	}

	public DynamicList() {
		this.head = null;
		this.tail = null;
		this.count = 0;
	}

	// Adds element at the end of the list
	public void add(Object item) {
		if (head == null) {
			// We have empty list
			head = new Node(item);
			tail = head;
		} else {
			// We have non-empty list
			Node newNode = new Node(item, tail);
			tail = newNode;
		}
		count++;
	}

	// Removes and returns elements on the specific index
	public Object remove(int index) {
		if (index >= count || index < 0) {
			throw new IndexOutOfBoundsException("Invalid index: " + index);
		}

		// Finds the element on the specified index
		int currentIndex = 0;
		Node currentNode = head;
		Node prevNode = null;
		while (currentIndex < index) {
			prevNode = currentNode;
			currentNode = currentNode.next;
			currentIndex++;
		}

		// Removes the element
		count--;
		if (count == 0) {
			head = null;
			tail = null;
		} else {
			if (prevNode == null) {
				head = currentNode.next;
			} else {
				prevNode.next = currentNode.next;
			}
		}
		return currentNode.element;
	}

	// Removes the specified item and return its index
	public int remove(Object item) {
		// Find the element containing search item
		int currentIndex = 0;
		Node currentNode = head;
		Node prevNode = null;

		while (currentNode != null) {
			if (currentNode.element != null && currentNode.element.equals(item)
					|| currentNode.element == null && item == null) {
				break;
			}
			prevNode = currentNode;
			currentNode = currentNode.next;
			currentIndex++;
		}
		if (currentNode != null) {
			// Element is found in the list. Remove it
			count--;
			if (count == 0) {
				head = null;
				tail = null;
			} else if (prevNode == null) {
				head = currentNode.next;
			} else {
				prevNode.next = currentNode.next;
			}
			return currentIndex;
		} else {
			// Element is not found in the list
			return -1;
		}
	}

	// Searches for given element in the list
	public int indexOf(Object item) {
		int index = 0;
		Node current = head;
		while (current != null) {
			if (current.element != null && current.element.equals(item) || (current.element == null && item == null)) {
				return index;
			}
			current = current.next;
			index++;
		}
		return -1;
	}

	public boolean contains(Object item) {
		int index = indexOf(item);
		boolean found = index != -1;
		return found;
	}

	public Object elementAt(int index) {
		if (index >= count || index < 0) {
			throw new IndexOutOfBoundsException("Invalid index: " + index);
		}
		Node currentNode = this.head;
		for (int i = 0; i < index; i++) {
			currentNode = currentNode.next;
		}
		return currentNode.element;
	}

	public int getLength() {
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DynamicList shoppingList = new DynamicList();
		shoppingList.add("Butter");
		shoppingList.add("Pork meat");
		shoppingList.add("Olive oil");
		shoppingList.add("Chocolate");
		System.out.println("We have to buy: ");
		for(int i = 0; i<shoppingList.getLength(); i++) {
			System.out.println(shoppingList.elementAt(i));
		}
		System.out.println();
		System.out.println("Do we have to buy vodka?");
		System.out.println(shoppingList.contains("vodka"));

	}

}
