import java.util.HashMap;
import java.util.Map;

/**
 * One of my attempts at the simple LRU cache
 * @author pbhatnagar
 * If you have any questions or comments, please feel free to contact
 * me at pbhatnagar3@gatech.edu
 *
 * MAY THE FORCE OF COMPILER BE WITH YOU. :D
 */
public class SimpleLRUCache {

	private DoubleLinkedListNode head = null;
	private DoubleLinkedListNode tail = null;
	private final Map<Integer, DoubleLinkedListNode> mapper = 
			new HashMap<Integer, DoubleLinkedListNode>();
	private int capacity = 0;
	private int currentOccupancy = 0;
	public SimpleLRUCache(int capacity){
		this.capacity = capacity;
	}
	public int getCurrentOccupancy() {
		return currentOccupancy;
	}
	public void setCurrentOccupancy(int currentOccupancy) {
		this.currentOccupancy = currentOccupancy;
	}

	public void remove(DoubleLinkedListNode toRemove){
		if(mapper.containsKey(toRemove.getKey())){
			currentOccupancy--;
			mapper.remove(toRemove.getKey());
			if(toRemove.getPre()!= null){
				(toRemove.getPre()).setPost(toRemove.getPost());
			}else{
				head = toRemove.getPost();
			}
			if(toRemove.getPost() != null){
				toRemove.getPost().setPre(toRemove.getPre());
			}else{
				tail = toRemove.getPre();
			}
		}
	}

	public Integer get(int key){
		if(mapper.containsKey(key)){
			DoubleLinkedListNode obj = mapper.get(key);
			//have to remove it from the currentPlace
			remove(obj);
			setHead(obj);
			return obj.getValue();
		}
		else{
			return null;
		}

	}
	private void setHead(DoubleLinkedListNode obj) {
		// TODO Auto-generated method stub
		if(head!= null)
			head.setPre(obj);
		obj.setPost(head);
		obj.setPre(null);
		head = obj;
	}

	public void add(int key, int value){
		if(mapper.containsKey(key)){
			DoubleLinkedListNode oldObj = mapper.get(key);			
			oldObj.setValue(value);
			remove(oldObj);
			//since we are just updating the value corresponding to the current key, we will
			//have to make sure that the currentOccupancy does not decrease when it should not
			currentOccupancy++;
			setHead(oldObj);
		}
		else{
			if(capacity == currentOccupancy){
				remove(tail);
			}
			DoubleLinkedListNode obj = new DoubleLinkedListNode(key, value);
			mapper.put(key, obj);
			if(head == null){
				head = obj;
				tail = obj;
				currentOccupancy++;
			}
			else{
				setHead(obj);
				currentOccupancy++;
			}
		}
	}

	@Override
	public String toString(){
		StringBuffer output = new StringBuffer("");
		DoubleLinkedListNode temp = head;
		if(temp!= null)
			while(temp != null){
				output.append(temp.getValue());
				output.append("->");
				temp = temp.getPost();
			}
		if(output.length() == 0)
			System.out.println("Nothing in the buffer");
		return output.toString();
	}

	public static void main(String[] args) {
		SimpleLRUCache cache = new SimpleLRUCache(3);
		System.out.println(cache);
		cache.add(7, 25);
		System.out.println(cache);
		cache.add(1, 2);
		System.out.println(cache);
		cache.add(2, 3);
		System.out.println(cache);
		cache.add(5, 6);
		System.out.println(cache);
		cache.get(2);
		System.out.println(cache);
	}
}




class DoubleLinkedListNode{
	private DoubleLinkedListNode pre;
	private DoubleLinkedListNode post;
	private int key;
	private int value;
	public DoubleLinkedListNode getPre() {
		return pre;
	}
	public void setPre(DoubleLinkedListNode pre) {
		this.pre = pre;
	}
	public DoubleLinkedListNode getPost() {
		return post;
	}
	public void setPost(DoubleLinkedListNode post) {
		this.post = post;
	}
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public DoubleLinkedListNode(int key, int value){
		this.key = key;
		this.value = value;
	}
}