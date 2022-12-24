package com.daya.learn.JavaStreaming;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo {

	private final Logger logger = Logger.getLogger(
			StreamDemo.class.getName());
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StreamDemo s = new StreamDemo();
		//s.mapStream();
		//s.flatStream();
		//s.sortedElements();
		s.sortedComparator();
		s.sortedStringComparator();
	}
	
	public void mapStream() {
		Stream<String> prodcutCategory = Stream.of("Washing Machine","Television","Laptop","Grocery","essentials");
		
		List<String> categoryCode = prodcutCategory.map(key->{
			String code = null;
			switch (key) {
			case "Washing Machine":code = key+":1";break;
			case "Television":code = key+":2";break;
			case "Laptop":code = key+":3";break;
			case "Grocery":code = key+":4";break;
			case "essentials":code = key+":5";break;
			default:code = key+":6";break;
			}
			return code;
		}).collect(Collectors.toList());
		
		categoryCode.forEach(System.out::println);
		/*
		 	Washing Machine:1
			Television:2
			Laptop:3
			Grocery:4
			essentials:5
		 */
		
	}
	
	public void flatStream() {
		
		List<List<String>> prodcutCategories = Arrays.asList(
				Arrays.asList("washing machine", "Television"),
				Arrays.asList("Laptop", "Camera", "Watch"), 
				Arrays.asList("grocery", "essentials"));
		
		List<String> products = prodcutCategories
				.stream()
				.flatMap(Collection::stream)
				.collect(Collectors.toList());
		
		//products.forEach(logger::info);
		logger.info("Flattened Map:"+products);
		/*
		washing machine
		Television
		Laptop
		Camera
		Watch
		grocery
		essentials
		*/
	}
	
	public void sortedElements() {
		Stream<Integer> integerStream = Stream.of(3, 4, 6, 2);
		Stream<Integer> inStream = integerStream.sorted();
		inStream.forEach(System.out::println);
		/*
		 	2
			3
			4
			6
		 */
	}
	
	public void sortedComparator() {
		Stream<Integer> integerStream = Stream.of(3, 4, 6, 2);
		Stream<Integer> inStream = integerStream.sorted((e1,e2)->e2-e1);
		inStream.forEach(System.out::println);
		/*
		 	6
			4
			3
			2
		 */
	}
	
	public void sortedStringComparator() {
		Stream<String> integerStream = Stream.of("washing machine", "Television", "Laptop", "Camera", "Watch", "grocery", "essentials");
		Stream<String> inStream = integerStream.sorted((e1,e2)->e2.compareToIgnoreCase(e1));
		inStream.forEach(System.out::println);
		/*
		 	Watch
			washing machine
			Television
			Laptop
			grocery
			essentials
			Camera
		 */
	}
	
	
	
}
