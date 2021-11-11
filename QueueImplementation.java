public class Main {
    // This is an inner class specifically utilized for LLStack class,
    // thus no setter or getters are needed
    private class Node {
        private Object data;
        private Node next;

        // Constructor with no parameters for inner class
        public Node() {
        }

        // Parametrized constructor for inner class
        public Node(Object newData, Node nextLink) {
            data = newData;
			next = nextLink;
        }
    }
    
    private Node front;
    private Node back;

    public Main() {
		front = null;
		back = null;
    	
    }
    
    //offer(enqueue) adds the object at the back of the queue. O(n)
    public void offer(Object o) {
		if (front == null) {
			front = new Node(o, null);
		}
		else if (front.next == null) {
			back = new Node(o, null);
			front.next = back;
		}
		else {
			back.next = new Node(o, null);
		}
    }
    
    //poll(dequeue): retrieves and removes the head of this queue, O(1)
    //or returns null if this queue is empty.
    public Object poll() {
        if (this.front == null) {
			return null;
		}
		else {
			Object o = front.data;
			front = front.next;
			return o;
		}

    }
    
    // Returns the size of linked list by traversing the list
    public int size() {
        if (front == null) {
			return -1;
		}
		Node curr = front;
		int count = 0;
		while (curr.next != null) {
			count++;
			curr = curr.next;
		}
		return count;
    }
    //peek: Retrieves, but does not remove, the head of this queue, O(1)
    //or returns null if this queue is empty.
    public Object peek() {
        if (front != null) {
			return front.data;
		}
    	return null;
    } 
    
    // O(1)
    public boolean isEmpty() {
        if (front == null) {
			return true;
		}
    	return false;
    } 
    
    // For two lists to be equal they must contain the same data items in O(n)
    // the same order. The equals method of T is used to compare data items.
    public boolean equals(Object otherObject) {
        if (otherObject == null) {
			return false;
		}
        else if (!(otherObject instanceof Main)) {
            return false;
        }
		else {
            Main otherList = (Main) otherObject;
            if (this.size() == otherList.size()) {
				Node cur1 = this.front;
				Node cur2 = otherList.front;
				while (cur1 != null) {
					if (!((cur1.data).equals(cur2.data))) {
						return false;
					}
					cur1 = cur1.next;
					cur2 = cur2.next;
				}	
			}
		}
            return true; // objects are the same
    }
    
    // There is no need to modify the driver
    public static void main(String[] args) {
     // input data for testing
        String target = "Somethings!";
        String palindrome = "a man a plan canal panama";

        Main list = new Main();
        // objects to be added to list
        Object object1 = (Character) target.charAt(4);
        Object object2 = (Character) target.charAt(1);
        Object object3 = (Character) target.charAt(2);
        Object object4 = (Character) target.charAt(9);
        Object object20 = (Character) target.charAt(6); // will not be added to list

        // add 4 objects to our linked list
        list.offer(object1);
        list.offer(object2);
        list.offer(object3);
        list.offer(object4);
        
        // make sure all are added
        System.out.println("My list has " + list.size() + " nodes.");
        
        //testing equals
        Main list2 = new Main();
        // add 4 objects to the new linked list
        list2.offer(object1);//t
        list2.offer(object2);//o
        list2.offer(object3);//m
        list2.offer(object4);//s
        boolean isEqual2 = list.equals(list2);
        System.out.println("list2 is equal to list1? " + isEqual2);
        
        // add 4 objects to our linked list in a different order
        Main list3 = new Main();
        list3.offer(object3);//m
        list3.offer(object1);//t
        list3.offer(object2);//o
        list3.offer(object4);//s
        boolean isEqual3 = list.equals(list3);
        System.out.println("list3 is equal to list1? " + isEqual3);
        
        // testing isEmpty() and poll()
        while(!list.isEmpty()) {
            Object temp = list.poll();
            System.out.println("Polling " + temp);
        }
       
    }  

}

