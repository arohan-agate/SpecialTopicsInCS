/*
1. I learned about how the various methods in the ArrayList class work together to create a working ArrayList object.
2. One of my main challenges was the .equals method which I was able to overcome by using the .getClass method and also creating a MyArrayList of time E. A challenge/error that I had was with the Iterator class, because I kept getting errors with it. Additionally, I was unable to run my code because I got a statement that says that the main file could not find Main.java.
*/
import java.util.NoSuchElementException;
import java.util.Iterator;

/**
 * An implementation of MyList with an array (a longer exercise would be to
 * implement the List interface as is done in the class java.util.ArrayList: the
 * source of the ArrayList class is available from Sun. Check it out).
 */

public class MyArrayList<E> implements MyList<E> {

	// Use an array for the implementation
	private E[] items; 

	// Default capacity of the array
	private static final int DEFAULT_CAPACITY = 10;

	// Number of elements in the array
	private int size;

	/**
	 * Constructs a MyArrayList with a specified capacity
	 */
	public MyArrayList(int initialCapacity) {
		if (initialCapacity < 0) {
			throw new IllegalArgumentException("Negative initial capacity=" + initialCapacity);
		}
		this.items = (E[]) new Object[initialCapacity];
	}

	/**
	 * Constructs a MyArrayList with a default capacity
	 */
	public MyArrayList() {
		this(DEFAULT_CAPACITY);
	}

	/**
	 * Returns the number of elements in this list.
	 */
	public int size() // O(1)
	{
		return this.size;
	}

	/**
	 * Returns true if this list contains no elements.
	 */
	public boolean isEmpty() // O(1) 
	{
		return this.size == 0;
	}

	/**
	 * Appends the specified element to the end of this list
	 */
	public boolean add(E o) // O(n)
	{
		if (this.size < this.items.length) {
			this.items[this.size] = o;
			this.size++;
		}
		else {
			throw new RuntimeException("list capacity exceeded");
		}
		return true;
	}

	/**
	 * Empties this List
	 */
	public void clear() // O(n) 
	{
		for (int i = 0; i < this.size; i++) {
			this.items[i] = null;
		}
		this.size = 0;
	}

	/**
	 * Returns the element at the specified position in this list.
	 */
	public E get(int index) // O(1)
	{
		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException();
		}
		else {
			return this.items[index];
		}
	}

	/**
	 * Returns the index of the specified element (-1 if there is no match)
	 */
	public int indexOf(Object o) // O(n)
	{
		// If o is null (look for a null element in the array)
		if (o == null) {
			return -1;
		} 
		else // o is an object (use equals)
		{
			for (int i = 0; i < this.size(); i++) {
				E elem = this.get(i);
				if (elem.equals(o)) {
					return i;
				}
			}
		}
		// If we get here, o is not in the list
		return -1;
	}

	/**
	 * Returns true if this list contains the specified element.
	 */
	public boolean contains(Object o) // O(n)
	 {
		return this.indexOf(o) != -1;
	}

	/**
	 * Removes the element in the List at position index
	 */
	public boolean remove(int index) // O(n) 
	{
		if (index < 0 || index > this.size) {
			throw new IndexOutOfBoundsException();
		}
		E removedElem = this.items[index];
		for (int i = index + 1; i < this.size; i++) {
			this.items[i-1] = this.items[i];
		}
		this.items[this.size-1] = null;
		this.size--;
		return true;
	}

	/**
	 * Removes the element in the List at position index
	 */
	public boolean remove(Object o) // O(n) 
	{
		int pos = indexOf(o);
		if (pos != -1) {
			remove(pos);
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds the specified object at the specified location
	 */
	public boolean add(int index, E o) // O(n)
	 {
		if (index < 0 || index > this.size) {
			throw new IndexOutOfBoundsException();
		}
		if (this.size >= this.items.length) {
			throw new RuntimeException("list capacity exceeded");
		}
		for (int i = this.size - 1; i >= index; i--) {
			this.items[i+1] = this.items[i];
		}
		this.size++;

		this.items[index] = o;
		return true;
	}

	/**
	 * Is this List equal to the specified object?
	 */
public boolean equals(Object o) // O(n)
    {
        if (o != null && o.getClass() == this.getClass()) {
			MyArrayList list = (MyArrayList) o;
            if (this.size() == list.size()) {
				for (int i = 0; i < this.size(); i++) {
					if (items[i] != list.get(i)) {
						return false;
					}
				}
				return true;
			}
			else {
				return false;
			}
        }
		else {
			return false;
		}
	}
	/**
	 * An inner class to define the iterator
	 */
	private class MyIterator implements Iterator<E> {
		private int index = 0;

		private MyArrayList<E> list;

		private int lastIndex = -1; // index of the object most recently visited

		// by next

		/**
		 * Create an iterator for a MyArrayList
		 */
		public MyIterator(MyArrayList<E> list) {
			this.list = list;
		}

		/**
		 * Any element left in the list?
		 */
		public boolean hasNext() {
			return index < this.list.size;
		}

		/**
		 * Returns the current element in the list and move to the next element
		 */
		public E next() {
			if (!this.hasNext()) {
				throw new NoSuchElementException();
			}
			this.lastIndex = index;
			return (E) this.list.items[index++];
		}

		/**
		 * Removes the last object returned by next
		 */
		public void remove() {
			if (this.lastIndex == -1) {
				throw new IllegalStateException();
			}
			this.list.remove(lastIndex);
			this.index--;
			this.lastIndex = -1;
		}
	}

	/**
	 * Returns an iterator over the elements in this list in proper sequence.
	 * 
	 * @return an iterator over the elements in this list in proper sequence.
	 */
	public Iterator<E> iterator() {
		return new MyIterator(this);
	}
}
