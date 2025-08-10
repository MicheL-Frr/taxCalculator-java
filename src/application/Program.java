package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<TaxPayer> list = new ArrayList<>();

		System.out.print("Enter the number of tax payers: ");
		int N = sc.nextInt();
		sc.nextLine();

		for (int i = 1; i <= N; i++) {
			System.out.println();
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			char taxType = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			double anuallncome = sc.nextDouble();
			sc.nextLine();
			if (taxType == 'i') {
				System.out.print("Health expenditures: ");
				double healthExpenditures = sc.nextDouble();
				sc.nextLine();
				list.add(new Individual(name, anuallncome, healthExpenditures));
			} else {
				System.out.print("Number of employees: ");
				int numberOfEmployees = sc.nextInt();
				sc.nextLine();
				list.add(new Company(name, anuallncome, numberOfEmployees));
			}
		}

		System.out.println();
		for (TaxPayer taxPayer : list) {
			System.out.println(taxPayer);
		}
		
		double sum = 0;
		for (TaxPayer taxPayer : list) {
			sum += taxPayer.tax();
		}
		
		System.out.println();
		System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sum));
	}

}
