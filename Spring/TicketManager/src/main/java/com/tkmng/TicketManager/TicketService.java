package com.tkmng.TicketManager;

import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
public class TicketService {

	private static TicketRepository t = new TicketRepository();
	
	public TicketService() {
	    t.addTicket(new Ticket(1L, "Concert", LocalDate.of(2023, 10, 30), "John Doe", 50.0));
	    t.addTicket(new Ticket(2L, "Movie Premiere", LocalDate.of(2023, 11, 5), "Jane Smith", 25.0));

	}

	
	public void addTicket(Ticket ticket) {
		t.addTicket(ticket);
	}

	
	public Collection<Ticket> getAllTickets() {
		return t.getAllTickets();
	}

	
	public Ticket getTicketFromId(Long id) {
		return t.getTicketFromId(id);
	}

	
	public void updateTicket(Ticket ticket) {
		t.updateTicket(ticket);
	}

	
	public void removeTicket(Long id) {
		t.removeTicket(id);
	}

}