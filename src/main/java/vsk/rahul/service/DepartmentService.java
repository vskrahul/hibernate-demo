package vsk.rahul.service;

import java.util.List;

import vsk.rahul.dao.DepartmentDao;
import vsk.rahul.model.Department;

public class DepartmentService {

	private static DepartmentDao departmentDao;

	public DepartmentService() {
		departmentDao = new DepartmentDao();
	}

	public void persist(Department entity) {
		departmentDao.openCurrentSessionwithTransaction();
		departmentDao.persist(entity);
		departmentDao.closeCurrentSessionwithTransaction();
	}
	
	public void update(Department entity) {
		departmentDao.openCurrentSessionwithTransaction();
		departmentDao.update(entity);
		departmentDao.closeCurrentSessionwithTransaction();
	}
	
	public Department findById(Integer id) {
		departmentDao.openCurrentSession();
		Department dept = departmentDao.findById(id);
		departmentDao.closeCurrentSession();
		return dept;
	}

	public void delete(Department entity) {
		departmentDao.openCurrentSessionwithTransaction();
		departmentDao.delete(entity);
		departmentDao.closeCurrentSessionwithTransaction();
	}

	public List<Department> findAll() {
		departmentDao.openCurrentSession();
		List<Department> depts = departmentDao.findAll();
		departmentDao.closeCurrentSession();
		return depts;
	}

	public void deleteAll() {
		departmentDao.openCurrentSessionwithTransaction();
		departmentDao.deleteAll();
		departmentDao.closeCurrentSessionwithTransaction();
	}
}
