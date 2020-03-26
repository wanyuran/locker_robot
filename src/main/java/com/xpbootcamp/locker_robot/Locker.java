package com.xpbootcamp.locker_robot;


import java.util.HashMap;
import java.util.Map;

public class Locker {
	private int capacity;
	private Map<Ticket, Bag> lockers = new HashMap<>();

	public Locker(int capacity) {
		this.capacity = capacity;
	}


	public Ticket save(Bag bag) {
		Ticket ticket = new Ticket();
		lockers.put(ticket, bag);

		if(capacity >0) {
			capacity = capacity - 1;
			return ticket;
		} else {
			throw new RuntimeException("当前柜子已满");
		}
	}

	public int getCapacity() {
		return capacity;
	}
}
