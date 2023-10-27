package com.tkmng.TicketManager;

import java.util.Map;
import java.util.HashMap;
import java.util.Collection;

public class TicketRepository {

	private final Map<Long, Ticket> tickets = new HashMap<>();
	private Long currentId = 1L;

	public TicketRepository() {
		
	}
	
	public void addTicket(Ticket ticket) {
		ticket.setId(currentId++);
		tickets.put(ticket.getId(), ticket);
	}

	
	public Collection<Ticket> getAllTickets() {
		return tickets.values();
	}

	
	public Ticket getTicketFromId(Long id) {
		return tickets.get(id);
	}

	
	public void updateTicket(Ticket ticket) {
		if (tickets.containsKey(ticket.getId())) {
			tickets.put(ticket.getId(), ticket);
		}
	}

	
	public void removeTicket(Long id) {
		tickets.remove(id);
	}

}