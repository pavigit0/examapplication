package com.online.exam.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.online.exam.entity.Candidate;


@Repository
public interface CandidateDAO extends JpaRepository<Candidate, Integer> {
	@Query(value = "select c from Candidate c where c.eMail=?1")
	public Candidate findByEmail(String eMail);
}
