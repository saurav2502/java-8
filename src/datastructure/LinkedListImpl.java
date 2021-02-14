/*
 * Copyright for LinkedListImpl.java by kumar since 26/10/20, 10:51 PM
 */

package datastructure;

/**
 * @author kumar
 * @project java-8
 * @since 26-10-2020
 */
class Node {
	int data;
	Node next;

	public Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}
}

public class LinkedListImpl {

	public Node createNode(Node node, int data) {
		Node newNode = new Node(data, node);
		return newNode;
	}

	public void printNode(Node node) {
		while (node.next != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.print(node.data);
	}

	public static void main(String[] args) {
		Node node = null;
		LinkedListImpl list = new LinkedListImpl();
		node = list.insert(node, 10);
		node = list.insert(node, 20);
		node = list.insert(node, 30);
		node = list.insert(node, 40);
		//list.printNode(node);
		//node = list.insertAtPos(node, 3, 100);
		//list.printNode(node);
		//node = list.deleteAtPos(node, 3);
		//System.out.println();
		list.printNode(node);
		//node = list.reverse(node);
		//list.reverse(node);
        node = list.rotateClockwise(2, node);
        list.printNode(node);
	}

	private Node insert(Node node, int value) {
		if (node == null) {
			return createNode(node, value);
		}
		node.next = insert(node.next, value);
		return node;
	}

	private Node insertAtPos(Node node, int position, int value) {
		if (position < 0) {
			System.out.println("position can't be lass than zero");
		}
		if (node == null && position > 1) {
			System.out.println("position greater than node existance");
		}
		if (node == null && position == 1) {
			return createNode(node, value);
		}
		if (position == 1) {
			Node node1 = createNode(node, value);
			node1.next = node;
			return node1;
		}
		node.next = insertAtPos(node.next, position - 1, value);
		return node;
	}

	private Node deleteAtPos(Node node, int position) {
		if (position < 0) {
			return null;
		}
		if (node == null || node.next == null) {
			return null;
		}
		if (node == null && position > 0) {
			System.out.println("no node to delete");
			return null;
		}
		if (position == 1) {
			return node.next;
		}
		node.next = deleteAtPos(node.next, position - 1);
		return node;
	}

	public Node reverse(Node node) {
		if (node == null || node.next == null) {
			return node;
		}

		Node temp = reverse(node.next);
		node.next.next = node;
		node.next = null;

		return temp;

	}

    public int getSizeOfList(Node node) {
        if(node == null) {
            return 0;
        }

        return 1 + getSizeOfList(node.next);
    }

    public Node rotateClockwise(int k, Node node) {
        if(node == null || k < 0) {
            return node;
        }

        int sizeOfLinkedList = getSizeOfList(node);
        k = k % sizeOfLinkedList;

        if(k == 0) {
            return node;
        }

        Node tmp = node;
        int i = 1;

        while(i < sizeOfLinkedList - k) {
            tmp = tmp.next;
            i++;
        }

        Node temp = tmp.next;
        Node head = temp;
        tmp.next = null;

        while(temp.next != null) {
            temp = temp.next;
        }

        temp.next = node;

        return head;
    }
}
