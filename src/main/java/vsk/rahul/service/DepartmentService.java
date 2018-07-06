package vsk.rahul.service;

import vsk.rahul.dao.DepartmentDao;
import vsk.rahul.model.Department;

public class DepartmentService {

	private static DepartmentDao bookDao;

	public DepartmentService() {
		bookDao = new DepartmentDao();
	}

	public void persist(Department entity) {
		bookDao.openCurrentSessionwithTransaction();
		bookDao.persist(entity);
		bookDao.closeCurrentSessionwithTransaction();
	}
}
