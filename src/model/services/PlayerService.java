package model.services;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.PlayerDao;
import model.entities.Department;

public class PlayerService {

	
	private PlayerDao dao = DaoFactory.createDepartmentDao();

	public List<Department> findAll() {
		return dao.findAll();
	}

	public void saveOrUpdate(Department obj) {
		if (obj.getId() == null) {
			dao.insert(obj);
		} else {
			dao.update(obj);
		}
	}
	
}
