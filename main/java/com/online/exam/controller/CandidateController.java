package com.online.exam.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.online.exam.entity.Candidate;
import com.online.exam.service.CandidateService;




@RestController
@RequestMapping("/candidate")
public class CandidateController {

	@Autowired
	private CandidateService cService;

	@GetMapping("/getall")
	public List<Candidate> getAllCandidates() {
		
		return cService.getAllCandidates();

	}

	@GetMapping("/getcandidatebyid/{cId}")
	public ResponseEntity<Candidate> getCandidateById(@PathVariable("cId") Integer candidateId){
		return new ResponseEntity<Candidate>(cService.getCandidateById(candidateId), HttpStatus.OK);
	}

	@PostMapping("/registercandidate")
	public Candidate addCustomer(@RequestBody Candidate candidate) {

		return cService.addCandidate(candidate);
	}

	@PutMapping("/updatecandidate")
	public Candidate updateCustomer(@RequestBody Candidate candidate) {
		return cService.updateCustomer(candidate);

	}

	@DeleteMapping("/candidate/{cId}")
	public void deleteCandidateById(@PathVariable Integer cId) {
		this.cService.deleteCandidateById(cId);
	}

}
