package com.xpbootcamp.locker_robot;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;


class PrimaryRobotTest {
	@Test
	void should_return_a_ticket_from_locker_when_save_bag_given_robot_and_a_bag() {
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

	@Test
	void should_ticket_from_another_locker_when_save_bag_given_a_robot_and_a_bag() {
		// Given
		Locker locker = new Locker(0);
		Locker anotherLocker = new Locker(1);

		Robot robot = new Robot(Arrays.asList(locker, anotherLocker));

		Bag bag = new Bag();

		// When
		Ticket ticket = robot.save(bag);

		// Then
		assertNotNull(ticket);
		Bag foundBag = anotherLocker.get(ticket);
		assertEquals(bag, foundBag);
	}

	@Test
	void should_return_error_message_when_save_bag_given_a_robot_and_a_bag() {
		// Given
		Locker locker = new Locker(0);
		Locker anotherLocker = new Locker(0);

		Robot robot = new Robot(Arrays.asList(locker, anotherLocker));

		Bag bag = new Bag();

		// When
		RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> {
			robot.save(bag);
		});

		// Then
		assertEquals("当前柜子已满", runtimeException.getMessage());
	}

	@Test
	void should_return_bag_when_get_bag_given_a_robot_and_a_valid_ticket() {
		// Given
		Locker locker = new Locker(1);
		Locker anotherLocker = new Locker(0);

		Robot robot = new Robot(Arrays.asList(locker, anotherLocker));

		Bag bag = new Bag();
		Ticket invalidTicket = locker.save(bag);

		// When
		Bag foundBag = robot.get(invalidTicket);

		// Then
		assertNotNull(foundBag);
		assertEquals(bag, foundBag);
	}
}


