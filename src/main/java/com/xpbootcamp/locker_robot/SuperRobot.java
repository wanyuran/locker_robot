package com.xpbootcamp.locker_robot;

import java.util.List;

public class SuperRobot {
    private final List<Locker> lockers;

    public SuperRobot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public Ticket saveBag(Bag bag) {
        float maxVacancyRate = 0;
        Locker tempLocker = null ;
        for (Locker locker: lockers) {
            float vacancyRate = (float) locker.getAvailableCapacity().intValue() / locker.getTotalCapacity().intValue();
            if (vacancyRate >= maxVacancyRate) {
                maxVacancyRate = vacancyRate;
                tempLocker = locker;
            }
        }

        if (tempLocker == null) {
            throw new RuntimeException("当前没有柜子");
        }

        return tempLocker.saveBag(bag);
    }
}
