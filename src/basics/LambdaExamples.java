package basics;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LambdaExamples {
	public static void main(String[] args) {
		List<String> names=List.of("rock","john","mike");
		
		
		Function<String, String> toLower=str->str.toUpperCase();
		String apply = toLower.apply(names.get(1));
		System.out.println(apply);
		
		System.out.println("1. Traditional for-each loop:");
		for(String str:names) {
			System.out.println(str);
		}
		
		//iteration
		System.out.println("2.for-each loop:");
		names.forEach((str)->{
			System.out.println(str.toUpperCase());
		});
		
		System.out.println("3.using method reference");
		names.forEach(System.out::println);
		
		List<String> collect = names.stream()
			 .filter(str->str.startsWith("r"))
			 .collect(Collectors.toList());
		System.out.println(collect);
		
		
		//mapping
		
		List<String> collect2 = names.stream()
			 .map(str->str.toUpperCase())
			 .collect(Collectors.toList());
		System.out.println(collect2);
		
		
	}
}
