class List // declare class list
{

	//PrintWriter out = null;
	private class Node {
		String number; // declare data
		String address;
		Node next; // declare next
		Node previous; // declare node previous

		Node(String number, String address) // constructor
		{
			this.number = number; // set this data equal to data
			this.address = address;
			next = null; // set next to null
			previous = null; // set previous to null
		}

		public String toString() // Overides Object's toString method.
		{
			return String.valueOf(number);
		}
	}

	private Node front; // declare node front
	private Node back; // declare node back
	private Node current; // declare node current
	int index; // declare index

	public List()  //Creates a new empty List
	{
		front = null; // set front to null
		back = null; // set back to null
		current = null; // set current to null
		index = -1; // set index to -1
	}

	// access functions
	int getLength() // Returns length of this List.
	{
		current = front; // set current to front
		int count = 0; // intitialze count
		while (current != null) { // while current is not at the end
			count++; // increase count
			current = current.next; // set current to next element
		}
		return count; // return the count
	}

	boolean isEmpty() // returns true if list is empty
	{
		return front == null; // return true if front is null
	}

	boolean offEnd() // Returns true if current is undefined.
	{
		return current == null; // return true if current is null
	}

	// If current element is defined, returns its position in
	// this List, ranging from 0 to getLength()-1 inclusive.
	// If current element is undefined, returns -1.
	int getIndex() {
		if (current != null) // if current is not null
			return index; // return index
		else
			// if current is null
			return -1; // return -1
	}

	String getFrontNumber() // Returns front element. Pre: !isEmpty().
	{
		if (!isEmpty()) // if list is not empty
			return front.number; // return data of front
		else
			// if list is empty
			throw new RuntimeException("Error:getFront called on an empty List"); // throw
																					// run
																					// time
																					// exception
	}

	String getFrontAddress() // Returns front element. Pre: !isEmpty().
	{
		if (!isEmpty()) // if list is not empty
			return front.address; // return data of front
		else
			// if list is empty
			throw new RuntimeException("Error:getFront called on an empty List"); // throw
																					// run
																					// time
																					// exception
	}

	String getBack() // Returns back element. Pre: !isEmpty().
	{
		if (!isEmpty()) // if list is not empty
			return back.number; // return data of back
		else
			// if list is empty
			throw new RuntimeException("Error:getBack called on an empty List"); // throw
																					// runtime
																					// exception
	}

	String getCurrentNumber() // Returns current element. Pre: !isEmpty(), !offEnd().
	{
		if (!isEmpty() && !offEnd()) // if list is not empty and not undefined
		{
			return current.number; // return data of current
		} else
			throw new RuntimeException(
					"Error:getCurrent called on undefined element or empty list"); // throw
																					// runtime
																					// exception
	}
	
	String getCurrentAddress() // Returns current element. Pre: !isEmpty(), !offEnd().
	{
		if (!isEmpty() && !offEnd()) // if list is not empty and not undefined
		{
			return current.address; // return data of current
		} else
			throw new RuntimeException(
					"Error:getCurrent called on undefined element or empty list"); // throw
																					// runtime
																					// exception
	}

	// Returns true if this List and L are the same integer
	// sequence. Ignores the current element in both Lists.
	boolean equals(List L) {
		boolean flag = true; // set boolean to true
		Node N = this.front; // set node n to front
		Node M = L.front; // set node M to front of L

		if (this.getLength() == L.getLength()) // if lengths are the same
		{
			while (flag && N != null) // while boolean is true and n is not at
										// end of list
			{
				flag = (N.number == M.number); // boolean condition
				N = N.next; // move n to next element
				M = M.next; // move m to next element
			}
			return flag; // return boolean
		} else { // if doesnt match
			return false; // return false
		}
	}

	// manipulation procedures
	void makeEmpty() // Sets this List to the empty state. Post: isEmpty().
	{
		while (!isEmpty())
			// while list is not empty
			front = front.next; // set front to next element
	}

	// If 0 <= i <= getLength()-1, moves current element
	// marker to position i in this List. Otherwise current
	// element becomes undefined.
	void moveTo(int i) {
		if (i >= 0 && i <= getLength() - 1) // if i is between 0 and length of
											// list
		{
			current = front; // set current to front
			index = 0; // set index to 0;
			for (int j = 0; j < i; j++) // go through list
			{
				current = current.next; // set current.next to current
				index++; // increase the index
			}
		} else
			// if not between 0 and length
			current = null; // set current to null
	}

	// Moves current one step toward front element. If the current
	// element is already the front element, current element becomes
	// undefined. Pre: !isEmpty(), !offEnd().
	void movePrev() {
		if (!isEmpty() && !offEnd()) // if list is not empty and current is
										// defined
		{
			if (current == front) // if current is first element
				current = null; // current is null
			else // if not
			{
				current = current.previous; // current is set to previous
											// element
				index--;// decrease index
			}
		} else
			// if not defined
			throw new RuntimeException(
					"Error:movePrev called on undefined element or empty list"); // throw
																					// runtime
	}

