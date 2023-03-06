package com.online.exam.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.online.exam.entity.Questions;


@Repository
public interface QuestionDao extends JpaRepository<Questions, Integer> {

	Questions findByquestionId(int questionId);

}