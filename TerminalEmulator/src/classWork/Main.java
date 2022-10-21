package classWork;

import java.io.File;
import java.util.Scanner;

public class Main {
	
	
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Terminal badre = null;
		String option= "";
		
		while(true) {
			System.out.println("root@root:$");
			option = sc.nextLine().toLowerCase().trim().replaceAll("\\s","");

			
			if (option.startsWith("ls")) {
				option = option.substring(2, option.length());
				badre = new Terminal(option);
				System.out.println(badre.lsCommando()); 
			}
			
			
		}
	}

}
