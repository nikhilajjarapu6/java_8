package basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Sorting {
	public static void main(String[] args) {
		 List<String> names = Arrays.asList("Amit", "Ravi", "Anjali", "Raj", "Arjun", "Vikas");
		 
		 ArrayList<String> al=new ArrayList<>(names);
	
		 //normal sorting
		 al.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		});
		 System.out.println(names);
		 
		 //normal sorting based on two conditions
		 al.sort(new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					int compareTo = Integer.compare(o1.length(),o2.length());
					if(compareTo==0)
						return o1.compareTo(o2);
					return compareTo;
				}
			});
		 
		 System.out.println(al);
		 
		 //using streams
		 List<String> list = al.stream()
							   .sorted()
							   .toList();
		 System.out.println(list);
		 
		 //using custom comparator to reverse
		 List<String> list2 = al.stream()
		   .sorted(Comparator.reverseOrder())
		   .toList();
		 System.out.println(list2);
		
		 //comparator
		 //sorting based on length and name
		 List<String> list3 = al.stream()
		   .sorted(Comparator.comparingInt(String::length).thenComparing(String::compareTo))
		   .toList();
		 System.out.println(list3);
		 
		 //sorting string by last second  character
		 List<String> list4 = al.stream()
		   .sorted(Comparator.comparing(s-> s.charAt(s.length()-2)))
		   .toList();
		 System.out.println(list4);
	}
}
