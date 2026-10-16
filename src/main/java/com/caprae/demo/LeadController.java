
package com.caprae.demo;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
public class LeadController {

    private final LeadRepository leadRepository;

    public LeadController(LeadRepository leadRepository) {
        this.leadRepository = leadRepository;
    }

    @GetMapping("/api/leads")
    public List<Lead> getAllLeads() {
        return leadRepository.findAll();
    }

    @PostMapping("/api/leads")
    public Lead addLead(@RequestBody Lead lead) {
        return leadRepository.save(lead);
    }

    @PutMapping("/api/leads/{id}")
    public Lead updateLead(@PathVariable Long id,
                           @RequestBody Lead updatedLead) {

        Lead lead = leadRepository.findById(id)
                .orElseThrow(() ->
                    new RuntimeException("Lead not found"));

        lead.setName(updatedLead.getName());
        lead.setCompany(updatedLead.getCompany());
        lead.setIndustry(updatedLead.getIndustry());
        lead.setScore(updatedLead.getScore());

        return leadRepository.save(lead);
    }

    @DeleteMapping("/api/leads/{id}")
    public void deleteLead(@PathVariable Long id) {
        leadRepository.deleteById(id);
    }
}
