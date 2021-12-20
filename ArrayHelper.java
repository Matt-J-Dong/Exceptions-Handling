/**
 * 
 * @author Matthew Dong
 */
public class ArrayHelper {
	
	private String[] array;
	
	/**
	 * Constructs an ArrayHelper object
	 * @param array
	 */
	public ArrayHelper(String[] array)
	{	this.array = array;		}
	
	/**
	 * Add an item to the end of this.array
	 */
	public void add(String item)
	{
		String[] arr = new String[array.length+1];
		for(int i=0;i<arr.length-1;i++) {
			arr[i]=array[i];
		}
		arr[arr.length-1]=item;
		array=arr;
		
	}
	
	/**
	 * Add an item at a given index of this.array
	 * 
	 * Throws an IllegalArgumentException if the index < 0 or 
	 * 					index > array.length
	 */
	public void add(String item, int index)
		throws IllegalArgumentException
	{
		String[] arr = new String[array.length+1];
		if(index>array.length||index<0) {
			throw new IllegalArgumentException ("Out of bounds.");
		}
		for(int i=0;i<index;i++) {
			arr[i]=array[i];
		}
		arr[index]=item;
		if(index!=arr.length-1) {
			for(int i=index+1;i<arr.length;i++) {
				arr[i]=array[i-1];
			}
		}
		array=arr;
	}
	
	/**
	 * Removes a given item from this.array.
	 * 
	 * array remains unchanged if the item is not an element of this.array.
	 * @return true if a change was made, false otherwise
	 */
	public boolean remove(String item)
	{
		String[] arr = new String[array.length-1];
		boolean change = false;
		for(int i=0;i<array.length;i++) {
			if(item.equals(array[i])) {
				change = true;
			}
			else {
				if(change==false) {
					arr[i]=array[i];
				}
				else {
					arr[i-1]=array[i];
				}
			}
		}
		array=arr;
		if(change==false) {
			return false;
		}
		return true;
	}
	
	/**
	 * Removes an item from this.array at a given index
	 * 
	 * Throws an ArrayIndexOutOfBoundsException if the index is not valid
	 * @return true if a change was made, false otherwise
	 */
	public boolean remove(int index) throws ArrayIndexOutOfBoundsException
	{
		String[] arr = new String[array.length-1];
		if(index>array.length||index<0) {
			throw new ArrayIndexOutOfBoundsException ("Out of bounds.");
		}
		for(int i=0;i<index;i++) {
			arr[i]=array[i];
		}
		for(int i=index+1;i<array.length;i++) {
			arr[i-1]=array[i];
		}
		array=arr;
		return true;
	}
	
	/**
	 * Determines if an element exists in this.array
	 * @return true if a element was found, false otherwise
	 */
	public boolean contains(String element)
	{
		for(int i=0;i<array.length;i++) {
			if(array[i]==null) {
				
			}
			else if(array[i].equals(element)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * returns the index of an element in this.array or 
	 * 					-1 if the element does not exist
	 */
	public int indexOf(String element)
	{
		for(int i=0;i<array.length;i++) {
			if(array[i]==null) {
				
			}
			else if(array[i].equals(element)) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * @return a String representation of this.array
	 */
	public String toString()
	{
		if(array.length == 0) return "{}";
		
		String str = "{";
		int i = 0;
		for( ; i < array.length - 1; i++)
		{
			if(array[i] == null)
				str += String.format("%s,", array[i]);
			else
				str += String.format("\"%s\",", array[i]);
		}
		if(array[i] == null)
			str += String.format("%s}", array[i]);
		else
			str += String.format("\"%s\"}", array[i]);
		return str;
				
	}
}
