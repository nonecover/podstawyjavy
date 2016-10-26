package com.jakomulski.daofactory;

import com.jakomulski.daofactory.models.Person;

public final class DAOFactory implements DataAccessObject {	
	
	private DAOFactory() {	}

	
	private final static DAOFactory INSTANCE = new DAOFactory();
	
	public static DAOFactory getInstance(DAOType daoType) {
		INSTANCE.setFactory(daoType);
		return INSTANCE;
	}

	
	private DataAccessObject currentDAO;
	
	public void setFactory(DAOType daoType) {
		currentDAO = daoType.getDAOInstance();
	}

	@Override
	public Person getPersonById(int id) {
		return currentDAO.getPersonById(id);
	}
}