package app.task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MyMultiThread {
	private static final long TIME_WORK = 60;
	private static int j;
	private static final long TIME = System.currentTimeMillis()/1000 + TIME_WORK;
	private static ArrayList <Thread> myThreads = new ArrayList<>();
	
	public static void go(ArrayList<HashMap <String, Integer>> addressesWithPriorities) {

		for (int i=0; i < addressesWithPriorities.size(); i++) {
			j=i;
			HashMap <String, Integer> addressAndPriority = new HashMap <String, Integer>();
			addressAndPriority = addressesWithPriorities.get(i);
			for (Map.Entry<String, Integer> entry : addressAndPriority.entrySet())
			{
				myThreads.add(new Thread(new Runnable() {
					private int numberT = 1 + j; 
					public void run() {
						do {
							if (TIME < System.currentTimeMillis()/1000) {
								finish();
							}
							if(!Thread.interrupted()) {
								Ping p = new Ping(entry.getKey());
								p.verifyTheAvailability();
								System.out.println("Thread#: " + numberT + " TimeStamp: " + p.getTime() + " Status <" + p.getReach()+"> " + "Host: " + p.getAddress() + " ");
								
								try {
									Thread.sleep(5000);
								} catch (InterruptedException e) {
									return;
								}
								
							} else {
								return;
							}
						}
						while (true);	
					}
				}));
				myThreads.get(i).setName(entry.getKey());
				myThreads.get(i).setPriority(PriorityValue(entry.getValue()));
				myThreads.get(i).start();
			}
		}
	}
	
	private static void finish() {
		for (Thread t : myThreads) {
			t.interrupt();
		}
		System.out.println("The work is done!");
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
