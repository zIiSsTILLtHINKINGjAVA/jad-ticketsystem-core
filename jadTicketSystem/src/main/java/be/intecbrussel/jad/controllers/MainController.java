package be.intecbrussel.jad.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/main")
public class MainController {
	
	 @RequestMapping(method = RequestMethod.GET)
	 public String showMenu() {
	    	
	    	return "user";
		}

}
