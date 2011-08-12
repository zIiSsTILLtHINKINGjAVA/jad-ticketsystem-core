package be.intecbrussel.jad.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import be.intecbrussel.jad.model.data.TicketDAO;
import be.intecbrussel.jad.model.entities.Account;
import be.intecbrussel.jad.model.entities.Ticket;
import be.intecbrussel.jad.services.AccountService;

@Controller
//@RequestMapping(value="tick")
public class TicketController {
	
	@Resource(name="accountService")
	private AccountService userService;
	
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

	@RequestMapping(method=RequestMethod.GET, value="newUser")
	public String addAccount(Model model){
		System.out.println("prepare to create a new user");
		model.addAttribute("userAttribute", new Account());
		
		return "addUser";
	}

	@RequestMapping(method = RequestMethod.POST, value = "newUser")
	public String addUserToDB(@ModelAttribute("userAttribute") Account user) {
		
		System.out.println("inserting the new user");
		
		// The "userAttribute" model has been passed to the controller from the JSP
		// Call AccountService to do the actual insert
		userService.add(user);
		
		System.out.println("new user inserted");
		
    	// This will resolve to /WEB-INF/jsp/addeduser.jsp
		return "addedUser";
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
