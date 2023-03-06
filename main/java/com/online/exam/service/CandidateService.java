package com.online.exam.service;

import java.util.List;


import com.online.exam.entity.Candidate;

public interface CandidateService {
	public List<Candidate> getAllCandidates();
	public Candidate getCandidateById(Integer candidate);
	public Candidate addCandidate(Candidate candidate);
	public Candidate updateCustomer(Candidate candidate);
	public void deleteCandidateById(Integer candidateId);
}
