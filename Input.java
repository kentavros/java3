package app.task3;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class Input {
	
	public static ArrayList <HashMap <String, Integer>> getInput() {
		System.out.println("Welcom! Enter the host address or its name to verify availability. (Example: google.com)");
		
		Scanner in = new Scanner(System.in);
		ArrayList <HashMap <String, Integer>> addresses = new ArrayList<>();
		String answer = "y";
		
		do {
			System.out.println("Input address: ");
			String address = in.nextLine();
			System.out.println("Input priority (1 -min, 2 -normal or 3 -max): ");
			
			String strPriority = in.nextLine();
			int x = Integer.parseInt(strPriority);
			Integer priority;
			if (x >= 1 && x <= 3) {
				priority = x;
			} else {
				priority = 1;
				System.out.println("Invalid priority - priority will be set by default = 1");
			}
			
			HashMap <String, Integer> addressAndPriority = new HashMap<>();
			addressAndPriority.put(address, priority);
			addresses.add(addressAndPriority);
			System.out.println("Add more (y / n or press Enter)?: ");
			answer = in.nextLine();
			if (!answer.equals("y")) {
				System.out.println("Start ...");
			}
		}
		while (answer.equals("y"));
		
		in.close();
		return addresses;
	}
}