package com.online.exam.controller;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.online.exam.dto.QuestionBankDetail;
import com.online.exam.dto.QuestionsDetail;
import com.online.exam.entity.QuestionBank;
import com.online.exam.entity.Questions;
import com.online.exam.service.CoeService;
import com.online.exam.service.QuestionBankService;
import com.online.exam.util.QuestionBankUtil;
import com.online.exam.util.QuestionsUtil;


@RestController
@RequestMapping("/question")
@CrossOrigin("http://localhost:4200")
public class CoeController {
	
	@Autowired
	private CoeService coeService;
	
	@Autowired
	private QuestionsUtil questionUtil;

	
private Integer qId;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/add questions")
	public QuestionsDetail addQuestions(HttpServletRequest request, @RequestBody QuestionsDetail requestData){
		
		HttpSession session = request.getSession();

		QuestionsDetail quesDetail = null;
		Questions question = new Questions(requestData.getQuestion(),requestData.getOption1(),requestData.getOption2(),requestData.getOption3(),requestData.getOption4() ,requestData.getCorrectAns());
		Questions ques = coeService.add(question);
		quesDetail = questionUtil.toDetails(ques);
		return quesDetail;
		
		}
	@GetMapping("/deletequestions/{qid}")
	public ResponseEntity<Questions> deleteQuestions(@PathVariable("qid") Integer qId,HttpServletRequest request) {
		HttpSession session= request.getSession();

		coeService.deleteQuestions(qId);

		return new ResponseEntity("Question deleted successfully", HttpStatus.OK);
	}
	@PutMapping("/editquestions")
	public ResponseEntity<Questions> editQuestions(@RequestBody Questions ques,HttpServletRequest request) {
		HttpSession session= request.getSession();

		Questions question =coeService.editQuestions(ques);
		if (question == null) {
			return new ResponseEntity("Sorry we can't update the question with id" + ques.getQuestionId(), HttpStatus.OK);
		}
		return new ResponseEntity<Questions>(question, HttpStatus.OK);
	}
	@GetMapping("/findqid")
	public ResponseEntity<?> findQuestions(@RequestParam int questionId){
		ResponseEntity<?> entity=null;
		Questions dbq=coeService.findByquestionId(questionId);
		entity=new ResponseEntity<Questions>(dbq,HttpStatus.OK);
		return entity;
	}
	@GetMapping("/showall/questions")
	public List<QuestionsDetail> showQuestions(HttpServletRequest request) {
		HttpSession session = request.getSession();
		List<Questions> quesList = coeService.showQuestions();
		List<QuestionsDetail> details = questionUtil.toDetails(quesList);
		
		return details;
	}
	
	
	
	
	
	@Autowired
	private QuestionBankService QuesBService;
	
	@Autowired
	private QuestionBankUtil QuesBUtil;

	private ServletRequest session;
	
	//private Integer qId;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/add questionbank")
	public QuestionBankDetail addQuestions(HttpServletRequest request, 
			@RequestBody QuestionBankDetail requestData){
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("user");
		if (userName == null) {
			//throw new UserNotFoundException("You are not logged in");
		}
		String role=(String) session.getAttribute("role");
		if(!role.equalsIgnoreCase("admin")) {
			//logger.error("Not eligible not customer");
			//throw new UserNotFoundException("You are not eligible to add questions in questionbank");
		}
		QuestionBankDetail QuesBDetail = null;
		QuestionBank questionbank = new QuestionBank(requestData.getQuesbankid(),requestData.getQuesid(),requestData.getQuestion(),requestData.getAnswer());
		QuestionBank QuesB = QuesBService.add(questionbank);
		QuesBDetail = QuesBUtil.toDetails(QuesB);
		
		return QuesBDetail;
	}
	
	@GetMapping("/deletequestionbank/{quesid}")
	public ResponseEntity<QuestionBank> deleteQuestionbank(@PathVariable("quesid") Integer quesId,HttpServletRequest request) {
		HttpSession session= request.getSession();
		
		
		QuestionBank questionbank =QuesBService.deleteQuestionBank(quesId);
		
		
		return new ResponseEntity("QuestionBank deleted successfully", HttpStatus.OK);
	}
	
	@PutMapping("/editquestionbank/{quesid}")
	public ResponseEntity<QuestionBank> editQuestionbank(@RequestBody QuestionBank QuesB,HttpServletRequest request) {
		HttpSession session= request.getSession();
		QuestionBank questionbank =QuesBService.editQuestionbank(QuesB);
		if (questionbank == null) {
			return new ResponseEntity("Sorry we can't update the questionbank with id" + QuesB.getQuesbankid(), HttpStatus.OK);
		}
		String role=(String) session.getAttribute("role");
		if(!role.equalsIgnoreCase("admin")) {
			//logger.error("Not eligible not customer");
			//throw new UserNotFoundException("You are not eligible to edit questionbank");
		}
		return new ResponseEntity<QuestionBank>(questionbank, HttpStatus.OK);
	}
	
	
	@GetMapping("/showall/questionbank")
	public List<QuestionBankDetail> showQuestionbank(HttpServletRequest request) {
		HttpSession session = request.getSession();
		List<QuestionBank> QuesBList = QuesBService.showQuestionbank();
		
		List<QuestionBankDetail> details = QuestionBankUtil.toDetails(QuesBList);
		return details;
	}
	@GetMapping("/findqbid")
	public ResponseEntity<?> findQuestionBank(@RequestParam int quesId){
		ResponseEntity<?> entity=null;
		
		
		QuestionBank questionbank= QuesBService.findByquesbankid(quesId);
		
		entity=new ResponseEntity<QuestionBank>(questionbank,HttpStatus.OK);
		
		return entity;
	}
  
}
