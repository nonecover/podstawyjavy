package com.jakomulski.daofactory;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class DAOTypeTests {
	

	@Test
	public void test() {		
		
		DataAccessObject dbDao = DAOType.DB.getDAOInstance();
		dbDao.getPersonById(5);
		
		DataAccessObject wsDao = DAOType.WS.getDAOInstance();
		wsDao.getPersonById(5);
		
		DataAccessObject xmlDao = DAOType.XML.getDAOInstance();
		xmlDao.getPersonById(5);
		
		DataAccessObject dbDaoCopy = DAOType.DB.getDAOInstance();
		DataAccessObject wsDaoCopy = DAOType.WS.getDAOInstance();
		DataAccessObject xmlDaoCopy = DAOType.XML.getDAOInstance();
		
		assertThat(dbDao, is(dbDaoCopy));
		assertThat(xmlDao, is(xmlDaoCopy));
		assertThat(wsDao, is(wsDaoCopy));
		
		assertThat(dbDao, not(xmlDao));
	}
}
