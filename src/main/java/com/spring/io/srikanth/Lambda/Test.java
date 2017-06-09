package com.spring.io.srikanth.Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;
/**
 * @author D123577
 *
 */
public class Test {



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to testing ecllipse...!");
		GreetingService gs1 = (message) -> System.out.println("java 8 lamda expressions " + message);
		gs1.sayMessage("hi");

		List<String> names = new ArrayList<String>();

		names.add("Mahesh");
		names.add("Suresh");
		names.add("Ramesh");
		names.add("SriKanth");
		names.add("Kalpesh");

		names.forEach(System.out::println);

		List<String> country = Arrays.asList("USA", "India", "Russia", "Japan", "England", "Germany");

		country.forEach(System.out::println);

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		DoublingNumber dn = (Integer i) -> i * 2;

		list.forEach(integer -> System.out.println(dn.doubleNumber(integer)));

		// Method references
		System.out.println(list.stream().reduce(0, Integer::sum));

		// Function Composition
		// given the values ,double the even numbers and total
		System.out.println(list.stream().filter(e -> e % 2 == 0).mapToInt(e -> e * 2).sum());

		System.out.println(list.parallelStream().filter(e -> e % 2 != 0).mapToInt(Test::compute).sum());
		
		//lamdas are cool,but streams are awesome
		//stream as abstraction
		//Non mutating pipeline
		
		//Stream Operations
		//filter
		// Streams important
		// filter
		// parameter: Stream <T> filter takes Predicate Interface<T>
		
		// Map is a transforming function number of input == number of input
		// parameter : stream<T> map takes Function<T,R> to return Stream<R>

		// both filter and map stay within their swimlanes

		// reduce cut across the swimlanes
		
		//double the even values and put that into a list
		//shared mutation
		//import static java.util.stream.Collectors.*;
		List<Double> doubleList = list.stream()
			.filter(e->e%2==0)
			.map(e->e*2.0)
			.collect(toList());
		
		System.out.println(doubleList);
		
		//collect is a reduced operation
		List<Person> people = createPeople();
		
		/*System.out.println(people.stream()
				.collect(toMap(
						person -> person.getName()+"-"+person.getAge(),
						person -> person)));*/
		//given a list of people,create a map where their name is the key and value is all the people with that name
		System.out.println(people.stream()
		.collect(groupingBy(Person::getName,
				mapping(Person::getAge,toList()))));
		
		Collections.sort(people,(p1,p2) -> p1.getName().compareTo(p2.getName()));
		
		people.forEach(System.out::println);
		
		System.out.println(people.parallelStream()
				.filter(person -> person.getName().startsWith("k"))
				.collect(toList()));
		
		List<Integer> number = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11,12,13,14,15,16,17,18,19,20);
		
		System.out.println(number.stream()
									.filter(e -> e >3)
									.filter(e -> e%2 ==0)
									.map(e -> e*2)
									.findFirst()); //findFirst() is the terminal operations
		//intermediate operations
		//terminal operations
		
		//limit
		
		System.out.println(Stream.iterate(100, e ->e+1)
				.limit(300)
				.filter(e ->e%2 ==0)
				.collect(toList()));
		System.out.println(people.parallelStream()
				.filter(e -> e.getName().startsWith("B"))
				.collect(toList()));
		
		System.out.println(people.parallelStream()
				.filter(e -> e.getName().startsWith("k"))
				.collect(mapping(Person::getName,toList())));
		
		 List<String> alpha = Arrays.asList("a", "b", "c", "d");
		  
		 List<String> countrys = Arrays.asList("Indonesia","USA", "India", "Russia", "Japan", "England", "Germany","ICE-LAND");
		
		//print all country name start with "I"
		 System.out.println(countrys.stream()
		 .filter(e ->e.startsWith("I"))
		 .collect(toList()));
		 
		 System.out.println(countrys.stream()
		 			.filter(e -> e.startsWith("I"))
		 			 .count());
	}

	/**
	 * @author D123577
	 *
	 */
	interface GreetingService {
		void sayMessage(String message);
	}

	interface DoublingNumber {
		Integer doubleNumber(Integer i);
	}

	public static int compute(int i) {
		return i * 2;
	}
	
	public static List<Person> createPeople(){
		return Arrays.asList(
				new Person("king","Male",25),
				new Person("Jackson","Male",28),
				new Person("Volcano","Female",29),
				new Person("kingKong","Female",34),
				new Person("king","Male",35),
				new Person("Lionking","Female",82),
				new Person("king","Male",25),
				new Person("Jackson","Male",28),
				new Person("Volcano","Female",29),
				new Person("kingKong","Female",34),
				new Person("king","Male",35),
				new Person("Bing","Male",35));
	}
	
	public static String getKeys(){
		return UUID.randomUUID().toString();
	}
	
	
}
