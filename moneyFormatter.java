package formatter;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class moneyFormatter {

	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		double payment = scan.nextDouble();
		scan.close();
		
		String us = NumberFormat.getCurrencyInstance(Locale.US).format(payment);
		String china = NumberFormat.getCurrencyInstance(Locale.CHINA).format(payment);
		String France = NumberFormat.getCurrencyInstance(Locale.FRANCE).format(payment);
		
		String india = NumberFormat.getCurrencyInstance(new Locale("en", "in")).format(payment);
		
		System.out.println("US: " + us);
		System.out.println("India: " + india);
		System.out.println("China: " + china);
		System.out.println("France: " + France);
		
	}

}