	// Moves current one step toward back element. If the current
	// element is already the back element, current element becomes
	// undefined. Pre: !isEmpty(), !offEnd().
	void moveNext() {
		if (!isEmpty() && !offEnd()) // if list is not empty and current is
										// defined
		{
			if (current == back) // if current is last element
				current = null; // current is undefined
			else {
				current = current.next; // move current to next element
				index++; // increase index
			}
		} else
			throw new RuntimeException(
					"Error:moveNext called on undefined element or empty list"); // else
																					// throw
																					// runtime
																					// exception
	}

	// Inserts new element before front element.
	// Post: !isEmpty().
	void insertFront(String number, String address) {
		Node newNode = new Node(number, address); // create new node to insert
		if (isEmpty()) // if list is empty
			back = newNode; // back is newnode
		else
			// if not
			front.previous = newNode; // previous of old front is new node
		newNode.next = front; // next of newnode is given to old front
		front = newNode; // newnode is now front
		index++; // increase index
	}

	// Inserts new element after back element.
	// Post: !isEmpty().
	void insertBack(String number, String address) {
		Node newNode = new Node(number, address); // create new node
		if (isEmpty()) // if list is empty
			front = newNode; // back is newnode
		else // if not
		{
			back.next = newNode; // newnode assigned to next value of back
			newNode.previous = back; // back is given to newnode previous
		}
		back = newNode; // back given newnode value
		//out = new PrintWriter("hello.txt");
		//out.println("whatsup");
		//out.close();
	}

	// Inserts new element before current element.
	// Pre: !isEmpty(), !offEnd().
	void insertBeforeCurrent(String number, String address) {
		if (!isEmpty() && !offEnd()) // if defined and not empty
		{
			Node newNode = new Node(number, address); // create new node
			if (current == front) // if current is front value
			{
				newNode.previous = null; // previous section of newnode is null
				front = newNode; // newnode is given to front
			} else {
				newNode.previous = current.previous; // value of
														// current.previous
														// given to
														// newnode.previous
				current.previous.next = newNode;// value of newnode given to old
												// current
			}
			newNode.next = current; // current is now newnode.next
			current.previous = newNode; // newnode is set to previous current
			index++;
		} else
			throw new RuntimeException(
					"Error:insertBeforeCurrent called on undefined element or empty list"); // throw
																							// runtime
																							// exception
	}

	// Inserts new element after current element.
	// Pre: !isEmpty(), !offEnd().
	void insertAfterCurrent(String number, String address) {
		if (!isEmpty() && !offEnd()) // if not empty and not undefined
		{
			Node newNode = new Node(number, address); // create new node
			if (current == back) // if current is back node
			{
				newNode.next = null; // next value of newnode is null
				back = newNode; // newnode is given to old back node
			} else {
				newNode.next = current.next; // next node of current is assigned
												// to next value of newnode
				current.next.previous = newNode;// newnode is given to old
												// current
			}
			newNode.previous = current;// current is assigned to previous
										// newnode
			current.next = newNode;// newnode is assigned to next value of
									// current
		} else
			throw new RuntimeException(
					"Error:insertAfterCurrent called on undefined element or empty list"); // throw
																							// new
																							// runtimeexception
	}

	// Deletes front element. Pre: !isEmpty().
	void deleteFront() {
		if (!isEmpty()) // if not empty list
		{
			Node temp = front; // temp node set to front
			if (front.next == null) // if first element
				back = null; // set back to null
			else
				front.next.previous = null; // set to null
			front = front.next; // front.next is set to front
			index--;
		} else
			throw new RuntimeException("Error:deleteFront called on empty list"); // throw
																					// runtime
																					// exception
	}

	// Deletes back element. Pre: !isEmpty().
	void deleteBack() {
		if (!isEmpty()) // if not empty
		{
			Node temp = back; // temporary node set to back
			if (front.next == null) // if only one item
				front = null; // set first to null
			else
				back.previous.next = null; // old previous set to null
			back = back.previous; // old previous set to back
		} else
			throw new RuntimeException("Error:deleteBack called on empty list"); // throw
																					// runtime
																					// exception
	}

	// Deletes current element, which then becomes undefined.
	// Pre: !isEmpty(), !offEnd(); Post: offEnd()
	void deleteCurrent() {
		if (!isEmpty() && !offEnd()) // if not empty and not undefined
		{
			if (current == front) // if first item
				front = current.next; // front is set to old next
			else
				current.previous.next = current.next; // old previous set to old
														// next
			if (current == back) // if last item
				back = current.previous; // old previous is set to back
			else
				current.next.previous = current.previous; // old previous set to
															// old last
			current = null; // make current undefined
		} else
			throw new RuntimeException(
					"Error:deleteCurrent called on empty list"); // throw
																	// runtime
																	// exception
	}

	// Other methods

	// Returns a new list which is identical to this list. The current
	// element in the new list is undefined, regardless of the state of
	// the current element in this List. The state of this List is
	// unchanged.
	/*
	 * List copy() { List L = new List(); //create new list Node N = this.front;
	 * //set node N to front of this list
	 * 
	 * while(N!=null) //while not at end of list { L.insertAfterCurrent(N.data);
	 * //insert data after current N=N.next; //keep moving n foward } return L;
	 * //return list L }
	 */

	// Overrides Object's toString method. Returns a string
	// representation of this List consisting of a space
	// separated sequence of integers, with no trailing space.
	public String toString() {
		String str = "";
		for (Node N = front; N != null; N = N.next) {
			str += N.toString() + " ";
		}
		return str;
	}
}