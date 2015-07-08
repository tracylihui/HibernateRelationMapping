package com.lihui.hibernate.single_n_n;

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
		Category c1 = new Category();
		c1.setCatregoryName("C-AA");

		Category c2 = new Category();
		c2.setCatregoryName("C-BB");

		Item i1 = new Item();
		i1.setItemName("I-AA");
		Item i2 = new Item();
		i2.setItemName("I-BB");

		c1.getItems().add(i1);
		c1.getItems().add(i2);
		c2.getItems().add(i1);
		c2.getItems().add(i2);
		
		session.save(c1);
		session.save(c2);
		session.save(i1);
		session.save(i2);

	}
}
