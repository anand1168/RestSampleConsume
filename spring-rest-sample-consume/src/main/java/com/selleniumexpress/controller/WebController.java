package com.selleniumexpress.controller;

import java.util.Arrays;
import java.util.List;

import javax.xml.ws.RespectBinding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.selleniumexpress.api.Student;

@Controller
public class WebController {

	private String url = "http://localhost:8080/spring-rest-sample/student";
	private String posturl = "http://localhost:8080/spring-rest-sample/student/?body";

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/get-all-student")
	public String getAll(Model model) {

		Student[] students = restTemplate.getForObject(url, Student[].class);

		List<Student> list = Arrays.asList(students);

		model.addAttribute("ListOfStudent", list);

		return "students";

	}
	
	
	@GetMapping("/saveStudent")
	@ResponseBody
	public String createStudent() {
	
		Student student=new Student();
		student.setId(5);
		student.setName("RAVI");
		student.setCountry("INDIA");
		
		HttpHeaders header=new HttpHeaders();
		header.add("Accept", "application/json");
		header.add("Content-Type", "application/json");
		
		HttpEntity<Student> entity=new HttpEntity<Student>(student,header);
		
		Student object = restTemplate.postForObject(posturl, entity, Student.class);
		
		
		return object.toString();
	 	
		
		
		
	}
	
	
	

}
