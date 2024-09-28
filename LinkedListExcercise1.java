/*Given two lists, concatenate the second list in reverse order to the end of the first list and return the concatenated list. Implement the logic inside concatenateLists() method.

Note: Use descendingIterator() method to iterate over the elements in reverse order.

Test the functionalities using the main() method of the Tester class.*/

import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

class Tester {
    
    public static List<Object> concatenateLists(List<Object> listOne, List<Object> listTwo) {
		// Create a new list to store the concatenated result
		List<Object> concatenatedList = new LinkedList<>(listOne);
		
		// Use descendingIterator to iterate over listTwo in reverse order
		Iterator<Object> iterator = ((LinkedList<Object>) listTwo).descendingIterator();
		while (iterator.hasNext()) {
			concatenatedList.add(iterator.next());
		}
		
		return concatenatedList;
	}

	public static void main(String args[]) {
		List<Object> listOne = new LinkedList<Object>();
		listOne.add("Hello");
		listOne.add(102);
		listOne.add(25);
		listOne.add(38.5);
		
		List<Object> listTwo = new LinkedList<Object>();
		listTwo.add(150);
		listTwo.add(200);
		listTwo.add('A');
		listTwo.add("Welcome");
		
		List<Object> concatenatedList = concatenateLists(listOne, listTwo);
		
		System.out.println("Concatenated linked list:");
		for (Object value : concatenatedList) {
			System.out.print(value + " ");
		}
	}
}
