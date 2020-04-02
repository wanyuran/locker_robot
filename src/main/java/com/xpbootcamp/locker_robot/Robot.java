package com.xpbootcamp.locker_robot;

import java.util.List;

import static java.util.Optional.ofNullable;

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
        return ofNullable(ticket)
            .orElseThrow(() -> new RuntimeException("当前柜子已满"));
    }

    public Bag get(Ticket ticket) {
        Bag bag = null;
        for (Locker locker: lockers) {
            try{
                bag = locker.get(ticket);
                break;
            } catch (RuntimeException ignored) { }
        }
        return ofNullable(bag)
                .orElseThrow(() -> new RuntimeException("当前票据无效"));
    }
}
