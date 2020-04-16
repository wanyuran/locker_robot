package com.xpbootcamp.locker_robot;

import java.util.List;

public class SuperRobot {
	private final List<Locker> lockers;

	public SuperRobot(List<Locker> lockers) {
		this.lockers = lockers;
	}

	public Ticket saveBag(Bag bag) {
		float maxVacancyRate = 0;
		Locker lockerWithMaxVacancyRate = null;
		for (Locker locker : lockers) {
			float vacancyRate = locker.getAvailableCapacity().floatValue() / locker.getTotalCapacity();
			if (vacancyRate >= maxVacancyRate) {
				lockerWithMaxVacancyRate = locker;
			}
		}

		if (lockerWithMaxVacancyRate == null) {
			throw new RuntimeException("当前没有柜子");
		}

		return lockerWithMaxVacancyRate.saveBag(bag);
	}
}
