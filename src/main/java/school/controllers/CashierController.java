package school.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import school.services.CashierService;

@Controller
public class CashierController {
	
	@Autowired
	CashierService cashierService;
	
	@GetMapping("/Cashier")
	public String onCashier(Model model,Principal principal) {
		model.addAttribute("cashier",cashierService.findCashierByUsername(principal.getName()));
		return "cashierArea";		
	}
}
