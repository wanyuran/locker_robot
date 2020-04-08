package com.xpbootcamp.locker_robot;


import java.util.HashMap;
import java.util.Map;

public class Locker {
	private int availableCapacity;
	private Map<Ticket, Bag> savedBag = new HashMap<>();

	public Locker(int availableCapacity) {
		this.availableCapacity = availableCapacity;
	}

	public Ticket saveBag(Bag bag) {
		if (availableCapacity <= 0) {
			throw new RuntimeException("当前柜子已满");
		}
		Ticket ticket = new Ticket();
		savedBag.put(ticket, bag);
		availableCapacity -= 1;
		return ticket;
	}

	public Bag getBag(Ticket ticket) {
		if (!savedBag.containsKey(ticket)) {
			throw new RuntimeException("当前票据无效");
		}
		Bag bag = savedBag.get(ticket);
		savedBag.remove(ticket);
		availableCapacity += 1;
		return bag;
	}

	public Integer getAvailableCapacity() {
		return availableCapacity;
	}
}
