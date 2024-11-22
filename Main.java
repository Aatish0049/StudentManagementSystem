import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.*;
import java.util.ArrayList;

public class Main {
	
	public static Scanner input = new Scanner(System.in).useLocale(Locale.US);
	
	public static void main(String[] args) {
		ArrayList<Student> students = new ArrayList<>();
		
		boolean shouldRun = true;
		
		while (shouldRun) {
			System.out.println("Enter a command (add, search, sort, view, exit): ");
			String command = input.nextLine();
			
			switch (command) {
				case "add":
					addStudent(students);
				break;
				case "search":
					searchStudents(students);
				break;
				case "sort":
					sortStudents(students);
				break;
				case "view":
					viewStudents(students);
				break;
				case "exit":
					shouldRun = false;
				break;
				default:
					System.out.println("Invalid Command");
				break;
			}
		}

	}
	
	private static void addStudent(ArrayList<Student> students) {
		System.out.println("Enter the student name: ");
		String name = input.nextLine();
		
		System.out.println("Enter the student ID: ");
		int ID = input.nextInt();
		input.nextLine();
		
		System.out.println("Enter the student email: ");
		String email = input.nextLine();
		
		while (!isValidEmail(email)) {
			System.out.println("Wrong email, try again: ");
			email = input.nextLine();
		}
		
		System.out.println("Enter the student GPA: ");
		double GPA = input.nextDouble();
		
		System.out.println("Enter the student age: ");
		int age = input.nextInt();
		
		input.nextLine();
		
		Student newStudent = new Student(name, email, ID, age, GPA);
		students.add(newStudent);
		
		System.out.println("Student added successfully");
		
	}
	
	private static boolean isValidEmail(String email) {
	    String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
	    Pattern pattern = Pattern.compile(regex);
	    Matcher matcher = pattern.matcher(email);
	    return matcher.find();
	}
	
	private static void searchStudents(ArrayList<Student> students) {
		System.out.println("Enter the student name: ");
		String name = input.nextLine();
		
		for (Student student: students) {
			if(student.getName().equals(name)) {
				System.out.println(student);
			}
		}
	}
	
	private static void sortStudents(ArrayList<Student> students) {
		System.out.println("Enter a field to sort by (name, ID, email, or GPA): ");
		String field = input.nextLine();
		
		Collections.sort(students, new StudentComparator(field));
		
		for (Student student: students) {
			System.out.println(student);
		}
	}
	
	private static void viewStudents(ArrayList<Student> students) {
		for (Student student: students) {
			System.out.println(student);
		}
	}
	
	
	

}