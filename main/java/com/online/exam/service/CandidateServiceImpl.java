package com.online.exam.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.online.exam.dao.CandidateDAO;
import com.online.exam.entity.Candidate;

@Component
@Transactional
public class CandidateServiceImpl implements CandidateService {
	
	@Autowired
	private CandidateDAO cDao;
	
//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public List<Candidate> getAllCandidates() {
//		List<Candidate> cList = cDao.findAll();
		return cDao.findAll();
	}
//	
//	@Bean
//	private BCryptPasswordEncoder getBCryptPasswordEncoder() {
//		return new BCryptPasswordEncoder();
//	}

	@Override
	public Candidate getCandidateById(Integer candidateid) {
		Optional<Candidate> optional = cDao.findById(candidateid);
		if(!optional.isPresent()){
        	System.out.println("***error***");
           // throw new StudentNotFoundException("student not found for id="+id);
        }
        Candidate cand=optional.get();
		return cand;
	}

	@Override
	public Candidate addCandidate(Candidate candidate) {
		candidate.setPassword(bcryptEncoder.encode(candidate.getPassword()));
		cDao.save(candidate);
		return candidate;
	}

	@Override
	public Candidate updateCustomer(Candidate candidate) {
		return cDao.save(candidate);
	}

	@Override
	public void deleteCandidateById(Integer candidateId) {
		cDao.deleteById(candidateId);		
	}
}