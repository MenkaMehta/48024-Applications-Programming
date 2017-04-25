import java.util.*;
import java.io.*;

public class ExceptionsTest {
	public static void main(String[] args) throws Exception {
		String fileName = readFileName();
		if (ask("Do you want to catch exceptions?"))
			runWithCatch(fileName);
		else
			runWithThrow(fileName);
	}

	public static void runWithThrow(String fileName) throws FileNotFoundException,
				 NoSuchElementException, NumberFormatException, ArithmeticException {
		Scanner scanner = new Scanner(new File(fileName));
		int a = Integer.parseInt(scanner.nextLine());
		int b = Integer.parseInt(scanner.nextLine());
		int div = a / b;
		System.out.println(a + " / " + b + " = " + div);
	}

	public static void runWithCatch(String fileName) {
		try (Scanner scanner = new Scanner(new File(fileName))) {
			int a = Integer.parseInt(scanner.nextLine());
			int b = Integer.parseInt(scanner.nextLine());
			int div = a / b;
			System.out.println(a + " / " + b + " = " + div);
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found: " + fileName);
		}
		catch (NoSuchElementException e) {
			System.out.println("Not enough lines: " + fileName);
		}
		catch (NumberFormatException e) {
			System.out.println("Incorrect number format: " + e.getMessage());
		}
		catch (ArithmeticException e) {
			System.out.println("Cannot divide by zero");
		}
	}

	private static String readFileName() {
		System.out.println("Available files:");
		System.out.println("file1.txt");
		System.out.println("file2.txt");
		System.out.println("file3.txt");
		System.out.println("file4.txt");
		System.out.print("Enter file name: ");
		return In.nextLine();
	}

	private static boolean ask(String question) {
		System.out.print(question + " ");
		return In.nextLine().toLowerCase().startsWith("y");
	}
}
