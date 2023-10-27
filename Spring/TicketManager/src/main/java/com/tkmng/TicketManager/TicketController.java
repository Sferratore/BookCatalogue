package com.tkmng.TicketManager;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/tickets")
public class TicketController {

	@Autowired
	private TicketService ticketService;

	@GetMapping
	public Collection<Ticket> ticketList() {
		return ticketService.getAllTickets();
	}

	@GetMapping("/{id}")
	public Ticket getTicket(@PathVariable Long id) {
		return ticketService.getTicketFromId(id);
	}

	@PostMapping
	public void newTicket(@RequestBody Ticket ticket) {
		ticketService.addTicket(ticket);
	}

	@PutMapping("/{id}")
	public void updateTicket(@RequestBody Ticket ticket) {
		ticketService.updateTicket(ticket);
	}

	@DeleteMapping("/{id}")
	public void deleteTicket(@PathVariable Long id) {
		ticketService.removeTicket(id);
	}
}
