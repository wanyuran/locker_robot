package com.xpbootcamp.locker_robot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LockerTest {
	@Test
	void should_return_ticket_when_save_bag_given_a_locker_with_capacity_is_1_and_a_bag() {
		// Given
		int capacity = 1;
		Locker locker = new Locker(capacity);
		Bag bag = new Bag();

		// When
		Ticket ticket = locker.saveBag(bag);

		// Then
		assertNotNull(ticket);
	}

	@Test
	void should_return_no_ticket_when_save_bag_given_a_locker_with_capacity_is_0_and_a_bag() {
		// Given
		int capacity = 0;
		Locker locker = new Locker(capacity);
		Bag bag = new Bag();

		// When
		RuntimeException runtimeException = assertThrows(RuntimeException.class,
			() -> locker.saveBag(bag));

		// Then
		assertEquals("当前柜子已满", runtimeException.getMessage());
	}

	@Test
	void should_return_error_message_when_save_bag_at_twice_given_a_locker_with_capacity_is_1_and_two_bag() {
		// Given
		int capacity = 1;
		Locker locker = new Locker(capacity);
		Bag bag = new Bag();
		Bag anotherBag = new Bag();

		// When
		RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> {
			locker.saveBag(bag);
			locker.saveBag(anotherBag);
		});

		// Then
		assertEquals("当前柜子已满", runtimeException.getMessage());

	}

	@Test
	void should_return_bag_when_get_bag_given_a_locker_with_capacity_is_0_and_a_valid_ticket() {
		// TODO initCapacity=1与测试名会不会有歧义
		// Given
		int initCapacity = 1;
		Locker locker = new Locker(initCapacity);
		Bag bag = new Bag();

		Ticket validTicket = locker.saveBag(bag);

		// When
		Bag foundBag = locker.getBag(validTicket);

		// Then
		assertNotNull(foundBag);
		assertSame(bag, foundBag);
	}


	@Test
	void should_return_no_bag_when_get_bag_given_a_locker_with_capacity_is_0_and_an_invalid_ticket() {
		// Given
		int capacity = 0;
		Locker locker = new Locker(capacity);
		Ticket invalidTicket = new Ticket();

		// When
		RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> {
			locker.getBag(invalidTicket);
		});

		// Then
		assertEquals("当前票据无效", runtimeException.getMessage());
	}

	@Test
	void should_return_no_bag_when_get_bag_given_a_locker_with_capacity_is_0_and_an_used_valid_ticket() {
		// Given
		int initCapacity = 1;
		Locker locker = new Locker(initCapacity);
		Bag bag = new Bag();

		Ticket usedTicket = locker.saveBag(bag);
		locker.getBag(usedTicket);

		// When
		RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> {
			locker.getBag(usedTicket);
		});

		// Then
		assertEquals("当前票据无效", runtimeException.getMessage());
	}

}

