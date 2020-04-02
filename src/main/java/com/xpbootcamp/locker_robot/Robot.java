package com.xpbootcamp.locker_robot;

import java.util.List;

public class Robot {

    private List<Locker> lockers;

    public Robot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public Ticket save(Bag bag) {
        Ticket ticket = null;
        for (Locker locker: lockers) {
            try{
                ticket = locker.save(bag);
                break;
            } catch (RuntimeException ignored) { }
        }

        if(ticket == null) {
            throw new RuntimeException("当前柜子已满");
        }

        return ticket;
    }
}
