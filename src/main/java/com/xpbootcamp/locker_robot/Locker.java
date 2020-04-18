package com.xpbootcamp.locker_robot;


import java.util.HashMap;
import java.util.Map;

public class Locker {
	private int availableCapacity;
	private int totalCapacity;
	private Map<Ticket, Bag> savedBag = new HashMap<>();

	public Locker(int availableCapacity) {
		this.availableCapacity = availableCapacity;
	}

	public Locker(int availableCapacity, int totalCapacity) {
		this.availableCapacity = availableCapacity;
		this.totalCapacity = totalCapacity;
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

	Integer getAvailableCapacity() {
		return availableCapacity;
	}

	Double getVacancyRate() {
		return (double) this.availableCapacity / this.totalCapacity;
	}
}
