package com.xpbootcamp.locker_robot;

import java.util.List;

public class Robot {

	private List<Locker> lockers;

	public Robot(List<Locker> lockers) {
		this.lockers = lockers;
	}

	public Ticket saveBag(Bag bag) {
		for (Locker locker : lockers) {
			try {
				return locker.saveBag(bag);
			} catch (RuntimeException ignored) {
			}
		}
		throw new RuntimeException("当前柜子已满");
	}

	public Bag getBag(Ticket ticket) {
		for (Locker locker : lockers) {
			try {
				return locker.getBag(ticket);
			} catch (RuntimeException ignored) {
			}
		}
		throw new RuntimeException("当前票据无效");
	}
}
