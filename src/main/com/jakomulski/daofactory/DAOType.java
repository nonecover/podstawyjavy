package com.jakomulski.daofactory;

import org.apache.log4j.Logger;


public enum DAOType {
	XML(XMLAccessObject.class), 
	DB(DBAccessObject.class), 
	WS(WSAccessObject.class),
	XLS(XLSAccessObject.class);
	
	private final static Logger LOGGER = Logger.getLogger(DAOType.class);
	
	private Class<? extends DataAccessObject> referredClass;

	private DAOType(Class<? extends DataAccessObject> referredClass) {
		this.referredClass = referredClass;
	}

	
	private DataAccessObject instanceOfDAO = null;
	//It should NOT be accessible outside package (only by DAOFactory)
	DataAccessObject getDAOInstance() {
		createDAOInstanceIfNull();
		return instanceOfDAO;
	}
	
	private void createDAOInstanceIfNull() {
		if (instanceOfDAO == null)
			try {
				instanceOfDAO = referredClass.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				LOGGER.error(e);
			}
	}
}