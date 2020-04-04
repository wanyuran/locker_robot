package com.xpbootcamp.locker_robot;

import java.util.List;

public class Robot {

	private List<Locker> lockers;

	public Robot(List<Locker> lockers) {
		this.lockers = lockers;
	}

	public Ticket save(Bag bag) {
		for (Locker locker : lockers) {
			try {
				return locker.save(bag);
			} catch (RuntimeException ignored) {
			}
		}
		throw new RuntimeException("当前柜子已满");
	}

	public Bag get(Ticket ticket) {
		for (Locker locker : lockers) {
			try {
				return locker.get(ticket);
			} catch (RuntimeException ignored) {
			}
		}
		throw new RuntimeException("当前票据无效");
	}
}
