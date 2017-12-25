package app.task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MyMultiThread {
	
	private static int j;
	
	public static void go(ArrayList<HashMap <String, Integer>> addressesWithPriorities) {

		System.out.println(addressesWithPriorities);
		ArrayList <Thread> myThreads = new ArrayList<>();
		
		for (int i=0; i < addressesWithPriorities.size(); i++) {
			j=i;
			
			HashMap <String, Integer> addressAndPriority = new HashMap <String, Integer>();
			addressAndPriority = addressesWithPriorities.get(i);
			for (Map.Entry<String, Integer> entry : addressAndPriority.entrySet())
			{
				myThreads.add(new Thread(new Runnable() {
					public int index = j;
					
					public void run() {
						System.out.println("111111");
					}
				}));
				myThreads.get(i).setName(entry.getKey());
				myThreads.get(i).setPriority(PriorityValue(entry.getValue()));
				myThreads.get(i).start();
				
//				System.out.println(entry.getKey());
//				System.out.println(entry.getValue());
			}
			
//			System.out.println(addressesWithPriorities.get(i).keySet());
//			System.out.println(addressesWithPriorities.get(i).values());
//			HashMap <String, Integer> addressAndPriority = new HashMap <String, Integer>();
//			addressAndPriority = addressesWithPriorities.get(i);
			
//			for (Map.Entry<String, Integer> entry : addressAndPriority.entrySet())
//			{
				
//				System.out.println(entry.getKey());
//				System.out.println(entry.getValue());
//			}
			
//			System.out.println(addressAndPriority.values());
		}
		

//		for (int i=0; i< addresses.size(); i++) {
//			j = i;
//
//			names.add(new Thread(new Runnable() {
//				public int index = j;
//				
//				public void run() {
//					System.out.println(addresses.get(index));
//				}
//				
//			}));
//			names.get(i).setName(addresses.get(i));
//			names.get(i).start();
//		}
		
		

	}
	
	
	private static int PriorityValue(int i) {
		int prior = 1;
		switch (i) {
			case 1:
				prior = Thread.MIN_PRIORITY;
				break;
			case 2:
				prior = Thread.NORM_PRIORITY;
				break;
			case 3:
				prior = Thread.MAX_PRIORITY;
				break;
		}
		return prior;
	}
	
	
}
