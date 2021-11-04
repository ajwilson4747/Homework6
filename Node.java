public class Node {
	public String word; 
	public Node prev; 
	public Node next; 
	
	public Node(String word) {
		this.word=word;
		prev = null; 
		next = null; 
	}
}
