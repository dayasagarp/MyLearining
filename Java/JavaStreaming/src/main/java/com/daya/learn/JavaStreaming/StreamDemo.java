package com.daya.learn.JavaStreaming;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;
import java.util.stream.Collectors;
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
		//s.sortedComparator();
		//s.sortedStringComparator();
		//s.filterAnyMatch();
		//s.filterAllMatch();
		//s.filterNoneMatch();
		//s.streamFilter();
		//s.findFirstStream();
		//s.findAnyStream();
		//s.joinStringReduce(",");
		//s.joinIntReduce();
		//s.generateStreamingData();
		//s.iterateStreamingData();
		s.parallelStream();
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
	
	public void filterAnyMatch() {
		String[] list = {"washing machine", 
		                 "Television", 
		                 "grocery", 
		                 "essentials", 
		                 "Laptop",
		                 "Television", 
		                 "grocery", 
		                 "essentials", 
		                 "Laptop",
		                 "Television", 
		                 "grocery", 
		                 "essentials",
		                 "Television", 
		                 "grocery",  
		                 "Laptop",
		                 "essentials",
		                 "Television", 
		                 "grocery", 
		                 "essentials",
		                 "Television", 
		                 "Laptop",
		                 "grocery", 
		                 "essentials",
		                 "Television", 
		                 "grocery", 
		                 "essentials",
		                 "Laptop"}; 
        Stream<String> productCategories = Stream.of(list);
        long before = System.nanoTime();
        System.out.println(productCategories.anyMatch(e -> e.contains("Laptop")));
        long after = System.nanoTime();
        System.out.println(after-before);
        
        productCategories = Stream.of(list);
        
        before = System.nanoTime();
        System.out.println(productCategories.filter(e -> e.contains("Laptop")).count()>0);
        after = System.nanoTime();
        System.out.println(after-before);
	}
	
	
	public void filterAllMatch() {
		Integer[] noArray = {3,4,5,7,9,4}; 
        Stream<Integer> numbers = Stream.of(noArray);
        long before = System.nanoTime();
        System.out.println(numbers.allMatch(e -> e<9));
        long after = System.nanoTime();
        System.out.println(after-before);
        
	}
	

	
	public void filterNoneMatch() {
		Integer[] noArray = {3,1,5,7,9,11}; 
        Stream<Integer> numbers = Stream.of(noArray);
        long before = System.nanoTime();
        System.out.println(numbers.noneMatch(e -> e%2==0));
        //System.out.println(numbers.allMatch(e -> e%2!=0));
        long after = System.nanoTime();
        System.out.println(after-before);
        
	}

	
	public void streamFilter() {
		Integer[] noArray = {3,1,5,7,9,11,2,6,4,8,6}; 
        Stream<Integer> numbers = Stream.of(noArray);
        long before = System.nanoTime();
        numbers.filter(e -> e%2==0).forEach(e->System.out.println(e));
        //System.out.println(numbers.allMatch(e -> e%2!=0));
        long after = System.nanoTime();
        System.out.println(after-before);
        
	}
	
	  public void findFirstStream() {
	        Stream<String> productCategories = Stream.of(
	                                                  "washing machine", 
	                                                  "Television", 
	                                                  "Laptop", 
	                                                  "grocery", 
	                                                  "essentials");

	        Optional<String> category = productCategories.findFirst();

	        if(category.isPresent()) 
	        	System.out.println(category.get());
	    }
	  
	  public void findAnyStream() {
	        Stream<String> productCategories = Stream.of(
	                                                  "washing machine", 
	                                                  "Television", 
	                                                  "Laptop", 
	                                                  "grocery", 
	                                                  "essentials");

	        Optional<String> category = productCategories.findAny();

	        if(category.isPresent()) 
	        	System.out.println(category.get());
	    }
	
	  
	    public void joinStringReduce(final String separator){
	        String[] strings = { "washing machine", 
                    "Television", 
                    "Laptop", 
                    "grocery", 
                    "essentials"};
	        
	        Optional<String> joined = Arrays.stream(strings).reduce((a,b)->!"".equals(a)?a+separator+b:b);
	        if(joined.isPresent()) {
	        	System.out.println(joined.get());
	        }
	    }
	    
	    public void joinIntReduce(){
	    	Integer[] noArray = {3,1,5,7,9,11,2,6,4,8,6}; 
	        
	        Optional<Integer> joined = Arrays.stream(noArray).reduce((a,b)->a+b);
	        if(joined.isPresent()) {
	        	System.out.println(joined.get());
	        }
	    }
	    
	    
	    public void generateStreamingData(){
	        Stream.generate(()->UUID.randomUUID().toString())
	        .limit(10)
	        .forEach(System.out::println);
	    }
	    
	    public void iterateStreamingData() {
	    	Stream<Double> evenNumStream = Stream.iterate(2.0, e -> Math.pow(e, 2.0));
	    	evenNumStream.limit(8).forEach(System.out::println);
	    	
	    	Stream<Integer> evenNumStream1 = Stream.iterate(1, e -> e+e);
	    	evenNumStream1.limit(8).forEach(System.out::println);
	    			
	    }
	    
	    public void parallelStream() {
	    	List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4,1, 2, 3, 4,1, 2, 3, 4,1, 2, 3, 4);
	    	long before = System.nanoTime();
	    	listOfNumbers.stream().forEach(number ->
	    	    System.out.println(number + " " + Thread.currentThread().getName()));
	    	long after = System.nanoTime();
	        System.out.println(after-before);
	    	
	    	
	        before = System.nanoTime();
	        listOfNumbers.stream().parallel().forEach(number ->
    	    System.out.println(number + " " + Thread.currentThread().getName()));
	        after = System.nanoTime();
	        System.out.println(after-before);
	    }
}

