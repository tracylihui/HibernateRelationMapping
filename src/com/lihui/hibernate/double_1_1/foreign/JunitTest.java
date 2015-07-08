package com.lihui.hibernate.double_1_1.foreign;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class JunitTest {
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;

	@Before
	public void init() {
		Configuration cfg = new Configuration().configure();
		ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(
				cfg.getProperties()).buildServiceRegistry();
		sessionFactory = cfg.buildSessionFactory(sr);
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
	}

	@After
	public void destroy() {
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	@Test
	public void testGet(){
		Department dep = (Department) session.get(Department.class, 1);
		System.out.println(dep.getDeptName());
		Manager mgr =dep.getManager();
		System.out.println(mgr.getMgrName());
	}
	@Test
	public void testSave() {
		Department dep = new Department();
		dep.setDeptName("a");
		
		Manager mgr = new Manager();
		mgr.setMgrName("b");
		
		dep.setManager(mgr);
		
		mgr.setDepartment(dep);
		
		session.save(mgr);
		session.save(dep);
		
	}
}
