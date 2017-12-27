package app.task3;

import java.net.InetAddress;

public class Ping {

	private String address;
	private long time;
	private String reach;
	
	public String getAddress() {
		return address;
	}
	private void setAddress(String address) {
		this.address = address;
	}
	public long getTime() {
		return time;
	}
	private void setTime(long time) {
		this.time = time;
	}
	public String getReach() {
		return reach;
	}
	private void setReach(String reach) {
		this.reach = reach;
	}
	
	public Ping(String address) {
		this.setAddress(address);
	}
	
	public void verifyTheAvailability() {
		this.setTime(System.currentTimeMillis()/1000);
		try {
			InetAddress inet = InetAddress.getByName(this.address);
			if (inet.isReachable(1000)){
				this.setReach("Is reachable!");
			} else {
				this.setReach("NOT reachable!");
			}
		} catch(Exception e) {
			this.setReach("Check the address:" + e.getMessage());
		}
	}
}
