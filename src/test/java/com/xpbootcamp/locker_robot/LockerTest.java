package com.xpbootcamp.locker_robot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class LockerTest {
	@Test
	void should_return_ticket_and_capacity_decrease_by_1_when_save_bag_given_a_locker_and_a_bag() {
		// Given
		int capacity = 50;
		Locker locker = new Locker(capacity);
		Bag bag = new Bag();

		// When
		Ticket ticket = locker.save(bag);

		// Then
		assertNotNull(ticket);
		assertEquals(capacity - 1, locker.getCapacity());
	}


	@Test
	void should_return_ticket_and_capacity_decrease_by_1_when_save_bag_given_a_locker_and_no_bag() {
		// Given
		int capacity = 50;
		Locker locker = new Locker(capacity);

		// When
		Ticket ticket = locker.save(null);

		// Then
		assertNotNull(ticket);
		assertEquals(capacity - 1, locker.getCapacity());
	}
}
