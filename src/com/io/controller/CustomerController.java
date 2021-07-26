package com.io.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.io.dao.CustomerDAO;
import com.io.entity.Customer;
import com.io.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/getcust")
	public String getAllCustomers(Model theModel) {
		
		List<Customer>customerList=customerService.getAllCustomers();
		System.out.println("Controller Custlist "+customerList);
		theModel.addAttribute("customers", customerList);
		return "custList";
		
	}
	
	@RequestMapping("/showFormAdd")
	public String addCustomer(Model model) {
		Customer customer=new Customer();
		model.addAttribute("customer", customer);
		return "addCustomer";
	}
	
	@PostMapping("/saveForm")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		customerService.saveCustomer(customer);
		return "redirect:getcust";  
	}
	
	@GetMapping("/showUpdateForm")
	public String updateCustomer(@RequestParam("custId") int custId,Model model) {
		
		Customer customer=customerService.getCustomerById(custId);
		model.addAttribute("customer", customer);
		return "addCustomer";
	}
	
	@GetMapping("/showDeleteForm")
	public String deleteCustomer(@RequestParam("custId") int custId) {
		
		customerService.deleteById(custId);
		return "redirect:getcust";
	}

}
