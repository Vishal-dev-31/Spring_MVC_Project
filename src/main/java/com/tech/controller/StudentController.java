package com.tech.controller;

import java.util.List;

import javax.persistence.Column;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tech.dto.Student;
import com.tech.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	StudentService studentService;

	@RequestMapping("/create")
	public ModelAndView create(@RequestParam("fname") String fname, @RequestParam("lname") String lname,
			@RequestParam("email") String email, @RequestParam("phone") String phone) {
		System.out.println("isnide create method");
		System.out.println(fname);
		System.out.println(lname);
		System.out.println(email);
		System.out.println(phone);

		int recordInserted = studentService.createStudent(fname, lname, email, phone);

		if (recordInserted > 0) {
			System.out.println("success case---");

			ModelAndView mav = new ModelAndView("create-sucess");
			return mav;
		} else {
			System.out.println("failure case---");
			ModelAndView mav = new ModelAndView("create-failure");
			return mav;
		}
	}
//	@RequestMapping("/getAll")
//	public void test()
//	{
//		
//	}
	@RequestMapping("/ ")
	public ModelAndView getAll() {
		System.out.println("getall------");
		
		List<Student> stdist=studentService.getAll();
	//ModelAndView mav = new ModelAndView("getAllStudent");
		ModelAndView mav = new ModelAndView("getAllStudent2");		
		mav.addObject("GET_ALL_STUDENT", stdist);
		return mav;
		

	}

	@RequestMapping("/deleteemp")
	public ModelAndView deleteStudent(@RequestParam("id") int sid)
	{
		System.out.println("deleteStudent------" +sid);
		List<Student> stdlist=studentService.deleteStudent(sid);
		
		ModelAndView mav = new ModelAndView("getAllStudent2");		
		mav.addObject("GET_ALL_STUDENT", stdlist);
		
		return mav;
	}
	
	
	@RequestMapping("/editemp")
	public ModelAndView editSudent(@RequestParam("id") int sid)
	{
		// sid 
		// select * From student where id =?
		// gives the single student (old data)
		
		System.out.println("editSudent------" +sid);
		
		Student studentFromDB =studentService.editStudent(sid);
		
		ModelAndView mav = new ModelAndView("edit-student");
		
		mav.addObject("STUDENT_FROM_DB", studentFromDB);
		return mav;
	}
	
	
	@RequestMapping("/updateStudent")
	public ModelAndView updateStudent(@RequestParam("sid1") int id,
			@RequestParam("sfname1") String fname,
			@RequestParam("slname1") String lname,
			@RequestParam("semail1") String email,
			@RequestParam("sphone1") String phone
			)
	{
		//http://localhost:8081/Spring_MVC_Project/updateStudent?sid1=3&sfname1=Rohit&slname1=Sharma&semail1=rohit%40gmail.com&sphone1=3333
		System.out.println("updateStudent------" +fname);
		
		List<Student> stdlist=studentService.updateStudent(id, fname, lname, email, phone);
		
		ModelAndView mav = new ModelAndView("getAllStudent2");		
		mav.addObject("GET_ALL_STUDENT", stdlist);
		
		return mav;
	}
}
//create
