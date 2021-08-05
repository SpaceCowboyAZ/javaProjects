package fileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Reader {

	public static void main(String[] args) throws FileNotFoundException {
	
		File file = new File("C:\\Users\\dylan\\Downloads");
				Scanner scan = new Scanner(file);
		System.out.println(scan.nextLine());

	}

}
