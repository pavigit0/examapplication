package com.online.exam.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.online.exam.entity.QuestionBank;


@Repository
public interface QuestionBankDao extends JpaRepository<QuestionBank, Integer>{

	QuestionBank findByquesbankid(int quesbankid);

}
