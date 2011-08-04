package be.intecbrussel.jad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TicketController {
	
	@RequestMapping(method=RequestMethod.GET, value="ticket")
	public String toReg() {
		System.out.println("in toReg");
		return "ticketRegistration";
	}
	
}
