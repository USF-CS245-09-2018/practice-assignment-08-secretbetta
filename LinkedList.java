
public class LinkedList implements List {
	
	private int size = 0;
	private Node head = null;
	
	/**
	 * Node class
	 * @author Andrew
	 *
	 */
	public class Node {
		private Node next = null;
		public Object data;
		
		public Node(Object obj) {
			data = obj;
		}
	}

	public LinkedList() {
		head = new Node(null);
		size = 0;
	}

	@Override
	public void add(Object obj) throws Exception {
		Node temp = new Node(obj);
		Node curr = head;
		
		if (curr.data == null) {
			head = new Node(obj);
		} else {
			while (curr.next != null) {
				curr = curr.next;
			}
			curr.next = temp;
		}
		
		this.size++;
	}

	@Override
	public void add(int pos, Object obj) throws Exception {
		Node temp = new Node(obj);
		Node curr = head;
		
		if (curr.data == null) {
			head = new Node(obj);
		} else {
			for (int x = 0; x < pos - 1; x++) {
				curr = curr.next;
			}
			
			temp.next = curr.next;
			curr.next = temp;
		}
		this.size++;
	}

	@Override
	public Object get(int pos) throws Exception {
		Node temp = head;
		for (int x = 0; x < pos; x++) {
			temp = temp.next;
		}
		return temp.data;
	}

	@Override
	public Object remove(int pos) throws Exception {
		Node temp = head;
		Node deleted;
		
		for (int x = 0; x < pos; x++) {
			temp = temp.next;
		}
		deleted = temp;
		temp = temp.next;
		this.size--;
		return deleted.data;
	}

	@Override
	public int size() {
		return this.size;
	}
	
	/**
	 * Debugger: Prints linked list
	 */
	public void show(){
		Node current = head;
		int num = 0;
		while(current.next!=null){
			System.out.print(num + "." + current.data+" -> ");
			current = current.next;
			num++;
		}
		System.out.println(num + "." + current.data);
	}
	
	public static void main(String[] args) {
		List list = new LinkedList();
		if (list.size() == 0) {
			try {
				list.get(0);
				System.out.println(list.get(0));
			} catch (Exception e) {
				// We expect this!
				System.out.println("WORKS");
			}
		}
		System.out.println("FAILS");
	}

}
