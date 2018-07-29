package test.code.main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import datastructure.HashTable;
import datastructure.HashTable.HashType;

class HashTest {

	@Test
	void test() {
		HashTable table = new HashTable(10, HashType.string);
		table.add("Bob");
		table.add("Ace");
		table.add("Alex");
		table.add("Yahn");
		table.add("Janu");
		table.add("Kdd");
		table.add("uet");
		assertEquals(0, table.get("Yahn"));
		assertNotEquals(-1, table.get("Bob"));
		assertEquals(9, table.get("uet"));
	}

}
