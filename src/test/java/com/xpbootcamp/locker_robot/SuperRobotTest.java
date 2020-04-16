package com.xpbootcamp.locker_robot;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;


class SuperRobotTest {
    @Test
    void should_return_a_ticket_from_another_locker_when_save_bag_given_a_robot_and_a_bag() {
        // Given
        Locker locker = new Locker(1, 2);
        Locker anotherLocker = new Locker(1, 1);
        SuperRobot superRobot = new SuperRobot(Arrays.asList(locker, anotherLocker));
        Bag bag = new Bag();

        // When
        Ticket ticket = superRobot.saveBag(bag);

        // Then
        assertNotNull(ticket);
        Bag foundBag = anotherLocker.getBag(ticket);
        assertSame(bag, foundBag);
    }

    @Test
    void should_return_a_ticket_from_locker_when_save_bag_given_a_robot_and_a_bag() {
        // Given
        Locker locker = new Locker(1, 1);
        Locker anotherLocker = new Locker(1, 2);
        SuperRobot superRobot = new SuperRobot(Arrays.asList(locker, anotherLocker));
        Bag bag = new Bag();

        // When
        Ticket ticket = superRobot.saveBag(bag);

        // Then
        assertNotNull(ticket);
        Bag foundBag = locker.getBag(ticket);
        assertSame(bag, foundBag);
    }
}
