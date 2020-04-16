package com.xpbootcamp.locker_robot;

import java.util.List;

public class SuperRobot {
    private final List<Locker> lockers;

    public SuperRobot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public Ticket saveBag(Bag bag) {
        if (lockers == null || lockers.isEmpty()) {
            throw new RuntimeException("当前没有柜子");
        }

        float maxVacancyRate = 0;
        Locker lockerWithMaxVacancyRate = null;

        for (Locker locker : lockers) {
            float vacancyRate = locker.getAvailableCapacity().floatValue() / locker.getTotalCapacity();
            if (vacancyRate > maxVacancyRate) {
                maxVacancyRate = vacancyRate;
                lockerWithMaxVacancyRate = locker;
            }
        }

        if (lockerWithMaxVacancyRate == null) {
            throw new RuntimeException("所有柜子已满");
        }

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
