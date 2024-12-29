package com.selleniumexpress.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.selleniumexpress.api.Student;

@RestController
public class MyRestController {

	private String url = "http://localhost:8080/spring-rest-sample/student/";
	private String posturl = "http://localhost:8080/spring-rest-sample/student/?{params}";

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/getallStudents")
	public List<Student> getStudents() {

		Student[] students = restTemplate.getForObject(url, Student[].class);
		return Arrays.asList(students);

	}
	
	
	
	@GetMapping("/api/student")
	public List<Student> fetchStudents() {

	
		ResponseEntity<Student[]> responseEntity = restTemplate.getForEntity(url,Student[].class);
		
		System.out.println(responseEntity.getStatusCodeValue());
		System.out.println(responseEntity.getStatusCode());
		System.out.println(responseEntity.getHeaders());
		Student[] body = responseEntity.getBody();
		

		return Arrays.asList(body);

	}
	
	
	@GetMapping("/fetch/{id}")
	public Student fetchByID(@PathVariable int id) {
		
		Student student;
		
		
		
		student = restTemplate.getForObject(url+id+"?aaa", Student.class);
		
		return student;
		
	}
	
	
	

	@GetMapping("/createStudent")
	public Student createStudent() {

		Student st = new Student();
		st.setId(19);
		st.setName("Krishiv");
		st.setCountry("India");

		HttpHeaders header = new HttpHeaders();
		header.add("Accept", "application/json");
		header.add("Content-Type", "application/json");

		HttpEntity request = new HttpEntity(st, header);

		Student student = restTemplate.postForObject(posturl, request, Student.class,"body");

		return student;

	}

}
