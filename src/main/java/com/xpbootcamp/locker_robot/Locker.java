package com.xpbootcamp.locker_robot;


import java.util.HashMap;
import java.util.Map;

public class Locker {
	private int capacity;
	private Map<Ticket, Bag> savedBag = new HashMap<>();

	public Locker(int capacity) {
		this.capacity = capacity;
	}

	public Ticket saveBag(Bag bag) {
		if (capacity <= 0) {
			throw new RuntimeException("当前柜子已满");
		}
		Ticket ticket = new Ticket();
		savedBag.put(ticket, bag);
		capacity -= 1;
		return ticket;
	}

	public Bag getBag(Ticket ticket) {
		if (!savedBag.containsKey(ticket)) {
			throw new RuntimeException("当前票据无效");
		}
		Bag bag = savedBag.get(ticket);
		savedBag.remove(ticket);
		capacity += 1;
		return bag;
	}
}
