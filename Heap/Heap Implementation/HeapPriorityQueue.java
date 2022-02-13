import java.util.Arrays;
import java.util.NoSuchElementException;

// Implements a priority queue of comparable objects using a
// min-heap represented as an array.
public class HeapPriorityQueue<E extends Comparable<E>> {
    private E[] elementData;
    private int size;
    
    // Constructs an empty queue.
    @SuppressWarnings("unchecked")
    public HeapPriorityQueue() {
        elementData = (E[])new Comparable[10];
        size = 0;
    }

    // O(n)
    // Adds the given element to this queue.
    public void add(E value) {
      if ((size + 1) >= elementData.length) {
       E[] copy = Arrays.copyOf(elementData, elementData.length * 2);
       elementData = copy;
	    }
    	elementData[size+1] = value;
		// bubble up
		int index = size+1;
		boolean found = false;
		while (!found && hasParent(index)) {
			int parent = parent(index);
			if (elementData[index].compareTo(elementData[parent]) < 0) {
				swap(elementData, index, parent(index));
				index = parent(index);
			} else {
				found = true;
			}
		}
		size++;
    }

    // O(1)
    // Returns true if there are no elements in this queue.
    public boolean isEmpty() {
    	//check if there's anything in the queue
		return size == 0;
    }

    // O(1)
    // Returns the minimum value in the queue without modifying the queue.
    // If the queue is empty, throws a NoSuchElementException.
    public E peek() {
    	//checks if queue is empty
      if (size==0){
        throw new NoSuchElementException("NoSuchElementException");
      }
      //returns lowest (and first) value w/o modification
      return elementData[1];
    }

    // O(logn)
    // Removes and returns the minimum value in the queue.
    // If the queue is empty, throws a NoSuchElementException.
     public E remove() {
        if (size == 0) {
          throw new NoSuchElementException("NoSuchElementException");
        }
        E result = elementData[1];
        elementData[1] = elementData[size];
        size--;
        int index = 1;
        boolean found = false;
        while (!found && hasLeftChild(index)) {
          int left = leftChild(index);
          int right = rightChild(index);
          int child = left;
          if (hasRightChild(index) && elementData[right].compareTo(elementData[left]) < 0) {
                child = right;
              }
          if (elementData[index].compareTo(elementData[child]) > 0) {
            swap(elementData, index, child);
            index = child;
          }
          else {
            found = true;
          }
          size--;
        }
        return result;
     }
	
    // O(1)
    // Returns the number of elements in the queue.
    public int size() {
      // TO DO
      return size;
    }
    
    // O(n)
    // Returns a string representation of this queue, such as "[10, 20, 30]";
    // The elements are not guaranteed to be listed in sorted order.
    public String toString() {
        String result = "[";
        if (!isEmpty()) {
            result += elementData[1];
            for (int i = 2; i < size; i++) {
                result += ", " + elementData[i];
            }
        }
        return result + "]";
    }
    

    // O(1)
    // helpers for navigating indexes up/down the tree
    private int parent(int index) {
    	return index/2; 
    }

    // O(1)
    // returns index of left child of given index 
    private int leftChild(int index) {
    	return index * 2;
    }

    // O(1)
    // returns index of right child of given index 
    private int rightChild(int index) {
    	// TO DO
      return index * 2 + 1;
    }

    // O(1)
    // returns true if the node at the given index has a parent (is not the root)
    private boolean hasParent(int index) {
    	return index > 1; // just cannot be root, which is always index 0;
    }

    // O(1)
    // returns true if the node at the given index has a non-empty left child
    private boolean hasLeftChild(int index) {
    	return leftChild(index) <= size;
    }

    // O(1)
    // returns true if the node at the given index has a non-empty right child
    private boolean hasRightChild(int index) {
    	return rightChild(index) <= size;
    }

    // O(1)
    // switches the values at the two given indexes of the given array
    private void swap(E[] a, int index1, int index2) {
    	E temp = a[index1];
		a[index1] = a[index2];
		a[index2] = temp;
    }
}
