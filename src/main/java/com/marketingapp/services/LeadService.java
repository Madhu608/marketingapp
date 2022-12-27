package com.marketingapp.services;

import java.util.List;

import com.marketingapp.entities.Lead;

public interface LeadService {

	public void SaveLead(Lead lead);

	public List<Lead> getallLead();

	public void deleteOneLead(long id);

	public Lead getLeadById(long id); 
	

}
