package com.tech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.dao.StudentDao;
import com.tech.dto.Student;

@Service
public class StudentService {

	@Autowired
	StudentDao studentDao;
	public int createStudent(String fname, String lname, String email , String phone) {

		Student student = new Student();
		student.setFname(fname);
		student.setLname(lname);
		student.setEmail(email);
		student.setPhone(phone);
		int records =studentDao.createStduent(student);
		
		return records;
		
		
		

	}
	public List<Student> getAll() {
	
		List<Student> stdlist=studentDao.getAll();
		return stdlist;
	}
	
	public List<Student> deleteStudent(int sid)
	{
		System.out.println("inside StudentService.deleteStudent " +sid);
		Student s1 = new Student();
		s1.setId(sid);
		studentDao.deleteStudent(s1);
		
		//show all the records after delete
		
		List<Student> stdlist=studentDao.getAll();
		return stdlist;
		
	}
	
	public Student editStudent(int sid)
	{
		System.out.println("inside StudentService.editStudent " +sid);
		Student s1 = new Student();
		s1.setId(sid);
		
		Student std=studentDao.editStudent(s1);
		return std;
		
	}
	
	public List<Student> updateStudent(int sid, String fname, String lname, String email, String phone)
	{
		System.out.println("inside StudentService.updateStudent " );
		
		Student s1 = new Student();
		s1.setId(sid);
		s1.setFname(fname);
		s1.setPhone(phone);
		s1.setEmail(email);
		//s1.setLname(fname);
		s1.setLname(lname);
		
		studentDao.updateStudent(s1);
		
		//show all the records after update
		
		List<Student> stdlist=studentDao.getAll();
		return stdlist;
		
		
	}
}
