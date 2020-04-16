package com.xpbootcamp.locker_robot;

import java.util.List;

public class SuperRobot {
    private final List<Locker> lockers;

    public SuperRobot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public Ticket saveBag(Bag bag) {
	    Locker lockerWithMaxVacancyRate = lockers.stream().max((locker1, locker2) -> {
		    float vacancyRate1 = locker1.getAvailableCapacity().floatValue() / locker1.getTotalCapacity();
		    float vacancyRate2 = locker2.getAvailableCapacity().floatValue() / locker2.getTotalCapacity();
		    return Float.compare(vacancyRate1, vacancyRate2);
	    }).orElseThrow(() -> new RuntimeException("当前没有柜子"));

        return lockerWithMaxVacancyRate.saveBag(bag);
    }

    public Bag getBag(Ticket ticket) {
        for (Locker locker : lockers) {
            try {
                return locker.getBag(ticket);
            } catch (RuntimeException ignore) {
            }
        }
        throw new RuntimeException("当前票据无效");
    }
}
