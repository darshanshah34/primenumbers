package com.example.springboot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;

import org.junit.jupiter.api.Test;


class TestPrimeNumbers {

	@Test
	void testPrimeMain() {
		CalculatePrimeNumbers tm = new CalculatePrimeNumbers();
		HashMap<Integer, Boolean>  markedList = (HashMap<Integer, Boolean>) tm.printAllPrimes(1000);
		assertEquals(Boolean.TRUE, markedList.get(29));
		assertEquals(Boolean.TRUE, markedList.get(1001));
		assertEquals(Boolean.FALSE, markedList.get(52));
		assertEquals(Boolean.FALSE, markedList.get(56));
		assertEquals(Boolean.FALSE, markedList.get(91));
		assertEquals(Boolean.TRUE, markedList.get(853));
		assertEquals(Boolean.TRUE, markedList.get(751));
	}
}
