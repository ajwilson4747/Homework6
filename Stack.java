public class Stack {
	public Node head; 
	public Node tail; 
	public Stack () {
		head = null; 
		tail=null; 
	}
	
	public void push(String s) {
		Node temp = new Node(s);
		
		if(head ==null) {
			head = temp; 
			tail = temp;
		}
		else {
			tail.next = temp; 
			temp.prev = tail; 
			tail = temp; 
		}
	}
	
	public String pop() {
		String m = tail.word; 
		
		if(tail.prev ==null) {
			head = null; 
			tail = null;
		}
		else {
			Node preString = tail.prev; 
			preString.next = null; 
			tail = preString;
		}
		return m;
	}
}
