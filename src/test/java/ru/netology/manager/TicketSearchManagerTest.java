package ru.netology.manager;

import Tickets.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.TicketRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketSearchManagerTest {
    private TicketRepository repository = new TicketRepository();
    private TicketSearchManager manager = new TicketSearchManager(repository);

    private Ticket firstTicket = new Ticket(1, 2100, "KUF", "EGO", 95);
    private Ticket secondTicket = new Ticket(2, 2110, "DME", "OGZ", 100);
    private Ticket thirdTicket = new Ticket(3, 2099, "KUF", "EGO", 110);
    private Ticket forthTicket = new Ticket(4, 2230, "DME", "OGZ", 90);
    private Ticket fifthTicket = new Ticket(5, 1890, "KUF", "EGO", 95);
    private Ticket sixthTicket = new Ticket(6, 2143, "DME", "OGZ", 85);
    private Ticket seventhTicket = new Ticket(7, 1946, "KUF", "EGO", 95);
    private Ticket eighthTicket = new Ticket(8, 2155, "KUF", "EGO", 93);
    private Ticket ninthTicket = new Ticket(9, 1993, "KUF", "EGO", 105);


    @BeforeEach
    void setUp() {
        manager.add(firstTicket);
        manager.add(secondTicket);
        manager.add(thirdTicket);
        manager.add(forthTicket);
        manager.add(fifthTicket);
        manager.add(sixthTicket);
        manager.add(seventhTicket);
        manager.add(eighthTicket);
        manager.add(ninthTicket);
    }

    @Test
    void shouldGetAll() {
        Ticket[] tickets = new Ticket[]{seventhTicket, firstTicket, ninthTicket, eighthTicket, thirdTicket, forthTicket, secondTicket, fifthTicket, secondTicket};
        Ticket[] result = manager.findAll("DME", "EGO");
        assertNotEquals(tickets, result);
    }

    @Test
    void shouldSearchCostBy() {
        Ticket[] tickets = new Ticket[]{ninthTicket, firstTicket, thirdTicket, eighthTicket, fifthTicket, seventhTicket};
        Ticket[] result = manager.findAll("KUF", "EGO");
        Arrays.sort(tickets);
        assertArrayEquals(tickets, result);
    }


}