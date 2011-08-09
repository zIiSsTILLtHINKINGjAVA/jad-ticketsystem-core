package be.intecbrussel.jad.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import be.intecbrussel.jad.model.data.TicketDAO;
import be.intecbrussel.jad.model.entities.Ticket;

@Controller
//@RequestMapping(value="tick")
public class TicketController {
	
	@RequestMapping(method=RequestMethod.GET, value="ticket")
	public String toReg() {
		System.out.println("in toReg");
		return "user";
	}
	@RequestMapping(method=RequestMethod.GET, value="newTicket")
	public String toNewTicket(@ModelAttribute("ticketForm") Ticket ticket){
		System.out.println("in toReg");
		return "newticket";
	}
	@ModelAttribute("categoryList")
	public String [] getCheckboses(){
		return new String [] {"Scherm","Hardware","Toetsenbord"};
	}
	@RequestMapping(value="sendToDb")
	public String putInDB(@ModelAttribute("ticketForm") Ticket ticket, BindingResult br){
		TicketDAO ticketDao = new TicketDAO();
		ticketDao.create(ticket);
		System.out.println(ticket.getTitle());
		return "newTicketConfirmed";
	}
	
}
