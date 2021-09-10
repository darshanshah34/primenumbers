package com.example.springboot;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class CalculatePrimeNumbers {

	private static final Boolean MARKED = Boolean.TRUE;
	private static final Boolean UN_MARKED = Boolean.FALSE;
	
	int maxNumber;
	HashMap<Integer, Boolean>  markedList = new HashMap<Integer, Boolean>();
	private static HashMap<Integer, Boolean>  primeList = new HashMap<Integer, Boolean>();
	
	public CalculatePrimeNumbers(int maxNumber) {
		super();
		this.maxNumber = maxNumber;
	}

	public int getMaxNumber() {
		return maxNumber;
	}

	public void setMaxNumber(int maxNumber) {
		this.maxNumber = maxNumber;
	}

	public CalculatePrimeNumbers() {
		super();
		
	}
	
	public Map<Integer, Boolean> printAllPrimes(int maxNumber) {
		int markedNumber = 2;
		System.out.println("new prime is " + markedNumber);
		//mark all as prime for now
		for (int i =2 ; i<= maxNumber ; i++ )  {
			markedList.put(i, UN_MARKED);
			primeList.put(i, UN_MARKED);
		}
		markedList.put(2, UN_MARKED);
		int i =2;
 		while(markedNumber <= maxNumber) {
 			markMultiples(maxNumber, markedNumber);
 			markedNumber = markedNumber + i++;
 			markedNumber = findTheSmallestLessThanP(markedList, markedNumber, maxNumber);
 			System.out.println("new prime is " + markedNumber);
 			primeList.put(markedNumber, MARKED);
 		}
 		return primeList;
	}

	private void markMultiples(int maxNumber, int markedNumber) {
		//mark the multiples of markedNumber 
		for (int i =1 ; i<= maxNumber ; i++ )  {
			int multiple = i*markedNumber;
			markedList.put(multiple, MARKED);
		}
	}
	
	private static int findTheSmallestLessThanP(HashMap<Integer, Boolean>  markedList, int markedMax, int maxNumber) {
		System.out.println("findTheSmallestLessThanP markedMax " + markedMax);
		if (markedMax >= maxNumber) {
			System.out.println("Need to end here");
			return maxNumber+1;
		}
		System.out.println("findTheSmallestLessThanP markedMax " + markedMax);
		for (int j=2; j<=markedMax; j++)  {
			if (markedList.get(j).equals(UN_MARKED)) {
				return j;
			}
		}
		return markedMax;
	}
}
