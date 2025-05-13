package basics;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class EmployeeSort {
	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(
			    new Employee(101, "Amit", "IT", 65000.0, 28, 4),
			    new Employee(102, "Ravi", "HR", 55000.0, 32, 6),
			    new Employee(103, "Anjali", "Finance", 70000.0, 30, 5),
			    new Employee(104, "Raj", "IT", 62000.0, 26, 3),
			    new Employee(105, "Sneha", "HR", 58000.0, 29, 4),
			    new Employee(106, "Vikram", "Finance", 75000.0, 35, 9),
			    new Employee(107, "Pooja", "Sales", 53000.0, 24, 2),
			    new Employee(108, "Arjun", "Sales", 51000.0, 27, 3),
			    new Employee(109, "Neha", "IT", 68000.0, 31, 6),
			    new Employee(110, "Saurav", "HR", 59000.0, 33, 7)
			);
		
		//sorting based on names
		 System.out.println("sorting - names");
		 employees.stream()
			     .sorted(Comparator.comparing(Employee::getName))
			     .forEach(Employee::employeeName);

		 System.out.println("\ndescending - names");
		 employees.stream()
		 	      .sorted(Comparator.comparing(Employee::getName).reversed())
		 	     .forEach(e->System.out.print(e.getName()+" "));
		 
		 System.out.println("\nascending - names");
		 employees.stream()
	      .sorted((a,b)->a.getName().compareTo(b.getName()))
	     .forEach(e->System.out.print(e.getName()+" "));
		 
		 
		 
		 //age sorting
		 System.out.println("\nascending - age");
		 employees.stream()
		 	      .sorted(Comparator.comparingInt(Employee::getAge))
		 	      .forEach(e->System.out.print(e.getName()+":"+e.getAge()+" "));
		 
		 System.out.println("\ndescending - age");
		 employees.stream()
	      .sorted(Comparator.comparingInt(Employee::getAge).reversed())
	      .forEach(e->System.out.print(e.getName()+":"+e.getAge()+" "));
		 
		 
		 //normal  sorting
//		 employees.stream()
//		 	      .sorted((a,b)->Integer.compare(a.getAge(),b.getAge()))
//		 	      .toList();

		 
		 System.out.println("\nascending - salary");
		 employees.stream()
		 	      .sorted(Comparator.comparingDouble(Employee::getSalary))
		 	      .forEach(e->System.out.print(e.getName()+":"+e.getSalary()+" "));
		 
		 
		 System.out.println("\nsorting based on department then name");
		 employees.stream()
		 	      .sorted(Comparator.comparing(Employee::getDept).thenComparing(Employee::getName))
		 	      .forEach(e->System.out.print(e.getName()+","+e.getDept()+"\n"));
		 
		 System.out.println("\nsorting based on department then name using lambda");
		 employees.stream()
		 	      .sorted((a,b)->{
		 	    	  int compareTo = a.getDept().compareTo(b.getDept());
		 	    	  if(compareTo==0) {
		 	    		 return Integer.compare(a.getAge(), b.getAge());
		 	    	  }
		 	    	  return compareTo;
		 	      })
		 	      .forEach(e->System.out.print(e.getName()+":"+e.getDept()+","+e.getAge()+"\n"));
		 
		 
		 System.out.println("\nsorting based on name length");
		 employees.stream()
		 		  .sorted(Comparator.comparingInt(s->s.getName().length()))
		 		  .forEach(Employee::employeeName);
		 
	}
}
