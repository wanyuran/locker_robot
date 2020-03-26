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
        Ticket ticket = locker.saveBag(bag);

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
        Ticket ticket = locker.saveBag(null);

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
            Ticket ticket = locker.saveBag(bag);
            // Then
            assertEquals(capacity, locker.getCapacity());
            assertNull(ticket);
        });
        assertEquals("当前柜子已满", runtimeException.getMessage());
    }

    @Test
    void should_return_bag_and_capacity_increase_by_1_when_get_bag_given_a_locker_and_a_valid_ticket() {
        // Given
        int capacity = 50;
        Locker locker = new Locker(capacity);
        Bag bag = new Bag();

        Ticket validTicket = locker.saveBag(bag);

        // When
        Bag foundBag = locker.getBag(validTicket);

        // Then
        assertNotNull(foundBag);
        assertSame(bag, foundBag);
        assertEquals(capacity, locker.getCapacity());
    }

    @Test
    void should_return_no_bag_and_capacity_increase_by_1_when_get_bag_given_a_locker_and_a_valid_ticket() {
        // Given
        int capacity = 50;
        Locker locker = new Locker(capacity);

        Ticket validTicket = locker.saveBag(null);

        // When
        Bag foundBag = locker.getBag(validTicket);

        // Then
        assertNull(foundBag);
        assertEquals(capacity, locker.getCapacity());
    }

    @Test
    void should_return_no_bag_when_get_bag_given_a_locker_and_an_invalid_ticket() {
        // Given
        int capacity = 50;
        Locker locker = new Locker(capacity);
        Ticket invalidTicket = new Ticket();

        // When
        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> {
            Bag foundBag = locker.getBag(invalidTicket);
            // Then
            assertEquals(capacity, locker.getCapacity());
            assertNull(foundBag);
        });
        assertEquals("当前票据无效", runtimeException.getMessage());
    }

    @Test
    void should_return_no_bag_when_get_bag_given_a_locker_and_an_used_valid_ticket() {
        // Given
        int capacity = 50;
        Locker locker = new Locker(capacity);
        Bag bag = new Bag();

        Ticket usedTicket = locker.saveBag(bag);
        locker.getBag(usedTicket);

        // When
        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> {
            Bag foundBag = locker.getBag(usedTicket);
            // Then
            assertEquals(capacity, locker.getCapacity());
            assertNull(foundBag);
        });
        assertEquals("当前票据无效", runtimeException.getMessage());
    }

}

