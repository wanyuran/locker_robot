package com.xpbootcamp.locker_robot;

import java.util.List;

/**
 * @ClassName PrimaryRobot
 * @Description TODO
 * @Author zijie.jiang
 * @Date 2020-04-11 22:05
 * @Version 1.0
 */
public class PrimaryRobot {
	private List<Locker> lockers;

	public PrimaryRobot(List<Locker> lockers) {
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
