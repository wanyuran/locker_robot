package com.xpbootcamp.locker_robot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

	@Test
	void should_return_no_ticket_when_save_bag_given_a_locker_with_no_capacity_and_a_bag() {
		// Given
		int capacity = 0;
		Locker locker = new Locker(capacity);
		Bag bag = new Bag();

		// When
		RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> {
			Ticket ticket = locker.save(bag);
			// Then
			assertEquals(capacity, locker.getCapacity());
			assertNull(ticket);
		});
		assertEquals("当前柜子已满", runtimeException.getMessage());
	}

	@Test
	void should_return_bag_and_capacity_increase_by_1_when_get_bag_given_locker_and_a_valid_ticket() {
		// Given
		int capacity = 50;
		Locker locker = new Locker(capacity);
		Bag bag = new Bag();

		Ticket validTicket = locker.save(bag);

		// When
		Bag foundBag = locker.get(validTicket);

		// Then
		assertNotNull(foundBag);
		assertSame(bag, foundBag);
		assertEquals(capacity, locker.getCapacity());
	}

    @Test
    void should_return_no_bag_and_capacity_increase_by_1_when_get_bag_given_locker_and_a_valid_ticket() {
        // Given
        int capacity = 50;
        Locker locker = new Locker(capacity);

        Ticket validTicket = locker.save(null);

        // When
        Bag foundBag = locker.get(validTicket);

        // Then
        assertNull(foundBag);
        assertEquals(capacity, locker.getCapacity());
    }


}
