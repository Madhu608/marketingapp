package com.marketingapp.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketingapp.dto.LeaddData;
import com.marketingapp.entities.Lead;
import com.marketingapp.services.LeadService;
import com.marketingapp.util.Emailservice;

@Controller
public class LeadController {
	
	@Autowired
	private Emailservice emailservice;

	@Autowired
	private LeadService leadService;
	//http://localhost:8080/create
	
	@RequestMapping("/create")
	public String ViewCreateLeadForm() {
		return "create_lead";
	}
	
	//http://localhost:8080/SaveLead
	@RequestMapping("SaveLead")
	public String SaveOneLead(@ModelAttribute("lead") Lead lead, ModelMap map) {
		map.addAttribute("msg","Record is saved..");
		emailservice.sendEmail(lead.getEmail(),"Welcome Email", "Test");
		leadService.SaveLead(lead);
		return "create_lead";
	}
	
	//Second way to read form date
	
	//@RequestMapping("SaveLead")
	//public String SaveOneLead(@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName,@RequestParam("email") String email,@RequestParam("mobile") long mobile) {
		//System.out.println(firstName);
		//System.out.println(lastName);
		//System.out.println(email);
		//System.out.println(mobile);
		
	//	 Lead lead = new Lead();
	//	lead.setFirstName(firstName);
	//	lead.setLastName(lastName);
	//	lead.setEmail(email);
	//	lead.setMobile(mobile);
	//	leadService.SaveLead(lead);
	//	return "create_lead";
	//}
	
	
	
	//Method 3 way to read form date
	
//	@RequestMapping("SaveLead")
//	public String SaveOneLead(LeaddData leaddData) {
	//	System.out.println(leaddData.getFirstName());
	//	System.out.println(leaddData.getLastName());
	//	System.out.println(leaddData.getEmail());
	//	System.out.println(leaddData.getMobile());
		
	//	return "create_lead";
		
	//}
	//@RequestMapping("SaveLead")
    // public String SaveOneLead(LeaddData leaddData) {
    //	 Lead lead = new Lead();
    //	 lead.setFirstName(leaddData.getFirstName());
    //	 lead.setLastName(leaddData.getLastName());
    //	 lead.setEmail(leaddData.getEmail());
    //	 lead.setMobile(leaddData.getMobile());
    //	 leadService.SaveLead(lead);
    //	 return "create_lead";
     //}
	//http://localhost:8080/listall
	@RequestMapping("/listall")
	public String listLead(Model model) {
		List<Lead> leads = leadService.getallLead();
	 model.addAttribute("leads", leads);
		return "list_lead";
	}
	  @RequestMapping("/delete")
	  public String deleteLead(@RequestParam("id") long id,Model model ) {
		  leadService.deleteOneLead(id);
		  List<Lead> leads = leadService.getallLead(); 
		  model.addAttribute("leads", leads);
		   return"list_lead";
	  }
	  @RequestMapping("/update")
	  public String updateOneLead(@RequestParam("id") long id,Model model ) {
		  Lead lead = leadService.getLeadById(id);
		  model.addAttribute("lead", lead);
		return "update_lead";
		  
	  }
	  @RequestMapping("updatelead")
		public String UpdateOneLead(@ModelAttribute("lead") Lead lead,Model model) {
			leadService.SaveLead(lead);
			List<Lead> leads = leadService.getallLead(); 
			model.addAttribute("leads", leads);
			return"list_lead";
		}
	}


