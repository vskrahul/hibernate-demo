package vsk.rahul.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import vsk.rahul.model.Department;

public class DepartmentDao implements DaoInterface<Department, Integer> {

	private Session currentSession;
	
	private Transaction currentTransaction;

	public Session openCurrentSession() {
		currentSession = getSessionFactory().openSession();
		return currentSession;
	}

	public Session openCurrentSessionwithTransaction() {
		currentSession = getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}
	
	public void closeCurrentSession() {
		currentSession.close();
	}
	
	public void closeCurrentSessionwithTransaction() {
		currentTransaction.commit();
		currentSession.close();
	}
	
	private static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(Department.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
		return sessionFactory;
	}

	public Session getCurrentSession() {
		return currentSession;
	}

	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}

	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}

	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}
	
	@Override
	public void persist(Department entity) {
		currentSession.save(entity);
	}

	@Override
	public void update(Department entity) {
		currentSession.update(entity);
	}

	@Override
	public Department findById(Integer id) {
		return currentSession.find(Department.class, id);
	}

	@Override
	public void delete(Department entity) {
		currentSession.delete(entity);
	}

	@Override
	public List<Department> findAll() {
		return currentSession.createQuery("from Department").list();
	}

	@Override
	public void deleteAll() {
		List<Department> list = findAll();
		list.stream().forEach(e -> delete(e));
	}

}
