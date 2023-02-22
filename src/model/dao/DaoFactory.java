package model.dao;

import db.DB;
import model.dao.impl.PlayerDaoJDBC;

public class DaoFactory {
	
	public static PlayerDao createPlayerDao() {
		return new PlayerDaoJDBC(DB.getConnection());
	}

}
