package basics;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Mapping {
	public static void main(String[] args) {
		List<String> names=Arrays.asList("rock","mike","john","wick","smith","kevin");
		List<Integer> numbers = Arrays.asList(2, 3, 4, 5,9,11);
		
		//map function for converting names to upper case
		//returns new stream of upper case letters
		List<String> list = names.stream()
								 .map(name->name.toUpperCase())
								 .toList();
		System.out.println(list);
		
		//converting only first letter
		List<String> list2 = names.stream()
 							   	 .map(name->name.substring(0, 1).toUpperCase()+name.substring(1))
								 .toList();
		System.out.println(list2);
		
		//convert strings to lengths
		List<String> list3 = names.stream()
									 .map(name->name+":"+name.length())
									 .toList();
		System.out.println(list3);
		
		Map<String, Integer> list4 = names.stream()
//				 .map(name->name+":"+name.length())
				 .collect(Collectors.toMap(
						 name->name,
						 name->name.length()
						 ));
		System.out.println(list4);
		
		//using method reference
		List<String> list5 = names.stream()
							 .map(String::toUpperCase)
							 .toList();
		System.out.println(list5);
		
		
		//applying square function
		List<Integer> list6 = numbers.stream()
									   .map(number->number*number)
									   .toList();
		System.out.println(list6);
		
		//finding square root function
		
		List<Double> list7 = numbers.stream()
							   .map(Math::sqrt)
							   .toList();
		System.out.println(list7);
		
		List<String> list8 = names.stream()
							     .filter(name->name.startsWith("m"))
							     .map(name->name.toUpperCase())
							     .toList();
		System.out.println(list8);
		
		//count strings with vowels
		long count = names.stream()
			 .filter(Mapping::hasVowel)
			 .map(name->name.toUpperCase())
			 .count();
		System.out.println(count);
		
		
		//method for finding vowels in each string
		
		Map<String, Integer> vowles = names.stream()
									 .collect(Collectors.toMap(
											 	name->name,
											 	Mapping::countVowels
											 ));
		System.out.println(vowles);
		
	}
	
	 public static boolean hasVowel(String name) {
	        for (char ch : name.toLowerCase().toCharArray()) {
	            if ("aeiou".indexOf(ch) != -1) {
	                return true;
	            }
	        }
	        return false;
	  }
	 
	 public static Integer countVowels(String name) {
		 int count=0;
	        for (char ch : name.toLowerCase().toCharArray()) {
	        	
	            if ("aeiou".indexOf(ch) != -1) {
	                count++;
	            }
	        }
	        return count;
	  }
}
