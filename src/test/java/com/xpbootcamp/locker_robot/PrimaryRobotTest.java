package com.xpbootcamp.locker_robot;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class PrimaryRobotTest {
    @Test
    void should_return_a_ticket_from_locker1_when_save_bag_given_robot() {
        // Given
        Locker locker = new Locker(1);
        Locker anotherLocker = new Locker(1);
        Robot robot = new Robot(Arrays.asList(locker, anotherLocker));
        Bag bag = new Bag();

        // When
        Ticket ticket = robot.save(bag);

        // Then
        assertNotNull(ticket);
        Bag foundBag = locker.get(ticket);
        assertEquals(bag, foundBag);
    }
}
