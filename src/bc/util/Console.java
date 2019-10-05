package bc.util;

import java.util.Scanner;

public class Console implements IConsole {

	private Scanner sc = new Scanner(System.in);

	@Override
	public String getString(String prompt) {

		// prompt user for any string where entry is required

		System.out.print(prompt);
		return sc.nextLine();
	}

	@Override
	public int getInt(String prompt) {

		// prompt user for any integer value

		int i = 0;
		boolean isValid = false;
		while (!isValid) {
			System.out.print(prompt);
			if (sc.hasNextInt()) {
				i = sc.nextInt();
				isValid = true;
			} else {
				System.out.println("Invalid number. Please try again.");
			}
			sc.nextLine();
		}
		return i;
	}

	@Override
	public int getIntWithinRange(String prompt, int min, int max) {

		// prompt user for an integer value within a range

		int i = 0;
		boolean isValid = false;
		while (!isValid) {
			i = getInt(prompt);
			if (i < min) {
				System.out.println("Number must be equal to or greater than " + min + ".");
			} else if (i > max) {
				System.out.println("Number must be equal to or less than " + max + ".");
			} else {
				isValid = true;
			}
		}
		return i;
	}

	@Override
	public double getDouble(String prompt) {

		// prompt user for any double value

		double d = 0;
		boolean isValid = false;
		while (!isValid) {
			System.out.print(prompt);
			if (sc.hasNextDouble()) {
				d = sc.nextDouble();
				isValid = true;
			} else {
				System.out.println("Invalid number. Please try again.");
			}
			sc.nextLine();
		}
		return d;
	}

	@Override
	public double getDoubleWithinRange(String prompt, double min, double max) {

		// prompt user for a double value within a range

		double d = 0;
		boolean isValid = false;
		while (!isValid) {
			d = getDouble(prompt);
			if (d < min) {
				System.out.println("Number must be equal to or greater than " + min + ".");
			} else if (d > max) {
				System.out.println("Number must be equal to or less than " + max + ".");
			} else {
				isValid = true;
			}
		}
		return d;
	}

	@Override
	public boolean userWantsToContinue(String prompt, String yes, String no) {

		// see if the user wants to continue

		boolean wantsToContinue = false;
		boolean isValid = false;
		while (!isValid) {
			System.out.print(prompt);
			String choice = sc.next();

			if (!choice.equalsIgnoreCase(yes) && !choice.equalsIgnoreCase(no)) {
				System.out.println("Please enter " + yes + " to continue or " + no + " to quit.");

			} else if (choice.equalsIgnoreCase(yes)) {
				isValid = true;
				wantsToContinue = true;
				sc.nextLine();
				System.out.println();

			} else {
				isValid = true;
				wantsToContinue = false;
				sc.nextLine();
				System.out.println();
			}
		}
		return wantsToContinue;
	}

	@Override
	public String askToContinue() {
		boolean isValid = false;
		String choice = "";
		while (!isValid) {
			System.out.print("Continue? (y/n): ");
			choice = sc.nextLine();
			if (!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n")) {
				System.out.println("Enter \"y\" to continue or \"n\" to quit.");
				continue;
			}
			isValid = true;
		}
		return choice;
	}
}