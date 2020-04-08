package com.xpbootcamp.locker_robot;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SmartRobotTest {
	@Test
	void should_return_a_ticket_from_locker_when_save_bag_given_a_robot_and_a_bag() {
		// Given
		Locker locker = new Locker(2);
		Locker anotherLocker = new Locker(1);
		Robot smartRobot = new Robot(Arrays.asList(locker, anotherLocker));
		Bag bag = new Bag();

		// When
		Ticket ticket = smartRobot.saveBag(bag);

		// Then
		assertNotNull(ticket);
		Bag foundBag = locker.getBag(ticket);
		assertEquals(bag, foundBag);
	}

	@Test
	void should_return_a_ticket_from_another_locker_when_save_bag_given_a_robot_and_a_bag() {
		// Given
		Locker locker = new Locker(1);
		Locker anotherLocker = new Locker(2);
		Robot smartRobot = new Robot(Arrays.asList(locker, anotherLocker));
		Bag bag = new Bag();

		// When
		Ticket ticket = smartRobot.saveBag(bag);

		// Then
		assertNotNull(ticket);
		Bag foundBag = anotherLocker.getBag(ticket);
		assertEquals(bag, foundBag);
	}

}
