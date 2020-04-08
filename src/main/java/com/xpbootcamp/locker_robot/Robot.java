package com.xpbootcamp.locker_robot;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Robot {

	private List<Locker> lockers;

	public Robot(List<Locker> lockers) {
		this.lockers = lockers;
	}

	public Ticket saveBag(Bag bag) {
		Locker foundLocker = lockers.stream()
			.max(Comparator.comparingInt(Locker::getAvailableCapacity))
			.orElseThrow(() -> new RuntimeException("没有柜子"));

		return foundLocker.saveBag(bag);
	}

	public Bag getBag(Ticket ticket) {

		return lockers.stream().map(locker -> {
			try {
				return locker.getBag(ticket);
			} catch (Exception e) {
				return null;
			}
		}).filter(Objects::nonNull)
			.findFirst()
			.orElseThrow(() -> new RuntimeException("当前票据无效"));
	}
}
