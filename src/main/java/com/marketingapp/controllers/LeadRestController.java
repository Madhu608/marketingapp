package com.marketingapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketingapp.entities.Lead;
import com.marketingapp.repositories.LeadRepository;

@RestController
@RequestMapping("/api/leads")
public class LeadRestController {
	
	//http://localhost:8080/api/leads
	
	@Autowired
	private LeadRepository leadRepo;
	
	@GetMapping
	public List<Lead> getAllLeads(){
		List<Lead> leads = leadRepo.findAll();
		return leads;
		
	}
	@PostMapping
	public void saveOneLead(@RequestBody Lead lead) {
		leadRepo.save(lead);
		
	}
	@PutMapping
	public void updateOneLead(@RequestBody Lead lead) {
		leadRepo.save(lead);
	}
	@DeleteMapping("/Delete/{id}")
	public void DeleteOneLead(@PathVariable("id")long id) {
		leadRepo.deleteById(id);
	}
	//http://localhost:8080/api/leads/find/1
	@GetMapping("/find/{id}")
	public Lead getOneLead(@PathVariable("id")long id) {
			Optional<Lead> findById = leadRepo.findById(id);
			Lead lead = findById.get();
			return lead;
	}
}