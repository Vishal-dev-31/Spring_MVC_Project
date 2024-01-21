package com.tech.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tech.dto.Student;

@Repository
public class StudentDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public int createStduent(Student s)
	{
		
		Session session=sessionFactory.openSession();
		
		int pk =(int)session.save(s);
		System.out.println("records saved -->" +pk);
		
		session.beginTransaction().commit();
		
		return pk;
	}

	public List<Student> getAll() {
		
		Session session=sessionFactory.openSession();
		Criteria cr=session.createCriteria(Student.class);
		List<Student> stdlist=cr.list();
		System.out.println("records from db ---> "+ stdlist);
		return stdlist;
	}
	
	public void deleteStudent(Student student)
	{
		Session session=sessionFactory.openSession();
		session.delete(student);
		session.beginTransaction().commit();
		
	}
	
	public Student editStudent(Student student)
	{
		Session session=sessionFactory.openSession();
		Student stduent=session.get(Student.class, student.getId());
		// use criteria and restrication as well
		System.out.println("records from db is " +stduent);
		return stduent;
	}
	
	
	public void updateStudent(Student student)
	{
		System.out.println(student);
		Session session=sessionFactory.openSession();
		session.update(student);
		session.beginTransaction().commit();
	}
	
	
	
	
}
