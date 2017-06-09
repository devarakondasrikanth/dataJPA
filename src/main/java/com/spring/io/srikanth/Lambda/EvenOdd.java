package com.spring.io.srikanth.Lambda;

import java.util.Arrays;
import java.util.List;

public class EvenOdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> numberList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		System.out.println(numberList
				.stream()
				.reduce(0,Integer::sum)
				);
		PrintEven pe = (Integer i) ->{
			if(i%2 ==0){
				System.out.println("even number "+i);
			}
		};
		numberList.forEach(e -> pe.printEven(e));	
		
		Factorial fact = (number) ->{
			int f =1;
			if(number > 0){
				while(number > 0){
					f = f*number;
					number--;
				}
				return f;
			}
			return 0;
		};
		
		System.out.println(fact.fact(6));
		
	}
	
	interface PrintEven{
		void printEven(Integer i);
	}
	
	interface Factorial{
		int fact(Integer i);
	}
	public static void PrintOdd(Integer number){
		if(number%2 != 0){
			System.out.println("odd number "+number);
		}
	}
	
	public static int Factorail(){
		int number = 5;
		int fact =1;
		if(number > 0){
			while(number > 0){
				fact = fact*number;
				number--;
			}
			return fact;
		}
		return 0;
	}

}
