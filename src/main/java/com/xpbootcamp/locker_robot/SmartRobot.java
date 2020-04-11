package com.xpbootcamp.locker_robot;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class SmartRobot {

	private List<Locker> lockers;

	public SmartRobot(List<Locker> lockers) {
		this.lockers = lockers;
	}

	public Ticket saveBag(Bag bag) {
		Locker foundLocker = lockers.stream()
			.max(Comparator.comparingInt(Locker::getAvailableCapacity))
			.orElseThrow(() -> new RuntimeException("没有柜子"));

		return foundLocker.saveBag(bag);
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
