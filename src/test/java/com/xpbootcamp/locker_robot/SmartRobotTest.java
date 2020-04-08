package com.xpbootcamp.locker_robot;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

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
		assertSame(bag, foundBag);
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
		assertSame(bag, foundBag);
	}

	@Test
	void should_return_a_ticket_from_locker_when_save_bag_given_a_robot_and_a_bag_and_same_capacity_lockers() {
		// Given
		Locker locker = new Locker(1);
		Locker anotherLocker = new Locker(1);

		Robot smartRobot = new Robot(Arrays.asList(locker, anotherLocker));
		Bag bag = new Bag();

		// When
		Ticket ticket = smartRobot.saveBag(bag);

		// Then
		assertNotNull(ticket);
		Bag foundBag = locker.getBag(ticket);
		assertSame(bag, foundBag);
	}

	@Test
	void should_return_error_message_when_save_bag_given_a_robot_and_a_bag_and_full_lockers() {
		// Given
		Locker locker = new Locker(0);
		Locker anotherLocker = new Locker(0);

		Robot smartRobot = new Robot(Arrays.asList(locker, anotherLocker));
		Bag bag = new Bag();

		// When
		RuntimeException runtimeException = assertThrows(RuntimeException.class,
				() -> smartRobot.saveBag(bag));

		// Then
		assertEquals("当前柜子已满", runtimeException.getMessage());
	}

	@Test
	void should_return_bag_when_get_bag_given_a_robot_and_a_valid_ticket() {
		// Given
		Locker locker = new Locker(1);
		Locker anotherLocker = new Locker(0);

		Robot smartRobot = new Robot(Arrays.asList(locker, anotherLocker));
		Bag bag = new Bag();

		Ticket validTicket = smartRobot.saveBag(bag);

		// When
		Bag foundBag = smartRobot.getBag(validTicket);

		// Then
		assertSame(bag, foundBag);
	}

	@Test
	void should_return_error_message_when_get_bag_given_a_robot_and_an_invalid_ticket() {
		// Given
		Locker locker = new Locker(0);
		Locker anotherLocker = new Locker(0);

		Robot smartRobot = new Robot(Arrays.asList(locker, anotherLocker));
		Ticket invalidTicket = new Ticket();

		// When
		RuntimeException runtimeException = assertThrows(RuntimeException.class,
				() -> smartRobot.getBag(invalidTicket));

		// Then
		assertEquals("当前票据无效", runtimeException.getMessage());
	}
}
