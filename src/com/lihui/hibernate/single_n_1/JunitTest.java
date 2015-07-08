package com.lihui.hibernate.single_n_1;

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
	public void testSave() {
		Customer customer = new Customer();
		customer.setCustomerName("a");
		
		Order order1 = new Order();
		order1.setOrderName("A");
		order1.setCustomer(customer);
		Order order2 = new Order();
		order2.setOrderName("B");
		order2.setCustomer(customer);
		
		session.save(order1);
		session.save(order2);
	}
}
