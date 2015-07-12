package DataStructure.List;

/**
 * ˫�������ʵ��
 * 
 * @author JohnnyLiao
 * @date 2015��7��12�� ����12:12:39
 */
public class DuLinkList<T> {
	private class Node {
		T data;
		Node prev;
		Node next;

		public Node() {
		}

		public Node(T data, Node prev, Node next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
	}
	
	private Node header;
	private Node tail;
	private int size;
	
	public DuLinkList() {
		header = null;
		tail = null;
	}
	
	public DuLinkList(T ele) {
		header = new Node (ele, null, null);
		tail = header;
		size++;
	}
	
	public int length() {
		return size;
	}
	
	// get the element by index
	public T get(int index) {
		return getNodeByIndex(index).data;
	}
	
	// get the node by index
	private Node getNodeByIndex(int index) {
		if (index < 0 || index > size - 1)
			throw new IndexOutOfBoundsException("���Ա�����Խ��");
		// �жϴ�ͷָ�뿪ʼ��������βָ�뿪ʼ
		if (index <= size / 2) {
			Node current = header;
			for (int i = 0; i <= size / 2 && current != null; i++, current = current.next) 
				if (i == index)
					return current;
		} else {
			Node current = tail;
			for(int i = size - 1; i > size / 2 && current != null; i-- , current = current.prev)
				if (i == index)
					return current;
		}
		return null;
	}
	
	// get the index by element
	public int locate(T ele) {
		Node current = header;
		for (int i = 0; i < size && current != null; i++, current = current.next) 
			if (current.data.equals(ele))
				return i;
		return -1;
	}
	
	// insert element in right index
	public void insert(T ele, int index) {
		if (index < 0 || index > size - 1)
			throw new IndexOutOfBoundsException("���Ա�����Խ��");
		
		if (header == null)
			add(ele);
		else {
			if (index == 0)
				addAtHeader(ele);
			else {
				Node prev = getNodeByIndex(index - 1);
				Node next = prev.next;
				
				Node newNode = new Node(ele, prev, next);
				prev.next = newNode;
				next.prev = newNode;
				size++;
			}
		}
	}

	// β�巨Ϊ��������½ڵ�
	public void add(T ele) {
		if (header == null) {
			header = new Node(ele, null, null);
			tail = header;
		} else {
			Node newNode = new Node(ele, tail, null);
			tail.next = newNode;
			tail = newNode;
		}
		size++;
	}

	// ͷ�巨�����½ڵ�
	private void addAtHeader(T ele) {
		header = new Node(ele, null, header);
		if (tail == null)
			tail = header;
		size++;
	}
	
	// delete the Node by index
	public T delete(int index) {
		if (index < 0 || index > size - 1)
			throw new IndexOutOfBoundsException("���Ա�����Խ��");
		Node del = null;
		// delete is the header node 
		if (index == 0) {
			del = header;
			header = header.next;
			header.prev = null;
		} else {
			Node prev = getNodeByIndex(index - 1);
			del = prev.next;
			prev.next = del.next;
			if (del.next != null) 
				del.next.prev = prev;
			del.prev = null;
			del.next = null;
		}
		size--;
		return del.data;
	}

	// remove the last element in the list
	public T remove() {
		return delete(size - 1);
	}
	
	public boolean empty() {
		return size == 0;
	}
	
	public void clear() {
		header = null;
		tail = null;
		size = 0;
	}
	
	@Override
	public String toString() {
		if (empty())
			return "[]";
		else {
			StringBuilder sb = new StringBuilder("[");
			for (Node current = header; current != null; current = current.next) {
				sb.append(current.data.toString() + ", ");
			}
			int len = sb.length();
			return sb.delete(len - 2, len).append("]").toString();
		}
	}
	
	public String reverseToString() {
		if (empty())
			return "[]";
		else {
			StringBuilder sb = new StringBuilder("[");
			for (Node current = tail; current != null; current = current.prev)
				sb.append(current.data.toString() + ", ");
			int len = sb.length();
			return sb.delete(len - 2, len).append("]").toString();
		}
	}
	
}
