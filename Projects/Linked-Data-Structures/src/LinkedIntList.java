//A LinkedIntList object can be used to store a list of integers.
public class LinkedIntList {
    private ListNode front; // reference to front node in list (null if empty)

    // Constructs a new empty list.
    public LinkedIntList() {
        front = null;
    }

    // Adds the given value to the end of the list.
    public void add(int value) {
        if (front == null) {
            // adding to an empty list
            front = new ListNode(value);
        } else {
            // adding to the end of an existing list;
            // traverse to the last node in the list so we can append to it
            ListNode current = front;
            while (current.next != null) {
                current = current.next;
            }

            // at this point, current.next == null,
            // and current refers to the last node
            current.next = new ListNode(value);
        }
    }

    // Adds the given value at the given index in the list.
    // Precondition: 0 <= index <= size
    public void add(int index, int value) {
        if (index == 0) {
            front = new ListNode(value, front);
        } else {
            ListNode current = front;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            current.next = new ListNode(value, current.next);
        }
    }

    // Removes the element at the given index from the list.
    // Precondition: 0 <= index < size
    public void remove(int index) {
        if (index == 0) {
            // removing the first element must be handled specially
            front = front.next;
        } else {
            // removing some element further down in the list;
            ListNode current = front;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            // change its next pointer to skip past the offending node
            current.next = current.next.next;
        }
    }

    // Returns the integer value at the given index in the list.
    // Precondition: 0 <= index < size
    public int get(int index) {
        ListNode current = front;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }
    

    // TODO: your methods go here 
    public void set(int index, int value) {
    		ListNode current = front;
    		for(int i = 0; i < index + 1; i++) {
    			current = current.next; 
    		}
    		current.data = value;
    }
    
//    public int lastIndexOf(int value) {
//    		ListNode current = front;
//    		boolean valueFound = false;
//    		int loopCounter = 0;
//    		int lastIndex = 0;
//    		while(current != null) {
//    			if(current.data == value) {
//    				lastIndex = loopCounter;
//    				valueFound = true;
//    			}
//    			loopCounter++;
//    			current = current.next;
//    		}
//    		if(valueFound == false) {
//    			return -1;
//    		} else {
//    			return lastIndex;
//    		}
//    }
    
    public int lastIndexOf(int value) {
    		ListNode current =front;
    		int counter = 0;
    		int index = -1;
    		while(current != null) {
    			if(current.data == value) {
    				index = counter;
    			}
    			counter++;
			current = current.next;
    		}
    		return index;
    }

    
    public void split() {
    		ListNode current = front;
    		if(current != null) {
    			while(current.next != null) {
    				if(current.next.data >= 0) {
    					current = current.next;
    				} else {
    					current.next.next = front;

    					ListNode temporary = current.next.next;
    					front = current.next;
    					current.next = temporary;
    				}
    			}
    		}
    }

    public void doubleList() {
    		ListNode pointerFinal = front;
    		ListNode current = front; 
    		int listSize = 1;
		while(pointerFinal.next != null) {
			listSize++;
			pointerFinal = pointerFinal.next;
		}
		for(int i = 0; i < listSize; i++) {
			ListNode temporary = new ListNode(current.data);
			pointerFinal.next = temporary;
			pointerFinal = pointerFinal.next;
			current = current.next;
		}																																																																																									
    }
}
