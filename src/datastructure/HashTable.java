package datastructure;

public class HashTable {
	
	String[] dataArray;
	int size;
	int items = 0;
	HashType hashType;
	
	public HashTable(int size, HashType hashType) {
		this.size = size;
		dataArray = new String[size];
		this.hashType = hashType;
	}
	
	private int hashFunction(String value) {
		int hash = 0;
		switch(hashType) {
			case string:
				int ascisum = 0;
				for(int i=0;i<value.length();i++) {
					ascisum = ascisum + ((int)value.charAt(i));
				}
				hash = ascisum;
				break;
			case integer:
				hash = Integer.parseInt(value);
				break;
		}
		return hash % this.size;
	}
	
	public void add(String value) {
		int index = hashFunction(value);
		addV(value, index);
	}
	
	private void addV(String value, int index) {
		if(index < size) {
			if(dataArray[index] == null) {
				dataArray[index] = value;
				items++;
			} else {
				addV(value, index+1);
			}
		} else {
			System.out.println("Table is full, cannot add item!!!");
		}
	}
	
	public int get(String value) {
		if (items == 0) return -1;
		int index = hashFunction(value);
		int i = getV(value, index);
		return i;
	}
	
	private int getV(String value, int index) {
		if(index < size) {
			if(dataArray[index] == null || !dataArray[index].equals(value))
				index = getV(value, index+1);
			return index;
		}
		return -1;
	}
	
	public int totalItems() {
		return items;
	}
	
	public void displayStack() {
		System.out.println("INDEX\tVALUE");
		System.out.println("=====\t=====");
		for(int i=0;i<size;i++) {
			if(dataArray[i] != null) {
				System.out.println(i+"\t"+dataArray[i]);
			} else {
				System.out.println(i+"\t");
			}
			System.out.println("-----\t-----");
		}
	}
	
	public enum HashType{
		string ("string"),
		integer ("integer");
		
		private final String name;
		
		private HashType(String name) {
			this.name = name;
		}
		
		public String getType() {
			return this.name;
		}
	}
	
	public static void main(String[] args) {
		HashTable table = new HashTable(10, HashType.string);
		table.add("Bob");
		table.add("Ace");
		table.add("Alex");
		table.add("Yahn");
		table.add("Janu");
		table.add("Kdd");
		table.add("uet");
		table.displayStack();
		//System.out.println("Alex at "+table.get("Alex"));
		//System.out.println("uet at "+table.get("uet"));
	}
	
}
