package com.example.springboot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimeNumberController {

	@Autowired
	CalculatePrimeNumbers calculatePrimeNumbers;
	
	@GetMapping(value="/primes/{maxNumber}", produces="application/json")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Entry<Integer, Boolean>> getAllPrimes(@PathVariable("maxNumber") Integer maxNumber) {
		Map<Integer, Boolean>  markedList = calculatePrimeNumbers.printAllPrimes(maxNumber);
		List<Entry<Integer, Boolean>> list = markedList.entrySet().stream().filter(x -> x.getValue().equals(Boolean.TRUE)).collect(Collectors.toList());
		return list; 
	}
	
	//Created as POC because of issues with geting the records from angular in array format
	@GetMapping(value="/primes2/{maxNumber}", produces="application/json")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Integer> getAllPrimes2(@PathVariable("maxNumber") Integer maxNumber) {
		//Integer[] array = new Integer[1000];
		Map<Integer, Boolean>  markedList = calculatePrimeNumbers.printAllPrimes(maxNumber);
		List<Entry<Integer, Boolean>> list = markedList.entrySet().stream().filter(x -> x.getValue().equals(Boolean.TRUE)).collect(Collectors.toList());
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list.forEach(x -> list2.add(x.getKey()));
		System.out.println(" List is " + list2);
		return list2;
	}
}
