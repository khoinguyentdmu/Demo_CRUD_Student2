package com.example.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.example.model.Student;
import com.example.repository.IStudentRepository;
import com.example.util.HibernateUltil;

@Repository
public class StudentRepositoryImpl implements IStudentRepository {
	/*
	 * create database db_example
	 * 
	 * use db_example;
	 * 
	 * create table tbl_student ( id INT(11) NOT NULL auto_increment, name
	 * VARCHAR(50) default NULL, email VARCHAR(50) default NULL, PRIMARY KEY (id) );
	 */
	@Override
	public List<Student> findAll() {
		/*
		 * String sql = "Select new " + Student.class.getName() // +
		 * "(e.id,e.name,e.email)" // + " from " + Student.class.getName() + " e ";
		 * return entityManager.createQuery(sql, Student.class).getResultList();
		 */

		Session session = HibernateUltil.getSessionFactory().getCurrentSession();

		session.beginTransaction();
		List<Student> students = session.createQuery("FROM " + Student.class.getName()).list();
		session.getTransaction().commit();

		return students;

	}

	public Student findById(int id) {

		Session session = HibernateUltil.getSessionFactory().getCurrentSession();

		session.beginTransaction();
		List<Student> students = session.createQuery("FROM " + Student.class.getName() + " WHERE id = " + id).list();
		session.getTransaction().commit();

		if (students != null && students.size() > 0)
			return students.get(0);
		return null;
	}

	@Override
	public Student save(Student student) {
		Session session = HibernateUltil.getSessionFactory().getCurrentSession();

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(student);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			return null;
		}

		return student;
	}

	@Override
	public Student update(Student student, int id) {
		Session session = HibernateUltil.getSessionFactory().getCurrentSession();

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			student.setId(id);
			session.update(student);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			return null;
		}

		return student;
	}

	@Override
	public boolean delete(int id) {
		Session session = HibernateUltil.getSessionFactory().getCurrentSession();

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Student student = (Student)session.get(Student.class, id);
			session.delete(student);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
